package pangGuy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Gui extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 800;
    private static final int SIZEY = 600;
    private JButton jb = new JButton("OKOKKOKOKOKOK");
    private VisualPanel pan = new VisualPanel();
    
    
    public Gui() {
        this.setSize(SIZEX, SIZEY);
        this.setTitle("Pang Guy gui");
        this.setLayout(new BorderLayout());
        

        this.getContentPane().add(this.jb, BorderLayout.SOUTH);
        this.getContentPane().add(this.pan, BorderLayout.NORTH);

        this.jb.addActionListener(e ->{

            this.pan.up();
            System.out.println("Done");

        });


        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);  
        
        
    }

    public class VisualPanel extends JPanel{

        public VisualPanel(){
            this.setSize(SIZEX, SIZEY);
            
        }

        public void paint(Graphics g){

            
            g.setColor(Color.green);


            g.fillOval(100, 200, 40, 20);
        }
        
        public void up(){
            this.repaint();
        }


    }
        
}
