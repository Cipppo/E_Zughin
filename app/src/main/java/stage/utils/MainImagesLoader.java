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
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(imgUrl.getPath()));
		} catch (IOException e) {
			System.out.println("Could not load image");
		}
		return image;
	}
}