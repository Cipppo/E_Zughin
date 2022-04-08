package pangGuy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import pangGuy.modularGun.Trigger;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;
import pangGuy.utilities.StepsApplier;
import pangGuy.gui.BoundChecker;
import pangGuy.character.Hero;

import mergeballs.gui.VisualInterface;
public class ActionFactory {

    private static final int SPEED = 5;


    private class rightAction extends AbstractAction{
        
        private final VisualInterface v;
        private final Hero h;
        private final BoundChecker bc;

        public rightAction(VisualInterface v, Hero h, BoundChecker bc){
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
                            this.v.setDirection(this.h.getDirection());
                        }
        }

    }

    
    private class leftAction extends AbstractAction{

        private final VisualInterface v;
        private final Hero h;
        private final BoundChecker bc;

        public leftAction(VisualInterface v, Hero h, BoundChecker bc){
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
                        this.v.setDirection(this.h.getDirection());
                    }
        }
        
    }
    

    private class shootAction extends AbstractAction{

        private final VisualInterface v;
        private final Hero h;
        private final BoundChecker bc;

        public shootAction(VisualInterface v, Hero h, BoundChecker bc){
            this.v = v;
            this.h = h;
            this.bc = bc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            var shootingGun = this.h.getGset().getShootingGun();
            var shootingGunComponent = this.v.getFreeComponent();
            if(!shootingGun.isEmpty()){
                new Trigger(shootingGun.get(), shootingGunComponent.get(), this.v, this.bc, this.h).start();
            }else{
                System.out.println("No available guns!");
            }

            
        }

    }




    public rightAction getRightAction(VisualInterface v, Hero h, BoundChecker bc){
        return new rightAction(v, h, bc);
    }

    
    public leftAction getLeftAction(VisualInterface v, Hero h, BoundChecker bc){
        return new leftAction(v, h, bc);
    }

    
    public shootAction getShootAction(VisualInterface v, Hero h, BoundChecker bc){
        return new shootAction(v, h, bc);
    }
    
}
