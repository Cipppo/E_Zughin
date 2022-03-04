package pangGuy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import pangGuy.Guy;
import pangGuy.utilities.Directions;
import java.awt.Graphics2D;
import java.awt.RenderingHints;




public class Gui extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 800;
    private static final int SIZEY = 600;
    private static final int DIM = 100;
    
    private final Guy guy = new Guy(100, 100);


    
    public Gui() {
        this.setSize(SIZEX, SIZEY);
        this.setTitle("Pang Guy gui");
        this.setLayout(new BorderLayout());
        

        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);  
        
        
    }


    public void paint(Graphics g){
        
        //g.clearRect(this.x - 30, this.y + 30, 130, 130);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.clearRect(0, 0, SIZEX, SIZEY);
        g.setColor(Color.black);

        synchronized (this){
            Polygon p = new Polygon();
            int x = this.guy.getPositions().getX();
            int y = this.guy.getPositions().getY();

            p.addPoint(x, y);
            p.addPoint(x, y + DIM);
            p.addPoint(x + DIM, y + DIM);
            p.addPoint(x + DIM, y);
            g.drawPolygon(p);

        }
    
    }

    public void update(Directions d){
        //this.removeAll();
        this.repaint();
        this.guy.move(d);
    }
}
