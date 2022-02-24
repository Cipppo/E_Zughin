package ball.physics;

public class Time {
    public double x, y;

    public Time(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void inc(double fact) {
        this.x+=fact;
        this.y+=fact;
    }

    @Override
    public String toString() {
        return "Time(" + this.x + ", " + this.y + ")";
    }
}
