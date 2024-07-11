package age.of.modifications.flafmg.event.game.civilization;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.modifications.flafmg.event.*;

public class DeclareWarEvent extends Event {
    private Civilization requesterCiv;
    private Civilization targetCiv;

    public DeclareWarEvent(Civilization requesterCiv, Civilization targetCiv){
        super("DeclareWarEvent");
        this.requesterCiv = requesterCiv;
        this.targetCiv = targetCiv;
    }

    public Civilization getRequesterCiv() {
        return requesterCiv;
    }

    public Civilization getTargetCiv() {
        return targetCiv;
    }
}
