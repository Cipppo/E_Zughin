package pangGuy.gui;

import java.util.HashMap;
import java.util.Map;

import pangGuy.modularGun.GunTypes;


import java.awt.image.BufferedImage;
import stage.utils.MainImagesLoader;
import java.util.List;
import java.util.ArrayList;

public class ArpionImageLoader {
    
    private Map<GunTypes, List<BufferedImage>> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    public ArpionImageLoader(){
        this.fillImagesCache(GunTypes.ARPION);
        this.fillImagesCache(GunTypes.STICKY_ARPION);
    }

    private void fillImagesCache(GunTypes gun){
        List<String> spriteName = this.getFileNamesGivenGunType(gun);
        List<BufferedImage> sprites = new ArrayList<>();
        for(String name : spriteName){
            sprites.add(loader.load(name));
        }
        this.entries.put(gun, sprites);
    }

    public List<BufferedImage> getArpionSprites(GunTypes gun){
        return this.entries.get(gun);
    }

    private List<String> getFileNamesGivenGunType(GunTypes gun){
        List<String> temp = new ArrayList<>();
        switch(gun){
            case ARPION:
                temp.add("Arpion1.png");
                temp.add("Arpion2.png");
                break;
            case STICKY_ARPION:
                temp.add("StickyArpion1.png");
                temp.add("StickyArpion2.png");
                break;
            default:
                break;   
        }
        return temp;
    }

}
