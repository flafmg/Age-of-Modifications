package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

/**
 * Event triggered when an army is requested to move to a province.
 */
public class RequestMoveArmyEvent extends Event {
    private Civilization requesterCiv;
    private Province fromProvince;
    private Province toProvince;
    private int armySize;

    public RequestMoveArmyEvent(Civilization requesterCiv, Province fromProvince, Province toProvince, int armySize) {
        super("RequestMoveArmyEvent");
        this.requesterCiv = requesterCiv;
        this.fromProvince = fromProvince;
        this.toProvince = toProvince;
        this.armySize = armySize;
    }

    public Civilization getRequesterCiv() {
        return requesterCiv;
    }

    public Province getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(Province fromProvince) {
        this.fromProvince = fromProvince;
    }

    public Province getToProvince() {
        return toProvince;
    }

    public void setToProvince(Province toProvince) {
        this.toProvince = toProvince;
    }

    public int getArmySize() {
        return armySize;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }
}