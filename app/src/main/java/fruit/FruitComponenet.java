package fruit;

import java.awt.Color;

import javax.swing.JLabel;

import fruit.utils.Pos2D;

public class FruitComponenet extends JLabel{
	private static final long serialVersionUID = -184196272935894487L;
	private static final int WIDTH = 40;
    private static final int HEIGHT = 40;

    private Shape s;



    public FruitComponenet(Pos2D startPos){
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
