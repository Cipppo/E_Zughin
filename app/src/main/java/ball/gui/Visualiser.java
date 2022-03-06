package ball.gui;

import ball.ballAgent.BallAgent;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.BorderLayout;
import java.util.ArrayList;
/**
 * This makes the BallAgent communicate with the Visual
 * When implementing GUI with collegues, remove CONTROL PANEL
 * Its purpose it's only for Testing reasons.
 */
public class Visualiser extends Thread {
    private final Visual frame;
    private final ControlPanel controlPane;
    private final List<BallAgent> balls;
    private boolean stop;
    
    
    public Visualiser(int ballsToGenerate) {
        this.frame = new Visual();
        this.controlPane = new ControlPanel(this);
        this.frame.add(this.controlPane, BorderLayout.NORTH);
        this.frame.setVisible(true);
        this.balls = new ArrayList<>();
        this.stop = false;
        
        for (int i = 0; i < ballsToGenerate; i++) {
            this.balls.add(new BallAgent());
        }
    }


    @Override
    public void run() {
        try {
            this.balls.forEach(t -> t.start());
            while(true) {
                if(!this.stop) {
                    this.frame.updatePosition(this.balls.stream()
                        .map(t -> t.getBallPosition())
                        .collect(Collectors.toList()));
                    Thread.sleep(20);
                } else {
                    Thread.sleep(20);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public synchronized List<BallAgent> getBalls() {
    	return this.balls;
    }
    //Maybe try to create an ad Hoc exception
    //Need to clean this mess
    public synchronized void duplicatation() {
        if (!this.balls.isEmpty()) {
            this.stop = true;
            var ball = this.balls.get(0);
            try { 
                var children = ball.duplicate();
                if (!children.isEmpty()) {
                    for (final var i : children) {
                        var newAgent = new BallAgent(i);
                        this.balls.add(newAgent);
                        newAgent.start();                    
                    }
                }
                ball.terminate();
                this.balls.remove(ball);
            } catch (IllegalStateException e) {
                ball.terminate();
                this.balls.remove(ball);
            }
            
            this.stop = false;
        }
    }

    /**
     * Pause/Freeze all balls
     */
    public synchronized void pauseAll() {
        if (!this.balls.isEmpty()) {
            this.balls.forEach(t -> {
                t.pause();
            });
        }
    }

    /**
     * Resume all balls that are freezed
     */
    public void resumeAll() {
        if(!this.balls.isEmpty()) {
            this.balls.forEach(t -> {
                t.restart();
            });
        }
    }
}
