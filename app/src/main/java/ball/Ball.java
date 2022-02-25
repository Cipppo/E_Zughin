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
        this.actualPosition = new Pos2D(this.bounds.x0 - 0.5, this.bounds.y1);
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
    
    /*
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
    */

    public synchronized void updatePos() {
        time.inc(0.3);
        this.actualPosition.x = this.initialPosition.x +  0.001 * this.velocity.getX() * this.time.x;
        this.actualPosition.y = this.initialPosition.y - 0.001 * (this.velocity.getY() * this.time.y - (0.5*gravity*Math.pow(this.time.y, 2)));
        this.applyConstraints();
        //System.out.println(this.actualPosition + " \t time: " + this.time + " \t "+ this.velocity);
    }

    // this should be cleand
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
