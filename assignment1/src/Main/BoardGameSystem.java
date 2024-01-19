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
                         BoardGameSystemUI.listGames(gameList);
                         break;
                    case 2:
                         BoardGame gameToAdd = BoardGameSystemUI.getGameFromUser();
                         if (gameToAdd != null) {
                              gameList.addGame(gameToAdd);
                              System.out.println("Game successfully added!");
                              Scanner scan = new Scanner(System.in);
                              scan.nextLine();
                         }
                         break;
                    case 3:
                         //Remove a game by index
                         BoardGameSystemUI.listGames(gameList);

                         break;
                    case 4:
                         //Add a game played
                         BoardGameSystemUI.listGames(gameList);

                         break;
                    case 5:
                         //Debug dump
                         BoardGameSystemUI.listGames(gameList);
                         break;
                    case 6:
                         quit = true;
                         System.out.println("Program closing.");
                         break;
               }
          }
     }
}