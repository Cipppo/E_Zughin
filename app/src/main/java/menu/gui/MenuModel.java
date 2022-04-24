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
import helpMenu.HelpPanel;
import menu.components.*;
import mergeballs.stage.StageGuiV2;
import player.Player;

public class MenuModel implements KeyListener{

	private JPanel panel;
	private GridBagConstraints container;
	private final MenuControl menuControl;
	private final HoFMainPanel HoF = new HoFMainPanel();
	private final HelpPanel help = new HelpPanel();
	private final TopMenuPanel topPanel = new TopMenuPanel();
	private final NavigationPanel navPanel = new NavigationPanel();
	private UpAction upAction;
	private DownAction downAction;
	private EnterAction enterAction;
	private final Gui gui;
	
	
	public MenuModel(Gui gui) throws FileNotFoundException{
		menuControl = new MenuControl(this);
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
		panel.add(help, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridy = 1;
		container.gridwidth = 1;
		panel.add(navPanel,container);
		
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
	
	public void restartMenu() {
		menuControl.setEnterStatus(0);
		if (menuControl.getNavStatus() == 0) {
			navPanel.getS1Label().setVisible(false);
			navPanel.getNicknameLabel().setVisible(false);
			navPanel.getStartLabel().setText("START");
			navPanel.getStartLabel().switchBlink();
		}else {
			topPanel.setVisible(true);
			navPanel.setVisible(true);
			switch (menuControl.getNavStatus()) {
			case 1:
				HoF.setVisible(false);
				break;
			case 2:
				help.setVisible(false);
				break;
			default:
				break;
			}
		}
	}
	
	public void changeBlink() {
		switch (menuControl.getNavStatus()) {
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
			navPanel.getHfLabel().switchBlink();
			break;
		}
	}
	
	public void exEntAct() {
		if (menuControl.getNavStatus() == 0) {
			navPanel.getStartLabel().setText("INSERT NAME:");
			navPanel.getNicknameLabel().setVisible(true);
			navPanel.getS1Label().setVisible(true);
			if (menuControl.getEnterStatus() == 1) {
				navPanel.getStartLabel().switchBlink();
			}
		}else {
			topPanel.setVisible(false);
			navPanel.setVisible(false);
			if (menuControl.getNavStatus() == 1) {
				HoF.setVisible(true);
			}else 
			if (menuControl.getNavStatus() == 2) {
				help.setVisible(true);
			}
		}
	}
	
	public void exActList(int i, char c) {
		if (menuControl.getNavStatus() == 0) {
			if (i == 10) {
				if (menuControl.getEnterStatus() < 2) {
					navPanel.getNicknameLabel().enterInput();
				}else {
					new StageGuiV2(new Player(navPanel.getNicknameLabel().getNickname()));
					gui.dispose();	
				}
				
			}else
			if(i == 8){
				navPanel.getNicknameLabel().deleteChar();
			}else {
				navPanel.getNicknameLabel().addChar(c);
			}
		}else {
			if (i == 27) {
				restartMenu();
			}
		}
	}
	
	
	public class UpAction extends AbstractAction{

		private static final long serialVersionUID = -5289279790210346730L;

		/**
		 * 
		 */

		@Override
		public void actionPerformed(ActionEvent e) {
			menuControl.UpAct();
		}
	}
	
	public class DownAction extends AbstractAction{

		private static final long serialVersionUID = 4937003853622850512L;

		/**
		 * 
		 */

		@Override
		public void actionPerformed(ActionEvent e) {
			menuControl.DownAct();
		}
		
	}
	
	public class EnterAction extends AbstractAction{

		private static final long serialVersionUID = 553356973218250398L;

		/**
		 * 
		 */

		@Override
		public void actionPerformed(ActionEvent e) {
			menuControl.EnterAct();
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
		menuControl.keyAct(e.getKeyCode(), e.getKeyChar());
		
	}

}