package ball.testing;

import pangGuy.gui.Shape;
import mergeballs.utilities.EntityPos2D;
import mergeballs.utilities.FullPair;

public class SquaredEnemy{
    private Shape shape;

    public SquaredEnemy(int x, int y, int width, int height) {
        this.shape = new Shape(new EntityPos2D(x, y), width, height);
    }

    public EntityPos2D getPosition() {
        return this.shape.getPos();
    }

    public FullPair<Integer, Integer> getDimension() {
        return this.shape.getDimensions();
    }

    public Shape getShape() {
        return this.shape;
    }
}
