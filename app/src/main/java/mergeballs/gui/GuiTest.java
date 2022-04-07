package mergeballs.gui;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pangGuy.actions.ActionApplier;
import pangGuy.character.Hero;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;
import stage.utils.*;
//import stage.components.*;
@SuppressWarnings("unused")
public class GuiTest extends JFrame{


    private final static int WIDTH = CenterOnDefaultScreen.center().width*70/100;
    private final static int HEIGHT = CenterOnDefaultScreen.center().height*70/100;


    private static final int HERO_WIDTH = 40;
    private static final int HERO_HEIGHT = 40;

    private static final int STARTX =  WIDTH / 2;
    private static final int STARTY = (HEIGHT - 35) - HERO_HEIGHT;


    private VisualTest visual = new VisualTest(WIDTH, HEIGHT, new Pos2D(STARTX, STARTY));
    public Hero hero = new Hero();
    private ActionApplier ap = new ActionApplier(this.visual, this.hero);
    private JPanel panel = this.visual.getVisualTest();



    public GuiTest(){
        

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.visual.getArpions().forEach(e -> {
            this.add(e);
        });
        
        this.add(visual.getHeroComponent());

        this.add(panel);

        System.out.println(WIDTH);
        System.out.println(HEIGHT);





        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }



    
}
