package pangGuy.modularGun;

import pangGuy.utilities.Directions;


public interface Bullet {

    void restore();

    void raise();

    public void changeDir(Directions dir);


}
