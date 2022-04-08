package pangGuy.character;

import java.util.Timer;
import java.util.TimerTask;

import pangGuy.modularGun.GunSet;

import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;

public class Hero {
    
    private Pos2D pos;
    private Directions direction;
    private GunSet gSet;
    private heroStatus status;

    public Hero(){
        this.pos = new Pos2D(0, 0);
        this.direction = Directions.LEFT;
        this.gSet = new GunSet();
        this.status = heroStatus.NEUTRAL;
    }

    private void updateDirection(Directions dir){
        this.direction = dir;
        this.gSet.setDirections(dir);
    }

    public Directions getDirection(){
        return this.direction;
    }

    public Pos2D getPosition(){
        return this.pos;
    }

    public void move(Directions dir){
        switch (dir) {
            case RIGHT:
                this.pos = new Pos2D(pos.x + 1, pos.y);
                break;
            case LEFT:
                this.pos = new Pos2D(pos.x - 1, pos.y);
                break;
        }
        this.updateDirection(dir);
    }

    public GunSet getGset(){
        return this.gSet;
    }

    public void hit(){
        this.status = heroStatus.HIT;
        System.out.println(this.status);
        Timer timer = new Timer();
        TimerTask hitCond = new hitCondition(this.status);
        timer.schedule(hitCond, 1);
    }

}
