package powerUp;

import pangGuy.gui.Shape;

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
