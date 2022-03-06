package pangGuy.gui;

import javax.swing.JFrame;

import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;



public class Gui extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private static final int SIZEX = 800;
    private static final int SIZEY = 600;

    private static final int STARTX = 100;
    private static final int STARTY = 100;

    private static final int WIDTH = 50;
    private static final int HEIGHT = 100;

    
    //private final Guy guy = new Guy(STARTX, STARTY);

   private final Shape shape = new Shape(new Pos2D(STARTX, STARTY), WIDTH, HEIGHT);

    private final BoundChecker bChecker = new BoundChecker(new Pair<Integer>(0, SIZEX),
     new Pair<Integer>(0, SIZEY));

    private final Actor actor = new Actor(this.shape, this.bChecker);
    private final ActionFactory factory = new ActionFactory();
    
    private final ActionApplier aa = new ActionApplier(this.actor, this.factory);

    
    public Gui() {
        this.setSize(SIZEX, SIZEY);
        this.setTitle("Pang Guy gui");
        this.setLayout(null);
        this.add(this.actor);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);  
        
        
    }
   
}
