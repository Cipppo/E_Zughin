package menu.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class NicknameInput extends JPanel{

	private static final long serialVersionUID = -3550165270008975447L;
	private String nickname;
	private int check;
	private int seconds = 0;
	private Timer timer;
	private SecondaryLabel nick;
	
	public NicknameInput() {
		nickname = "";
		check = -1;
		nick = new SecondaryLabel();
		nick.setSSize(4);
		nick.setFont(nick.getGameFont());
		nick.setText(nickname);
		this.setLayout(new BorderLayout());
		this.add(nick, BorderLayout.CENTER);
		this.setBackground(Color.black);
		simpleTimer();
		timer.start();
		
	}
	
	public void enterInput() {
		if (check == -1) {
			nickname += "  ";
			nick.setText(nickname);
		}
	}
		
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
	
	public void deleteChar() {
		if (nickname.length() > 2) {
			//nickname = nickname.substring(0, nickname.length()-2) + "-";
			nickname = nickname.substring(0, nickname.length()-1);
			nick.setText(nickname);
		}
	}
	
	public String getNickname() {
		return this.nickname.substring(2);
	}
	
	public void simpleTimer() {
		timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds % 2 == 0) {
                	nick.setForeground(Color.GREEN);
    			}else {
    				nick.setForeground(Color.GREEN);
    			}
                
                
                if(seconds >= 1000) {
                	//seconds = 0;
                	timer.stop();
                }
            }

        });
	}
}
	
	
	


