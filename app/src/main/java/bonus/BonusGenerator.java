package bonus;

import java.util.Random;
import pangGuy.gui.Shape;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;

/**
 * Generates a Random Bonus at a Random Position
 */
public class BonusGenerator {

    private static final int BONUS_WIDTH = 20;
    private static final int BONUS_HEIGHT = 20;
    
    private final int baseScore = 100;
    private final Pair<Integer, Integer> bounds;

    /**
     * Creates a BonusGenerator.
     * @param bounds the window Bounds
     */
    public BonusGenerator(Pair<Integer, Integer> bounds){
        this.bounds = bounds;
    }

    private int getRandomInt(int bound){
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    private int generateNextScore(){
        return this.baseScore * (this.getRandomInt(8) + 1); //8 + 1 in order to avoid 0: [1, 9]
    }

    private EntityPos2D generateRandomPos(){
        Random rand = new Random();
        return new EntityPos2D(rand.nextInt(this.bounds.getX() - BONUS_WIDTH), this.bounds.getY() - BONUS_HEIGHT);
    }

    private Shape generateRandomShape(){
        return new Shape(this.generateRandomPos(), BONUS_WIDTH, BONUS_HEIGHT);
    }

    /**
     * Generates a random bonus at a random position.
     * @return
     */
    public BonusEntity generateNextBonus(){
        return new BonusEntity(this.generateNextScore(), generateRandomShape());
    }

}
