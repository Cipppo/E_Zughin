package ball.physics;

public class Velocity2D {
    public double vx;
    public double vy;

    public Velocity2D(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public double getX() {
        return vx;
    }

    public double getY() {
        return vy;
    }

    public void invertXSing() {
        this.vy = -this.vy;
    }

    public void invertYSing() {
        this.vy = -this.vy;
    }

    @Override
    public String toString() {
        return "Velocity(" + this.vx + ", " + this.vy + ")";
    }
}
