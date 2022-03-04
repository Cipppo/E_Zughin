package pangGuy.gui;

import javax.swing.JFrame;

import pangGuy.utilities.Directions;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class ControlPanel extends JFrame{

    private static final int SIZEX = 300;
    private static final int SIZEY = 300;

    private JButton down = new JButton("Down");
    private JButton up = new JButton("Up");
    private JButton left = new JButton("Left");
    private JButton right = new JButton("right");
    private final JButton center = new JButton("Controller");
    private Gui gui;

    public ControlPanel(Gui gui){
        this.gui = gui;
        this.setSize(SIZEX, SIZEY);
        this.setName("Control Panel");
        this.setLayout(new BorderLayout());
        
        down.addActionListener(e -> {
            this.gui.update(Directions.DOWN);
        });

        up.addActionListener(e -> {
            this.gui.update(Directions.UP);
        });

        left.addActionListener(e -> {
            this.gui.update(Directions.LEFT);
        });

        right.addActionListener(e -> {
            this.gui.update(Directions.RIGHT);
        });
        


        this.getContentPane().add(this.down, BorderLayout.SOUTH);
        this.getContentPane().add(this.up, BorderLayout.NORTH);
        this.getContentPane().add(this.left, BorderLayout.WEST);
        this.getContentPane().add(this.right, BorderLayout.EAST);
        this.getContentPane().add(this.center, BorderLayout.CENTER);

        this.setVisible(true);
    }
    
}
