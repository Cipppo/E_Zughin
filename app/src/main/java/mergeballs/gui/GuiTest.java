package mergeballs.gui;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ball.controller.Runner;
import pangGuy.actions.ActionFactory;
import mergeballs.control.EntityHandler;
import pangGuy.actions.ActionApplier;
import pangGuy.character.Hero;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;
import stage.utils.*;
import pangGuy.gui.BoundChecker;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//import stage.components.*;
@SuppressWarnings("unused")
public class GuiTest extends JFrame {
    private final static int WIDTH = CenterOnDefaultScreen.center().width*70/100;
    private final static int HEIGHT = CenterOnDefaultScreen.center().height*70/100;
    private static final int STARTX =  WIDTH / 2;
    private static final int STARTY = (HEIGHT ) - 85 ;


    private VisualTest visual = new VisualTest(WIDTH, HEIGHT, new Pos2D(STARTX, STARTY));
    public Hero hero = new Hero();
    private ActionApplier ap = new ActionApplier(this.visual, this.hero);
    private JPanel panel = this.visual.getVisualTest();
    private final EntityHandler handler = new EntityHandler(this.visual, this.hero.getGset(), this.hero);

    private final ActionFactory factory = new ActionFactory();

    private BoundChecker bc = new BoundChecker(new Pair<Integer, Integer>(0, visual.getBounds().getX()), new Pair<Integer, Integer>(0, visual.getBounds().getY()));

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
