package powerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ball.controller.Runner;
import pangGuy.modularGun.GunSet;

public class PowerUpGenerator {

    private List<PowerUp> powerups;

    public PowerUpGenerator(GunSet gSet, Runner context){
        this.powerups = new ArrayList<>(List.of(
            new StickyArpion(gSet), 
            new DoubleGun(gSet), 
            new Bomb(context), 
            new TimeFreeze(context)
        ));
    }

    private int getRandomInt(){
        Random rand = new Random();
        return rand.nextInt(4);
    }

    public PowerUp getRandomPowerUp(){
        return this.powerups.get(this.getRandomInt());
    }



}
