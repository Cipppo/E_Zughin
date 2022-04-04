package pangGuy.character;

import pangGuy.modularGun.GunSet;
import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;

public class Hero {
    
    private Pos2D pos;
    private Directions direction;
    private GunSet gSet;

    public Hero(){
        this.pos = new Pos2D(0, 0);
        this.direction = Directions.LEFT;
        this.gSet = new GunSet();
    }


    public void move(Directions dir){
        switch (dir) {
            case RIGHT:
                this.pos = new Pos2D(pos.x + 1, pos.y);
                break;
            case LEFT:
                this.pos = new Pos2D(pos.y - 1, pos.y);
                break;
        }
    }

}
