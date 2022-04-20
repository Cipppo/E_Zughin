package powerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import stage.utils.MainImagesLoader;

//mport java.util.ArrayList;
import java.awt.image.BufferedImage;

public class PowerupImageLoader {
    
    private List<BufferedImage> entries;
    private MainImagesLoader loader;

    public PowerupImageLoader(){
        this.loader = new MainImagesLoader();
        this.entries = new ArrayList<>(List.of(
            this.loader.load("Bomb.png"), 
            this.loader.load("TimeFreeze.png"), 
            this.loader.load("DoubleArpionPowerup.png"), 
            this.loader.load("StickyArpionPowerup.png")
        ));
    }

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
