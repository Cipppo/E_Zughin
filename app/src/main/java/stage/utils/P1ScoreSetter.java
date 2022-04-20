package stage.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bonus.Score;

public class P1ScoreSetter extends Thread {

    private Score score;
    private JPanel[][] hud;
    private int actualScore = 0;

    public P1ScoreSetter(Score score, JPanel[][] hud) {
        this.score = score;
        this.hud = hud;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                if(this.actualScore != this.score.getScore()) {
                    this.actualScore = this.score.getScore();
                    this.hud[1][1].removeAll();
                    this.hud[1][1].add(new JLabel("" + this.actualScore));
                }
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
