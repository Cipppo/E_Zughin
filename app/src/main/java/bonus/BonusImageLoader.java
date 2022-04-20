package bonus;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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
            this.loader.load("WaterMelon.png")
        ));
    }


    public BufferedImage getSprite(BonusEntity bonus){
        System.out.println("Bonus Score: " + bonus.getPoints() + "/ 100: " + bonus.getPoints() / 100);
        return this.entries.get((bonus.getPoints() / 100) - 1);
    }

    

}
