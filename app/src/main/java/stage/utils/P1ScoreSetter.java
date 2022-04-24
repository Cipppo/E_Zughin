package stage.utils;

import javax.swing.JLabel;

import player.Player;
import stage.components.HUDPanel;
import java.awt.Font;
import java.awt.Color;

/**
 * This class changes the score field of the HUD when the guy picks up a bonus.
 */
public class P1ScoreSetter extends Thread implements HUDFieldSetter{

    private Player player;
    private HUDPanel hud;
    private int actualScore = 0;
    private MainFontLoader fontLoader = new MainFontLoader();
	private Font gameFont = fontLoader.load();
    private JLabel scoreLabel = new JLabel();
    private JLabel playerNameLabel = new JLabel();
    private Boolean terminated = false;


    public P1ScoreSetter(Player player, HUDPanel hud) {
        this.player = player;
        this.hud = hud;
        this.scoreLabel.setForeground(Color.WHITE);
        this.scoreLabel.setFont(gameFont);
        this.playerNameLabel.setForeground(Color.WHITE);
        this.playerNameLabel.setFont(gameFont);
        this.playerNameLabel.setText(player.getNickname());
    }
    
    /**
     * This thread is dedicated to the edit of the interested field when the score value changes.
     */
    @Override
    public void run() {
        this.hud.getHUDPanel()[0][0].add(playerNameLabel);
        while (!this.terminated) {
            try {
                if (this.actualScore != this.player.getScore().getScore()) {
                    this.actualScore = this.player.getScore().getScore();
                    this.scoreLabel.setText("" + this.actualScore);
                    this.scoreLabel.setForeground(Color.green);
                    this.hud.getHUDPanel()[1][1].removeAll();
                    this.hud.getHUDPanel()[1][1].add(scoreLabel);
                    this.hud.validate();
                    this.hud.repaint();
                    Thread.sleep(150);
                }else{
                    this.scoreLabel.setForeground(Color.WHITE);
                    this.scoreLabel.setText("" + this.actualScore);
                    this.hud.getHUDPanel()[1][1].removeAll();
                    this.hud.getHUDPanel()[1][1].add(scoreLabel);
                    this.hud.validate();
                    this.hud.repaint();
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void terminate() {
        this.terminated = true;
    }
}
