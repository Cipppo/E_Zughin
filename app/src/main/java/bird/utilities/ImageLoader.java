package bird.utilities;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import stage.utils.MainImagesLoader;

public class ImageLoader {
    
    private Map<Directions, Pair<BufferedImage>> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    public ImageLoader() {
        this.fillIamgesCache(Directions.LEFT);
        this.fillIamgesCache(Directions.RIGHT);
    }

    private void fillIamgesCache(Directions dir) {
        Pair<String> spriteName = this.getFileNameGivenDimension(dir);
        Pair<BufferedImage> images = new Pair<BufferedImage>(loader.load(spriteName.getX()), loader.load(spriteName.getY()));
        this.entries.put(dir, images);
    }

    public BufferedImage getBirdImage(Directions dir, BirdPos2D pos) {
        if(pos.y % 20 != 0) {
            return this.entries.get(dir).getX();
        } else {
            return this.entries.get(dir).getY();
        }
    }

    private Pair<String> getFileNameGivenDimension(Directions dir) {
        switch (dir) {
            case LEFT:
                return new Pair<String>("BirdFirstSx.png", "BirdSecondSx.png");
            case RIGHT:
                return new Pair<String>("BirdFirstDx.png", "BirdSecondDx.png");
            default:
                throw new IllegalArgumentException();
        }
    }
}
