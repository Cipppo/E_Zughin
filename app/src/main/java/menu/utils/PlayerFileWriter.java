package menu.utils;

import java.io.PrintWriter;

import player.Player;

/**
 * class to write the players in a file
 *
 */
public class PlayerFileWriter {
    
	/**
	 * write the players in file
	 * @param writer file
	 * @param players container of object player
	 * @param n number of players
	 */
    public static void write(PrintWriter writer, Player[] players, int n) {
        for (int i = 0; i < n; i++) {
            String line = players[i].getNickname() + "; " + Integer.toString(players[i].getScore().getScore()) + "; " +
                players[i].getDate() + ";";
            writer.println(line);
          }
          writer.close();
    }
}