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
    
    
    public Ball(Trajectory trajectory, SpherePos2D position, double gravity) {
    	this.trajectory = trajectory;
    	this.actualPosition = position;
    	this.initialPosition = new SpherePos2D(position.x, position.y, position.getDimension());
    	this.velocity = this.trajectory.getXYVelocity();
    	this.gravity = gravity;
        this.size = this.getPosition().getDiameter();
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
