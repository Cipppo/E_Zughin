package bonus;

public class Score {
    
    private int score;

    public Score(){
        this.score = 0;
    }

    public void resetScore(){
        this.score = 0;
    }
    
    public int getScore(){
        return this.score;
    }

    public void raiseScore(int points){
        this.score += points;
    }



}
