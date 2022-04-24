package powerUp;

import pangGuy.gui.Shape;

/**
 * Models a basic Visual Entity for a powerup.
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
