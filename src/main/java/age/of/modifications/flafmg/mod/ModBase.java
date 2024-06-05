package age.of.modifications.flafmg.mod;

public abstract class ModBase {

    /**
     * Method called during mod initialization.
     */
    public void onInit(){};

    /**
     * Method called after all mods initialized.
     */
    public void onPostInit(){};

    /**
     * Method called when the mod is disabled.
     */
    public void onDisable(){};

    /**
     * Method called every new game turn.
     */
    public void onTurn(){};

    /**
     * Method called when a turn finished processing.
     */
    public void onTurnEnd(){};

    /**
     * Method called when the game turn is saved.
     */
    public void onSave(){};

    /**
     * Called every game update.
     */
    public void onUpdate(){};
}
