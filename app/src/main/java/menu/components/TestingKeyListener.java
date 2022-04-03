package menu.components;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.JPanel;

import hallOfFameMenu.components.DataLabel;
import hallOfFameMenu.components.HoFMainPanel;
import menu.gui.Gui;

public class TestingKeyListener extends JPanel implements KeyListener{

	private static final long serialVersionUID = 7141694249033633519L;
	private HoFMainPanel HoF = new HoFMainPanel();
	
	public TestingKeyListener(Gui gui) throws FileNotFoundException{
		gui.addKeyListener(this);
		this.add(new DataLabel("porcodio"));
		this.setBackground(Color.black);
		//this.add(HoF);
		//HoF.setVisible(true);
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
		String c = "" + e.getKeyChar();
		
		this.add(new DataLabel(c));
		this.setBackground(Color.PINK);
		System.out.println("you released button: " + c);
		
	}

}
