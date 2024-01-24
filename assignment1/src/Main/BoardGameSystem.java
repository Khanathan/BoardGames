package Main;

/**
 * A class that handles the logic and state of the program. The program is a system for managing board games.
 * Users can see all board games currently in the system, add, remove board games or add a game played.
 */
public class BoardGameSystem {
     public static void start() {
          BoardGameList gameList = new BoardGameList();
          boolean quit = false;

          while (!quit) {
               int choice = BoardGameSystemUI.getMenuChoice();
               switch (choice) {
                    case 1 -> {
                         //List all games
                         BoardGameSystemUI.listAllGames(gameList);
                         BoardGameSystemUI.pauseLine();
                    }
                    case 2 -> {
                         //Add a game
                         BoardGame gameToAdd = BoardGameSystemUI.getGameFromUser();
                         if (gameToAdd != null) {
                              gameList.addGame(gameToAdd);
                         }
                         BoardGameSystemUI.pauseLine();
                    }
                    case 3 -> {
                         //Remove a game by index
                         if (!gameList.removeGame(BoardGameSystemUI.getGameDeleteChoice(gameList))) {
                              BoardGameSystemUI.cancelled();
                         } else {
                              BoardGameSystemUI.gameRemovedSuccess();
                         }
                         BoardGameSystemUI.pauseLine();
                    }
                    case 4 -> {
                         //Add a game played
                         if (!gameList.incrementGamesPlayed(BoardGameSystemUI.getGamePlayedChoice(gameList))) {
                              BoardGameSystemUI.cancelled();
                         } else {
                              BoardGameSystemUI.gamePlayedSuccess();
                         }
                         BoardGameSystemUI.pauseLine();
                    }
                    case 5 -> {
                         //Debug dump
                         BoardGameSystemUI.debugDump(gameList);
                         BoardGameSystemUI.pauseLine();
                    }

                    case 6 -> {
                         //quit
                         quit = true;
                         BoardGameSystemUI.close();
                    }
               }
          }
     }
}