package age.of.modifications.flafmg.mod;

public abstract class Mod extends ModBase {
    private String main;
    private String name;
    private String description;
    private String author;
    private String version;
    private int aomVersion;

    public boolean loaded;

    protected String getMain() {
        return main;
    }

    protected void setMain(String main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    protected void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    protected void setVersion(String version) {
        this.version = version;
    }

    public int getAomVersion() {
        return aomVersion;
    }

    protected void setAomVersion(int aomVersion) {
        this.aomVersion = aomVersion;
    }
}
