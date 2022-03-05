package pangGuy.gui;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

public class Actor extends JLabel{
    
    private final Shape s;

    public Actor(Shape s){
        this.s = s;

        super.setBackground(Color.black);
        super.setBounds(this.s.getRectangle());
        super.setOpaque(true);
    }


}
