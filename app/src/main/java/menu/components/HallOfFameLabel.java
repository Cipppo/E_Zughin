package menu.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;

import stage.utils.MainFontLoader;

public class HallOfFameLabel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5582360522433197786L;
	MainFontLoader fontLoader = new MainFontLoader(4);
	Font gameFont = fontLoader.load();
	private final JLabel hallLabel;
	private int seconds = 0;
	private Timer timer;
	private boolean IsUpLastAction = false;
    
    public HallOfFameLabel() {
    	hallLabel = new JLabel();
    	hallLabel.setText("HALL OF FAME");
    	hallLabel.setFont(gameFont);
    	hallLabel.setForeground(Color.WHITE);
    	hallLabel.setLayout(new BorderLayout());
    	this.setBackground(Color.BLACK);
    	this.add(hallLabel, BorderLayout.CENTER);
    	simpleTimer();
		timer.start();
    }
    
    public void setLastAction(boolean last) {
    	this.IsUpLastAction = last;
    }
    
    public void simpleTimer() {

        timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds % 2 == 0 && IsUpLastAction) {
    				hallLabel.setForeground(Color.GREEN);
    			}else {
    				hallLabel.setForeground(Color.WHITE);
    			}
                
                
                if(seconds >= 1000) {
                	//seconds = 0;
                	timer.stop();
                }
            }

        });
    }

}
