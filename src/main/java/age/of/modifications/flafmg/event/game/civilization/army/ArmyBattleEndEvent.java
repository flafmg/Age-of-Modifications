package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

/**
 * Event triggered when an army battle ends.
 */
public class ArmyBattleEndEvent extends Event {
    private Civilization winnerCiv;
    private Civilization loserCiv;
    private Province battleProvince;

    public ArmyBattleEndEvent(Civilization winnerCiv, Civilization loserCiv, Province battleProvince) {
        super("ArmyBattleEndEvent");
        this.winnerCiv = winnerCiv;
        this.loserCiv = loserCiv;
        this.battleProvince = battleProvince;
    }

    public Civilization getWinnerCiv() {
        return winnerCiv;
    }

    public Civilization getLoserCiv() {
        return loserCiv;
    }

    public Province getBattleProvince() {
        return battleProvince;
    }
}
