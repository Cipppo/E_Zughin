package pangGuy.gui;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ControlPanel extends JFrame{

    private static final int SIZEX = 50;
    private static final int SIZEY = 50;

    private JButton jb = new JButton();
    private Gui gui;

    public ControlPanel(Gui gui){
        this.gui = gui;
        this.setSize(SIZEX, SIZEY);
        this.setName("Control Panel");
        
        jb.addActionListener(e -> {
            this.gui.update();
        });

        this.getContentPane().add(this.jb);

    }
    
}
