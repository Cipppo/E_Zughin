package pangGuy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import pangGuy.gui.Actor;
import pangGuy.utilities.Pos2D;

public class ActionFactory {

    private static final int SPEED = 5;


    private class upAction extends AbstractAction{

        private Actor a;

        public upAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.changeLocation(new Pos2D(a.getX(), a.getY() - SPEED));
            System.out.println("UP");
            System.out.println(a.getShape().toString());
        }
        
    }


    private class rightAction extends AbstractAction{
        
        private Actor a;

        public rightAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.changeLocation(new Pos2D(a.getX() + SPEED, a.getY()));
            System.out.println("RIGHT");
            System.out.println(a.getShape().toString());
        }

    }

    private class leftAction extends AbstractAction{

        private Actor a;

        public leftAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.changeLocation(new Pos2D(a.getX() - SPEED, a.getY()));
            System.out.println("LEFT");
            System.out.println(a.getShape().toString());
        }
        
    }

    private class downAction extends AbstractAction{
        
        private Actor a;

        public downAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.changeLocation(new Pos2D(a.getX(), a.getY() + SPEED));
            System.out.println("DOWN");
            System.out.println(a.getShape().toString());
        }

    }

    public upAction getUpAction(Actor a){
        return new upAction(a);
    }

    public rightAction getRightAction(Actor a){
        return new rightAction(a);
    }

    public leftAction getLeftAction(Actor a){
        return new leftAction(a);
    }

    public downAction getDownAction(Actor a){
        return new downAction(a);
    }

}
