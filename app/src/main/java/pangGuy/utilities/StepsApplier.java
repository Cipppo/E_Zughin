package pangGuy.utilities;



public class StepsApplier {

    private static final int HERO_STEP = 5;
    private static final int BULLET_STEP = 5;

    private Pos2D startPos;

    public StepsApplier(Pos2D startpos){
        this.startPos = startpos;
    }

    public Pos2D convertHeroPosition(Pos2D pos){
        int x = (pos.x * HERO_STEP) + this.startPos.x;
        return new Pos2D(x, this.startPos.y);
    }

    public int covertStepPosition(int step){
        return step * BULLET_STEP;
    }

    public int fromPixeltoStep(int y){
        return (((this.startPos.y - y) / BULLET_STEP) + 10 );
    }



    
}
