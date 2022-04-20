package ball.physics;

import java.util.function.Function;

/**
 * Models a {@link ball.ballAgent.Ball} trajectory, describing the 
 * motion of a body launched at a certain initial velocity, and 
 * at a certain angle at X0 and Y0.
 */
public class Trajectory {
    private double theta;
    private double initialVelocity;

    public Trajectory(double angle, double initialVelocity) {
        this.theta = angle;
        this.initialVelocity = initialVelocity;
    }

    /**
     * This method calculates and returns horizontal and vertical speed
     * given an initial velocity and the angle of the trajectory.
     * @return {@link ball.physics.Velocity2D}
     */
    public Velocity2D getXYVelocity() {
        double vx = this.relativeSpeed(this.initialVelocity, this.theta, x -> Math.cos(x));
        double vy = this.relativeSpeed(this.initialVelocity, this.theta, x -> Math.sin(x));
        return new Velocity2D(vx, vy);
    }

    /**
     * Calculating the speed relative to x or y using cos and sin respectively.
     * @param v0
     * @param theta
     * @param func
     * @return
     */
    private double relativeSpeed(double v0, double theta, Function<Double, Double> func) {
        return v0 * func.apply(Math.toRadians(theta));
    }

    public double getAngle() {
        return this.theta;
    }
    
    public double getInitialVelocity() {
        return this.initialVelocity;
    }
}