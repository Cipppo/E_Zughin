package pangGuy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


import pangGuy.gun.GunRaiser;
import pangGuy.modularGun.GunSet;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;
import pangGuy.gui.Actor;
import pangGuy.gui.BoundChecker;

public class ActionFactory {

    private static final int SPEED = 5;


    private class rightAction extends AbstractAction{
        
        private final Actor actor;
        private final GunSet guns;
        private final BoundChecker bc;

        public rightAction(Actor actor, GunSet guns, BoundChecker bc){
            this.actor = actor;
            this.guns = guns;
            this.bc = bc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //m.move(new Pos2D(m.getCurrentPos().x + SPEED, m.getCurrentPos().y), Directions.RIGHT);
            //System.out.println("RIGHT");
            var pos = this.actor.getShape().getPos();
            if(bc.isInside(new Pos2D(pos.x + SPEED, pos.y), this.actor.getShape().getDimensions().getX(), 
            this.actor.getShape().getDimensions().getY())){
                    this.actor.changeLocation(new Pos2D(pos.x + SPEED, pos.y));
                    this.actor.setDir(Directions.RIGHT);
                    this.guns.moveGuns();
                }
            
        }

    }

    private class leftAction extends AbstractAction{

        private final Actor actor;
        private final GunSet guns;
        private final BoundChecker bc;

        public leftAction(Actor actor, GunSet guns, BoundChecker bc){
            this.actor = actor;
            this.guns = guns;
            this.bc = bc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //m.move(new Pos2D(m.getCurrentPos().x - SPEED, m.getCurrentPos().y), Directions.LEFT);
            //System.out.println("LEFT");
            var pos = this.actor.getShape().getPos();
            if(bc.isInside(new Pos2D(pos.x - SPEED, pos.y), this.actor.getShape().getDimensions().getX(), 
            this.actor.getShape().getDimensions().getY())){
                    this.actor.changeLocation(new Pos2D(pos.x - SPEED, pos.y));
                    this.actor.setDir(Directions.LEFT);
                    this.guns.moveGuns();
                }
        }
        
    }

    private class shootAction extends AbstractAction{

        private GunRaiser g;

        public shootAction(GunRaiser g){
            this.g = g;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            g.raise();
        }

    }



    public rightAction getRightAction(Actor actor, GunSet guns, BoundChecker bc){
        return new rightAction(actor, guns, bc);
    }

    public leftAction getLeftAction(Actor actor, GunSet guns, BoundChecker bc){
        return new leftAction(actor, guns, bc);
    }

    public shootAction getShootAction(GunRaiser g){
        return new shootAction(g);
    }
}
