package stage.utils;

import javax.swing.JLabel;

import player.Player;
import stage.components.HUDPanel;
import java.awt.Font;
import java.awt.Color;

public class P1ScoreSetter extends Thread {

    private Player player;
    private HUDPanel hud;
    private int actualScore = 0;
    private MainFontLoader fontLoader = new MainFontLoader();
	private Font gameFont = fontLoader.load();
    private JLabel label = new JLabel();

    public P1ScoreSetter(Player player, HUDPanel hud) {
        this.player = player;
        this.hud = hud;
    }
    
    @Override
    public void run() {
        label.setForeground(Color.WHITE);
        label.setFont(gameFont);

        while (true) {
            try {
                if (this.actualScore != this.player.getScore().getScore()) {
                    this.actualScore = this.player.getScore().getScore();
                    label.setText("" + this.actualScore);
                    this.hud.getHUDPanel()[1][1].removeAll();
                    this.hud.getHUDPanel()[1][1].add(label);
                    this.hud.validate();
                    this.hud.repaint();
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
