

package pangGuy.gui;

import javax.swing.JFrame;

import pangGuy.gun.GunRaiser;
import powerUp.DoubleGun;

import javax.swing.GrayFilter;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("unused")
public class ControlPanel extends JFrame{

    private static final int SIZEX = 300;
    private static final int SIZEY = 300;

    private JButton jb = new JButton("Raise");
    private Gui gui;
    private GunRaiser gRaiser;
    private JLabel label = new JLabel("Status");
    public ControlPanel(Gui gui){
        this.gui = gui;
        this.gRaiser = gui.gunRaiser;
        
        this.setSize(SIZEX, SIZEY);
        this.setName("Control Panel");
        
        this.jb.addActionListener(e -> {
            new DoubleGun(this.gRaiser).start();
        });

        this.add(jb);
        this.setVisible(true);
    }
    
    private class Banner extends Thread{
        
    }


}
