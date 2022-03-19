package pangGuy.utilities;

public class Pos2D{

    public int x;
    public int y;


    public Pos2D(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString(){
        return "(x = " + this.x + "| y = " + this.y + ")" ;
    }

}