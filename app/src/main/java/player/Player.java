package player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class to store data for single player
 *
 */
public class Player {
	
	private String nickname;
	private int score;			
	private String date;		
	
	
	/**
	 * Constructor with one parameter
	 * @param nickname
	 */
	public Player(String nickname) {
		this.nickname = nickname;
		this.score = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		this.date = dtf.format(now);
	}
	
	/**
	 * Constructor with parameters
	 * @param nickname
	 * @param score
	 * @param date
	 */
	public Player(String nickname, int score, String date) {
		this.nickname = nickname;
		this.score = score;
		this.date = date;
	}
	
	/////////////////////////////////////////INTERFACE METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * returns the nickname
	 * @return 
	 */
	public String getNickname() { 
		return this.nickname; 
	}
	
	/**
	 * returns the score
	 * @return
	 */
	public int getScore() { 
		return this.score; 
		}
	
	/**
	 * returns the date
	 * @return
	 */
	public String getDate() {
		return this.date;
	}
	
	/**
	 * Set Player score
	 * @param score
	 */
	public void setScore(int score) { 
		this.score = score; 
		}
	
	public void incScore(int score) {
		this.score += score;
	}

}

