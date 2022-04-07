package ball.testing;

import pangGuy.gui.Shape;
import pangGuy.utilities.Pair;
import pangGuy.utilities.Pos2D;

public class SquaredEnemy{
    private Shape shape;

    public SquaredEnemy(int x, int y, int width, int height) {
        this.shape = new Shape(new Pos2D(x, y), width, height);
    }

    public Pos2D getPosition() {
        return this.shape.getPos();
    }

    public Pair<Integer, Integer> getDimension() {
        return this.shape.getDimensions();
    }

    public Shape getShape() {
        return this.shape;
    }
}
