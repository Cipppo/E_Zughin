package menu.components;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import hallOfFameMenu.components.*;
import menu.gui.Gui;
import menu.utils.GenericLabel;
import menu.utils.NicknameInput;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.GridLayout;
import java.io.FileNotFoundException;

public class MainPanel extends JPanel implements KeyListener{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3036609648280707540L;
	private HoFMainPanel HoF = new HoFMainPanel();
	private TitleLabel title = new TitleLabel();
	private SubtitleLabel subtitle = new SubtitleLabel();
	private UpAction upAction;
	private DownAction downAction;
	private EnterAction enterAction;
	private SelectionLabel s1 = new SelectionLabel();
	private SelectionLabel s2 = new SelectionLabel();
	private int selectionVar = 0;
	private boolean enterCheck = false;
	private StartLabel start = new StartLabel();
	private HallOfFameLabel hf = new HallOfFameLabel();
	private JPanel panel;
	private GridBagConstraints container;
	private NicknameInput nick;
	private int enterStatus = 0;
	private DataLabel credits = new DataLabel("CREDITS");
	
	public MainPanel(Gui gui) throws FileNotFoundException{
		 
		
		panel = new JPanel(new GridBagLayout());
		container = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.ipady = 20;
		container.gridx = 0;
		container.gridy = 0;
		container.gridwidth = 3;
		panel.add(title, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 0;
		panel.add(HoF, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 1;
		container.gridwidth = 10;
		panel.add(subtitle, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 2;
		container.gridwidth = 1;
		panel.add(start, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 2;
		container.gridy = 2;
		panel.add(s1, container);
		s1.setVisible(false); //attenzione
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 3;
		container.gridwidth = 1;
		container.ipady = 7;
		panel.add(hf, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 4;
		credits.setGSize(4);
		credits.setFont(credits.getGameFont());
		//credits.set
		panel.add(credits, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 5;
		DataLabel help = new DataLabel("HELP");
		help.setGSize(4);
		help.setFont(help.getGameFont());
		//credits.set
		panel.add(help, container);
		
		
		
		/*container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 3;
		container.gridy = 3;
		s2.setLastAction(false);
		panel.add(s2, container);*/
		

		this.addKeyListener(this);
		
		panel.setBackground(Color.BLACK);
		this.add(panel);
		this.setBackground(Color.BLACK);
		//this.add(MainPanel);
		
		upAction = new UpAction();
    	downAction = new DownAction();
    	enterAction = new EnterAction();
    	
    	this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
    	this.getActionMap().put("upAction", upAction);
    	this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
    	this.getActionMap().put("downAction", downAction);
    	this.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
    	this.getActionMap().put("enterAction", enterAction);
	}
	
	public void restartMenu() {
		HoF.setVisible(false);
		title.setVisible(true);
		subtitle.setVisible(true);
		start.setVisible(true);
		hf.setVisible(true);
		enterCheck = false;
		enterStatus = 1;
		nick.setVisible(false);
		s1.setVisible(false);
		
	}
		
	public class UpAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 4806181623163612729L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(enterCheck == false) {
				start.setLastAction(true);
				hf.setLastAction(false);
				selectionVar = 0;
			}
			
		}
		
		
	}
	
	public class DownAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = -8270958421456510125L;

	
		@Override
		public void actionPerformed(ActionEvent e) {
			/*if(enterCheck == false) {
				start.setLastAction(false);
				hf.setLastAction(true);
				selectionVar = 1;
			}*/
			enterCheck = false;
			start.setLastAction(false);
			start.setT("START");
			hf.setLastAction(true);
			if(enterStatus > 0) {
				nick.setVisible(false);
				s1.setVisible(false);
			}
			
			
			selectionVar = 1;
			
		}
		
		
	}
	
	public class EnterAction extends AbstractAction{

	
		/**
		 * 
		 */
		private static final long serialVersionUID = -5986885832851680610L;

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("enterrrr");
			//this.add(new MainPanel());
			
			enterCheck = true;
			
			//s1.setVisible(false);
			//s2.setVisible(false);
			//start.setVisible(false);
			//hf.setVisible(false);
			if (selectionVar == 0) {
				selectionVar = 2;
				/*container.fill = GridBagConstraints.HORIZONTAL ;
				container.gridx = 0;
				container.gridy = 2;
				container.gridwidth = 1;
				DataLabel insert = new DataLabel("INSERT NAME:");
				insert.setGSize(4);
				insert.setFont(insert.getGameFont());
				panel.add(insert, container);*/
				start.setT("INSERT NAME:");
				start.setLastAction(false);
				
				selectionVar = 2;
				container.fill = GridBagConstraints.HORIZONTAL ;
				container.gridx = 1;
				container.gridy = 2;
				container.gridwidth = 1;
				nick = new NicknameInput();
				enterStatus = 0;
				nick.setVisible(true);
				panel.add(nick, container);
				s1.setVisible(true);
			}else
			if(selectionVar == 1) {
				HoF.setVisible(true);
				title.setVisible(false);
				subtitle.setVisible(false);
				start.setVisible(false);
				hf.setVisible(false);
				/*if(enterStatus > 0) {
					nick.setVisible(false);
				}*/
				
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
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
		int check = e.getKeyCode();
		if (selectionVar == 2) {
			if (check == 10) {
				enterStatus++;
				if (enterStatus < 2) {
					nick.enterInput();
				}else {
					System.out.println(nick.getNickname());
				}
				
			}else
			if(check == 8){
				nick.deleteChar();
			}else {
				nick.addChar(e.getKeyChar());
			}
		}else
		if(selectionVar == 1) {
			if (check == 27) {
				restartMenu();
			}
		}
		//System.out.println("you released keyz button: " + e.getKeyChar());
	}
		
		

}
