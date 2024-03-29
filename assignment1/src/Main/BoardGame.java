package Main;

import java.lang.Math;

/**
 * A class that represents a board game. Has a name, weight and counter (timesPlayed) keeping track of how many times
 * the game has been played. The class has getter methods for all attributes and a method for incrementing timesPlayed.
 * The class also has methods to check for valid weight and name, and throws an exception when invalid values are used to
 * create a new BoardGame object.
 */
public class BoardGame {
     private String name;
     private double weight; //Must be: 1 <= weight <= 5.0
     private int timesPlayed;

     public BoardGame(String name, double weight) throws InvalidWeightException, EmptyNameException {
          if (!isValidWeight(weight)) {
               throw new InvalidWeightException(weight);
          }

          if (name.equals("")) {
               throw new EmptyNameException();
          }

          this.name = name;
          this.weight = Math.round(weight * 100.0) / 100.0; //weight is rounded to 2 decimal places
          timesPlayed = 0;
     }

     public static boolean isValidName(String name) {
          return name.length() >= 1;
     }

     public static boolean isValidWeight(double weight) {
          //Arbitrary min and max weight of board games
          double minWeight = 1.0;
          double maxWeight = 5.0;

          return (weight >= minWeight) && (weight <= maxWeight);
     }

     public String getName() {
          return name;
     }

     public double getWeight() {
          return weight;
     }

     public int getTimesPlayed() {
          return timesPlayed;
     }

     public void incrementTimesPlayed() {
          timesPlayed++;
     }

     public String toString() {
          return "Game name: " + name + ", weight: " + weight + ", times played: " + timesPlayed;
     }
}
