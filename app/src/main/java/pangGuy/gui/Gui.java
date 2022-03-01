package pangGuy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Gui {

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 800;
    private static final int SIZEY = 600;
    private JButton jb = new JButton("OKOKKOKOKOKOK");
    private JPanel panel = new JPanel();
    private JFrame frame;
    
    public Gui() {
     
        JFrame frame=new JFrame();  
                          
        // Creating Button          
        JButton b = new JButton();
        
        b.setBounds(50,50,90, 50);  
             
        //Adding button onto the frame
        frame.add(b);  
                  
        // Setting Frame size. This is the window size
        frame.setSize(300,200);  
        
        frame.setLayout(null);  
        frame.setVisible(true);  
                  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
}
