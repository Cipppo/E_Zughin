package pangGuy.gui;

import javax.swing.JFrame;

import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;
import pangGuy.actions.ActionApplier;
import pangGuy.actions.ActionFactory;
import pangGuy.gun.Gun;




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

    private final Actor actor = new Actor(this.shape);
    private final Gun gun = new Gun(this.actor);

    private final Moover moover = new Moover(this.actor, this.gun, this.bChecker);
    
    private final ActionFactory factory = new ActionFactory();
    private final ActionApplier aa = new ActionApplier(this.actor,this.moover, this.factory);

    
    public Gui() {
        this.setSize(SIZEX, SIZEY);
        this.setTitle("Pang Guy gui");
        this.setLayout(null);
        this.add(this.gun);
        this.add(this.actor);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);  
        
        
    }
   
}
