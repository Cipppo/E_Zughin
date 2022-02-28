package pangGuy.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 800;
    private static final int SIZEY = 600;
    
    public Gui() {
        this.setTitle("Pang guy");
        this.setSize(SIZEX, SIZEY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setResizable(false);
        
        
        
        this.setVisible(true);
    }
    
    
    

}
