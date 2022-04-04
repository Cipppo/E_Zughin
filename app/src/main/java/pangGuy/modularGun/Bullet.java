package pangGuy.modularGun;

import pangGuy.utilities.Directions;


public interface Bullet {

    void restore();

    void raise();

    Status getStatus();

    Directions getDirection();

    void changeDir(Directions dir);


}
