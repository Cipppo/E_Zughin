package mergeballs.utilities;

public class EntityPos2D {
    
    public int x;
    public int y;

    public EntityPos2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(x = " + this.x + "| y = " + this.y + ")" ;
    }

}
