package stage.components;

import javax.swing.JLabel;
import stage.utils.FontLoader;

import java.awt.Color;
import java.awt.Font;

public class StageNameLabel extends JLabel{

    Font gameFont = FontLoader.load();
    
    public StageNameLabel() {
        this.setText("MT. KEIRIN");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
