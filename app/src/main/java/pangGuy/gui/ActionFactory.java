package pangGuy.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionFactory {


    private class upAction extends AbstractAction{

        private Shape s;

        public upAction(Shape s){
            this.s = s;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            s.getRectangle().setLocation(s.getPos().x, s.getPos().y-1);
            System.out.println(s.getPos().y);
        }
        
    }
    



    public upAction getUpAction(Shape s){
        return new upAction(s);
    }



}
