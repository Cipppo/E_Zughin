package ball.ballAgent;

import ball.Boundary;
import ball.physics.*;
/**
 * This is the structure of the ball, described by:
 *      - A trajectory
 *      - A two dimensional position
 */
public class Ball implements Entity {
    private Trajectory trajectory;
    private SpherePos2D actualPosition;
    private SpherePos2D initialPosition;
    private final Velocity2D velocity;
    private Time time = new Time(0.0, 0.0);
    private final double gravity;
    private final int size;
    private final double tickFactor;
    
    /**
     * Constructor used and called only from the factory in this same package.
     * @param trajectory
     * @param position
     * @param gravity
     * @param tickFactor
     *          fraction of time of refresh of the ball. Small ticks lead to slower balls.
     */
    protected Ball(Trajectory trajectory, SpherePos2D position, double gravity, double tickFactor) {
    	this.trajectory = trajectory;
    	this.actualPosition = position;
    	this.initialPosition = new SpherePos2D(position.getX(), position.getY(), position.getDimension(), position.getDiameter());
    	this.velocity = this.trajectory.getXYVelocity();
    	this.gravity = gravity;
        this.size = this.getPosition().getDiameter();
        this.tickFactor = tickFactor;
    }

    /**
     * Updates the position of the ball, basing the calculations on Projectile Motion'sequations.
     */
    public synchronized void updatePos() {
        time.inc(tickFactor);
        this.actualPosition.setX(this.initialPosition.getX() +  0.001 * this.velocity.getX() * this.time.getX());
        this.actualPosition.setY(this.initialPosition.getY() - 0.001 * (this.velocity.getY() * this.time.getY() 
                                        - (0.5*gravity*Math.pow(this.time.getY(), 2))));
    }

    /**
     * Whenever the ball hits a wall, this method will be called.
     * It's necessary to pass as argument a postion (double beetween -1 and 1)
     * because floating point precision cause bad bugs when displaying 
     * the ball bouncing in wall. In {@link ball.controller.BallBoundChecker#checkConstraints(BallAgent)}
     * there are small variations in X1 and Y1 axis and thanks to those values, when hitting the wall
     * the transition in the other direction is smoother.
     * 
     * NOTE: In MacOS Y1 limit is below the frame of the gui, and for avoiding seeing the ball
     * disappear under the Y1 boundary, i've added a bigger offset than X1.
     * 
     * @param position
     *          the position that the ball need to occupy in this moment.
     * @param bound
     *          Y or X boundary, needed by this method to determinate wich velocity 
     *              (Horizontal or Vertical) to invert.
     */
    public synchronized void applyConstraints(double position, Boundary bound) {
        if (bound == Boundary.Y0 || bound == Boundary.Y1) {
            this.initialPosition.setY(position);
            this.time.resetY();
            this.velocity.vy = -this.velocity.vy;
        } else {
            this.initialPosition.setX(position);
            this.time.resetX();
            this.velocity.vx = -this.velocity.vx;
        }
    }
    @Override
    public synchronized SpherePos2D getPosition() {
        return this.actualPosition;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public synchronized Trajectory getTrajectory() {
        return this.trajectory;
    }

    public  synchronized Velocity2D getVelocity() {
        return this.velocity;
    }
}
