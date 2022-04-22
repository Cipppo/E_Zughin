package stage.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 * This utility has the purpose of loading the "Retro Gaming.ttf" font and choosing a size for it.
 */
public class MainFontLoader {
    
	private int fontSizePercentage;
	
    /**
     * This constructor make the user choose a font size percentage.
     * @param fontSizePercentage
     *          the font size percentage to associate to the font.
     */
	public MainFontLoader(int fontSizePercentage) {
		this.fontSizePercentage = fontSizePercentage;
	}
	
    /**
     * This contructor set the font size to the default (2).
     */
	public MainFontLoader() {
		this.fontSizePercentage = 2;
	}
	
    /**
     * This method looks for the font in the bin directory,
     * if the font isn't in this directory it calls SecondaryFontLoader.
     * @return
     *      the desired font, in case of search failure it returns a default font.
     */
    public Font load(){
        final InputStream fontStream = ClassLoader.getSystemResourceAsStream("Retro Gaming.ttf");
        Font font = null;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.BOLD, CenterOnDefaultScreen.center().height*this.fontSizePercentage/100);
        } catch (FontFormatException e) {
            System.out.println("Could not load font");
        } catch (IOException e) {
            System.out.println("Could not load font");
        }
    	return font;
    }
}
