package pangGuy.actions;

import javax.swing.KeyStroke;

import pangGuy.gui.Actor;
import pangGuy.gui.BoundChecker;
import pangGuy.gui.Field;
import pangGuy.gui.Moover;
import pangGuy.gun.GunRaiser;
import pangGuy.modularGun.GunSet;
import pangGuy.utilities.Pair;
public class ActionApplier{

    private final ActionFactory f = new ActionFactory();

    public ActionApplier(Actor a, GunSet g, Field field){

        BoundChecker bc = new BoundChecker(field.getSizeX(), field.getSizeY());

        a.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        a.getActionMap().put("rightAction", f.getRightAction(a, g, bc));
        
        a.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        a.getActionMap().put("leftAction", f.getLeftAction(a, g, bc));
        /*

        
        a.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "shootAction");
        a.getActionMap().put("shootAction", f.getShootAction(g));
        */
    }


}

       