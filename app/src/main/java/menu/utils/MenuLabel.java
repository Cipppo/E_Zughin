package menu.utils;

import javax.swing.JLabel;
import javax.swing.Timer;

import stage.utils.MainFontLoader;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class to create generic label of the menu
 *
 */
public class MenuLabel extends JLabel{

	private static final long serialVersionUID = -7051688817017962691L;
	private Color primaryColor;
	private Color secondaryColor;
	private boolean blink;
	private int fontSize;
	private int seconds = 0;
	private Timer timer;
	private MainFontLoader fontLoader;
	
	/**
	 * Constructor with three parameters
	 * @param text 
	 * @param fontS  Size
	 * @param c      color
	 */
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
	
	/**
	 * Constructor with two parameters
	 * @param text    
	 * @param fontS
	 * 				Font Size
	 */
	public MenuLabel(String text, int fontS) {
		this(text, fontS, Color.WHITE);
	}
	
	/**
	 * Constructor with one parameter
	 * @param text
	 */
	public MenuLabel(String text) {
		this(text, 4);
	}
	
	/**
	 * set label size
	 * @param size
	 */
	public void setTextSize(int size) {
		this.fontLoader = new MainFontLoader(size);
		//this.gameFont = fontLoader.load();
		this.setFont(fontLoader.load());
	}
	
	/**
	 * set the primary color
	 * @param color
	 */
	public void setPrimaryColor(Color color) {
		this.primaryColor = color;
	}
	
	/**
	 * set the secondary color
	 * @param color
	 */
	public void setSecondaryColor(Color color) {
		this.secondaryColor = color;
	}
	
	/**
	 * makes the label blinking, it becomes dinamic; or opposite
	 */
	public void switchBlink() {
		blink = !blink;
	}
	
	/**
	 * true if the label is blinking, false if not
	 * @return blink state
	 */
	public boolean getBlink() {
		return blink;
	}
	
	/**
	 * gives the time to change the color of blinking
	 */
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