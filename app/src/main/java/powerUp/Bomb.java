package powerUp;

import ball.controller.Runner;
import ball.physics.Dimensions;

public class Bomb {
    private final Runner context;

    public Bomb (Runner context) {
        this.context = context;
    }

    public void activate() {
        this.context.getBalls().forEach(t -> {
            if (!t.getBallPosition().getDimension().equals(Dimensions.GRANDSON)) {
                this.context.duplication(t);
            }
        });
    }
}
