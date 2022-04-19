package ball.physics;
/**
 * Time is a class used by {@link ball.ballAgent.Ball} for modeling
 * X and Y times. When the ball hits a wall in X, Time.X value is 
 * reset to 0 while Y time keeps going on, and viceversa when the 
 * hits the ground or "roof" of the stage.
 */
public class Time {
    private double x, y;

    public Time(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Increment the time of a given factor. Smaller the number, 
     * smaller is the update movement of {@link ball.ballAgent.Ball}, 
     * and viceversa. Suggested factor (0.09).
     * @param factor of increment of time
     */
    public void inc(double factor) {
        this.x+=factor;
        this.y+=factor;
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
