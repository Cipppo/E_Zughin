package powerUp;

import pangGuy.gui.Shape;

/**
<<<<<<< HEAD
 * This class models a {@link powerUp.PowerUp}, but as an
 * entity, meaning that it's a {@link powerUp.Pickable} made
 * of an {@link utilities.EntityShape}.
=======
 * Models a basic Visual Entity for a powerup.
>>>>>>> feature
 */
public class PowerUpEntity extends Pickable {
    private final PowerUp powerUp;
    private boolean isActivated;

    /**
     * Returns a new PowerupEntity.
     * @param powerUp
     * @param shape
     */
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

    /**
     * Getter for the PowerUp.
     * @return the PowerUp associated.
     */
    public PowerUp getPowerUp(){
        return this.powerUp;
    }
}
