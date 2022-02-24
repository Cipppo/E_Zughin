package ball;

import ball.physics.*;

import java.util.Random;


/**
 * It has to be a thread in the future
 */
public class Ball extends Thread {
    private Trajectory trajectory;
    private Pos2D actualPosition;
    private Velocity2D velocity;
    private final double gravity = 9.81;
    private Time time = new Time(0.0, 0.0);
    private Boundary bounds;
    private Pos2D initialPosition;
    private boolean stop = false;

    // all temporary boundaries
    private static final double MAX_ANGLE = 80;
    private static final double MIN_ANGLE = 30;
    private static final double MAX_VELOCITY = 90;
    private static final double MIN_VELOCITY = 50;


    public Ball() {
        Random rand = new Random();
        var angle = rand.nextDouble() * (MAX_ANGLE - MIN_ANGLE) + MIN_ANGLE;
        var initialVelocity = rand.nextDouble() * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
        trajectory = new Trajectory(angle, initialVelocity);
        this.bounds = new Boundary(0, 0, 1, 1);
        this.actualPosition = new Pos2D(this.bounds.x0, this.bounds.y1);
        this.initialPosition = new Pos2D(actualPosition.x, actualPosition.y);
        this.velocity = this.trajectory.getXYVelocity();

    }

    @Override
    public void run() {
        try {
            while(!this.stop) {
                this.updatePos();
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void terminate() {
        this.stop = true;
    }

    public synchronized void updatePos() {
        time.inc(0.3);
        this.actualPosition.x = this.initialPosition.x +  0.001 * this.velocity.getX() * this.time.x;
        this.actualPosition.y = this.initialPosition.y - 0.001 * (this.velocity.getY() * this.time.y - (0.5*gravity*Math.pow(this.time.y, 2)));
        this.applyConstraints();
        System.out.println(this.actualPosition + " \t time: " + this.time + " \t "+ this.velocity);
    }

    private void applyConstraints() {
        if(this.actualPosition.y > bounds.y1) {
            this.initialPosition.y = bounds.y1;
            this.time.y = 0.0;
            this.velocity.vy = -this.velocity.vy;
        } else if (this.actualPosition.y < bounds.y0 + 0.1) {
            this.initialPosition.y = bounds.y0 + 0.1;
            this.time.y = 0.0;
            this.velocity.vy = -this.velocity.vy;
        } else if (this.actualPosition.x > bounds.x1 - 0.1) {
            this.initialPosition.x = bounds.x1 - 0.1;
            this.time.x = 0.0;
            this.velocity.vx = -this.velocity.vx;
        } else if (this.actualPosition.x < bounds.x0) {
            this.initialPosition.x = bounds.x0;
            this.time.x = 0.0;
            this.velocity.vx = -this.velocity.vx;
        }
    }

    public synchronized Pos2D getCurrentPosition() {
        return this.actualPosition;
    }
}
