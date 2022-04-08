package mergeballs.gui;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pangGuy.actions.ActionFactory;
import mergeballs.control.BallRunner;
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
public class GuiTest extends JFrame implements KeyListener{


    private final static int WIDTH = CenterOnDefaultScreen.center().width*70/100;
    private final static int HEIGHT = CenterOnDefaultScreen.center().height*70/100;


    private static final int HERO_WIDTH = 40;
    private static final int HERO_HEIGHT = 100;

    private static final int STARTX =  WIDTH / 2;
    private static final int STARTY = (HEIGHT - 35) - HERO_HEIGHT;


    private VisualTest visual = new VisualTest(WIDTH, HEIGHT, new Pos2D(STARTX, STARTY));
    public Hero hero = new Hero();
    private ActionApplier ap = new ActionApplier(this.visual, this.hero);
    private JPanel panel = this.visual.getVisualTest();
    //private final BallRunner ballRunner = new BallRunner(this.visual);
    private final ActionFactory factory = new ActionFactory();

    private BoundChecker bc = new BoundChecker(new Pair<Integer, Integer>(0, visual.getBounds().getX()), new Pair<Integer, Integer>(0, visual.getBounds().getY()));

    public GuiTest(){
        

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(panel);
        //this.ballRunner.start();
        //this.visual.updatePosition(pos); <- i Don't know how to get the positions
        System.out.println(WIDTH);
        System.out.println(HEIGHT);





        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                this.factory.getLeftAction(this.visual, this.hero, this.bc);
                break;
            case 32:
                this.factory.getShootAction(this.visual, this.hero, this.bc);
                break;
            case 39:
                this.factory.getRightAction(this.visual, this.hero, this.bc);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }



    
}
