package Main;

import java.util.ArrayList;
import java.util.Iterator;

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
          if (index == 0) {
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
          if (index == 0) {
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