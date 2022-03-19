package pangGuy.actions;

import javax.swing.KeyStroke;

import pangGuy.gui.Actor;

import pangGuy.gui.Moover;
import pangGuy.gun.GunRaiser;

public class ActionApplier{

    public ActionApplier(Actor a, Moover m,  ActionFactory f, GunRaiser g){

        a.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        a.getActionMap().put("leftAction", f.getLeftAction(m));

        a.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        a.getActionMap().put("rightAction", f.getRightAction(m));

        a.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "shootAction");
        a.getActionMap().put("shootAction", f.getShootAction(g));
        
    }


}

       