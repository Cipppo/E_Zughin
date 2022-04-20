package bonus;

import java.util.Random;
import pangGuy.gui.Shape;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;

public class BonusGenerator {

    private static final int BONUS_WIDTH = 15;
    private static final int BONUS_HEIGHT = 15;
    
    private final int baseScore = 100;
    private final Pair<Integer, Integer> bounds;

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
        return new EntityPos2D(rand.nextInt(this.bounds.getX()), this.bounds.getY() - BONUS_HEIGHT);
    }

    private Shape generateRandomShape(){
        return new Shape(this.generateRandomPos(), BONUS_WIDTH, BONUS_HEIGHT);
    }

    public BonusEntity generateNextBonus(){
        return new BonusEntity(this.generateNextScore(), generateRandomShape());
    }

}
