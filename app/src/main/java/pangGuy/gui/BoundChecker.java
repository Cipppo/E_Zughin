package pangGuy.gui;


import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;



public class BoundChecker {

    private Pair<Integer> x;
    private Pair<Integer> y;

    public BoundChecker(Pair<Integer> x, Pair<Integer> y){
        this.x = x;
        this.y = y;
    }


    public boolean isInside(Pos2D pos ,int width, int height){
        if(pos.x >= this.x.getX() && pos.x + width <= this.x.getY()){
            if(pos.y >= this.y.getX() && pos.y + height <= this.y.getY()){
                System.out.println("PERFORMED");
                return true;
            }
        }
        return false;
    }



    
}
