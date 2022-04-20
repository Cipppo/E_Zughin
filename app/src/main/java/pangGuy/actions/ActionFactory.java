package pangGuy.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import pangGuy.modularGun.Trigger;
import pangGuy.utilities.Directions;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.StepsApplier;
import pangGuy.gui.BoundChecker;
import pangGuy.character.Hero;
import mergeballs.gui.VisualInterface;

/**
 * A factory which models the main character Actions.
 */

public class ActionFactory {

    private static final int SPEED = 20;

    /**
     * The action which permits the main character to step Right.
     */
    private class RightAction extends AbstractAction{
        
        private final VisualInterface v;
        private final Hero h;
        private final BoundChecker bc;
        
        /**
         * Creates a new RightAction 
         * @param v the used Visual.
         * @param h the Hero Model.
         * @param bc the Bound Checker.
         */
        public RightAction(VisualInterface v, Hero h, BoundChecker bc){
            this.v = v;
            this.h = h;
            this.bc = bc;
        }

        @Override
        /**
         * It makes the main character step right, if it's possible.
         */
        public void actionPerformed(ActionEvent e) {
            if (this.h.isAwake()) {
                EntityPos2D actualHeroPos = h.getPosition();
                var axisHeroPos = new StepsApplier(v.getStartPos()).convertHeroPosition(actualHeroPos);
                if (this.bc.isInside(new EntityPos2D(axisHeroPos.getX() + SPEED, axisHeroPos.getY()), this.v.getHeroComponent().getShape().getDimensions().getX(), 
                            this.v.getHeroComponent().getShape().getDimensions().getY())) {
                                this.h.move(Directions.RIGHT);
                                this.v.move(new EntityPos2D(axisHeroPos.getX() + SPEED, axisHeroPos.getY()));
                                this.v.setDirection(this.h.getDirection());
                            }
            }
        }

    }
    
    /**
     * The action which permits the main character to step Left.
     */
    private class LeftAction extends AbstractAction{

        private final VisualInterface v;
        private final Hero h;
        private final BoundChecker bc;

        /**
         * Creates a new LeftAction. 
         * @param v the used Visual.
         * @param h the Hero Model.
         * @param bc the Bound Checker.
         */
        public LeftAction(VisualInterface v, Hero h, BoundChecker bc){
            this.v = v;
            this.h = h;
            this.bc = bc;
        }

        @Override
        /**
        * It makes the main character step left, if it's possible.
        */
        public void actionPerformed(ActionEvent e) {
            if (this.h.isAwake()) {
                EntityPos2D actualHeroPos = h.getPosition();
                var axisHeroPos = new StepsApplier(v.getStartPos()).convertHeroPosition(actualHeroPos);
                if (this.bc.isInside(new EntityPos2D(axisHeroPos.getX() - SPEED, axisHeroPos.getY()), this.v.getHeroComponent().getShape().getDimensions().getX(), 
                this.v.getHeroComponent().getShape().getDimensions().getY())) {
                    this.h.move(Directions.LEFT);  
                    this.v.move(new EntityPos2D(axisHeroPos.getX() - SPEED,  axisHeroPos.getY()));
                    this.v.setDirection(this.h.getDirection());
                }
            }
        }
        
    }
    
    /**
     * It makes the main character shoot.
     */
    private class ShootAction extends AbstractAction{

        private final VisualInterface v;
        private final Hero h;
        private final BoundChecker bc;

        /**
         * Create a new ShootAction
         * @param v the used Visual.
         * @param h the Hero Model.
         * @param bc the Bound Checker.
         */
        public ShootAction(VisualInterface v, Hero h, BoundChecker bc){
            this.v = v;
            this.h = h;
            this.bc = bc;
        }

        @Override
        /**
         * It makes the main character shoot, if there are available guns.
         */
        public void actionPerformed(ActionEvent e) {
            if (this.h.isAwake()) {
                var shootingGun = this.h.getGset().getShootingGun();
                var shootingGunComponent = this.v.getFreeComponent();
                if (!shootingGun.isEmpty()) {
                    new Trigger(shootingGun.get(), shootingGunComponent.get(), this.v, this.bc, this.h).start();
                }else{
                    System.out.println("No available guns!");
                }
            }
        }

    }

    /**
    * 
    * @param v the used Visual.
    * @param h the Hero Model.
    * @param bc the Bound Checker.
    * @return a new getRightAction.
    */
    public RightAction getRightAction(VisualInterface v, Hero h, BoundChecker bc){
        return new RightAction(v, h, bc);
    }

    /**
     * 
     * @param v the used Visual.
     * @param h the Hero Model.
     * @param bc the Bound Checker.
     * @return a new getLeftAction.
     */
    public LeftAction getLeftAction(VisualInterface v, Hero h, BoundChecker bc){
        return new LeftAction(v, h, bc);
    }

    /**
     * 
     * @param v the used Visual.
     * @param h the Hero Model.
     * @param bc the Bound Checker.
     * @return a new ShootAction.
     */
    public ShootAction getShootAction(VisualInterface v, Hero h, BoundChecker bc){
        return new ShootAction(v, h, bc);
    }
}
