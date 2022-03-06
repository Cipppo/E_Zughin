package stage.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class FontLoader {
    
    public static Font load(){
        try (var fontIn = FontLoader.class.getResourceAsStream("/Retro Gaming.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontIn).deriveFont(Font.BOLD, CenterOnDefaultScreen.center().height*2/100);
            return font;
          } catch (FontFormatException e) {
            System.out.println("FontFormatException: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
        return new Font("Arial", Font.BOLD, 14);
    }
}
