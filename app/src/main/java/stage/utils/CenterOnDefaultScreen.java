package stage.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;

/**
 * This utility finds out which monitor is the primary and takes its size.
 */
public class CenterOnDefaultScreen {
	
	/**
	 * 
	 * @return new Dimension(width, height)
	 * 			dimension of the screen.
	 */
	public static Dimension center() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		return new Dimension(width, height);
	}

}
