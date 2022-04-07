package pangGuy.actions;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import mergeballs.gui.VisualInterface;
import pangGuy.gui.BoundChecker;

import pangGuy.character.Hero;
import pangGuy.gui.Visual;

import pangGuy.utilities.Pair;

public class ActionApplier{

    private final ActionFactory f = new ActionFactory();

    public ActionApplier(VisualInterface v, Hero h){

        BoundChecker bc = new BoundChecker(new Pair<Integer, Integer>(0, v.getBounds().getX()), new Pair<Integer, Integer>(0, v.getBounds().getY()));
        JPanel character = v.getHeroComponent();


        character.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        character.getActionMap().put("rightAction", f.getRightAction(v, h, bc));
        
        
        character.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        character.getActionMap().put("leftAction", f.getLeftAction(v, h, bc));
        
        
        character.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "shootAction");
        character.getActionMap().put("shootAction", f.getShootAction(v, h, bc));

    }


}

       