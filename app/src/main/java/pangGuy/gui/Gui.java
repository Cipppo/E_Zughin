package pangGuy.gui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;
import powerUp.DoubleGun;
import pangGuy.actions.ActionApplier;
import pangGuy.actions.ActionFactory;
import pangGuy.gun.Gun;
import pangGuy.gun.Raiser;
import pangGuy.modularGun.GunSet;
import pangGuy.gun.GunRaiser;



@SuppressWarnings("unused")
public class Gui extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 1000;
    private static final int SIZEY = 500;

    
    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;

    private static final int STARTX = SIZEX / 2;
    private static final int STARTY = (SIZEY - 35) - HEIGHT;

    public final Actor actor = new Actor(new Shape(new Pos2D(STARTX, STARTY), WIDTH, HEIGHT));
    
    private final Field field = new Field(0, SIZEX, 0, SIZEY);
    public final GunSet gSet = new GunSet(this.actor, this.field);

    private final ActionApplier aa = new ActionApplier(this.actor, this.gSet, this.field);

    
    
    public Gui() {
        this.setSize(SIZEX, SIZEY);
        this.setTitle("Pang Guy gui");
        this.getContentPane().setLayout(null);
        this.gSet.getArpions().forEach(e -> {
            this.add((JPanel) e);
        });
        this.add(this.actor);
        
        


        
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);  
        
        
    }
   
}
