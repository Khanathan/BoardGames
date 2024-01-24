package Main;

/**
 * Exception for when a BoardGame is created with a name less than 1 character in length.
 */
public class EmptyNameException extends Exception {
     public EmptyNameException() {
          super("A board game name must be at least 1 character in length.");
     }
}
