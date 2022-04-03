

package pangGuy.gui;

import javax.swing.JFrame;

import pangGuy.gun.GunRaiser;
import powerUp.DoubleGun;

import java.awt.Color;

import javax.swing.GrayFilter;
import javax.swing.JButton;
import javax.swing.JLabel;

import pangGuy.modularGun.GunSet;
@SuppressWarnings("unused")
public class ControlPanel extends JFrame{

    private static final int SIZEX = 300;
    private static final int SIZEY = 300;

    private JButton jb = new JButton("Double Arpion: not Active");
    private Gui gui;
    private GunSet gSet;
    private JLabel label = new JLabel("Status");

    public ControlPanel(Gui gui){
        this.gui = gui;
        this.gSet = gui.gSet;

        

        this.setSize(SIZEX, SIZEY);
        this.setName("Control Panel");
        this.jb.setBackground(Color.red);
        
        this.jb.addActionListener(e -> {
            new DoubleGun(this.gSet).start();
            new Banner(this.jb).start();
        });

        this.add(jb);
        
        

        this.setVisible(true);
    }
    
    private class Banner extends Thread{
        
        private JButton jb;
        private int timeElapsed;
        private int totalTime;

        public Banner(JButton jb){
            this.jb = jb;
            this.timeElapsed = 0;
            this.totalTime = 15;
        }


        public void run(){
            
            try{
                this.jb.setBackground(Color.green);
                this.jb.setText("Double Arpion: Active");
                Thread.sleep(15000);
                this.jb.setBackground(Color.RED);
                this.jb.setText("Double Arpion: not Active");
            }catch(Exception e){
                System.out.println("\nThread.sleep() Exception: " + e.getMessage());
            }
            
        }

      

    }


}
