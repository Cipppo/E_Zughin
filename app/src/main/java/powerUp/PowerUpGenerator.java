package powerUp;

import java.util.Random;
import pangGuy.modularGun.GunBag;
import ball.controller.BallRunner;

/**
 * Generates one random powerup at a random position.
 */
public class PowerUpGenerator {
    private GunBag gSet;
    private BallRunner context;

    /**
     * Creates a new PowerUpgenerator.
     * @param gSet the Hero's gunSet.
     * @param context the active BallRunner.
     */
    public PowerUpGenerator(GunBag gSet, BallRunner context){
        this.gSet = gSet;
        this.context = context;
    }

    private int getRandomInt(){
        Random rand = new Random();
        return rand.nextInt(4);
    }

    /**
     * Generates a random PowerUp.
     * @return a random PowerUp.
     */
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
