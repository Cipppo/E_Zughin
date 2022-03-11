package menu.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JLabel;

import javax.swing.JPanel;

import java.awt.Color;

import stage.utils.MainFontLoader;

public class SelectionPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2928014517775593930L;
	MainFontLoader fontLoader = new MainFontLoader(6);
	Font gameFont = fontLoader.load();
	private final JLabel selectionPanel = new JLabel();
	private int seconds = 0;
	private Timer timer;
    
    public SelectionPanel() {
    	selectionPanel.setText("_");
    	selectionPanel.setFont(gameFont);
    	selectionPanel.setForeground(Color.green);

    	this.setBackground(Color.BLACK);
    	
		this.add(selectionPanel);
		simpleTimer();
		timer.start();
    }	
	
    public void simpleTimer() {

        timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds % 2 == 0) {
    				selectionPanel.setForeground(Color.green);
    			}else {
    				selectionPanel.setForeground(Color.black);
    			}
                
                
                if(seconds >= 1000) {
                	//seconds = 0;
                	timer.stop();
                }
            }

        });
    }

}
