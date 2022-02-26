package ball.ballAgent;

import ball.Boundary;
import ball.physics.*;

import java.awt.Dimension;
import java.util.Random;

enum Axis {
	XAXIS,
	YAXIS;
}

/**
 * Need to implement thread support and consequently:
 *      -TODO: try to disassemble this class (thread delegation scares me) and build an entity and follow SRP
 *          meaning that one class will handle movement and time, and another one is more like a structure that 
 *          stores velocity values, (got to implement dimensions in the space), positions and maybe traj.
 *      -TODO: Need to implement starting Y value, and how to handle the first launch without compromising 
 *      	initial velocity; (I think this could be optional);
 *      -TODO: generate random x position and at a fixed height Y
 *      -TODO: create a timer for suspension of balls during pre-game phase
 *      -TODO: implement function that splits ball into other two with opposite Velocity2D.vx
 */

/**
 * This is the structure of the ball, described by:
 *      - A trajectory
 *      - A two dimensional position
 */
public class Ball {
    private Trajectory trajectory;
    private Pos2D actualPosition;
    private Velocity2D velocity;

    private Time time = new Time(0.0, 0.0);
    private Pos2D initialPosition;
    //private boolean stop = false;

    private static final double GRAVITY = 9.81;
    // all temporary boundaries
    private static final double MAX_ANGLE = 80;
    private static final double MIN_ANGLE = 50;
    private static final double MAX_VELOCITY = 150;
    private static final double MIN_VELOCITY = 80;


    public Ball() {
        Random rand = new Random();
        var angle = rand.nextDouble() * (MAX_ANGLE - MIN_ANGLE) + MIN_ANGLE;
        var initialVelocity = rand.nextDouble() * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
        trajectory = new Trajectory(angle, initialVelocity);
        this.actualPosition = new Pos2D(Boundary.X0.getValue(), Boundary.Y1.getValue(), Dimensions.FATHER);
        this.initialPosition = new Pos2D(actualPosition.x, actualPosition.y, Dimensions.FATHER);
        this.velocity = this.trajectory.getXYVelocity();
    }

    public synchronized void updatePos() {
        time.inc(0.2);
        this.actualPosition.x = this.initialPosition.x +  0.001 * this.velocity.getX() * this.time.getX();
        this.actualPosition.y = this.initialPosition.y - 0.001 * (this.velocity.getY() * this.time.getY() 
                                                            - (0.5*GRAVITY*Math.pow(this.time.getY(), 2)));
        this.checkConstraints();
    }

    // this should be cleaned
    private void checkConstraints() {
        if(this.actualPosition.y > Boundary.Y1.getValue()) {
            this.applyConstraints(Boundary.Y1.getValue(), Axis.YAXIS);
        } else if (this.actualPosition.y < Boundary.Y0.getValue()) {
            this.applyConstraints(Boundary.Y0.getValue(), Axis.YAXIS);
        } else if (this.actualPosition.x > Boundary.X1.getValue() - 0.05) {
            this.applyConstraints(Boundary.X1.getValue() - 0.05, Axis.XAXIS);
        } else if (this.actualPosition.x < Boundary.X0.getValue()) {
            this.applyConstraints(Boundary.X0.getValue(), Axis.XAXIS);
        }
    }

    private void applyConstraints(double bound, Axis axis) {
        if (axis == Axis.YAXIS) {
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
