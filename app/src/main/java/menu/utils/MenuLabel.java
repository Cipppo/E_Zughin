package menu.utils;

import javax.swing.JLabel;
import javax.swing.Timer;

import stage.utils.MainFontLoader;
import java.awt.Color;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLabel extends JLabel{

	private static final long serialVersionUID = -7051688817017962691L;
	private Color primaryColor;
	private Color secondaryColor;
	private boolean blink;
	private int fontSize;
	private int seconds = 0;
	private Timer timer;
	private MainFontLoader fontLoader;
	//private Font gameFont;
	
	
	public MenuLabel(String text, int fontS, Color c) {
		this.fontSize = fontS;
		primaryColor = c;
		secondaryColor = Color.GREEN;
		blink = false;
		this.setText(text.toUpperCase());
		this.setBackground(Color.BLACK);
		this.setForeground(primaryColor);
		this.fontLoader = new MainFontLoader(fontSize);
		this.setFont(fontLoader.load());
		
		simpleTimer();
		timer.start();
	}
	
	public MenuLabel(String text, int fontS) {
		this(text, fontS, Color.WHITE);
	}
	
	public MenuLabel(String text) {
		this(text, 4);
	}
	
	public void setTextSize(int size) {
		this.fontLoader = new MainFontLoader(size);
		//this.gameFont = fontLoader.load();
		this.setFont(fontLoader.load());
	}
	
	public void setPrimaryColor(Color color) {
		this.primaryColor = color;
	}
	
	public void switchBlink() {
		blink = !blink;
	}
	
	public boolean getBlink() {
		return blink;
	}
	
	public void simpleTimer() {
		timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds % 2 == 0 && blink) {
                	MenuLabel.this.setForeground(secondaryColor);
    			}else {
    				MenuLabel.this.setForeground(primaryColor);
    			}
                
                
                if(seconds >= 1000) {
                	//seconds = 0;
                	timer.stop();
                }
            }

        });
	}
	
	

}
