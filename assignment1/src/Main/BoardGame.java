package Main;

import java.lang.Math;

public class BoardGame {
     private String name;
     private double weight; //Must be: 1 <= weight <= 5.0
     private int timesPlayed;

     public BoardGame(String name, double weight) throws InvalidWeightException, EmptyNameException {
          if (weight < 1 || weight > 5) {
               throw new InvalidWeightException(weight);
          }

          if (name.equals("")) {
               throw new EmptyNameException();
          }

          this.name = name;
          this.weight = Math.round(weight * 100.0) / 100.0; //weight is rounded to 2 decimal places
          timesPlayed = 0;
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

     public static boolean isValidName(String name) {
          return name.length() >= 1;
     }
}
