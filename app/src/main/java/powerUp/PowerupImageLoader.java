package powerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import stage.utils.MainImagesLoader;

/**
 * Models a ImageLoader for the powerups.
 */
import java.awt.image.BufferedImage;

public class PowerupImageLoader {
    
    private List<BufferedImage> entries;
    private MainImagesLoader loader;

    /**
     * Returns a new PowerupImageLoader
     */
    public PowerupImageLoader(){
        this.loader = new MainImagesLoader();
        this.entries = new ArrayList<>(List.of(
            this.loader.load("sprite/Powerups/Bomb.png"), 
            this.loader.load("sprite/Powerups/TimeFreeze.png"), 
            this.loader.load("sprite/Powerups/DoubleArpionPowerup.png"), 
            this.loader.load("sprite/Powerups/StickyArpionPowerup.png")
        ));
    }

    /**
     * Given a powerup, returns his sprite.
     * @param powerup the powerup which asks the sprite.
     * @return the Powerup's sprite.
     */
    public Optional<BufferedImage> getPowUpSprite(PowerUp powerup){
        if(powerup instanceof Bomb){
            return Optional.of(this.entries.get(0));
        }else if(powerup instanceof TimeFreeze){
            return Optional.of(this.entries.get(1));
        }else if(powerup instanceof DoubleGun){
            return Optional.of(this.entries.get(2));
        }else if(powerup instanceof StickyArpion){
            return Optional.of(this.entries.get(3));
        }
        return Optional.empty();
    } 



}
