package pangGuy;

import pangGuy.utilities.*;

//Scorporare i vari aspetti, posizione deve avere una sua classe



public class Guy {

    private int x;
    private int y;


    public Guy(int x, int y ){
        this.x = x;
        this.y = y;
    }

    
    public void move(Directions d){
        switch (d) {
            case DOWN:
                this.y++;
                break;
            case UP:
                this.y--;
                break;
            case LEFT:
                this.x--;
                break;
            case RIGHT:
                this.x++;
                break;
            default:
                break;
        }
    }

    public Pair<Integer> getPositions(){
        return new Pair<Integer>(this.x, this.y);

    }



}
