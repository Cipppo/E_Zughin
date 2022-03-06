package stage.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import stage.utils.FontLoader;

public class StageNumberLabel extends JLabel{
    
    Font gameFont = FontLoader.load();
    
    public StageNumberLabel(){
        this.setText("10-28 STAGE");
		this.setForeground(Color.white);
		this.setFont(gameFont);
    }
}
