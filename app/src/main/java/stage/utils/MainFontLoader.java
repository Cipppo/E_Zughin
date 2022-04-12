package stage.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 * This utility has the purpose of loading the "Retro Gaming.ttf" font and choosing a size for it.
 */
public class MainFontLoader {
    
	private int fontSizePercentage;
	
    /**
     * This constructor make the user chose a font size percentage.
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
    	SecondaryFontLoader fontLoader = new SecondaryFontLoader(fontSizePercentage);
    	
        try (var fontIn = MainFontLoader.class.getResourceAsStream("/Retro Gaming.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontIn).deriveFont(Font.BOLD, CenterOnDefaultScreen.center().height*this.fontSizePercentage/100);
            return font;
        } catch (FontFormatException e) {
            System.out.println("FontFormatException: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException: Font not found in bin directory, taking it from resources");
            return fontLoader.load();
        }
        return new Font("Arial", Font.BOLD, 14);
    }
}
