package ball.ballAgent;

import ball.Boundary;
import ball.physics.*;

enum Axis {
	XAXIS,
	YAXIS;
}

/**
 * Need to implement thread support and consequently:
 *      -TODO: create a timer for suspension of balls during pre-game phase
 */

/**
 * This is the structure of the ball, described by:
 *      - A trajectory
 *      - A two dimensional position
 */
public class Ball {
    private Trajectory trajectory;
    private Pos2D actualPosition;
    private Pos2D initialPosition;
    private final Velocity2D velocity;
    private Time time = new Time(0.0, 0.0);
    private final double gravity;
    
    
    public Ball(Trajectory trajectory, Pos2D position, double gravity) {
    	this.trajectory = trajectory;
    	this.actualPosition = position;
    	this.initialPosition = new Pos2D(position.x, position.y, position.getDimension());
    	this.velocity = this.trajectory.getXYVelocity();
    	this.gravity = gravity;
    }

    public synchronized void updatePos() {
        time.inc(0.09);
        this.actualPosition.x = this.initialPosition.x +  0.001 * this.velocity.getX() * this.time.getX();
        this.actualPosition.y = this.initialPosition.y - 0.001 * (this.velocity.getY() * this.time.getY() 
                                                            - (0.5*gravity*Math.pow(this.time.getY(), 2)));
        //System.out.println(this.actualPosition);
    }

    public synchronized void applyConstraints(double bound, Boundary axis) {
        if (axis == Boundary.Y0 || axis == Boundary.Y1) {
            this.initialPosition.y = bound;
            this.time.resetY();
            this.velocity.vy = -this.velocity.vy;
        } else {
            this.initialPosition.x = bound;
            this.time.resetX();
            this.velocity.vx = -this.velocity.vx;
        }
    }

    public synchronized Pos2D getCurrentPosition() {
        return this.actualPosition;
    }

    public synchronized Trajectory getTrajectory() {
        return this.trajectory;
    }

    public  synchronized Velocity2D getVelocity() {
        return this.velocity;
    }
}
