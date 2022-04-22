package menu.utils;

import java.util.Scanner;

import bonus.Score;
import player.Player;
import player.Players;

public class PlayerFileReader {
    
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