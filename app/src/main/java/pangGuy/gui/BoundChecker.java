package pangGuy.gui;


import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;



public class BoundChecker {

    private Pair<Integer, Integer> x;
    private Pair<Integer, Integer>  y;

    public BoundChecker(Pair<Integer, Integer>  x, Pair<Integer, Integer>  y){
        this.x = x;
        this.y = y;
    }


    public boolean isInside(Pos2D pos ,int width, int height){
        if(pos.x >= this.x.getX() + 8 && pos.x + width <= this.x.getY() - 8){
        
            //System.out.println("PERFORMED");
            return true;
        }
        return false;
    }


    public boolean isExtendible(Pos2D pos){
        if(pos.y > 0 + 35){
            return true;
        }else{
            return false;
        }
    }
    
}
