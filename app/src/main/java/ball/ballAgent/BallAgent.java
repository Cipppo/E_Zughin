package ball.ballAgent;

import java.util.List;

import ball.Boundary;
import ball.physics.Dimensions;
import ball.physics.SpherePos2D;

/**
 * This class should handle Thread support and all calculus needed to update position;
 */
public class BallAgent extends Thread {
    private final Ball ball;
    private boolean stop;
    private boolean paused;

    public BallAgent() {
        this.ball = BallFactory.randomPos();
        //this.ball = BallFactory.moonBall();
        this.stop = false;
        this.paused = false;
    }

    public BallAgent(final Ball ball) {
        this.ball = ball;
        this.stop = false;
    }

    @Override
    public void run() {
        try {
            while(!this.stop) {
                while(this.paused) {
                    Thread.sleep(20);//Don't know now how to handle this, tried to reduce CPU bounding as much as possibile
                }
                this.ball.updatePos();
                Thread.sleep(15);
            }
        } catch (Exception e) { 
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }

    public synchronized void terminate() {
        this.stop = false;
    }

    public synchronized SpherePos2D getBallPosition() {
        return this.ball.getPosition();
    }

    /**
     * 
     * @return List<Ball> the two childern Ball.
     * 
     * @throws IllegalStateException if the ball isn't splittable;
     */
    public synchronized List<Ball> duplicate() {
        if (this.ball.getPosition().getDimension() != Dimensions.GRANDSON) {
            var ball1 = this.generateBall();
            var ball2 = this.generateBall();

            ball1.getVelocity().vx = -ball1.getVelocity().vx;

            return List.of(ball1, ball2);
        } else {
            throw new IllegalStateException();
        }

    }

    private Ball generateBall() {
        return BallFactory.fromFatherBall(this.ball);
    }

    public synchronized void pause() {
        this.paused = true;
    }
    /**
     * Maybe try to implement a version with a specific time to wait before resuming;
     * it comes useful in the implementation of a Pause Menu and a 3-2-1 timer when closing.
     */
    public synchronized void restart() {
        this.paused = false;
    }

    public void applyConstraints(double d, Boundary x0) {
        this.ball.applyConstraints(d, x0);
    }

    public synchronized int getSize() {
        return this.ball.getSize();
    }
}
