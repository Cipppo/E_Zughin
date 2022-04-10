package pangGuy.gui;

import java.util.HashMap;
import java.util.Map;

import pangGuy.utilities.Directions;

import java.awt.image.BufferedImage;
import stage.utils.MainImagesLoader;
import java.util.List;
import java.util.ArrayList;

public class PangGuyImageLoader {

    private Map<Directions, List<BufferedImage>> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    public PangGuyImageLoader(){
        this.fillImagesCache(Directions.RIGHT);
        this.fillImagesCache(Directions.LEFT);
    }

    private void fillImagesCache(Directions dir){
        List<String> spriteName = this.getFileNamesGivenDirections(dir);
        List<BufferedImage> sprites = new ArrayList<>();
        for(String name : spriteName){
            sprites.add(loader.load(name));
        }
        this.entries.put(dir, sprites);
    }

    public List<BufferedImage> getHeroImage(Directions dir){
        return this.entries.get(dir);
    }

    private List<String> getFileNamesGivenDirections(Directions dir){
        List<String> temp = new ArrayList<>();
        switch(dir){
            case RIGHT:
                temp.add("StillRight.png");
                temp.add("WalkingRight1.png");
                temp.add("WalkingRight2.png");
                temp.add("PrepShootingRight.png");
                temp.add("DeathRight.png");
                break;
            case LEFT:
                temp.add("StillLeft.png");
                temp.add("WalkingLeft1.png");
                temp.add("WalkingLeft2.png");
                temp.add("PrepShootingLeft.png");
                temp.add("DeathLeft.png");
        }
        return temp;
    }

}
