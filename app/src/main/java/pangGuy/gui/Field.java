package pangGuy.gui;

import pangGuy.utilities.Pair;


public class Field {
    
    private final Pair<Integer> sizeX;
    private final Pair<Integer> sizeY;
    //Possibility to add a Set of Boundary such as obstacles


    public Field(int x1, int x2, int y1, int y2){
        this.sizeX = new Pair<Integer>(x1,x2);
        this.sizeY = new Pair<Integer>(x1, x2);
    }


    public Pair<Integer> getSizeX(){
        return this.sizeX;
    }

    public Pair<Integer> getSizeY(){
        return this.sizeY;
    }



}
