package ball.physics;

public class Time {
    private double x, y;

    public Time(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void inc(double fact) {
        this.x+=fact;
        this.y+=fact;
    }

    public void resetX() {
        this.x = 0.0;
    }
    
    public void resetY() {
        this.y = 0.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Time(" + this.x + ", " + this.y + ")";
    }
}
