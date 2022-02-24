package ball;

public class Boundary {
    public double x0;
    public double y0;
    public double x1;
    public double y1;

    public Boundary(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public double getX0() {
        return this.x0;
    }

    public double getY0() {
        return this.y0;
    }

    public double getX1() {
        return this.x1;
    }

    public double getY1() {
        return this.y1;
    }
}
