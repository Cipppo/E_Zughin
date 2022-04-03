package menu.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import menu.components.MainPanel;
import menu.components.TestingKeyListener;
import stage.utils.CenterOnDefaultScreen;

public class Gui extends JFrame implements KeyListener{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5959162590670099057L;
	private final int width = CenterOnDefaultScreen.center().width;
	private final int heigth = CenterOnDefaultScreen.center().height;
	private MainPanel mainPanel;
	
	
	private TestingKeyListener test;

	public Gui() throws FileNotFoundException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setSize(width*70/100, heigth*70/100);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//this.mainPanel = new MainPanel(this);
		test = new TestingKeyListener(this);
		this.add(test, BorderLayout.CENTER);
		//this.addKeyListener(this);
		
		this.setVisible(true);
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
		System.out.println("you released key: " + e.getKeyChar());
		
	}
}
