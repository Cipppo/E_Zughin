package pangGuy.gui;

import java.util.HashMap;
import java.util.Map;
import pangGuy.modularGun.GunTypes;
import java.awt.image.BufferedImage;
import stage.utils.MainImagesLoader;
import java.util.List;
import java.util.ArrayList;

/**
 * Manages the Arpion sprites.
 */

public class ArpionImageLoader {
    
    private Map<GunTypes, List<BufferedImage>> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    /**
     * Creates a new ArpionImageLoader with a cache full of sprites sorted by the gunTypes.
     */
    public ArpionImageLoader(){
        this.fillImagesCache(GunTypes.ARPION);
        this.fillImagesCache(GunTypes.STICKY_ARPION);
        this.fillImagesCache(GunTypes.DOUBLE_ARPION);
    }

    /**
     * Fills the cache with the selected sprites.
     * @param gun the choosen GunTypes.
     */
    private void fillImagesCache(GunTypes gun){
        List<String> spriteName = this.getFileNamesGivenGunType(gun);
        List<BufferedImage> sprites = new ArrayList<>();
        for(String name : spriteName){
            sprites.add(loader.load(name));
        }
        this.entries.put(gun, sprites);
    }

    /**
     * Returns a List of sprites having the same GunType.
     * @param gun the choosen GunType.
     * @return a List full of Sprites.
     */
    public List<BufferedImage> getArpionSprites(GunTypes gun){
        return this.entries.get(gun);
    }

    /**
     * Given a GunType it return a List of file names.
     * @param gun the choosen GunType.
     * @return a List full of image names.
     */
    private List<String> getFileNamesGivenGunType(GunTypes gun){
        List<String> temp = new ArrayList<>();
        switch(gun){
            case ARPION:
                temp.add("sprite/Arpions/LongArpion.png");
                temp.add("sprite/Arpions/Arpion2.png");
                break;
            case STICKY_ARPION:
                temp.add("sprite/Arpions/StickyArpion1.png");
                temp.add("sprite/Arpions/StickyArpion2.png");
                break;
            case DOUBLE_ARPION:
                temp.add("sprite/Arpions/LongArpion.png");
                temp.add("sprite/Arpions/Arpion2.png");
                break;   
        }
        return temp;
    }

}
