package bird.utilities;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;



import pangGuy.utilities.EntityPos2D;
import pangGuy.utilities.Pair;
import stage.utils.MainImagesLoader;

/**
 * this class loads the image of given bird,
 * and chaches the result of the loading;
 */
public class BirdPNGLoader {
    
    private Map<BirdDirections, Pair<BufferedImage, BufferedImage>> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    public BirdPNGLoader() {
        this.fillIamgesCache(BirdDirections.LEFT);
        this.fillIamgesCache(BirdDirections.RIGHT);
    }

    private void fillIamgesCache(BirdDirections dir) {
        Pair<String, String> spriteName = this.getFileNameGivenDimension(dir);
        Pair<BufferedImage, BufferedImage> images = new Pair<BufferedImage, BufferedImage>(loader.load(spriteName.getX()), loader.load(spriteName.getY()));
        this.entries.put(dir, images);
    }

    public BufferedImage getBirdImage(BirdDirections dir, EntityPos2D pos) {
        if(pos.getY() % 20 != 0) {
            return this.entries.get(dir).getX();
        } else {
            return this.entries.get(dir).getY();
        }
    }

    private Pair<String, String> getFileNameGivenDimension(BirdDirections dir) {
        switch (dir) {
            case LEFT:
                return new Pair<String, String>("BirdFirstSx.png", "BirdSecondSx.png");
            case RIGHT:
                return new Pair<String, String>("BirdFirstDx.png", "BirdSecondDx.png");
            default:
                throw new IllegalArgumentException();
        }
    }
}
