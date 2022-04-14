package bird.utilities;

/**
 * Expresses the position of the bird on the basis of the abscissas and ordinates
 */
public class BirdPos2D{

    public int x;
    public int y;


    public BirdPos2D(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString(){
        return "(x = " + this.x + "| y = " + this.y + ")" ;
    }

}