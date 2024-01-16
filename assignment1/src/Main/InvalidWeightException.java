package Main;

public class InvalidWeightException extends Exception{
     public InvalidWeightException(double weight) {
          super(weight + " is an invalid weight for a board game. A valid weight must be between 1.0 and 5.0");
     }
}
