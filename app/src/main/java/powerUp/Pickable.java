package powerUp;

import ball.controller.IntersectionChecker;
import pangGuy.gui.HeroComponent;
import pangGuy.gui.Shape;

/**
 * Class that models a pickable object (Fruit or {@link powerUp.PowerUp}).
 * A Pickable wraps a {@link pangGuy.gui.Shape} and an instance of Fruit or PowerUp.
 * This class will be used to handle the moment of picking up this item by
 * the {@link pangGuy.character.Hero} and activating it's specified effect.
 */
public abstract class Pickable {
    private final Shape shape;

    protected Pickable(Shape shape) {
        this.shape = shape;
    }
   
    /**
     * activating the Item wrapped by this class
     */
    public abstract void activate();
    
    /**
     * @param hero
     * @return true if the hero picked this item up
     */
    public boolean isPickedUp(HeroComponent hero) {
        return IntersectionChecker.checkItemPickUp(hero.getShape(), this.shape);
    }
    
    public Shape getShape() {
        return this.shape;
    }
}