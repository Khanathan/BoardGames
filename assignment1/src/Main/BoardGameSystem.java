package Main;

import java.util.Scanner;

/**
 * A class that allows the user to manage board games.
 * Users can see all board games in the system, add, remove or add a board game match played.
 */
public class BoardGameSystem {
     public static void start() {
          BoardGameList gameList = new BoardGameList();
          boolean quit = false;

          while (!quit) {
               int choice = BoardGameSystemUI.getMenuChoice();
               switch (choice) {
                    case 1:
                         //List all games
                         BoardGameSystemUI.listAllGames(gameList);
                         break;
                    case 2:
                         //Add a game
                         BoardGame gameToAdd = BoardGameSystemUI.getGameFromUser();
                         if (gameToAdd != null) {
                              gameList.addGame(gameToAdd);
                         }
                         break;
                    case 3:
                         //Remove a game by index
                         gameList.removeGame(BoardGameSystemUI.getGameDeleteChoice(gameList));
                         break;
                    case 4:
                         //Add a game played
                         gameList.incrementGamesPlayed(BoardGameSystemUI.getGamePlayedChoice(gameList)); //Get a choice from user then increment game played counter of that game
                         break;
                    case 5:
                         //Debug dump
                         BoardGameSystemUI.debugDump(gameList);
                         break;
                    case 6:
                         quit = true;
                         System.out.println("Program closing.");
                         break;
               }
          }
     }
}