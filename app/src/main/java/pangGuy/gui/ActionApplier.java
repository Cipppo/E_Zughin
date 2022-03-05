package pangGuy.gui;

import javax.swing.KeyStroke;

public class ActionApplier{

    public ActionApplier(Actor a, ActionFactory f){

        a.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        a.getActionMap().put("upAction", f.getUpAction(a));

        a.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        a.getActionMap().put("downAction", f.getDownAction(a));

        a.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        a.getActionMap().put("leftAction", f.getLeftAction(a));

        a.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        a.getActionMap().put("rightAction", f.getRightAction(a));
    }


}

       /*
        super.setLocation(x, y); // -> Usare questo metodo per aggiornare!!!

        super.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        super.getActionMap().put("upAction", f.getUpAction(s));
        System.out.println(s.getPos().y);

        */