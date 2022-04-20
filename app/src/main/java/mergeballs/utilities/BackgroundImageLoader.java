package mergeballs.utilities;

import java.awt.image.BufferedImage;

import stage.utils.MainImagesLoader;

public class BackgroundImageLoader {

    private MainImagesLoader loader = new MainImagesLoader();
    
    public BufferedImage getBackImage() {
        return loader.load("mountFuji.png");
    }
}
