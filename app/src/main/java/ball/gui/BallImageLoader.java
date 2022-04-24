package ball.gui;

import ball.physics.Dimensions;
import stage.utils.MainImagesLoader;

import java.util.Map;

import java.util.HashMap;

import java.awt.image.BufferedImage;

/**
 * This class loads ball images from a specific location (resources/sprite/spheres/).
 */
public class BallImageLoader {

    private Map<Dimensions, BufferedImage> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    public BallImageLoader() {
        this.fillIamgesCache(Dimensions.FATHER);
        this.fillIamgesCache(Dimensions.SON);
        this.fillIamgesCache(Dimensions.GRANDSON);
    }

    private void fillIamgesCache(Dimensions dim) {
        String spriteName = this.getFileNameGivenDimension(dim);
        BufferedImage image = loader.load(spriteName);
        this.entries.put(dim, image);
    }
    
    public BufferedImage getBallImage(Dimensions ball) {
        return this.entries.get(ball);
    }


    private String getFileNameGivenDimension(Dimensions dim) {
        switch (dim) {
            case FATHER:
                return "sprite/spheres/ballFather.png";
            case SON:
                return "sprite/spheres/ballSon.png";
            case GRANDSON:
                return "sprite/spheres/ballGrandSon.png";
            default:
                throw new IllegalArgumentException();
        }
    }

}
