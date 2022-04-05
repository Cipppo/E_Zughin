package pangGuy.modularGun;

import pangGuy.utilities.Bound;
import pangGuy.utilities.Directions;


public interface Bullet {

    void restore();

    void raise();

    Status getStatus();

    void setStatus(Status status);

    Directions getDirection();

    int getWaitTime();

    void setWaitTime(int newWaitTime);

    void changeDir(Directions dir);

    void step();

    int getStepsDone();

    Bound getBound();


}
