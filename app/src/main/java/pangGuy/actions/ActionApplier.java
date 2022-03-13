package pangGuy.actions;

import javax.swing.KeyStroke;

import pangGuy.gui.Actor;

import pangGuy.gui.Moover;

public class ActionApplier{

    public ActionApplier(Actor a, Moover m,  ActionFactory f){

        /*
        a.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        a.getActionMap().put("upAction", f.getUpAction(m));

        a.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        a.getActionMap().put("downAction", f.getDownAction(m));

        */

        a.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        a.getActionMap().put("leftAction", f.getLeftAction(m));

        a.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        a.getActionMap().put("rightAction", f.getRightAction(m));
        
    }


}

       /*
        super.setLocation(x, y); // -> Usare questo metodo per aggiornare!!!

        super.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        super.getActionMap().put("upAction", f.getUpAction(s));
        System.out.println(s.getPos().y);

        */