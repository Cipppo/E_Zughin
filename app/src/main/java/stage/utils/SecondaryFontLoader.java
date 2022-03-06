/**
 * Loads a Font file and returns it as a Font Object.
 * 
 * @param fontFilePath (String) Full path and file name of the font to load.<br>
 * 
 * @param fontStyle (Integer) The Font Style to use for the loaded font, for 
 * example:<pre>
 * 
 *      Font.PLAIN
 *      Font.BOLD
 *      Font.ITALIC
 *      Font.BOLDITALIC</pre>
 * 
 * @param fontSize (Integer) The desired size of font.<br>
 * 
 * @return (Font) A Font Object
 */

package stage.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondaryFontLoader {

    public static Font load() {
        String fontFilePath = FindDirectory.find().toString();
        int fontStyle = Font.BOLD;
        int fontSize = CenterOnDefaultScreen.center().height*2/100;
        Font font = null;
        int fontTypeResource = Font.TRUETYPE_FONT;
    
        if((fontFilePath == null || fontFilePath.isEmpty()) || fontSize < 1) {
            throw new IllegalArgumentException("load() Method Error! Arguments " +
                                                "passed to this method must contain a file path or a numerical " +
                                                "value other than 0!" + System.lineSeparator());
        }
    
        try {
            font = Font.createFont(fontTypeResource, new FileInputStream(
                   new File(fontFilePath))).deriveFont(fontStyle, fontSize);
        }
        catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + fontFilePath);
        }
        catch (FontFormatException | IOException ex) {
            System.out.println("Exception thrown");
        }
        return font;
    }
}
