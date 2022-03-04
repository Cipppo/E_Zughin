package pangGuy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.RenderingHints;




public class Gui extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 800;
    private static final int SIZEY = 600;
    private JButton jb = new JButton("OKOKKOKOKOKOK");
    
    private int x = 100;
    private int y = 100;

    
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
            p.addPoint(this.x, this.y);
            p.addPoint(this.x, this.y + 100);
            p.addPoint(this.x + 100, this.y + 100);
            p.addPoint(this.x + 100, this.y);
            g.drawPolygon(p);

        }
    
    }

    public void update(){
        //this.removeAll();
        this.repaint();
        this.y = this.y+10;
    }
}
