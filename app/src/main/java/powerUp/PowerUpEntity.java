package powerUp;

import pangGuy.gui.Shape;

/**
 * This class models a {@link powerUp.PowerUp}, but as an
 * entity, meaning that it's a {@link powerUp.Pickable} made
 * of an {@link utilities.EntityShape}.
 */
public class PowerUpEntity extends Pickable {
    private final PowerUp powerUp;
    private boolean isActivated;

    public PowerUpEntity(PowerUp powerUp, Shape shape) {
        super(shape);
        this.powerUp = powerUp;
        this.isActivated = false;
    }

    @Override
    public void activate() {
        if (!this.isActivated) {
            this.isActivated = true;
            this.powerUp.activate();
        }
    }

    public PowerUp getPowerUp(){
        return this.powerUp;
    }
}
