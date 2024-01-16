package Main;

import java.util.ListIterator;
import java.util.Scanner;

public class BoardGameSystemUI {
     public static int menu() {
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
          System.out.println("Please choose an option (1-6): ");

          //Get user input for choice
          Scanner scan = new Scanner(System.in);
          int choice;
          try {
               choice = Integer.parseInt(scan.nextLine());
          } catch (Exception e) {
               choice = -1;
          }
          while (choice == -1) {
               try {
                    System.out.println("Please enter a valid choice (an integer between 1 and 6):");
                    choice = Integer.parseInt(scan.nextLine());
               } catch (Exception e) {
                    choice = -1;
               }
          }
          return choice;
     }

     //Method to list all games
     //mode 0: list all games normally
     //mode 1: debug dump
     public static void listGames(ListIterator<BoardGame> iterator, int printMode) {
          //In case of empty game list
          if (!iterator.hasNext()) {
               System.out.println("There is currently no game in the system.\n");
          } else {
               BoardGame game;
               int index = 1;
               //iterate through game list and print each game
               System.out.println("Board Games List:");
               while (iterator.hasNext()) {
                    game = iterator.next();
                    String output = "";

                    //Normal print mode, for option 1 in the menu
                    if (printMode == 0) {
                         output = index + ". " + game.getName()
                                   + ", game weight: " + game.getWeight() + ", times played: " + game.getTimesPlayed() + ".";
                         index++;
                    }
                    //Debug dump mode
                    else if (printMode == 1) {
                         output = game.toString();
                    }
                    System.out.println(output);
               }
          }
          System.out.println();

          //Let user see the game list before moving on
          (new Scanner(System.in)).nextLine();
     }

     public static BoardGame getGameFromUser() {
          Scanner scan = new Scanner(System.in);
          String gameName = "";
          double weight;

          //Get user input for name
          System.out.println("Please enter the name of the game you want to add (must be at least 1 characer): ");
          gameName = scan.nextLine();

          //Name validation
          while (gameName.length() < 1) {
               System.out.println("Please enter a valid game name (at least 1 character in length):");
               gameName = scan.nextLine();
          }

          //Get user input for weight
          try {
               System.out.println("Please enter a weight for the game you want to add (between 1.0 and 5.0):");
               weight = Double.parseDouble(scan.nextLine());
          } catch (Exception e) {
               weight = -1.0; //If the user enters an invalid input (not a float number), default to an invalid weight value
          }

          //weight validation
          while (weight < 1.0 || weight > 5.0) {
               try {
                    System.out.println("Please re-enter a valid weight (must be a number between 1.0 and 5.0):");
                    weight = Double.parseDouble(scan.nextLine());
               } catch (Exception e) {
                    weight = -1.0;
               }
          }

          try {
               return new BoardGame(gameName, weight);
          } catch (Exception e) {
               //Ideally we never reach this code block
               System.out.println(e.getMessage());
               return null;
          }
     }

     public static int getInputForGameDelete() {
          Scanner scan = new Scanner(System.in);
          int input = -1;

          System.out.println("Please choose which game you would like to delete (Pick a number from the above list)");
          try {
               input = Integer.parseInt(scan.nextLine());
          } catch (Exception e) {
               do {
                    System.out.println("Please re-enter a valid choice (An index from the above list): ");
                    try {
                         input = Integer.parseInt(scan.nextLine());
                    } catch (Exception e2) {
                         input = -1;
                    }
               } while (input == -1);
          }
          return input;
     }
}