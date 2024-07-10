package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

/**
 * Event triggered when army move request is removed or changed.
 */
public class RemoveMoveArmyEvent extends Event {
    private Civilization requesterCiv;
    private Province province;
    private int armySize;

    public RemoveMoveArmyEvent(Civilization requesterCiv, Province province, int armySize){
        super("RemoveMoveArmyEvent");
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
