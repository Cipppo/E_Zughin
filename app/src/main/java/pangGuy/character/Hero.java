package pangGuy.character;

import pangGuy.utilities.EntityPos2D;
import mergeballs.control.Pausable;
import pangGuy.modularGun.GunSet;
import pangGuy.utilities.Directions;
import pangGuy.modularGun.GunBag;

/**
 * Models the model of the main character.
 */

public class Hero implements Pausable{

    private EntityPos2D pos;
    private Directions direction;
    private GunBag gSet;
    private HeroStatus status;
    private int lives;
    private boolean awake;

    /**
     * Creates the main character giving default values.
     */
    public Hero(){
        this.awake = true;
        this.pos = new EntityPos2D(0, 0);
        this.direction = Directions.LEFT;
        this.gSet = new GunSet();
        this.status = HeroStatus.NEUTRAL;
        this.lives = 3;
    }

    /**
     * Updates the hero direction.
     * @param dir the given direction.
     */
    private void updateDirection(Directions dir){
        this.direction = dir;
        this.gSet.setDirections(dir);
    }

    /**
     * Getter for the actual Direction.
     * @return the actual direction.
     */
    public Directions getDirection(){
        return this.direction;
    }

    /**
     * Getter for the actual absolute position.
     * @return the absolute position.
     */
    public EntityPos2D getPosition(){
        return this.pos;
    }

    /**
     * Giving a Directions, it change the absolute coords making a step.
     * @param dir the direction where it has to step.
     */
    public void move(Directions dir){
        switch (dir) {
            case RIGHT:
                this.pos = new EntityPos2D(pos.getX() + 1, pos.getY());
                break;
            case LEFT:
                this.pos = new EntityPos2D(pos.getX() - 1, pos.getY());
                break;
        }
        this.updateDirection(dir);
    }
    
    /**
     * Getter for the GunSet.
     * @return the GunSet in use.
     */
    public GunBag getGset(){
        return this.gSet;
    }

    /**
     * The method is called whenever a ball hits the main character, it cut off one life.
     */
    public void hit(){
        if (this.isAwake()){
            this.lives--;
            System.out.println("Lifes: " + this.lives);
        }
    }

    /**
     * Setter for HeroStatus.
     * @param status the status that needs to be set.
     */
    public void setStatus(HeroStatus status){
        this.status = status;
    }

    /**
     * Getter for Status.
     * @return the current Hero status.
     */
    public HeroStatus getStatus(){
        return this.status;
    }

    /**
     * Toggle method for awake in order to pause the hero.
     */
    public void toggleAwake(){
        if(this.awake == true){
            this.awake = false;
        }else{
            this.awake = true;
        }
    }

    /**
     * Getter for isAwake.
     * @return if the Hero can accept commands.
     */
    public boolean isAwake(){
        return this.awake;
    }

    /**
     * Getter for lifes.
     * @return the remaining lifes.
     */
    public int getLifes(){
        return this.lives;
    }

    @Override
    public void pauseAll() {
        this.toggleAwake();
    }

    @Override
    public void resumeAll() {
        this.toggleAwake();
    }

    /**
     * Resetting position and lives, used when restarting a new game
     */
    public void reset() {
        this.pos = new EntityPos2D(0, 0);
        this.lives = 3;
    }

}
