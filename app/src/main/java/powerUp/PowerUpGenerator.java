package powerUp;

import java.util.Random;

import ball.controller.BallRunner;
import pangGuy.modularGun.GunSet;

public class PowerUpGenerator {
    private GunSet gSet;
    private BallRunner context;

    public PowerUpGenerator(GunSet gSet, BallRunner context){
        this.gSet = gSet;
        this.context = context;
    }

    private int getRandomInt(){
        Random rand = new Random();
        return rand.nextInt(4);
    }

    public PowerUp getRandomPowerUp() {
        var num = this.getRandomInt();
        switch (num) {
            case 0:
                return new StickyArpion(this.gSet);
            case 1:
                return new DoubleGun(this.gSet);
            case 2:
                return new Bomb(context);
            case 3:
                return new TimeFreeze(context);
            default:
                return null;
        }
    }
}
