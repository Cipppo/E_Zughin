package ball.gui;

import ball.physics.Dimensions;
import ball.physics.Pos2D;
import stage.utils.MainImagesLoader;

import java.util.Map;
import java.util.HashMap;

import java.awt.image.BufferedImage;

/**
 * this class loads the image of given ball (maybe try to disassemble for multiuse),
 * and chaches the result of the loading;
 */
public class ImageLoader {

    private Map<Pos2D, BufferedImage> entries = new HashMap<>();
    private MainImagesLoader loader = new MainImagesLoader();

    public void setBallImage(Pos2D ball) {
        String spriteName = this.getFileNameGivenDimension(ball.getDimension());
        BufferedImage image = loader.load(spriteName);
        this.entries.put(ball, image);
    }
    
    public BufferedImage getBallImage(Pos2D ball) {
        return this.entries.get(ball);
    }


    private String getFileNameGivenDimension(Dimensions dim) {
        switch (dim) {
            case FATHER:
                return "ballFather.png";
            case SON:
                return "ballSon.png";
            case GRANDSON:
                return "ballGrandSon.png";
            default:
                throw new IllegalArgumentException();
        }
    }

}
