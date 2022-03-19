package pangGuy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import pangGuy.gui.Moover;
import pangGuy.gun.GunRaiser;
import pangGuy.utilities.Pos2D;

public class ActionFactory {

    private static final int SPEED = 5;


    private class upAction extends AbstractAction{

        private Moover m;

        public upAction(Moover m){
            this.m = m;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            m.move(new Pos2D(m.getCurrentPos().x, m.getCurrentPos().y - SPEED));
            System.out.println("UP");
            
        }
        
    }


    private class rightAction extends AbstractAction{
        
        private Moover m;

        public rightAction(Moover m){
            this.m = m;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            m.move(new Pos2D(m.getCurrentPos().x + SPEED, m.getCurrentPos().y));
            System.out.println("RIGHT");
            
        }

    }

    private class leftAction extends AbstractAction{

        private Moover m;

        public leftAction(Moover m){
            this.m = m;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            m.move(new Pos2D(m.getCurrentPos().x - SPEED, m.getCurrentPos().y));
            System.out.println("LEFT");
            
        }
        
    }

    private class downAction extends AbstractAction{
        
        private Moover m;

        public downAction(Moover m){
            this.m = m;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            m.move(new Pos2D(m.getCurrentPos().x,m.getCurrentPos().y + SPEED));
            System.out.println("DOWN");
            
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

    public upAction getUpAction(Moover a){
        return new upAction(a);
    }

    public rightAction getRightAction(Moover a){
        return new rightAction(a);
    }

    public leftAction getLeftAction(Moover a){
        return new leftAction(a);
    }

    public downAction getDownAction(Moover a){
        return new downAction(a);
    }

    public shootAction getShootAction(GunRaiser g){
        return new shootAction(g);
    }
}
