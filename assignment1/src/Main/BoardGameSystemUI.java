package Main;

import java.util.Scanner;

/**
 * A class that handles all inputs and outputs. Includes methods that prints to the screen and methods to get user inputs.
 */
public class BoardGameSystemUI {
     private static Scanner scan = new Scanner(System.in);

     private static void printMenu() {
          System.out.println("______                     _");
          System.out.println("| ___ \\                   | |");
          System.out.println("| |_/ / ___   __ _ _ __ __| | __ _  __ _ _ __ ___   ___  ___ ");
          System.out.println("| ___ \\/ _ \\ / _` | '__/ _` |/ _` |/ _` | '_ ` _ \\ / _ \\/ __|");
          System.out.println("| |_/ / (_) | (_| | | | (_| | (_| | (_| | | | | | |  __/\\__ \\");
          System.out.println("\\____/ \\___/ \\__,_|_|  \\__,_|\\__, |\\__,_|_| |_| |_|\\___||___/");
          System.out.println("                              __/ |");
          System.out.println("                             |___/\n");
          System.out.println("____________________________Menu____________________________\n");
          System.out.println("1.   List all games.");
          System.out.println("2.   Add a new game.");
          System.out.println("3.   Remove a game.");
          System.out.println("4.   Add a game played.");
          System.out.println("5.   Debug dump.");
          System.out.println("6.   Exit.\n");
     }

     public static int getMenuChoice() {
          printMenu();

          //Get user input for choice
          int firstChoice = 1;
          int lastChoice = 6;
          return getUserInput("Please choose an option (1-6) from the above menu:", firstChoice, lastChoice);
     }

     //Method to list all games
     public static void listAllGames(BoardGameList gameList) {
          if (gameList.size() == 0) {
               System.out.println("There is currently no board game in the system.");
          } else {
               int index = 1; //Index number of board games in the list

               for (BoardGame bg : gameList) {
                    System.out.println(index + ". " + bg.getName()
                              + ", game weight: " + bg.getWeight() + ", times played: " + bg.getTimesPlayed());
                    index++;
               }
          }
     }

     //Getting game name from the user can be extracted into a separate method, but I decided to leave it here for now
     //because there is currently no other place this needs to be done.
     public static BoardGame getGameFromUser() {
          String gameName = "";
          double weight;
          BoardGame game;

          //Get user input for name
          System.out.println("Please enter the name of the game you want to add (must be at least 1 characer): ");
          gameName = scan.nextLine();

          //Name validation
          while (!BoardGame.isValidName(gameName)) {
               System.out.println("Please enter a valid game name (at least 1 character in length):");
               gameName = scan.nextLine();
          }

          //Get user input for weight
          double lowerBound = 1.0;
          double upperBound = 5.0;

          weight = getUserInput("Please enter the weight of the board game ("
                    + lowerBound + " to " + upperBound + "):", lowerBound, upperBound);

          try {
               game = new BoardGame(gameName, weight);

               System.out.println("New game added successfully.");
               return game;
          } catch (Exception e) {
               //Ideally we never reach this code block
               System.out.println(e.getMessage());
               return null;
          }
     }

     public static int getGameDeleteChoice(BoardGameList gameList) {
          int lowerBound = 0;
          int upperBound = gameList.size();
          listAllGames(gameList);
          int choice = getUserInput("Please choose which game you would like to delete (Pick a number from the above list, 0 to cancel):",
                    lowerBound, upperBound);

          return choice;
     }

     public static int getGamePlayedChoice(BoardGameList gameList) {
          listAllGames(gameList);
          int lowerBound = 0;
          int upperBound = gameList.size();
          int choice = getUserInput("Please choose the game you just played (Pick a number from the above list, 0 to cancel):",
                    lowerBound, upperBound);
          return choice;
     }

     public static void debugDump(BoardGameList gameList) {
          if (gameList.size() == 0) {
               System.out.println("There is currently no board game in the system.");
          } else {
               for (BoardGame bg : gameList) {
                    System.out.println(bg.toString());
               }
          }
     }

     //Generic method for prompting the user for an input, must be an int within a range
     private static int getUserInput(String prompt, int lowerBound, int upperBound) {
          int choice;
          System.out.println(prompt);

          try {
               choice = Integer.parseInt(scan.nextLine());
          } catch (Exception e) {
               choice = lowerBound;
          }

          while (!(lowerBound <= choice && choice <= upperBound)) {
               try {
                    System.out.println("Please re-enter a valid input (must be between "
                              + lowerBound + " and " + upperBound + "):");
                    choice = Integer.parseInt(scan.nextLine());
               } catch (Exception e) {
                    choice = lowerBound - 1;
               }
          }

          return choice;
     }

     //Version that returns double instead of int
     private static double getUserInput(String prompt, double lowerBound, double upperBound) {
          double choice;
          System.out.println(prompt);

          try {
               choice = Double.parseDouble(scan.nextLine());
          } catch (Exception e) {
               choice = lowerBound - 1;
          }

          while (!(lowerBound <= choice && choice <= upperBound)) {
               try {
                    System.out.println("Please re-enter a valid input (must be between "
                              + lowerBound + " and " + upperBound + "):");
                    choice = Double.parseDouble(scan.nextLine());
               } catch (Exception e) {
                    choice = lowerBound - 1;
               }
          }

          return choice;
     }

     //Method for letting the user read the output before continuing by hitting enter
     public static void pauseLine() {
          System.out.println("Hit enter to continue...");
          scan.nextLine();
     }

     //Method for when the user cancels the current action
     public static void cancelled() {
          System.out.println("Cancelled.");
     }

     public static void gamePlayedSuccess() {
          System.out.println("Game played added successfully.");
     }

     public static void gameRemovedSuccess() {
          System.out.println("Game removed successfully.");
     }

     //For when the user chooses to quit/close the program, closes the Scanner
     public static void close() {
          System.out.println("Program closing.");
          scan.close();
     }
}