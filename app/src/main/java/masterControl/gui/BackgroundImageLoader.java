package masterControl.gui;

import java.awt.image.BufferedImage;

import stage.utils.MainImagesLoader;

/**
 * Image loader for the Background.
 */
public class BackgroundImageLoader {

    private MainImagesLoader loader = new MainImagesLoader();
    
    /**
     * Return the Background image.
     * @return
     */
    public BufferedImage getBackImage() {
        return loader.load("sprite/Backgrounds/mountFuji.png");
    }
}
