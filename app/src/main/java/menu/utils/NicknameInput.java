package menu.utils;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * class to crate and manage the nickname label
 *
 */
public class NicknameInput extends JPanel{

	private static final long serialVersionUID = -3550165270008975447L;
	private String nickname;
	private int check;
	private MenuLabel nick;
	
	/**
	 * constructor without parameters
	 */
	public NicknameInput() {
		nickname = "";
		check = -1;
		nick = new MenuLabel("", 4, Color.GREEN);
		nick.setText(nickname);
		this.setLayout(new BorderLayout());
		this.add(nick, BorderLayout.CENTER);
		this.setBackground(Color.black);
		
	}
	
	/**
	 * initialize the text the first enter input
	 */
	public void enterInput() {
		if (check == -1) {
			nickname = "  ";
			nick.setText(nickname);
		}
		check++;
		
	}
	
	
	/**
	 * add a char to the label
	 * @param c char
	 */
	public void addChar(char c) {
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String car = "" + c;
		car = car.toUpperCase();
		if (alpha.contains(car) && nickname.length() < 14) {
			//nickname = nickname.substring(0, nickname.length()-1) + car + "-";
			nickname += car;
			nick.setText(nickname);
		}
	}
	
	/**
	 * delete a char from the label
	 */
	public void deleteChar() {
		if (nickname.length() > 2) {
			//nickname = nickname.substring(0, nickname.length()-2) + "-";
			nickname = nickname.substring(0, nickname.length()-1);
			nick.setText(nickname);
		}
	}
	
	/**
	 * get the label content
	 * @return nickname
	 */
	public String getNickname() {
		return this.nickname.substring(2);
	}
}
	
	
	


