package bird.utilities;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import stage.utils.MainImagesLoader;

public class ImageLoader {
    
    private Map<Directions, BufferedImage> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    public ImageLoader() {
        this.fillIamgesCache(Directions.LEFT);
        this.fillIamgesCache(Directions.RIGHT);
    }

    private void fillIamgesCache(Directions dir) {
        String spriteName = this.getFileNameGivenDimension(dir);
        BufferedImage image = loader.load(spriteName);
        this.entries.put(dir, image);
    }

    public BufferedImage getBirdImage(Directions dir) {
        return this.entries.get(dir);
    }

    private String getFileNameGivenDimension(Directions dir) {
        switch (dir) {
            case LEFT:
                return "BirdFirstSx.png";
            case RIGHT:
                return "BirdFirstDx.png";
            default:
                throw new IllegalArgumentException();
        }
    }
}
