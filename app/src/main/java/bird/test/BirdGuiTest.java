package bird.test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mergeballs.control.EntityHandler;
import mergeballs.gui.VisualTest;
import pangGuy.actions.ActionApplier;
import pangGuy.actions.ActionFactory;
import pangGuy.character.Hero;
import pangGuy.gui.BoundChecker;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;
import stage.utils.CenterOnDefaultScreen;

public class BirdGuiTest extends JFrame{
    
	private static final long serialVersionUID = -3558174777161143038L;
	private final static int WIDTH = CenterOnDefaultScreen.center().width*70/100;
    private final static int HEIGHT = CenterOnDefaultScreen.center().height*48/100;
    private static final int STARTX =  WIDTH / 2;
    private static final int STARTY = (HEIGHT ) - 85 ;


    private VisualTest visual = new VisualTest(WIDTH, HEIGHT, new EntityPos2D(STARTX, STARTY));
    public Hero hero = new Hero();
    private JPanel panel = this.visual.getVisualTest();
    private final EntityHandler handler = new EntityHandler(this.visual, this.hero);

    public BirdGuiTest() {
        new ActionApplier(this.visual, this.hero);
        new ActionFactory();
        new BoundChecker(new Pair<Integer, Integer>(0, visual.getBounds().getX()));

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
