package age.of.modifications.flafmg.mod;

import age.of.civilizations2.jakowski.lukasz.Commands;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class ModManager {
    private static List<Mod> loadedMods = new ArrayList<>();
    private static int AoMVersion = 0;

    public File[] modPaths;
    public boolean allLoaded;

    public ModManager() {
        unloadAll();
        startupMods();
    }

    private void startupMods() {
        File modsFolder = new File("mods");
        if (!modsFolder.exists()) {
            if (modsFolder.mkdirs()) {
                System.out.println("[AoM] Mods folder created at " + modsFolder.getAbsolutePath());
                Commands.addMessage("[AoM] Mods folder created at " + modsFolder.getAbsolutePath());
            } else {
                System.err.println("[AoM] Error: Failed to create mods folder at " + modsFolder.getAbsolutePath());
                Commands.addMessage("[AoM] Error: Failed to create mods folder at " + modsFolder.getAbsolutePath());
                return;
            }
        }
        modPaths = modsFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jar"));
    }

    public void loadMod(String jarPath) {
        File jarFile = new File(jarPath);
        if (!jarFile.exists()) {
            System.err.println("[AoM] Error: JAR file not found at " + jarFile.getName());
            Commands.addMessage("[AoM] Error: JAR file not found at " + jarFile.getName());
            return;
        }

        try (JarFile jar = new JarFile(jarFile);
             URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()})) {

            ZipEntry entry = jar.getEntry("mod.yaml");
            if (entry == null) {
                System.err.println("[AoM] Error: mod.yaml file not found in JAR " + jarFile.getName());
                Commands.addMessage("[AoM] Error: mod.yaml file not found in JAR " + jarFile.getName());
                return;
            }

            loadModFromYaml(jar, classLoader, entry, jarFile);
        } catch (IOException e) {
            System.err.println("[AoM] Error: Failed to load JAR file.");
            e.printStackTrace();
            Commands.addMessage("[AoM] Error: Failed to load JAR file.");
        }
    }

    private void loadModFromYaml(JarFile jar, URLClassLoader classLoader, ZipEntry entry, File jarFile) {
        try (InputStream yamlInputStream = jar.getInputStream(entry)) {
            Yaml yaml = new Yaml();
            Map<String, Object> yamlData = yaml.load(yamlInputStream);

            String mainClass = (String) yamlData.get("mainClass");
            String name = (String) yamlData.getOrDefault("name", jarFile.getName().replace(".jar", ""));
            String description = (String) yamlData.getOrDefault("description", "");
            String author = (String) yamlData.getOrDefault("author", "???");
            String version = (String) yamlData.getOrDefault("version", "???");
            int aomVersion = (int) yamlData.getOrDefault("aom-version", -1);

            if (isModDuplicate(name)) return;
            if (aomVersion > AoMVersion) warnVersionMismatch(name, aomVersion);

            Mod modInstance = createModInstance(classLoader, mainClass, name, description, author, version);
            if (modInstance != null) {
                initializeMod(modInstance);
            }
        } catch (Exception e) {
            System.err.println("[AoM] Error: Failed to parse or instantiate mod.");
            e.printStackTrace();
            Commands.addMessage("[AoM] Error: Failed to parse or instantiate mod.");
        }
    }

    private boolean isModDuplicate(String name) {
        for (Mod loadedMod : loadedMods) {
            if (loadedMod.getName().equals(name)) {
                System.out.println("[AoM] WARN: Duplicated Mod " + name + ".");
                Commands.addMessage("[AoM] WARN: Duplicated Mod " + name + ".");
                return true;
            }
        }
        return false;
    }

    private void warnVersionMismatch(String name, int aomVersion) {
        System.out.println("[AoM] WARN: Mod " + name + " version " + aomVersion + "+ but you're running version " + AoMVersion + ".");
        Commands.addMessage("[AoM] WARN: Mod " + name + " version " + aomVersion + "+ but you're running version " + AoMVersion + ".");
    }

    private Mod createModInstance(URLClassLoader classLoader, String mainClass, String name, String description, String author, String version) {
        try {
            Class<?> modClass = classLoader.loadClass(mainClass);
            Mod modInstance = (Mod) modClass.getDeclaredConstructor().newInstance();

            modInstance.setMain(mainClass);
            modInstance.setName(name);
            modInstance.setDescription(description);
            modInstance.setAuthor(author);
            modInstance.setVersion(version);

            return modInstance;
        } catch (Exception e) {
            System.err.println("[AoM] Error: Failed to load mod class.");
            e.printStackTrace();
            Commands.addMessage("[AoM] Error: Failed to load mod class.");
            return null;
        }
    }

    private void initializeMod(Mod modInstance) {
        System.out.println("[AoM] Initializing " + modInstance.getName());
        Commands.addMessage("[AoM] Initializing " + modInstance.getName());

        loadedMods.add(modInstance);

        try {
            modInstance.onInit();
        } catch (Exception e) {
            e.printStackTrace();
            unloadMod(modInstance);
        }
    }

    public void unloadAll() {
        for (Mod mod : loadedMods) {
            unloadMod(mod);
        }
    }

    public void unloadMod(Mod mod) {
        if (mod != null) {
            mod.onDisable();
            loadedMods.remove(mod);
            mod = null;
        }
    }

    public static List<Mod> getLoadedMods() {
        return Collections.unmodifiableList(loadedMods);
    }

    public static boolean isModLoaded(String modName) {
        return loadedMods.stream().anyMatch(mod -> mod.getName().equalsIgnoreCase(modName));
    }

    public void callOnSave() {
        for (Mod mod : loadedMods) {
            mod.onSave();
        }
    }

    public void callOnUpdate() {
        for (Mod mod : loadedMods) {
            mod.onUpdate();
        }
    }

    public void callOnPostInit() {
        for (Mod mod : loadedMods) {
            mod.onPostInit();
        }
    }

    public void callOnTurn() {
        for (Mod mod : loadedMods) {
            mod.onTurn();
        }
    }

    public void callOnTurnFinished() {
        for (Mod mod : loadedMods) {
            mod.onTurnEnd();
        }
    }
}
