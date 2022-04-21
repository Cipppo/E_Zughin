package player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bonus.Score;

/**
 * Class to store data for single player
 *
 */
public class Player {
	
	private String nickname;
	private Score score;		
	private String date;		
	
	
	/**
	 * Constructor with one parameter
	 * @param nickname
	 */
	public Player(String nickname) {
		this.nickname = nickname;
		this.score = new Score();
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
	public Player(String nickname, Score score, String date) {
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
	public Score getScore() { 
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
	 * Increase Player Score
	 * @param score
	 */
	public void increaseScore(int score) { 
		this.score.raiseScore(score);
	}


}

