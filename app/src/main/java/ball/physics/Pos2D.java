package ball.physics;


/**
 * got to implent serializable for thread support
 */
public class Pos2D {
    public double x;
    public double y;

    public Pos2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Pos2D sum(Pos2D p2) {
        return new Pos2D(this.x + p2.x, this.y + p2.y);
    }

    public Pos2D sub(Pos2D p2) {
        return new Pos2D(this.x - p2.x, this.y - p2.y);
    }

    @Override
    public String toString() {
        return "Pos(" + this.x + ", " + this.y + ")";
    }
}
