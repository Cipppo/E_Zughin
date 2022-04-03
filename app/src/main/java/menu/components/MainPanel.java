package menu.components;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import hallOfFameMenu.components.DataLabel;
import hallOfFameMenu.components.HoFMainPanel;
import hallOfFameMenu.components.SubtitlesLabel;
import menu.gui.Gui;
import menu.utils.GenericLabel;

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
	private int cont = 0;
	private GridBagConstraints container;

	
	public MainPanel(Gui gui) throws FileNotFoundException{
		 
		
		panel = new JPanel(new GridBagLayout());
		container = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.ipady = 40;
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
		
		/*s1.setVisible(false);
		t1.setVisible(false);
		HoF.setVisible(true);
		/*container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 3;
		container.gridwidth = 5;
		container.gridheight = 2;
		MainPanel.add(new NavigationPanel(), container);*/
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 2;
		container.gridwidth = 1;
		panel.add(start, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 1;
		container.gridy = 2;
		panel.add(s1, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 3;
		container.gridwidth = 3;
		panel.add(hf, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 3;
		container.gridy = 3;
		s2.setLastAction(false);
		panel.add(s2, container);
		

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
	
	public void InsertName(char c) {
		String s = "" + c;
		this.container.fill = GridBagConstraints.HORIZONTAL ;
		this.container.gridx = cont;
		this.container.gridy = 3;
		this.panel.add(new DataLabel("srticazzi"), container);
		this.cont++;
		System.out.println("arrrivati");
	}
		
	public class UpAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 4806181623163612729L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(enterCheck == false) {
				s1.setLastAction(true);
				s2.setLastAction(false);
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
			if(enterCheck == false) {
				s2.setLastAction(true);
				s1.setLastAction(false);
				selectionVar = 1;
			}
			
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
			
			s1.setVisible(false);
			s2.setVisible(false);
			start.setVisible(false);
			hf.setVisible(false);
			if (selectionVar == 0) {
				selectionVar = 2;
				container.fill = GridBagConstraints.HORIZONTAL ;
				container.gridx = 0;
				container.gridy = 2;
				container.gridwidth = 1;
				panel.add(new DataLabel("PORCODIOOOO"), container);
			}else
			if(selectionVar == 1) {
				HoF.setVisible(true);
				title.setVisible(false);
				subtitle.setVisible(false);
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
		if (selectionVar == 2) {
			
			
			
			System.out.println("you released keyz button: " + e.getKeyChar());
			this.InsertName(e.getKeyChar());
		}
		//System.out.println("you released keyz button: " + e.getKeyChar());
	}
		
		

}
