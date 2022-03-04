package pangGuy.gui;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ControlPanel extends JFrame{

    private static final int SIZEX = 100;
    private static final int SIZEY = 100;

    private JButton down = new JButton("Down");
    private JButton up = new JButton("Up");
    private JButton left = new JButton("Left");
    private JButton right = new JButton("right");
    private Gui gui;

    public ControlPanel(Gui gui){
        this.gui = gui;
        this.setSize(SIZEX, SIZEY);
        this.setName("Control Panel");
        
        down.addActionListener(e -> {
            this.gui.update();
        });


        this.getContentPane().add(this.down);
        
        this.setVisible(true);
    }
    
}
