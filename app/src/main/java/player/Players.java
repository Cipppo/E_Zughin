package player;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import menu.utils.PlayerFileReader;
import menu.utils.PlayerFileWriter;

/**
 * Container class to store all the objects Player
 *
 */
public class Players {
	private final int CMax = 10;	//max of objects to store for the top 10 players
	
	private Player[] players;		//array of objects
	int n;
	private final String path = System.getProperty("user.home") + File.separator + "bestPlayersSaves.txt";
	
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
	/**
     * Reads data from last saved data textfile to object collection
     */
     public void Read() {
            try (InputStream ciao = Players.class.getResourceAsStream(File.separator + "bestPlayersSaves.txt")) {
                Scanner scan = new Scanner(ciao);
                PlayerFileReader.read(scan, this);
            } catch (IOException e1) {
                InputStream ciao = new ByteArrayInputStream((path).getBytes());
                Scanner scan = new Scanner(ciao);
                PlayerFileReader.read(scan, this);
            }
            
            
          }
    
    /**
     * Saves the object collection in a data textfile
     * @throws FileNotFoundException
     */
     public void Save() throws FileNotFoundException {
            try (PrintWriter writer = new PrintWriter(new File(Players.class.getResource(File.separator + "bestPlayersSaves.txt").getFile()))) {
              PlayerFileWriter.write(writer, players, n);
            } catch (FileNotFoundException e1) {
                File file = new File(path);
                PrintWriter writer;
                if (file.getAbsoluteFile().exists()) {
                    writer = new PrintWriter(new FileOutputStream(file, true));
                } else {
                    try {
                        file.getParentFile().mkdir();
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    writer = new PrintWriter(file);
                }
                PlayerFileWriter.write(writer, players, n);
            }
            
        }
	
	
}
