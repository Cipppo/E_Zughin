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
import pangGuy.gun.GunRaiser;



@SuppressWarnings("unused")
public class Gui extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 1000;
    private static final int SIZEY = 500;

    
    private static final int WIDTH = 50;
    private static final int HEIGHT = 100;

    private static final int STARTX = SIZEX / 2;
    private static final int STARTY = (SIZEY - 35) - HEIGHT;

    
    //private final Guy guy = new Guy(STARTX, STARTY);

   private final Shape shape = new Shape(new Pos2D(STARTX, STARTY), WIDTH, HEIGHT);

    private final BoundChecker bChecker = new BoundChecker(new Pair<Integer>(0, SIZEX),
     new Pair<Integer>(0, SIZEY));

    
    public final Actor actor = new Actor(this.shape);

    public final Gun gun = new Gun(this.actor, Color.green);
    public final Gun gun2 = new Gun(this.actor, Color.ORANGE);

    public final Raiser raiser = new Raiser(this.gun, this.bChecker);
    public final GunRaiser gunRaiser = new GunRaiser(this.gun, this.gun2, this.bChecker);

    private final Moover moover = new Moover(this.actor, this.gun, this.gun2, this.bChecker);
    
    private final ActionFactory factory = new ActionFactory();
    private final ActionApplier aa = new ActionApplier(this.actor,this.moover, this.factory, this.gunRaiser);


    
    
    public Gui() {
        this.setSize(SIZEX, SIZEY);
        this.setTitle("Pang Guy gui");
        this.getContentPane().setLayout(null);
        this.add(this.gun);
        this.add(gun2);
        this.add(this.actor);
        
        


        
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);  
        
        
    }
   
}
