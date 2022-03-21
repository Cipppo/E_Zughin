package ball.gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ball.physics.Dimensions;

public class ImageLoader {
    //TODO: transform this static path, into a dynamic following FontLoader 
    private final String resourcesPath = "/Users/stefanofuri/OOP-prj/E_Zughin/app/src/main/resources/sprite/spheres/";

    public ImageLoader() {
    }

    public BufferedImage getImageFromDimensions(Dimensions dimension) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(this.resourcesPath + this.getFileNameGivenDimension(dimension)));
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid dimension given");
        }
        return image;
    }

    public String getFileNameGivenDimension(Dimensions dim) {
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
