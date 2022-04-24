package menu.utils;

import java.io.PrintWriter;

import player.Player;

public class PlayerFileWriter {
    
    public static void write(PrintWriter writer, Player[] players, int n) {
        for (int i = 0; i < n; i++) {
            String line = players[i].getNickname() + "; " + Integer.toString(players[i].getScore().getScore()) + "; " +
                players[i].getDate() + ";";
            writer.println(line);
          }
          writer.close();
    }
}