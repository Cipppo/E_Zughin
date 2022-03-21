package stage.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SecondaryImagesLoader {

	public BufferedImage load(String resourceName) {
		String imageFilePath = FindDirectory.find(resourceName).toString();
		BufferedImage image = null;
		
		if(imageFilePath == null || imageFilePath.isEmpty()) {
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
