package Main;

public class EmptyNameException extends Exception{
     public EmptyNameException() {
          super("A board game name must be at least 1 character in length.");
     }
}
