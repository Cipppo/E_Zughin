package menu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class NavigationPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4264611596965143016L;
	

	private UpAction upAction;
	private DownAction downAction;
	private EnterAction enterAction;
	private SelectionPanel s1 = new SelectionPanel();
	private SelectionPanel s2 = new SelectionPanel();

	public NavigationPanel() {
		JPanel navigationPanel = new JPanel(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		navigationPanel.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 0;
		container.gridwidth = 1;
		navigationPanel.add(new StartPanel(), container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 1;
		container.gridy = 0;
		navigationPanel.add(s1, container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 0;
		container.gridy = 1;
		container.gridwidth = 3;
		navigationPanel.add(new HallOfFamePanel(), container);
		
		container.fill = GridBagConstraints.HORIZONTAL ;
		container.gridx = 3;
		container.gridy = 1;
		s2.setLastAction(false);
		navigationPanel.add(s2, container);
		
		navigationPanel.setBackground(Color.BLACK);
		this.setBackground(Color.BLACK);
		this.add(navigationPanel);
		
		upAction = new UpAction();
    	downAction = new DownAction();
    	enterAction = new EnterAction();
    	
    	navigationPanel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
    	navigationPanel.getActionMap().put("upAction", upAction);
    	navigationPanel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
    	navigationPanel.getActionMap().put("downAction", downAction);
    	navigationPanel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
    	navigationPanel.getActionMap().put("enterAction", enterAction);
		
		
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
			
		}
		
		
	}
	
	public class EnterAction extends AbstractAction{

	
		/**
		 * 
		 */
		private static final long serialVersionUID = -5986885832851680610L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("enterrrr");
			
		}
		
		
	}
}
