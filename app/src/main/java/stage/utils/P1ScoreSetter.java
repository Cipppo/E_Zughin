package stage.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bonus.Score;

public class P1ScoreSetter extends Thread {

    private Score score;
    JPanel[][] hud;

    public P1ScoreSetter(Score score, JPanel[][] hud) {
        this.score = score;
        this.hud = hud;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                this.hud[1][1].removeAll();
                this.hud[1][1].add(new JLabel("" + this.score.getScore()));
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
