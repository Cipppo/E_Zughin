package pangGuy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import pangGuy.gui.Visual;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;
import pangGuy.utilities.StepsApplier;
import pangGuy.gui.BoundChecker;
import pangGuy.character.Hero;
public class ActionFactory {

    private static final int SPEED = 5;


    private class rightAction extends AbstractAction{
        
        private final Visual v;
        private final Hero h;
        private final BoundChecker bc;

        public rightAction(Visual v, Hero h, BoundChecker bc){
            this.v = v;
            this.h = h;
            this.bc = bc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Pos2D actualHeroPos = h.getPosition();
            var axisHeroPos = new StepsApplier(v.getStartPos()).convertHeroPosition(actualHeroPos);
            if(this.bc.isInside(new Pos2D(axisHeroPos.x + SPEED, axisHeroPos.y), this.v.getHeroComponent().getShape().getDimensions().getX(), 
                        this.v.getHeroComponent().getShape().getDimensions().getY())){
                            this.h.move(Directions.RIGHT);
                            this.v.move(new Pos2D(axisHeroPos.x + SPEED, axisHeroPos.y));
                            this.v.setDirection(Directions.RIGHT);
                        }
        }

    }

    
    private class leftAction extends AbstractAction{

        private final Visual v;
        private final Hero h;
        private final BoundChecker bc;

        public leftAction(Visual v, Hero h, BoundChecker bc){
            this.v = v;
            this.h = h;
            this.bc = bc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Pos2D actualHeroPos = h.getPosition();
            var axisHeroPos = new StepsApplier(v.getStartPos()).convertHeroPosition(actualHeroPos);
            if(this.bc.isInside(new Pos2D(axisHeroPos.x - SPEED, axisHeroPos.y), this.v.getHeroComponent().getShape().getDimensions().getX(), 
                    this.v.getHeroComponent().getShape().getDimensions().getY())){
                        this.h.move(Directions.LEFT);  
                        this.v.move(new Pos2D(axisHeroPos.x - SPEED,  axisHeroPos.y));
                        this.v.setDirection(Directions.LEFT);
                    }
        }
        
    }
    
    /*
    private class shootAction extends AbstractAction{

        private GunSet g;

        public shootAction(GunSet g){
            this.g = g;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            g.shoot();
            
        }

    }

    */


    public rightAction getRightAction(Visual v, Hero h, BoundChecker bc){
        return new rightAction(v, h, bc);
    }

    
    public leftAction getLeftAction(Visual v, Hero h, BoundChecker bc){
        return new leftAction(v, h, bc);
    }

    /*
    public shootAction getShootAction(GunSet g){
        return new shootAction(g);
    }
    */
}
