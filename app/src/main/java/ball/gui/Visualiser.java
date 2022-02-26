package ball.gui;

import ball.ballAgent.BallAgent;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
/**
 * This makes the BallAgent communicate with the Visual
 */
public class Visualiser extends Thread {
    private final Visual frame;
    private final List<BallAgent> balls;
    
    
    public Visualiser(int ballsToGenerate) {
        this.frame = new Visual();
        this.frame.setVisible(true);
        this.balls = new ArrayList<>();
        
        
        for (int i = 0; i < ballsToGenerate; i++) {
            this.balls.add(new BallAgent());
        }
    }


    @Override
    public void run() {
        try {
            this.balls.forEach(t -> t.start());
            while(true) {
                this.frame.updatePosition(this.balls.stream()
                        .map(t -> t.getBallPosition())
                        .collect(Collectors.toList()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public synchronized List<BallAgent> getBalls() {
    	return this.balls;
    }
    
    public synchronized void removeBall() {
    	var ball = this.balls.get(this.balls.size() - 1);
    	ball.terminate();
    	this.balls.remove(ball);
    }
}
