package menu.components;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import hallOfFameMenu.components.HoFMainPanel;

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
	private StartLabel start = new StartLabel();
	private HallOfFameLabel hf = new HallOfFameLabel();
	private char s;
	
	public MainPanel() throws FileNotFoundException{
		JPanel MainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		MainPanel.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.ipady = 40;
		container.gridx = 0;
		container.gridy = 0;
		container.gridwidth = 3;
		MainPanel.add(title, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 0;
		MainPanel.add(HoF, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 1;
		container.gridwidth = 10;
		MainPanel.add(subtitle, container);
		
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
		MainPanel.add(start, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 1;
		container.gridy = 2;
		MainPanel.add(s1, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 3;
		container.gridwidth = 3;
		MainPanel.add(hf, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 3;
		container.gridy = 3;
		s2.setLastAction(false);
		MainPanel.add(s2, container);
		
		
		
		this.setBackground(Color.BLACK);
		MainPanel.setBackground(Color.BLACK);
		this.add(MainPanel);
		
		upAction = new UpAction();
    	downAction = new DownAction();
    	enterAction = new EnterAction();
    	
    	MainPanel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
    	MainPanel.getActionMap().put("upAction", upAction);
    	MainPanel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
    	MainPanel.getActionMap().put("downAction", downAction);
    	MainPanel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
    	MainPanel.getActionMap().put("enterAction", enterAction);
	}
		
	public class UpAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 4806181623163612729L;

		@Override
		public void actionPerformed(ActionEvent e) {
			s1.setLastAction(true);
			s2.setLastAction(false);
			selectionVar = 0;
			
		}
		
		
	}
	
	public class DownAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = -8270958421456510125L;

	
		@Override
		public void actionPerformed(ActionEvent e) {
			s2.setLastAction(true);
			s1.setLastAction(false);
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

			s1.setVisible(false);
			s2.setVisible(false);
			start.setVisible(false);
			hf.setVisible(false);
			if (selectionVar == 0) {
				
			}else {
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
		System.out.println(e.getKeyChar());
		
	}
		
		

}
