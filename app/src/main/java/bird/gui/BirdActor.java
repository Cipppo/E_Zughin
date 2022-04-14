package bird.gui;

import javax.swing.JLabel;

import bird.utilities.BirdDirections;
import bird.utilities.BirdPNGLoader;
import bird.utilities.BirdPos2D;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class BirdActor extends JLabel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1967410748214691856L;
    
	private BirdShape s;
    private final BirdPNGLoader iLoader = new BirdPNGLoader();

    public BirdActor(BirdShape s){
        this.s = s;
        
        super.setBounds(this.s.getRectangle());
        super.setOpaque(false);
        
    }
    
    public void changeLocation(BirdPos2D pos){

        super.setLocation(pos.x, pos.y);
        this.s = new BirdShape(pos, this.s.getDimensions().getX(), 
        this.s.getDimensions().getY(), this.getShape().getDireciton());  
    }

    public BirdShape getShape(){
        return this.s;
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(iLoader.getBirdImage(this.getShape().getDireciton() == BirdDirections.RIGHT ? BirdDirections.RIGHT : BirdDirections.LEFT, s.getPos()), 
                0, 0, null);

        g2.dispose();
    }
}
