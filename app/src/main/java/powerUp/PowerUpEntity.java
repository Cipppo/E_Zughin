package powerUp;

import pangGuy.gui.Shape;

public class PowerUpEntity extends Pickable {
    private final PowerUp powerUp;

    public PowerUpEntity(PowerUp powerUp, Shape shape) {
        super(shape);
        this.powerUp = powerUp;
    }

    @Override
    public void activate() {
        this.powerUp.activate();
    }
}
