package stage.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class MainFontLoader {
    
	private int fontSizePercentage;
	
	public MainFontLoader(int fontSizePercentage) {
		this.fontSizePercentage = fontSizePercentage;
	}
	
	public MainFontLoader() {
		this.fontSizePercentage = 2;
	}
	
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
