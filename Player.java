
import java.util.Scanner;


public class Player {
    int turnCounter= 5;
    Cards[] playerBoard = new Cards[9];
    Cards[] playerHand;
    boolean stand = false;
    Scanner sc = new Scanner(System.in);
    Cards[] shuffledCards;
    public Player() {
        
    }
    public Player(Cards[] playerHand,Cards[] shuffledCards) {
        this.playerHand = playerHand;
        this.shuffledCards = shuffledCards;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public Cards[] getPlayerBoard() {
        return playerBoard;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public void setPlayerBoard(Cards[] playerBoard) {
        this.playerBoard = playerBoard;
    }
    
    
    
    
    
}
