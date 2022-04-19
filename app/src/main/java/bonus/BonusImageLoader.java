package bonus;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import stage.utils.MainImagesLoader;

public class BonusImageLoader {
    
    private List<BufferedImage> entries;
    private MainImagesLoader loader;


    public BonusImageLoader(){
        this.loader = new MainImagesLoader();
        this.entries = new ArrayList<>(List.of(
            this.loader.load("Ananas.png"), 
            this.loader.load("Apple.png"), 
            this.loader.load("Banana.png"), 
            this.loader.load("Cake.png"), 
            this.loader.load("Cherry.png"), 
            this.loader.load("GrapeFruit.png"), 
            this.loader.load("Lemon.png"), 
            this.loader.load("Orange.png"), 
            this.loader.load("Strawberry.png"), 
            this.loader.load("Watermelon.png")
        ));
    }

    private int getRandomIndex(){
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public BufferedImage getSprite(){
        return this.entries.get(this.getRandomIndex());
    }

    

}
