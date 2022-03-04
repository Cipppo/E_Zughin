package stage.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;

public class CenterOnDefaultScreen {
	
	public static Dimension center() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int heigth = gd.getDisplayMode().getHeight();
		
		return new Dimension(width, heigth);
	}

}
