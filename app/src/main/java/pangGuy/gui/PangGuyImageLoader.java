package pangGuy.gui;

import java.util.HashMap;
import java.util.Map;

import pangGuy.utilities.Directions;

import java.awt.image.BufferedImage;
import stage.utils.MainImagesLoader;
import java.util.List;
import java.util.ArrayList;

/**
 * This class manages the Hero character sprites.
 */

public class PangGuyImageLoader {

    private Map<Directions, List<BufferedImage>> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    /**
     * Create a new PangGuyImageLoader with a cache full of sprites sorted by their directions.
     */
    public PangGuyImageLoader(){
        this.fillImagesCache(Directions.RIGHT);
        this.fillImagesCache(Directions.LEFT);
    }

    /**
     * Fills the cache with the selected sprites.
     * @param dir the choosen direction.
     */
    private void fillImagesCache(Directions dir){
        List<String> spriteName = this.getFileNamesGivenDirections(dir);
        List<BufferedImage> sprites = new ArrayList<>();
        for(String name : spriteName){
            sprites.add(loader.load(name));
        }
        this.entries.put(dir, sprites);
    }

    /**
     * Returns a List of sprites having the same directions.
     * @param dir the choosen direction.
     * @return a List full of sprites.
     */
    public List<BufferedImage> getHeroImage(Directions dir){
        return this.entries.get(dir);
    }

    /**
     * Given a Directions it returns a List of file names.
     * @param dir the choosen direction.
     * @return a List full of image names.
     */
    private List<String> getFileNamesGivenDirections(Directions dir){
        List<String> temp = new ArrayList<>();
        switch(dir){
            case RIGHT:
                temp.add("sprite/Guy/ResizedStillRight.png");
                temp.add("sprite/Guy/WalkingRight1.png");
                temp.add("sprite/Guy/WalkingRight2.png");
                temp.add("sprite/Guy/PrepShootingRight.png");
                temp.add("sprite/Guy/DeathRight.png");
                break;
            case LEFT:
                temp.add("sprite/Guy/ResizedStillLeft.png");
                temp.add("sprite/Guy/WalkingLeft1.png");
                temp.add("sprite/Guy/WalkingLeft2.png");
                temp.add("sprite/Guy/PrepShootingLeft.png");
                temp.add("sprite/Guy/DeathLeft.png");
        }
        return temp;
    }

}
