package stage.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * If the MainFontLoader fails, this class loads a Font file and returns it as a Font Object.
 * 
 * @param fontFilePath (String) Full path and file name of the font to load.
 * 
 * @param fontStyle (Integer) The Font Style to use for the loaded font, for 
 * example:
 * 
 *      Font.PLAIN
 *      Font.BOLD
 *      Font.ITALIC
 *      Font.BOLDITALIC
 * 
 * @param fontSize (Integer) The desired size of font.
 * 
 * @return (Font) A Font Object
 */
public class SecondaryFontLoader {
	
	private final int fontSizePercentage;
	
    /**
     * This constructor make the user choose a font size.
     * @param fontSizePercentage
     *          the font size to associate to the font.
     */
	public SecondaryFontLoader(int fontSizePercentage) {
		this.fontSizePercentage = fontSizePercentage;
	}
	
    /**
     * This contructor set the font size percentage to the default (2).
     */
	public SecondaryFontLoader() {
		this.fontSizePercentage = 2;
	}

    /**
     * This method uses FindDirectory to search for the "Retro Gaming.ttf" font.
     * @return
     *      the desired font.
     */
    public Font load() {
        String fontFilePath = FindDirectory.find("Retro Gaming.ttf").toString();
        int fontStyle = Font.BOLD;
        int fontSize = CenterOnDefaultScreen.center().height*this.fontSizePercentage/100;
        Font font = null;
        int fontTypeResource = Font.TRUETYPE_FONT;
    
        if ((fontFilePath == null || fontFilePath.isEmpty()) || fontSize < 1) {
            throw new IllegalArgumentException("load() Method Error! Arguments " +
                                                "passed to this method must contain a file path" 
                                                + System.lineSeparator());
        }
    
        try {
            font = Font.createFont(fontTypeResource, new FileInputStream(
                   new File(fontFilePath))).deriveFont(fontStyle, fontSize);
        }
        catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + fontFilePath);
        }
        catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return font;
    }
}
