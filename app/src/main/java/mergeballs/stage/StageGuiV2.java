package mergeballs.stage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import mergeballs.control.Controller;
import mergeballs.control.DeathHandler;
import mergeballs.control.HUDHandler;
import mergeballs.gui.VisualTest;
import pangGuy.character.Hero;
import pangGuy.utilities.EntityPos2D;
import player.Player;
import stage.components.HUDPanel;
import stage.utils.CenterOnDefaultScreen;
import stage.utils.HUDFieldSetter;
import stage.utils.PauseHUDSetter;

public class StageGuiV2 extends JFrame {
    private final int width = CenterOnDefaultScreen.center().width*70/100;
	private final int heigth = CenterOnDefaultScreen.center().height*60/100;
    private final int panelHeight = heigth - 200;
    private final int STARTX = width / 2;
    private final int STARTY = panelHeight - 50;

    private VisualTest visual = new VisualTest(this.width, this.panelHeight, new EntityPos2D(STARTX, STARTY));
    private JPanel panel = this.visual.getVisualTest();
    private final HUDPanel hud;
    private final HUDHandler hudHandler;
    private final HUDFieldSetter pauseHUDSetter;

    private final DeathHandler deathHandler; 
    private final Hero hero;
    private Controller controller;
    private Player player;

    public StageGuiV2(Player player) {
        this.hero = new Hero();
        this.player = player;
        this.controller = new Controller(this.visual, player, this.hero);
        this.controller.startAll();
        
        this.hud = new HUDPanel();
        this.hudHandler = new HUDHandler(this.hud, player, this.hero);
        this.hudHandler.startAll();

        this.pauseHUDSetter = new PauseHUDSetter(this.hud, this.controller.getPauseHandler());
        this.pauseHUDSetter.start();

        this.deathHandler = new DeathHandler(this, this.hero);
        this.deathHandler.start();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, heigth);
		this.setLayout(null);

		this.setLocationRelativeTo(null);
		this.setResizable(false);

        System.out.println("WIDTH: " + this.width + " HEIGHT: " + this.heigth);
        System.out.println("X START: " + this.STARTX + " Y START: " + this.STARTY);
        System.out.println("Fixed Panel Height: " + this.panelHeight);

        this.add(panel);
        panel.setLocation(0, 0);
        this.panel.setBackground(Color.red);
        this.panel.setForeground(Color.YELLOW);

        this.add(hud);
        this.hud.setLocation(0, this.panelHeight);
        this.hud.setSize(this.width, 170);

        this.setVisible(true);
    }
     
    public void terminator() {
        this.controller.terminator();
        this.hudHandler.terminator();
        this.pauseHUDSetter.terminate();
    }

    //temp
    public Player getPlayer() {
        return this.player;
    }
    //temp
    public Hero getHero() {
        return this.hero;
    }

    public Controller getController(){
        return this.controller;
    }
}
