package ball.ballAgent;

import ball.Boundary;
import ball.physics.*;

import java.util.Random;

/**
 * This is the structure of the ball, described by:
 *      - A trajectory
 *      - A two dimensional position
 */
public class Ball {
    private Trajectory trajectory;
    private Pos2D actualPosition;
    private Velocity2D velocity;

    private static final double GRAVITY = 9.81;
    private Time time = new Time(0.0, 0.0);
    private Boundary bounds;
    private Pos2D initialPosition;
    //private boolean stop = false;

    // all temporary boundaries
    private static final double MAX_ANGLE = 80;
    private static final double MIN_ANGLE = 40;
    private static final double MAX_VELOCITY = 150;
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
    /**
     * Need to implement thread support and consequently:
     *      -a class for handling view/model interactions (update ball position -> draw ball position)
     *          already created Visualiser class, need to change name of that and all Guis components;
     *      -try to disassemble this class (thread delegation scares me) and build an entity and follow SRP
     *          meaning that one class will handle movement and time, and another one is more like a structure that 
     *          stores velocity values, (got to implement dimensions in the space), positions and maybe traj.
     *      -Need to implement starting Y value, and how to handle the first launch without compromising 
     *      	initial velocity; (I think this could be optional);
     */

    public synchronized void updatePos() {
        time.inc(0.1);
        this.actualPosition.x = this.initialPosition.x +  0.001 * this.velocity.getX() * this.time.getX();
        this.actualPosition.y = this.initialPosition.y - 0.001 * (this.velocity.getY() * this.time.getY() 
                                                            - (0.5*GRAVITY*Math.pow(this.time.getY(), 2)));
        this.checkConstraints();
    }

    // this should be cleaned
    private void checkConstraints() {
        if(this.actualPosition.y > bounds.y1) {
            this.applyConstraints(bounds.y1, 0);
        } else if (this.actualPosition.y < bounds.y0) {
            this.applyConstraints(bounds.y0, 0);
        } else if (this.actualPosition.x > bounds.x1 - 0.05) {
            this.applyConstraints(bounds.x1 - 0.05, 1);
        } else if (this.actualPosition.x < bounds.x0) {
            this.applyConstraints(bounds.x0, 1);
        }
    }

    // gotta find something better than that int
    private void applyConstraints(double bound, int axis) {
        if (axis == 0) {
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
}
