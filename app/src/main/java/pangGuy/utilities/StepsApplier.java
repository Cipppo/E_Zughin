package pangGuy.utilities;

import mergeballs.utilities.EntityPos2D;

/**
 * A converter from absolute position to X,Y based position
 */

public class StepsApplier {

    private static final int HERO_STEP = 20;
    private static final int BULLET_STEP = 5;

    private EntityPos2D startPos;

    /**
     * Creates a new StepsApplier given the starting Gui position.
     * @param startpos
     */
    public StepsApplier(EntityPos2D startpos){
        this.startPos = startpos;
    }

    /**
     * Converts Model Position to Gui coords.
     * @param pos
     * @return the GUI coords.
     */
    public EntityPos2D convertHeroPosition(EntityPos2D pos){
        int x = (pos.x * HERO_STEP) + this.startPos.x;
        return new EntityPos2D(x, this.startPos.y);
    }

    /**
     * Converts Model Arpion steps to GUI coords.
     * @param step
     * @return the GUI coords.
     */
    public int covertStepPosition(int step){
        return step * BULLET_STEP;
    }

    /**
     * Converts GUI position to Model Arpion position.
     * @param y
     * @return the Model steps.
     */
    public int fromPixeltoStep(int y){
        return (((this.startPos.y - y) / BULLET_STEP) + 10 );
    }



    
}
