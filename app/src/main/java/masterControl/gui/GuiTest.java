package masterControl.gui;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ball.controller.BallRunner;
import bonus.Score;
import masterControl.control.EntityHandler;
import pangGuy.actions.ActionFactory;
import pangGuy.actions.ActionApplier;
import pangGuy.character.Hero;
import pangGuy.utilities.Pair;
import stage.utils.*;
import pangGuy.gui.BoundChecker;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import pangGuy.utilities.EntityPos2D;


@SuppressWarnings("unused")
public class GuiTest extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int WIDTH = CenterOnDefaultScreen.center().width*70/100;
    private final static int HEIGHT = CenterOnDefaultScreen.center().height*70/100;
    private static final int STARTX =  WIDTH / 2;
    private static final int STARTY = (HEIGHT ) - 85 ;


    private VisualTest visual = new VisualTest(WIDTH, HEIGHT, new EntityPos2D(STARTX, STARTY));
    public Hero hero = new Hero();
    private ActionApplier ap = new ActionApplier(this.visual, this.hero);
    private JPanel panel = this.visual.getVisualTest();
    private final Score score = new Score();
    private final EntityHandler handler = new EntityHandler(this.visual, this.hero);

    private final ActionFactory factory = new ActionFactory();

    private BoundChecker bc = new BoundChecker(new Pair<Integer, Integer>(0, visual.getBounds().getX()));

    public GuiTest() {
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(panel);
        this.handler.start();

        System.out.println(WIDTH);
        System.out.println(HEIGHT);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }    
}
