package player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Players {
	private final int CMax = 15;
	
	private Player[] players;
	int n;
	
	public Players() {
		this.players = new Player[CMax];
		this.n = 0;
	}
	
	public int get() {	return this.n; }
	
	public Player get(int i) {	return players[i];}	
	
	public void add(Player p) {
		if (n == CMax) {
			if(!removeLastPlayerByScore(p.getScore())) {
				return;
			}
		}
		this.players[n++] = p;
		
	}
	
	public boolean removeLastPlayerByScore(int score) {
		if (this.players[n-1].getScore() < score) {
			this.players[n-1] = null;
			this.n--;
			return true;
		}
		return false;
	}
	
	public void Read() {
		InputStream ciao = Players.class.getResourceAsStream("/bestPlayersSaves.txt");
		Scanner scan = new Scanner(ciao);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] parts = line.split(";");
			this.add(new Player(parts[0]));
			//System.out.println(parts[1])
			this.players[n-1].setScore(Integer.parseInt(parts[1].trim()));
		}
		
		
	}
	
	
	public void Save() throws FileNotFoundException {
		PrintWriter writer =  new PrintWriter(new File(Players.class.getResource("/bestPlayersSaves.txt").getFile()));
		for (int i = 0; i < this.n; i++) {
			String line = this.players[i].getNickname() + "; " + Integer.toString(this.players[i].getScore()) + ";";
			writer.println(line);
		}
		writer.close();
		
	}
	
	
}
