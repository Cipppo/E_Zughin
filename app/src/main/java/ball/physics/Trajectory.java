package ball.physics;

import java.util.function.Function;

public class Trajectory {
    private double theta;
    private double initialVelocity;

    public Trajectory(double angle, double initialVelocity) {
        this.theta = angle;
        this.initialVelocity = initialVelocity;
    }

    public Velocity2D getXYVelocity() {
        double vx = this.angularSpeed(this.initialVelocity, this.theta, x -> Math.cos(x));
        double vy = this.angularSpeed(this.initialVelocity, this.theta, x -> Math.sin(x));
        return new Velocity2D(vx, vy);
    }

    private double angularSpeed(double v0, double theta, Function<Double, Double> func) {
        return v0 * func.apply(Math.toRadians(theta));
    }

    public double getAngle() {
        return this.theta;
    }
    
    public double getInitialVelocity() {
        return this.initialVelocity;
    }
}