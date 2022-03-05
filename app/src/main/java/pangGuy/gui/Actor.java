package pangGuy.gui;



import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class Actor extends JLabel{
    
    private final Shape s;
    private ActionFactory f;


    public Actor(Shape s){
        this.s = s;
        f = new ActionFactory();

        super.setBackground(Color.black);
        super.setBounds(this.s.getRectangle());
        super.setOpaque(true);

        

        super.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        super.getActionMap().put("upAction", f.getUpAction(s));
        System.out.println(s.getPos().y);


    }

}
