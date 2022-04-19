package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pangGuy.gui.Shape;
import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;

public class BonusGenerator {

    private static final int BONUS_WIDTH = 15;
    private static final int BONUS_HEIGHT = 15;
    
    private List<Integer> baseScores;
    private final Pair<Integer, Integer> bounds;

    public BonusGenerator(Pair<Integer, Integer> bounds){
        this.baseScores = new ArrayList<>(List.of(10, 100, 1000));
        this.bounds = bounds;
    }

    private int getRandomInt(int bound){
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    private int generateNextScore(){
        return this.baseScores.get(this.getRandomInt(2)) * this.getRandomInt(10);
    }

    private EntityPos2D generateRandomPos(){
        Random rand = new Random();
        return new EntityPos2D(rand.nextInt(this.bounds.getX()), this.bounds.getY());
    }

    private Shape generateRandomShape(){
        return new Shape(this.generateRandomPos(), BONUS_WIDTH, BONUS_HEIGHT);
    }

    public BonusEntity generateNextBonus(){
        return new BonusEntity(this.generateNextScore(), generateRandomShape());
    }

}
