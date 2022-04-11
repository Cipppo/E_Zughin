package mergeballs.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import pangGuy.modularGun.GunSet;
import powerUp.DoubleGun;
import powerUp.StickyArpion;

import java.awt.Color;

@SuppressWarnings("unused")
public class ControlPanelTest extends JFrame {
    
    private static final int SIZEX = 300;
    private static final int SIZEY = 300;

    private JButton jb = new JButton("Double Arpion: not Active");
    private JButton jb2 = new JButton("Sticky Arpion: not Active");
    private JButton jb3 = new JButton("HIT");
    private JButton jb4 = new JButton("Hero Hit");
    private GuiTest gui;
    private GunSet gSet;
    private JLabel label = new JLabel("Status");

    private JPanel panel = new JPanel();

    public ControlPanelTest(GuiTest gui){
        this.gui = gui;
        this.gSet = gui.hero.getGset();

        this.setSize(SIZEX, SIZEY);
        this.setName("Control Panel");
        this.jb.setBackground(Color.red);
        this.jb2.setBackground(Color.red);

        this.jb.addActionListener(e -> {
            new DoubleGun(this.gSet).start();
            new Banner(this.jb).start();
        });

        this.jb2.addActionListener(e -> {
            new StickyArpion(this.gSet).start();
            new Banner(this.jb2).start();
        });



        this.panel.add(jb);
        this.panel.add(jb2);
        //this.panel.add(jb3);
        this.panel.add(jb4);
        this.getContentPane().add(this.panel);
        
        

        this.setVisible(true);

    }

        
    private class Banner extends Thread{
        
        private JButton jb;

        public Banner(JButton jb){
            this.jb = jb;

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
