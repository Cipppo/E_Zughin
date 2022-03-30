package pangGuy.modularGun;

import pangGuy.utilities.Pos2D;

public interface Bullet {
    
    Pos2D getPos();

    void setPos();

    void setMovable();

    void setUnMovable();

    boolean isMovable();

    void restore();

    void shoot();


}
