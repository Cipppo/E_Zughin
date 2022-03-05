package stage.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FontLoader {
    
    public static Font load(){
    	String fontFilePath = "src\\main\\resources\\Retro Gaming.ttf";
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
            System.out.println("FileNotFoundException");
        }
        catch (FontFormatException | IOException ex) {
            System.out.println("Exception thrown");
        }
        return font;
    }
}
