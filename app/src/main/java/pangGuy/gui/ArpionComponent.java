package pangGuy.gui;

import pangGuy.utilities.Directions;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;
import pangGuy.utilities.PosConverter;


import java.awt.Color;

import javax.swing.JPanel;

public class ArpionComponent extends JPanel{
    
    private static final int WIDTH = 10;
    private static final int HEIGHT = 2;

    private Shape s;
    private final int serialNumber;

    public ArpionComponent(Color color, Pos2D startpos, int serial){
        this.s = new Shape(startpos, WIDTH, HEIGHT);
        this.serialNumber = serial;

        super.setBackground(color);
        super.setForeground(color);
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

    public void setDirection(Directions dir, Shape shape){
        PosConverter posConverter = new PosConverter(new Pair<Integer,Integer>(WIDTH, HEIGHT), shape);
        this.changeLocation(posConverter.getPos(dir));

    }

}
