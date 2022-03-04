package stage.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Map;

public class CenterOnDefaultScreen {
	
	public static Map<String, Integer> center() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int heigth = gd.getDisplayMode().getHeight();
		Map<String, Integer> dimensions = new HashMap<>();
		
		dimensions.put("width", width);
		dimensions.put("heigth", heigth);
		
		return dimensions;
	}

}
