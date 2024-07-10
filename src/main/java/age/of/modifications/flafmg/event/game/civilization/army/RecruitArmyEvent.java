package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

/**
 * Called when army is effectivaly recruited and added to province;
 */
public class RecruitArmyEvent extends Event {
    private Civilization requesterCiv;
    private Province province;
    private int armySize;

    public RecruitArmyEvent(Civilization requesterCiv, Province province, int armySize) {
        super("RecruitArmyEvent");
        this.requesterCiv = requesterCiv;
        this.province = province;
        this.armySize = armySize;
    }

    public Civilization getRequesterCiv() {
        return requesterCiv;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public int getArmySize() {
        return armySize;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }
}

