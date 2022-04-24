package bonus;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import stage.utils.MainImagesLoader;

/**
 * Image Loader for the bonuses.
 */
public class BonusImageLoader {
    
    private List<BufferedImage> entries;
    private MainImagesLoader loader;

    /**
     * Creates a new ImageLoader
     */
    public BonusImageLoader(){
        this.loader = new MainImagesLoader();
        this.entries = new ArrayList<>(List.of(
            this.loader.load("sprite/Fruit/Ananas.png"), 
            this.loader.load("sprite/Fruit/Apple.png"), 
            this.loader.load("sprite/Fruit/Banana.png"), 
            this.loader.load("sprite/Fruit/Cake.png"), 
            this.loader.load("sprite/Fruit/Cherry.png"), 
            this.loader.load("sprite/Fruit/GrapeFruit.png"), 
            this.loader.load("sprite/Fruit/Lemon.png"), 
            this.loader.load("sprite/Fruit/Orange.png"), 
            this.loader.load("sprite/Fruit/Strawberry.png"), 
            this.loader.load("sprite/Fruit/WaterMelon.png")
        ));
    }

    /**
     * Given a score, it returns the associated sprite
     * @param bonus the bonus which asks the sprite.
     * @return  the Sprite of the bonus.
     */
    public BufferedImage getSprite(BonusEntity bonus){
        return this.entries.get((bonus.getPoints() / 100) - 1);
    }

    

}
