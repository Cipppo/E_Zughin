package pangGuy.modularGun;

import pangGuy.utilities.Directions;

public class Arpion implements Bullet {

    /*
    private static final int WIDTH = 10;
    private static final int HEIGHT = 2;
    private static final int SPEED = 4;
    */
    
    private Status status;
    private Directions direction;
    private int waitTime;
    private int steps;

    public Arpion(){
        this.waitTime = 0;
        this.status = Status.IDLE;
        this.direction = Directions.LEFT;
        this.steps = 0;
    }

    @Override
    public void restore() {
        this.steps = 0;
        this.status = Status.IDLE;
    }

    @Override
    public void raise() {
        this.status = Status.RISING;
    }
    
    @Override
    public void changeDir(Directions dir){
        this.direction = dir;
    }
    
    @Override
    public Directions getDirection(){
        return this.direction;
    }

    @Override 
    public Status getStatus(){
        return this.status;
    }

    @Override
    public int getWaitTime() {
        return this.waitTime;
    }

    @Override
    public void setWaitTime(int newWaitTime){
        this.waitTime = newWaitTime;
    }

    
    @Override
    public void setStatus(Status status) {
        this.status = status;
        
    }

    @Override
    public void step(){
        this.steps ++;
    }

    @Override 
    public int getStepsDone(){
        return this.steps;
    }
    
    @Override 
    public String toString(){
        return "Status:" + this.status + "Direction: " + this.direction;
    }

}
