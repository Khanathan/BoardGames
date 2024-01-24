package Main;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A collection of BoardGame objects. This class supports basic operations such as adding and removing games,
 * increment gamesPlayed of a specific game, and is iterable.
 */

public class BoardGameList implements Iterable<BoardGame> {
     ArrayList<BoardGame> gameList;

     public BoardGameList() {
          gameList = new ArrayList<>();
     }

     public boolean isEmpty() {
          return gameList.isEmpty();
     }

     public void addGame(BoardGame gameToAdd) {
          gameList.add(gameToAdd);
     }

     //Takes a 1-based index but removes the item at 0-based position in the linked list
     public boolean removeGame(int index) {
          if (isEmpty() || index == 0 || index >= gameList.size()) {
               return false;
          }
          //do nothing if invalid index
          try {
               gameList.remove(index - 1);
               return true;
          } catch (Exception e) {
               return false;
          }
     }

     //Increment games played count of the game at the index given
     public boolean incrementGamesPlayed(int index) {
          if (isEmpty() || index == 0 || index >= gameList.size()) {
               return false;
          }
          gameList.get(index - 1).incrementTimesPlayed();
          return true;
     }

     //Returns game list iterator starting at the beginning
     public Iterator<BoardGame> iterator() {
          return gameList.iterator();
     }

     public int size() {
          return gameList.size();
     }
}