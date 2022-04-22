package stage.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * This utility has the purpose of loading the desired image.
 */
public class MainImagesLoader {
	
	/**
	 * This method looks for the image in the bin directory,
     * if this isn't in this directory it calls SecondaryImagesLoader.\
	 * 
	 * @param resourceName
	 * 			the name of the image to look for.
	 * @return
	 * 			the image.
	 */
	public BufferedImage load(String resourceName) {
		final URL imgUrl = ClassLoader.getSystemResource(resourceName);
		final String string = imgUrl.toString();
		BufferedImage image = null;
		SecondaryImagesLoader imagesLoader = new SecondaryImagesLoader();
		
		
		try (var imageIn = MainImagesLoader.class.getResourceAsStream(string)) {
			image = ImageIO.read(new File(imageIn.toString()));
			return image;
		} catch (IOException e1) {
			System.out.println("IOException: Image not found in bin directory, taking it from resources");
			return imagesLoader.load(resourceName);
		} catch (NullPointerException e2) {
			System.out.println("Diocane");
			return imagesLoader.load(resourceName);
		}
	}
}