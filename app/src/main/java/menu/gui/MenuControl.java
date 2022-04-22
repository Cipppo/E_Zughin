package menu.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import hallOfFameMenu.components.HoFMainPanel;
import menu.components.*;
import mergeballs.stage.StageGuiV2;
import player.Player;

public class MenuControl implements KeyListener{

	private JPanel panel;
	private GridBagConstraints container;
	private HoFMainPanel HoF = new HoFMainPanel();
	private TopMenuPanel topPanel = new TopMenuPanel();
	private NavigationPanel navPanel = new NavigationPanel();
	private int navStatus;
	private int enterStatus = 0;
	private UpAction upAction;
	private DownAction downAction;
	private EnterAction enterAction;
	private final Gui gui;
	
	
	public MenuControl(Gui gui) throws FileNotFoundException{
		this.gui = gui;
		panel = new JPanel(new GridBagLayout());
		container = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.NORTH;
		container.anchor = GridBagConstraints.NORTH;
		container.gridx = 0;
		container.gridy = 0;
		container.gridwidth = 10;
		container.weighty = 10;
		panel.add(topPanel, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		panel.add(HoF, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridy = 1;
		container.gridwidth = 1;
		panel.add(navPanel,container);
		
		navStatus = 0;
		
		panel.setBackground(Color.BLACK);
		gui.add(panel);
		
		upAction = new UpAction();
    	downAction = new DownAction();
    	enterAction = new EnterAction();
    	
    	panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
    	panel.getActionMap().put("upAction", upAction);
    	panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
    	panel.getActionMap().put("downAction", downAction);
    	panel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
    	panel.getActionMap().put("enterAction", enterAction);
    	
    	panel.addKeyListener(this);
	}
	
	public void incNavStatus() {
		if (navStatus < 3) {
			navStatus++;
			changeBlink();
		}
	}
	
	public void decNavStatus() {
		if (navStatus > 0) {
			navStatus--;
			changeBlink();
		}
	}
	
	public void restartMenu() {
		enterStatus = 0;
		if (navStatus == 0) {
			navPanel.getS1Label().setVisible(false);
			navPanel.getNicknameLabel().setVisible(false);
			navPanel.getStartLabel().setText("START");
			navPanel.getStartLabel().switchBlink();
		}else {
			topPanel.setVisible(true);
			navPanel.setVisible(true);
			switch (navStatus) {
			case 1:
				HoF.setVisible(false);
				break;

			default:
				break;
			}
		}
	}
	
	public void changeBlink() {
		switch (navStatus) {
		case 0:
			navPanel.getStartLabel().switchBlink();
			navPanel.getHfLabel().switchBlink();
			break;
		case 1:
			navPanel.getHfLabel().switchBlink();
			if(navPanel.getStartLabel().getBlink()) {
				navPanel.getStartLabel().switchBlink();
			}else {
				navPanel.getHelpLabel().switchBlink();
			}
			break;
		case 2:
			navPanel.getHelpLabel().switchBlink();
			if(navPanel.getHfLabel().getBlink()) {
				navPanel.getHfLabel().switchBlink();
			}else {
				navPanel.getCreditsLabel().switchBlink();
			}
			break;
		case 3:
			navPanel.getCreditsLabel().switchBlink();
			navPanel.getHelpLabel().switchBlink();
		}
	}
	
	
	public class UpAction extends AbstractAction{

		private static final long serialVersionUID = -5289279790210346730L;

		/**
		 * 
		 */

		@Override
		public void actionPerformed(ActionEvent e) {
			if (enterStatus > 0) {
				restartMenu();
			}else {
				decNavStatus();
			}
			
		}
	}
	
	public class DownAction extends AbstractAction{

		private static final long serialVersionUID = 4937003853622850512L;

		/**
		 * 
		 */

		@Override
		public void actionPerformed(ActionEvent e) {
			if (enterStatus > 0) {
				restartMenu();
			}else {
				incNavStatus();
			}
			
			
		}
		
	}
	
	public class EnterAction extends AbstractAction{

		private static final long serialVersionUID = 553356973218250398L;

		/**
		 * 
		 */

		@Override
		public void actionPerformed(ActionEvent e) {
			enterStatus++;
			if (navStatus == 0) {
				navPanel.getStartLabel().setText("INSERT NAME:");
				navPanel.getNicknameLabel().setVisible(true);
				navPanel.getS1Label().setVisible(true);
				if (enterStatus == 1) {
					navPanel.getStartLabel().switchBlink();
				}
			}else {
				topPanel.setVisible(false);
				navPanel.setVisible(false);
				if (navStatus == 1) {
					HoF.setVisible(true);
				}
				//TODO
			}
			
		}
		
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (enterStatus > 0) {
			int check = e.getKeyCode();
			if (navStatus == 0) {
				if (check == 10) {
					//enterStatus++;
					if (enterStatus < 2) {
						navPanel.getNicknameLabel().enterInput();
					}else {
						System.out.println(navPanel.getNicknameLabel().getNickname());
						new StageGuiV2(new Player(navPanel.getNicknameLabel().getNickname()));
						gui.dispose();	
					}
					
				}else
				if(check == 8){
					navPanel.getNicknameLabel().deleteChar();
				}else {
					navPanel.getNicknameLabel().addChar(e.getKeyChar());
				}
			}else
			if(navStatus == 1) {
				if (check == 27) {
					restartMenu();
				}
			}
		}
		
		
	}

}
