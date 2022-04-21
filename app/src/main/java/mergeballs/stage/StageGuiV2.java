package mergeballs.stage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import mergeballs.control.Controller;
import mergeballs.gui.VisualTest;
import pangGuy.utilities.EntityPos2D;
import player.Player;
import stage.components.HUDPanel;
import stage.utils.CenterOnDefaultScreen;
import stage.utils.P1ScoreSetter;
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
    private final P1ScoreSetter scoresetter;
    private final PauseHUDSetter pauseHUDSetter;
    
    private Controller controller;

    public StageGuiV2(Player player) {
        this.controller = new Controller(this.visual);
        this.controller.startAll();
        
        this.hud = new HUDPanel();

        this.scoresetter = new P1ScoreSetter(player, this.hud);
        this.pauseHUDSetter = new PauseHUDSetter(this.hud, this.controller.getPauseHandler());

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
