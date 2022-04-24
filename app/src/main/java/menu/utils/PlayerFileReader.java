package menu.utils;

import java.util.Scanner;

import bonus.Score;
import player.Player;
import player.Players;

/**
 * class to read data about the players from a file
 *
 */
public class PlayerFileReader {
    /**
     * reads data
     * @param scan where to read data
     * @param player player container to store the data
     */
    public static void read(Scanner scan, Players player) {
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] parts = line.split(";");
            String nickname = parts[0].trim();
            Score score = new Score();
            score.raiseScore(Integer.parseInt(parts[1].trim()));
            String date = parts[2].trim();
            
            player.add(new Player(nickname, score, date));
          }
          scan.close();
    }
}