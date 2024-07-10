package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

/**
 * Event triggered when army is disbanded.
 */
public class DisbandArmyEvent extends Event {
    private Civilization requesterCiv;
    private Province province;
    private int armySize;

    public DisbandArmyEvent(Civilization requesterCiv, Province province, int armySize){
        super("DisbandArmyEvent");
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
