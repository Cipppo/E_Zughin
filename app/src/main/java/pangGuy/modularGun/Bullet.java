package pangGuy.modularGun;

import pangGuy.utilities.Pos2D;

public interface Bullet {
    
    Pos2D getPos();

    void setPos(Pos2D pos);

    boolean isMovable();

    void restore();

    void shoot();


}
