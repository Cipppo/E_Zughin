package pangGuy.utilities;

public class StepsApplier {

    private static final int HERO_STEP = 5;


    public StepsApplier(){}

    public Pos2D convertHeroPosition(Pos2D pos){
        int x = Math.abs(pos.x * HERO_STEP);
        return new Pos2D(x, pos.y);
    }




    
}
