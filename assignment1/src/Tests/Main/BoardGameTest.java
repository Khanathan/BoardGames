package Main;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameTest {

     @org.junit.jupiter.api.Test
     void getName() {
          try {
               BoardGame b1 = new BoardGame("Mario Kart", 2.5);
               BoardGame b2 = new BoardGame("123213|", 5);
               assertEquals("Mario Kart", b1.getName());
               assertEquals("123213|", b2.getName());
          } catch (Exception e) {
          }

     }

     @org.junit.jupiter.api.Test
     void getWeight() {
          try {
               BoardGame b1 = new BoardGame("Mario Kart", 2.5);
               BoardGame b2 = new BoardGame("123213|", 5);
               assertEquals(2.5, b1.getWeight());
               assertEquals(5.0, b2.getWeight());
          } catch (Exception e) {
          }
     }

     @org.junit.jupiter.api.Test
     void getTimesPlayed() {
          try {
               BoardGame b1 = new BoardGame("Mario Kart", 2.5);
               assertEquals(0, b1.getTimesPlayed());
               b1.incrementTimesPlayed();
               assertEquals(1, b1.getTimesPlayed());
               BoardGame b2 = new BoardGame("123213|", 5);
               assertEquals(0, b2.getTimesPlayed());
          } catch (Exception e) {
          }
     }

     @org.junit.jupiter.api.Test
     void testToString() {
          try {
               BoardGame b1 = new BoardGame("Mario Kart", 2.5);
               b1.incrementTimesPlayed();
               assertEquals("Game name: Mario Kart, weight: 2.5, times played: 1", b1.toString());
          } catch (Exception e) {

          }
     }
}