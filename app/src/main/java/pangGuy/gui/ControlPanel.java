

package pangGuy.gui;

import javax.swing.JFrame;



import javax.swing.JButton;


public class ControlPanel extends JFrame{

    private static final int SIZEX = 300;
    private static final int SIZEY = 300;

    private JButton jb = new JButton("Raise");
    private Gui gui;

    public ControlPanel(Gui gui){
        this.gui = gui;
        this.setSize(SIZEX, SIZEY);
        this.setName("Control Panel");
        
        this.jb.addActionListener(e -> {
            this.gui.gun.raise();
        });

        this.add(jb);
        this.setVisible(true);
    }
    
}
