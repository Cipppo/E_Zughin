package bird.gui;

import javax.swing.JLabel;

import bird.utilities.Directions;
import bird.utilities.ImageLoader;
import bird.utilities.Pos2D;
import stage.utils.CenterOnDefaultScreen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Optional;

public class Actor extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1967410748214691856L;


    private static final int SIZEX = CenterOnDefaultScreen.center().width*70/100;
    private static final int SIZEY = CenterOnDefaultScreen.center().height*70/100;
    
	private Shape s;
    private final ImageLoader iLoader = new ImageLoader();

    public Actor(Shape s){
        this.s = s;
        
        super.setBackground(Color.black);
        super.setBounds(this.s.getRectangle());
        super.setOpaque(true);
        
    }
    
    public void changeLocation(Pos2D pos){

        super.setLocation(pos.x, pos.y);
        this.s = new Shape(pos, this.s.getDimensions().getX(), 
        this.s.getDimensions().getY(), Optional.of(this.getShape().getDireciton()));  
    }

    public Shape getShape(){
        return this.s;
    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.clearRect(0, 0, SIZEX, SIZEY);

        g2.drawImage(iLoader.getBirdImage(this.getShape().getDireciton() == Directions.RIGHT ? Directions.RIGHT : Directions.LEFT), 
                0, 0, null);

        g2.dispose();
    }
}
