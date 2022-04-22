package ball.controller;

import java.util.concurrent.CopyOnWriteArrayList;

import java.util.List;

import ball.ballAgent.BallAgent;
import mergeballs.control.Pausable;
import pangGuy.gui.Shape;

/**
 * This class stores and handle all the balls present in the game.
 * Main jobs of this class are:
 * <ul> 
 *      <li>Storing Ball informations</li>
 *      <li>Starting all balls Thread when this class Starts</li>
 *      <li>Checks if balls are touching frame borders using a {@link ball.controller.IntersectionChecker} </li>
 *      <li>Expose duplication method to other class in case there is a collison with an enemy</li>
 *      <li>Expose pausing/resuming methods in case of game interruptions</li>
 * </ul>
 */
public class BallRunner extends Thread implements Pausable {
    private final CopyOnWriteArrayList<BallAgent> balls;
    private final BallBoundChecker checker;
    private boolean stop;

    public BallRunner(int ballsToGenerate, BallBoundChecker checker) {
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
     * Check for each ball if there is a collision with an Entity;
     * @param entity
     *          modeled as a {@link pangGuy.gui.Shape}.
     */
    public synchronized void checkCollision(Shape entity) {
        if(!this.balls.isEmpty()) {
            this.balls.forEach(t -> {
                if (checker.checkEnemyCollision(entity, t)) {
                    this.duplication(t);
                }
            });
        }
    }

    /**
     * Split the ball given as argument.
     * @param ball
     */
    public synchronized void duplication(BallAgent ball) {
        this.stop = true;
        try {
            var children = ball.duplicate();
            for (final var i : children) {
                var newAgent = new BallAgent(i);
                this.balls.add(newAgent);
                newAgent.start();
            }
        } catch (IllegalStateException e) {
            //System.out.println("Cannot duplicate GRANDCHILD ball");
        }
        
        ball.terminate();
        this.balls.remove(ball);
        this.stop = false;
    }

    @Override
    public synchronized void pauseAll() {
        if (!this.balls.isEmpty()) {
            this.balls.forEach(t -> t.pause());
        }
    }

    @Override
    public void resumeAll() {
        if (!this.balls.isEmpty()) {
            this.balls.forEach(t -> t.restart());
        }
    }

    public synchronized List<BallAgent> getBalls() {
        return this.balls;
    }
}
