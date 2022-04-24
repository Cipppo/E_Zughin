package pangGuy.actions;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import masterControl.gui.VisualInterface;
import pangGuy.gui.BoundChecker;
import pangGuy.character.Hero;
import pangGuy.utilities.Pair;

/**
 * Interface from visual input to Hero Actions.
 */

public class ActionApplier{

    private final ActionFactory f = new ActionFactory();

    /**
     * Creates the KeyBindings which permits the Hero to perform Actions.
     * @param v the VIsual Interface.
     * @param h the Hero Model.
     */
    public ActionApplier(VisualInterface v, Hero h){

        BoundChecker bc = new BoundChecker(new Pair<Integer, Integer>(0, v.getBounds().getX()));
        JPanel character = v.getVisualTest();


        character.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        character.getActionMap().put("rightAction", f.getRightAction(v, h, bc));
        
        
        character.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        character.getActionMap().put("leftAction", f.getLeftAction(v, h, bc));
        
        
        character.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "shootAction");
        character.getActionMap().put("shootAction", f.getShootAction(v, h, bc));

    }


}

       