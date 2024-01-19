package Main;

import java.util.Scanner;

//TO DO: MAKE A GENERIC METHOD FOR GETTING USER INPUT
//maybe: private static int getUserInput(String message, int lower_bound, int upper_bound){}
//lower and upper bound used for input validation, maybe lower_bound is 0 and upperbound is length/size of gameList
public class BoardGameSystemUI {
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
          System.out.println("Please choose an option (1-6): ");
     }

     public static int getMenuChoice() {
          printMenu();

          //Get user input for choice
          Scanner scan = new Scanner(System.in);
          int choice;
          try {
               choice = Integer.parseInt(scan.nextLine());
          } catch (Exception e) {
               //In case of invalid input format, default to an invalid choice
               choice = -1;
          }

          //Input validation
          while (!isValidMenuChoice(choice)) {
               try {
                    System.out.println("Please enter a valid choice (an integer between 1 and 6):");
                    choice = Integer.parseInt(scan.nextLine());
               } catch (Exception e) {
                    choice = -1;
               }
          }

          return choice;
     }

     private static boolean isValidMenuChoice(int choice) {
          final int LOWER_BOUND = 1;
          final int UPPER_BOUND = 6;

          return (LOWER_BOUND <= choice && choice <= UPPER_BOUND);
     }

     //Method to list all games
     public static void listAllGames(BoardGameList gameList) {
          int index = 1;
          for (BoardGame bg : gameList) {
               System.out.println(index + ". " + bg.getName()
                         + ", game weight: " + bg.getWeight() + ", times played: " + bg.getTimesPlayed());
               index++;
          }

          //Let user see the output before moving on
          Scanner scan = new Scanner(System.in);
          scan.nextLine();
          scan.close();
     }

     public static void debugDump(BoardGameList gameList) {
          for (BoardGame bg : gameList) {
               System.out.println(bg.toString());
          }
     }

     //Needs some improvement here
     public static BoardGame getGameFromUser() {
          Scanner scan = new Scanner(System.in);
          String gameName = "";
          double weight;

          //Get user input for name
          System.out.println("Please enter the name of the game you want to add (must be at least 1 characer): ");
          gameName = scan.nextLine();

          //Name validation
          //TO CHANGE: make an isValidName() method inside BoardGame class
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
          //TO CHANGE: make an isValidWeight() method inside BoardGame class to eliminate magic numbers
          //while (BoardGame.isValidWeight(weight)){}
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

     public static int getGameDeleteChoice() {
          Scanner scan = new Scanner(System.in);
          int input;

          System.out.println("Please choose which game you would like to delete (Pick a number from the above list):");
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


     public static int getGamePlayedChoice() {
          System.out.println("Please choose the game you want to add a game played to (Pick a number from the above list):");
          return 1;
     }

     //MAKE A GENERIC METHOD FOR GETTING USER INPUT
}