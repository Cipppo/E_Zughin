package ball.ballAgent;

import java.util.List;

import ball.Boundary;
import ball.physics.Dimensions;
import ball.physics.SpherePos2D;

/**
 * This class has the job to wrap the concept of a {@linkplain ball.ballAgent.Ball}. 
 * This class create a ball and stores all its values. It has also
 * the job to constantly update the ball position, and it offers a 
 * variety of method to change the status and the behaviour of the 
 * ball.
 */
public class BallAgent extends Thread {
    private final Ball ball;
    private boolean stop;
    private boolean paused;

    public BallAgent() {
        this.ball = BallFactory.randomPos();
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
                    Thread.sleep(20);
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
     * This method duplicate the current ball into other 2 child balls.
     * The new Balls will have same parameter as this ball, except:
     * <ul>
     * <li>the first ball will have inverted x velocity</li>
     * <li>new balls will have different dimension (depend on the {@link Dimensions})</li>
     * </ul>
     * 
     * The expected behaviour is that, when this method is called, the ball creates 
     * two other balls, one goes to the left, and the other goes to the right.
     * 
     * @return Two childern Ball.
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

    /**
     * Pause the ball if not already paused
     */
    public synchronized void pause() {
        if (!this.paused) {
            this.paused = true;
        }
    }
    
    /**
     * Restart the ball if was paused
     */
    public synchronized void restart() {
        if (this.paused) {
            this.paused = false;
        }
    }

    /**
     * 
     * @param position the new position of the ball
     * @param bound the stage boundary where the ball crashed into (X0, X1, Y0, Y1).
     */
    public void applyConstraints(double position, Boundary bound) {
        this.ball.applyConstraints(position, bound);
    }

    /**
     * @return the size of the ball (diameter)
     */
    public synchronized int getSize() {
        return this.ball.getSize();
    }
}
