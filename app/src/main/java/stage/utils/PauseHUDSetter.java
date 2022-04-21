package stage.utils;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mergeballs.control.EntityHandler;
import stage.components.HUDPanel;
import stage.components.StageNameLabel;

public class PauseHUDSetter extends Thread {
    
    private final HUDPanel hud;
    private final EntityHandler handler;
    private final MainFontLoader fontLoader = new MainFontLoader(2);
	private final Font gameFont = fontLoader.load();
    private final JLabel resumeLabel = new JLabel("ESC: RESUME", SwingConstants.CENTER);
	private final JLabel exitLabel = new JLabel("ENTER: EXIT", SwingConstants.CENTER);
    private final JLabel StageNameLabel = new StageNameLabel();
    private Boolean stageNameVisible = true;

    public PauseHUDSetter(HUDPanel hud, EntityHandler handler) {
        this.hud = hud;
        this.handler = handler;
    }
    
    @Override
    public void run() {
        exitLabel.setFont(gameFont);
		resumeLabel.setFont(gameFont);
		resumeLabel.setVerticalAlignment(JLabel.BOTTOM);
		exitLabel.setVerticalAlignment(JLabel.NORTH);
		resumeLabel.setForeground(Color.GREEN);
		exitLabel.setForeground(Color.GREEN);

        while (true) {
            try {
                if (this.handler.getPauseStatus() && this.stageNameVisible) {
                    this.hud.getHUDPanel()[0][3].removeAll();
                    this.hud.getHUDPanel()[1][3].removeAll();
                    this.hud.getHUDPanel()[0][3].add(resumeLabel);
                    this.hud.getHUDPanel()[1][3].add(exitLabel);
                    this.stageNameVisible = false;
                    this.hud.validate();
                    this.hud.repaint();
                } else if (!this.handler.getPauseStatus() && !this.stageNameVisible) {
                    this.hud.getHUDPanel()[0][3].removeAll();
                    this.hud.getHUDPanel()[1][3].removeAll();
                    this.hud.getHUDPanel()[0][3].add(StageNameLabel);
                    this.stageNameVisible = true;
                    this.hud.validate();
                    this.hud.repaint();
                }
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
