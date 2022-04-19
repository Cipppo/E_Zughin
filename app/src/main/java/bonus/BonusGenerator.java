package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BonusGenerator {
    
    List<Integer> baseScores;

    public BonusGenerator(){
        this.baseScores = new ArrayList<>(List.of(10, 100, 1000));
    }

    private int getRandomInt(int bound){
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    public int generateNextScore(){
        return this.baseScores.get(this.getRandomInt(2)) * this.getRandomInt(10);
    }

}
