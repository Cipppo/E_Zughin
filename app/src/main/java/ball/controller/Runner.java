package ball.controller;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

import ball.ballAgent.BallAgent;
import pangGuy.gui.Shape;

public class Runner extends Thread {
    private final CopyOnWriteArrayList<BallAgent> balls;
    private final ConstraintCheck checker;
    private boolean stop;

    public Runner(int ballsToGenerate, ConstraintCheck checker) {
        this.balls = new CopyOnWriteArrayList<>();
        this.checker = checker;
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
                if (!this.stop) {
                    this.balls.forEach(t -> {
                        this.checker.checkConstraints(t);
                    });
                    Thread.sleep(10);
                } else {
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + this.toString() + " Interrupted");
        }
    }

    /**
     * @param entity
     *          by now is a Sqared Entity, need to change to
     *          something in common with arpion and guy.
     */
    public synchronized void checkCollision(Shape enemy) {
        if(!this.balls.isEmpty()) {
            this.balls.forEach(t -> {
                if (this.checker.checkEnemyCollision(enemy, t)) {
                    this.duplication(t);
                }
            });
        }
    }

    public synchronized void duplication(BallAgent ball) {
        this.stop = true;
        try {
            var children = ball.duplicate();
            for (final var i : children) {
                var newAgent = new BallAgent(i);
                this.balls.add(newAgent);
                newAgent.start();
            }
        } catch (IllegalStateException e) { }
        
        ball.terminate();
        this.balls.remove(ball);
        this.stop = false;
    }

    public synchronized void pauseAll() {
        if (!this.balls.isEmpty()) {
            this.balls.forEach(t -> t.pause());
        }
    }

    public void resumeAll() {
        if (!this.balls.isEmpty()) {
            this.balls.forEach(t -> t.restart());
        }
    }

    public synchronized List<BallAgent> getBalls() {
        return this.balls;
    }
}
