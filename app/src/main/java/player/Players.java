package player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import bonus.Score;

/**
 * Container class to store all the objects Player
 *
 */
public class Players {
	private final int CMax = 10;	//max of objects to store for the top 10 players
	
	private Player[] players;		//array of objects
	int n;
	//private final String path = System.getProperty("user.home") + File.separator + "bestPlayersSaves.txt";
	
	/**
	 * Constructor without parameters(Default)
	 */
	public Players() {
		this.players = new Player[CMax];
		this.n = 0;
	}
	
	/**
	 * Method Get without arguments
	 * @return lenght of the array of objects (int)
	 */
	public int get() {	
		return this.n; 
		}
	
	/**
	 * Method Get with argument (index)
	 * @param i
	 * @return the i-th objects
	 */
	public Player get(int i) {	
		return players[i];
		}	
	
	/**
	 * Add the argument to the array of objects
	 * @param p
	 */
	public void add(Player p) {
		if (n == CMax) {									//fullness control of the array
			if(!removeLastPlayerByScore(p.getScore().getScore())) { 
				return;
			}
		}
		this.players[n++] = p;
		this.Sort();
	}
	
	/**
	 * removes the last player if his score is less than the argument
	 * @param score
	 * @return true the operation succeed, false if it do not
	 */
	public boolean removeLastPlayerByScore(int score) {
		if (this.players[n-1].getScore().getScore() < score) {
			this.players[n-1] = null;
			this.n--;
			return true;
		}
		return false;
	}
	
	/**
	 * Sort the container by the score
	 */
	public void Sort() {
		for (int i = 1; i < this.n; i++) {
			Player key = this.get(i);
			int j = i - 1;
			while(j >= 0 && this.get(j).getScore().getScore() < key.getScore().getScore()) {
				this.players[j+1] = this.players[j];
				j--;
			}
			this.players[j+1] = key;
		}
	}
	
	/**
	 * Reads data from last saved data textfile to object collection
	 */
	public void Read() {
		final InputStream input = ClassLoader.getSystemResourceAsStream("bestPlayersData");
        Scanner scan = new Scanner(input);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line;
        try {
			while((line = br.readLine()) != null) {
			    String[] parts = line.split(";");
			    String nickname = parts[0].trim();
			    Score score = new Score();
			    score.raiseScore(Integer.parseInt(parts[1].trim()));
			    String date = parts[2].trim();
			    
			    this.add(new Player(nickname, score, date));
			  }
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          scan.close();
      }
    
    /**
     * Saves the object collection in a data textfile
     * @throws FileNotFoundException
     */
     public void Save() {
    	 	PrintWriter writer;
			try {
				writer = new PrintWriter(new File(ClassLoader.getSystemResourceAsStream("bestPlayersData").toString()));
	    	 	for (int i = 0; i < n; i++) {
	                String line = players[i].getNickname() + "; " + Integer.toString(players[i].getScore().getScore()) + "; " +
	                    players[i].getDate() + ";";
	                writer.println(line);
	              }
	            writer.close();
	            System.out.print("ok");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("not ok");
			}
        }
	
	
}
