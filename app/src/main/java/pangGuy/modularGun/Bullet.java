package pangGuy.modularGun;


import pangGuy.utilities.Directions;
import pangGuy.utilities.Pos2D;


public interface Bullet {

    void restore();

    void raise();

    void lock(int xPos);

    void unlock();

    Status getStatus();

    Directions getDirection();

    int getWaitTime();

    void setWaitTime(int newWaitTime);

    void changeDir(Directions dir);

    int getStepsDone();

    void hit();

    Pos2D getRisingPos();


}
