package bird.gui;

import pangGuy.utilities.Pair;
import bird.utilities.BirdPos2D;

public class BirdBoundChecker {

    private Pair<Integer, Integer> x;
    private Pair<Integer, Integer> y;

    public BirdBoundChecker(Pair<Integer, Integer> x, Pair<Integer, Integer> y){
        this.x = x;
        this.y = y;
    }


    public boolean isInside(BirdPos2D pos ,int width, int height){
        if(pos.x >= this.x.getX() && pos.x + width <= this.x.getY()){
            if(pos.y >= this.y.getX() && pos.y + height <= this.y.getY() - 35){
                //System.out.println("PERFORMED");
                return true;
            }
        }
        return false;
    }

    public Pair<Integer, Integer> getXPair() {
        return this.x;
    }

    public Pair<Integer, Integer> getYPair() {
        return this.y;
    }
    
}
