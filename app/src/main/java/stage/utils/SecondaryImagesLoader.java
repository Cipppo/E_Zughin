package stage.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * If the MainImageLoader fails, this class loads a BufferedImage.
 * As parameters, this class needs the full path and file name of the image to load (a String).
 * and it's return the desired image as {@link java.awt.image.BufferedImage}
 */
public class SecondaryImagesLoader {

	/**
	 * This method uses FindDirectory to search for the desired image.
	 * 
	 * @param resourceName
	 * 			the name of the image to load complete of the format specifier.
	 * @return
	 * 			the desired image.
	 */
	public BufferedImage load(String resourceName) {
		String imageFilePath = FindDirectory.find(resourceName).toString();
		BufferedImage image = null;
		
		if (imageFilePath == null || imageFilePath.isEmpty()) {
			throw new IllegalArgumentException("load() Method Error! Arguments " +
                    "passed to this method must contain a file path" 
					+ System.lineSeparator());
		}
		
		try {
			image = ImageIO.read(new File(imageFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
