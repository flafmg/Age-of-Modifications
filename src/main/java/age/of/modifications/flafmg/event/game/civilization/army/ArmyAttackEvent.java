package age.of.modifications.flafmg.event.game.civilization.army;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

public class ArmyAttackEvent extends Event {
    private Civilization attackingCiv;
    private Civilization defendingCiv;
    private Province battleProvince;
    private int attackingArmy;
    private int defendingArmy;

    public ArmyAttackEvent(Civilization attackingCiv, Civilization defendingCiv, Province battleProvince, int attackingArmy, int defendingArmy){
        super("ArmyAttackEvent");
        this.attackingCiv = attackingCiv;
        this.defendingCiv = defendingCiv;
        this.battleProvince = battleProvince;
        this.attackingArmy = attackingArmy;
        this.defendingArmy = defendingArmy;
    }

    public Civilization getAttackingCiv() {
        return attackingCiv;
    }

    public Civilization getDefendingCiv() {
        return defendingCiv;
    }

    public Province getBattleProvince() {
        return battleProvince;
    }

    public int getAttackingArmy() {
        return attackingArmy;
    }

    public int getDefendingArmy() {
        return defendingArmy;
    }

    public void setAttackingArmy(int attackingArmy) {
        this.attackingArmy = attackingArmy;
    }
}
