package ball.ballAgent;

import java.util.List;

import ball.physics.Dimensions;
import ball.physics.Pos2D;

/**
 * This class should handle Thread support and all calculus needed to update position;
 */
public class BallAgent extends Thread {
    private final Ball ball;
    private boolean stop;

    public BallAgent() {
        //this.ball = BallFactory.randomVelAndAngleBall();
        this.ball = BallFactory.randomPos();
        this.stop = false;
    }

    public BallAgent(final Ball ball) {
        this.ball = ball;
        this.stop = false;
    }

    @Override
    public void run() {
        try {
            while(!this.stop) {
                this.ball.updatePos();
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void terminate() {
        this.stop = false;
    }

    public synchronized Pos2D getBallPosition() {
        return this.ball.getCurrentPosition();
    }

    //Absolutaly to be cleaned
    public synchronized List<Ball> duplicate() {
        // TODO: change gravity to something dynamic
        var ball1 = this.generateBall();
        var ball2 = this.generateBall();

        ball1.getVelocity().vx = -ball1.getVelocity().vx;

        return List.of(ball1, ball2);
    }

    private Ball generateBall() {
        if (this.ball.getCurrentPosition().getDimension() != Dimensions.GRANDSON) {
            return BallFactory.fromFatherBall(this.ball);
        } else {
            throw new IllegalStateException();
        }
    }
}
