package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

/**
 * Event triggered when a new army engages in combat.
 */
public class ArmyBattleEvent extends Event {
    private Civilization atackerCiv; // this is the civ that first moved its armys
    private Civilization opponentCiv;
    private Province battleProvince;
    private int requesterArmySize;
    private int opponentArmySize;

    public ArmyBattleEvent(Civilization atackerCiv, Civilization opponentCiv, Province battleProvince, int requesterArmySize, int opponentArmySize, Civilization winnerCiv) {
        super("ArmyBattleEvent");
        this.atackerCiv = atackerCiv;
        this.opponentCiv = opponentCiv;
        this.battleProvince = battleProvince;
        this.requesterArmySize = requesterArmySize;
        this.opponentArmySize = opponentArmySize;
    }

    public Civilization getAtackerCiv() {
        return atackerCiv;
    }

    public Civilization getOpponentCiv() {
        return opponentCiv;
    }

    public Province getBattleProvince() {
        return battleProvince;
    }

    public int getRequesterArmySize() {
        return requesterArmySize;
    }

    public int getOpponentArmySize() {
        return opponentArmySize;
    }

    public void setAtackerCiv(Civilization atackerCiv) {
        this.atackerCiv = atackerCiv;
    }

    public void setOpponentCiv(Civilization opponentCiv) {
        this.opponentCiv = opponentCiv;
    }

    public void setBattleProvince(Province battleProvince) {
        this.battleProvince = battleProvince;
    }

    public void setRequesterArmySize(int requesterArmySize) {
        this.requesterArmySize = requesterArmySize;
    }

    public void setOpponentArmySize(int opponentArmySize) {
        this.opponentArmySize = opponentArmySize;
    }
}
