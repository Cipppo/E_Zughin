package menu.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import stage.utils.MainFontLoader;

public class StartLabel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8430588428621513653L;
	MainFontLoader fontLoader = new MainFontLoader(4);
	Font gameFont = fontLoader.load();
	private final JLabel start;
	private int seconds = 0;
	private Timer timer;
	private boolean IsUpLastAction = true;
    
    public StartLabel() {
    	start = new JLabel();
    	start.setText("START");
    	start.setFont(gameFont);
    	start.setForeground(Color.GREEN);
    	this.setLayout(new BorderLayout());
    	this.setBackground(Color.BLACK);
    	this.add(start, BorderLayout.CENTER);
    	simpleTimer();
		timer.start();
    }
    
    public void setLastAction(boolean last) {
    	this.IsUpLastAction = last;
    }
    
    public void setT(String text) {
    	this.start.setText(text);
    }
    
    public void simpleTimer() {

        timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds % 2 == 0 && IsUpLastAction) {
    				start.setForeground(Color.GREEN);
    			}else {
    				start.setForeground(Color.WHITE);
    			}
                
                
                if(seconds >= 1000) {
                	//seconds = 0;
                	timer.stop();
                }
            }

        });
    }
}
