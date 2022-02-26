package ball.ballAgent;

import ball.physics.Pos2D;

/**
 * This class should handle Thread support and all calculus needed to update position;
 */
public class BallAgent extends Thread {
    private final Ball ball;
    private boolean stop;

    public BallAgent() {
        this.ball = BallFactory.randomVelAndAngleBall();
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
}
