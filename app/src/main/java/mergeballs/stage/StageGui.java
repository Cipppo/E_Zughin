package mergeballs.stage;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bonus.Score;
import mergeballs.control.EntityHandler;
import mergeballs.gui.VisualTest;
import pangGuy.actions.ActionApplier;
import pangGuy.actions.ActionFactory;
import pangGuy.character.Hero;
import pangGuy.gui.BoundChecker;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;
import stage.utils.*;
import stage.components.*;
import java.awt.Color;


@SuppressWarnings("unused")
public class StageGui extends JFrame{

    private final int width = CenterOnDefaultScreen.center().width*70/100;
	private final int heigth = CenterOnDefaultScreen.center().height*60/100;
    private final int panelHeight = heigth - 200;
    private final int STARTX = width / 2;
    private final int STARTY = panelHeight - 50;
    

    private VisualTest visual = new VisualTest(this.width, this.panelHeight, new EntityPos2D(STARTX, STARTY));
    public Hero hero = new Hero();
    private ActionApplier ap = new ActionApplier(this.visual, this.hero);
    private JPanel panel = this.visual.getVisualTest();
    private final Score score = new Score();
    private final EntityHandler handler = new EntityHandler(this.visual, this.hero.getGset(), this.hero, this.score);

    private final ActionFactory factory = new ActionFactory();

    private BoundChecker bc = new BoundChecker(new Pair<Integer, Integer>(0, visual.getBounds().getX()));
    
	private final MainPanel mainPanel = new MainPanel();

    private final HUDPanel hud;
    private final P1ScoreSetter scoresetter;
    private final PauseHUDSetter pauseHUDSetter;

    public StageGui(){
        this.hud = new HUDPanel();
        this.scoresetter = new P1ScoreSetter(score, hud);
        this.pauseHUDSetter = new PauseHUDSetter(hud, handler);
        this.scoresetter.start();
        this.pauseHUDSetter.start();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, heigth);
		this.setLayout(null);

		this.setLocationRelativeTo(null);
		this.setResizable(false);

		System.out.println("WIDTH: " + this.width + " HEIGHT: " + this.heigth);
        System.out.println("X START: " + this.STARTX + " Y START: " + this.STARTY);
        System.out.println("Fixed Panel Height: " + this.panelHeight);
        
        this.handler.start();
        
		//this.add(mainPanel, BorderLayout.CENTER);
        
        this.add(panel);
        panel.setLocation(0, 0);
        this.panel.setBackground(Color.red);
        this.panel.setForeground(Color.YELLOW);

        
        this.add(hud);
        this.hud.setLocation(0, this.panelHeight);
        this.hud.setSize(this.width, 170);




		this.setVisible(true);
    }
}