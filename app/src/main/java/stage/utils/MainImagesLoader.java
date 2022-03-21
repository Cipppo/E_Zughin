package stage.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainImagesLoader {
	
	public BufferedImage load(String resourceName) {
		BufferedImage image = null;
		SecondaryImagesLoader imagesLoader = new SecondaryImagesLoader();
		
		
		try(var imageIn = MainImagesLoader.class.getResourceAsStream("/" + resourceName)) {
			image = ImageIO.read(new File(imageIn.toString()));
			return image;
		} catch (IOException e1) {
			System.out.println("IOException: Image not found in bin directory, taking it from resources");
			return imagesLoader.load(resourceName);
		}
	}
}