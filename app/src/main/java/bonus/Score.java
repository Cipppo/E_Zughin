package bonus;

/**
 * The class models the Score of a player
 */
public class Score {
    
    private int score;

    /**
     * Creates a new Score with 0 points.
     */
    public Score(){
        this.score = 0;
    }

    /**
     * Resets the actual score.
     */
    public void resetScore(){
        this.score = 0;
    }
    
    /**
     * Getter fot the score.
     * @return the actual Score.
     */
    public int getScore(){
        return this.score;
    }

    /**
     * Adds the points given to the actual score.
     * @param points
     */
    public void raiseScore(int points){
        this.score += points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        return "Actual Score: " + this.score;
    }


}
