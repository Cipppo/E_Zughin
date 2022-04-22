package pangGuy.modularGun;


import mergeballs.control.Pausable;
import pangGuy.utilities.Directions;


public interface Bullet extends Pausable{

    /**
     * Takes the Bullet to his Original status.
     */
    void restore();

    /**
     * Makes the Bullet raise.
     */
    void raise();

    /**
     * Locks the bullet to an XPos.
     */
    void lock(); 

    /**
     * Unlocks the Bullet.
     */
    void unlock();

    /**
     * getter for the Status.
     * @return the current Status.
     */
    Status getStatus();

    /**
     * Getter for the direction.
     * @return the current direction.
     */
    Directions getDirection();

    /**
     * Getter for the wait time.
     * @return the current wait time.
     */
    int getWaitTime();

    /**
     * Setter for the wait time.
     * @param newWaitTime the wait time that needs to be set.
     */
    void setWaitTime(int newWaitTime);

    /**
     * Setter for the Direction
     * @param dir the direction that needs to be set.
     */
    void changeDir(Directions dir);

    /**
     * Getter for the steps.
     * @return the steps done.
     */
    int getStepsDone();

    /**
     * The method is called when the Arpion hits something
     */
    void hit();
}
