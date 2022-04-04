package pangGuy.utilities;


import pangGuy.gui.Shape;


public class PosConverter {
    
    private Pair<Integer, Integer> dimensions;
    private Shape shape;

    public PosConverter(Pair<Integer, Integer> dimensions, Shape shape){
        this.dimensions = dimensions;
        this.shape = shape;
    }


    private Pos2D getLeftPos(){
        return this.shape.getLeftFoot();
    }


    private Pos2D getRightPos(){
        int x = (this.shape.getLeftFoot().x + (int) this.shape.getDimensions().getX()) - this.dimensions.getX();
        int y = this.shape.getLeftFoot().y;
        return new Pos2D(x, y);
    }

    public Pos2D getPos(Directions dir){
        if(dir == Directions.RIGHT){
            return getRightPos();
        }else{
            return getLeftPos();
        }
    }
}
