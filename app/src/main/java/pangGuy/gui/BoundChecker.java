package pangGuy.gui;


import pangGuy.utilities.Pos2D;
import pangGuy.utilities.Pair;



public class BoundChecker {

    private Pair<Integer, Integer> x;


    public BoundChecker(Pair<Integer, Integer>  x){
        this.x = x;
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
