package stage.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import stage.utils.CenterOnDefaultScreen;
import stage.utils.MainFontLoader;

public class TimerLabel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8265734918486724201L;
	MainFontLoader fontLoader = new MainFontLoader();
	Font gameFont = fontLoader.load();
    private final JLabel timerLabel = new JLabel("TIME: 90");
    private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;

    private int secondsRemaining = 90;
    private Timer timer;

    public TimerLabel() {
        timerLabel.setFont(gameFont);
        timerLabel.setForeground(Color.BLACK);
        this.setPreferredSize(new Dimension(width*10/100, heigth*3/100));
        this.setOpaque(false);
        this.add(timerLabel);

        simpleTimer();
        timer.start();
    }

    public void simpleTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                secondsRemaining--;
                timerLabel.setText("TIME: " + secondsRemaining);
                if(secondsRemaining == 0) {
                    timer.stop();
                }
            }

        });
    }

    public Timer getTimer() {
        return this.timer;
    }

}
