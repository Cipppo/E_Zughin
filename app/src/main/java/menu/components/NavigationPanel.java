package menu.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import menu.utils.MenuLabel;
import menu.utils.NicknameInput;

public class NavigationPanel extends JPanel {

	private static final long serialVersionUID = 4264611596965143016L;
	private MenuLabel s1 = new MenuLabel("_");
	private MenuLabel start = new MenuLabel("START");
	private MenuLabel hf = new MenuLabel("HALL OF FAME");
	private MenuLabel help = new MenuLabel("HELP");
	private NicknameInput nickname = new NicknameInput();
	
	
	public NavigationPanel() {
		super(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		super.setLayout(new GridBagLayout());
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 0;
		container.gridwidth = 1;
		container.ipady = 10;
		super.add(start, container);
		start.switchBlink();
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 1;
		container.gridy = 0;
		super.add(nickname, container);
		nickname.setVisible(false);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 2;
		container.gridy = 0;
		super.add(s1, container);
		s1.setVisible(false);
		s1.switchBlink();
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 1;
		super.add(hf, container);
		
		container.fill = GridBagConstraints.HORIZONTAL;
		container.gridx = 0;
		container.gridy = 2;
		//container.gridwidth = 1;
		super.add(help, container);
		
		this.setBackground(Color.BLACK);
	}
	
	
	public MenuLabel getStartLabel() {
		return this.start;
	}
	
	public MenuLabel getS1Label() {
		return this.s1;
	}
	
	public MenuLabel getHfLabel() {
		return this.hf;
	}
	
	public MenuLabel getHelpLabel() {
		return this.help;
	}
	
	public NicknameInput getNicknameLabel() {
		return nickname;
	}
	
	
}
