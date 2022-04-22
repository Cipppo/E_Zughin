package powerUp;

import ball.controller.BallRunner;
import ball.physics.Dimensions;

/**
 * Bomb implements {@link powerUp.PowerUp}, and this item
 * cause the duplication of all the balls present in current game,
 * except the balls with a dimension equal to {@link ball.physics.Dimensions#GRANDSON}.
 */
public class Bomb implements PowerUp {
    private final BallRunner context;

    public Bomb (BallRunner context) {
        this.context = context;
    }

    @Override
    public void activate() {
        this.context.getBalls().forEach(t -> {
            if (!t.getBallPosition().getDimension().equals(Dimensions.GRANDSON)) {
                this.context.duplication(t);
            }
        });
    }

    /**
     * This Powerup has't a lifespan, once it's activated, it ends.
     */
    @Override
    public boolean isActive() {
        return false;
    }
}
