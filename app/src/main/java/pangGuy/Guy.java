package pangGuy;

import pangGuy.utilities.*;

//Scorporare i vari aspetti, posizione deve avere una sua classe



public class Guy {

    Pos2D pos;


    public Guy(int x, int y ){
        pos = new Pos2D(x, y);
    }

    
    public void move(Directions d){
        switch (d) {
            case DOWN:
                this.pos.y++;
                break;
            case UP:
                this.pos.y--;
                break;
            case LEFT:
                this.pos.x--;
                break;
            case RIGHT:
                this.pos.x++;
                break;
            default:
                break;
        }
    }

    public Pos2D getPosition(){
        return this.pos;
    }



}
