package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

/**
 * Event triggered when an army battle ends. READONLY EVENT
 */
public class ArmyAttackResultEvent extends Event {
    private Civilization winnerCiv;
    private Civilization loserCiv;
    private Province battleProvince;
    private Report_Data reportData;

    public ArmyAttackResultEvent(Civilization winnerCiv, Civilization loserCiv, Province battleProvince, Report_Data reportData) {
        super("ArmyAttackResultEvent");
        this.winnerCiv = winnerCiv;
        this.loserCiv = loserCiv;
        this.battleProvince = battleProvince;
        this.reportData = reportData;
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

    public Report_Data getReportData() {
        return reportData;
    }
}
