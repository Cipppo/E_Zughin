package menu.components;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Desktop.Action;

import stage.utils.MainFontLoader;

public class SelectionLabel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2928014517775593930L;
	MainFontLoader fontLoader = new MainFontLoader(4);
	Font gameFont = fontLoader.load();
	private final JLabel selectionPanel = new JLabel();
	private int seconds = 0;
	private Timer timer;
	private boolean IsUpLastAction = true;
	
    
    public SelectionLabel() {
    	selectionPanel.setText("-");
    	selectionPanel.setFont(gameFont);
    	selectionPanel.setForeground(Color.BLACK);
    	this.setLayout(new BorderLayout());
    	this.setBackground(Color.BLACK);
    	this.add(selectionPanel, BorderLayout.CENTER);
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
