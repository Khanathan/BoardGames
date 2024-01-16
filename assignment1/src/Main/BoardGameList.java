package Main;

import java.util.LinkedList;
import java.util.ListIterator;

public class BoardGameList {
     LinkedList<BoardGame> gameList;
     private int count;

     public BoardGameList() {
          gameList = new LinkedList<BoardGame>();
          count = 0;
     }

     public boolean isEmpty() {
          return count == 0;
     }

     public void addGame(BoardGame gameToAdd) {
          gameList.add(gameToAdd);
          count++;
     }

     //Takes a 1-based index but removes the item at 0-based position in the linked list
     public boolean removeGame(int index) {
          //do nothing if invalid index
          if (index <= count) {
               gameList.remove(index - 1);
               count--;
               return true;
          }
          return false;
     }

     //Increment games played count of the game at the index given
     public void incrementGamesPlayed(int index) {
          gameList.get(index - 1).incrementTimesPlayed();
     }

     //Returns game list iterator starting at the beginning
     public ListIterator<BoardGame> GameListIterator() {
          return gameList.listIterator(0);
     }
}