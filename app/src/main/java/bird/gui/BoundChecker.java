package bird.gui;

import bird.utilities.Pair;
import bird.utilities.Pos2D;

public class BoundChecker {

    private Pair<Integer> x;
    private Pair<Integer> y;

    public BoundChecker(Pair<Integer> x, Pair<Integer> y){
        this.x = x;
        this.y = y;
    }


    public boolean isInside(Pos2D pos ,int width, int height){
        if(pos.x >= this.x.getX() && pos.x + width <= this.x.getY()){
            if(pos.y >= this.y.getX() && pos.y + height <= this.y.getY() - 35){
                //System.out.println("PERFORMED");
                return true;
            }
        }
        return false;
    }

    public Pair<Integer> getXPair() {
        return this.x;
    }

    public Pair<Integer> getYPair() {
        return this.y;
    }
    
}
