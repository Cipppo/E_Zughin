package pangGuy.modularGun;

import pangGuy.utilities.Directions;

/**
 * Models one Arpion.
 */

public class Arpion implements Bullet {
    
    private Status status;
    private Directions direction;
    private int waitTime;
    private int steps;
    
    /**
     * Creates one Arpion with default values.
     */
    public Arpion(){
        this.waitTime = 0;
        this.status = Status.IDLE;
        this.direction = Directions.LEFT;
        this.steps = 0;
    }

    @Override
    public void restore() {
        this.status = Status.IDLE;

        this.steps = 0;
    }

    @Override
    public void raise() {
        this.steps++;
    }

    @Override
    public void lock(){
        this.setStatus(Status.RISING);
    }
    
    @Override
    public void unlock(){
        this.setStatus(Status.IDLE);
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

    private void setStatus(Status status) {
        this.status = status;
        
    }

    @Override 
    public int getStepsDone(){
        return this.steps;
    }

    @Override
    public void hit() {
        if(this.status == Status.RISING){
            this.setStatus(Status.HIT);
        }
    }

    @Override 
    public String toString(){
        return "Status:" + this.status + "Direction: " + this.direction;
    }
}
