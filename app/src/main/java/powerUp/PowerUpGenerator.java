package powerUp;

import java.util.ArrayList;
import java.util.List;

import pangGuy.modularGun.GunSet;

public class PowerUpGenerator {

    List<PowerUp> powerups = new ArrayList<>();

    public PowerUpGenerator(GunSet gSet){

        this.powerups.add(
            new StickyArpion(gSet);
        )

    }


}
