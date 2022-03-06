package pangGuy.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionFactory {

    private static final int SPEED = 2;


    private class upAction extends AbstractAction{

        private Actor a;

        public upAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.setLocation(a.getX(), a.getY() - SPEED);
            System.out.println("UP");
        }
        
    }


    private class rightAction extends AbstractAction{
        
        private Actor a;

        public rightAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.setLocation(a.getX() + SPEED, a.getY());
            System.out.println("RIGHT");
        }

    }

    private class leftAction extends AbstractAction{

        private Actor a;

        public leftAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.setLocation(a.getX() - SPEED, a.getY());
            System.out.println("LEFT");
        }
        
    }

    private class downAction extends AbstractAction{
        
        private Actor a;

        public downAction(Actor a){
            this.a = a;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            a.setLocation(a.getX(), a.getY() + SPEED);
            System.out.println("DOWN");
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
