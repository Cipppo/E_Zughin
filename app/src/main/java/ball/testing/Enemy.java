package ball.testing;

import ball.physics.Dimensions;
import ball.physics.Entity;
import ball.physics.Pos2D;

public class Enemy implements Entity {

    private final Pos2D position;
    private final int size;

    public Enemy(double x, double y, int size) {
        this.position = new Pos2D(x, y, Dimensions.STD, size);
        this.size = size;
    }

    @Override
    public Pos2D getPosition() {
        return this.position;
    }

    @Override
    public int getSize() {
        return this.size;
    }
    
}
