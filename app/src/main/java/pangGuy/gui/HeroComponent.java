package pangGuy.gui;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;

import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;

public class HeroComponent extends JPanel{

    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;

    private Shape s;



    public HeroComponent(Pos2D startPos){
        this.s = new Shape(startPos, WIDTH, HEIGHT);

        super.setBackground(Color.black);
        super.setBounds(this.s.getRectangle());
        super.setOpaque(true);

    }


    public void changeLocation(Pos2D pos){
        super.setLocation(pos.x, pos.y);
        this.s = new Shape(pos, WIDTH, HEIGHT);

    }

    public Shape getShape(){
        return this.s;
    }




}