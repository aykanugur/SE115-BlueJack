import java.util.Scanner;
import java.util.Random;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        GameFunctions gf = new GameFunctions();
        Cards[] shuffledCards = gf.startCreateCards();
        Cards[] playerHand =gf.firstStepDeckGenerator(shuffledCards, true);
        Cards[] computerHand = gf.firstStepDeckGenerator(shuffledCards, false);
        boolean whoWon;
        
        while (true) {
            gf.startText();
            int choice = sc.nextInt();
            if(choice==1) 
            {
            whoWon = play(shuffledCards, playerHand, computerHand,0,0);
            if(whoWon)
            {
                System.out.println("User won");
                choice = 2;
            }else
            {
            System.out.println("PC won");
            choice = 2;
            }
            }
            if(choice==2)
            {
                System.out.println("");
                System.out.println("Thx for playing bluejack made by Aykan Ugur");
                System.out.println("");
                break;
            }else
            {
                System.out.println("");
                System.out.println("pls enter valid number for this section");
                System.out.println("");
            }
        } 
            
        
    }
    public static boolean play(Cards[] shuffledCards,Cards[] playerHand,Cards[] computerHand,int playerWins,int computerWins){
        
        
        GameFunctions gf = new GameFunctions();
        gf.playText(shuffledCards,playerHand,computerHand);//start of player turn
        
 
            while ((gf.getstand()||gf.isComputerstand())&&gf.getComputerTotal()<=20&&gf.playerTotal<=20) {            
            if(gf.getstand())// oyuncu
            {
            gf.startTurn();
            gf.playText(shuffledCards,playerHand,computerHand);
            
           if(gf.getPlayerTotal()>=20)
             {
               //player busted  
                 break;
             }
            }
            if(gf.isComputerstand())
            {
              gf.startToThink();
              
              gf.playText(shuffledCards, playerHand, computerHand);
              
              if(gf.getComputerTotal()>=20)
             {
               //computer busted  
                 break;
             }

            }
  
        }
            
            gf.playText(shuffledCards, playerHand, computerHand);
           
            
            
             // Check if any player has a full board and the sum is less than or equal to 20
        boolean player1FullBoard = gf.playerTotalPlayed == 9 && gf.getPlayerTotal() <= 20;
        boolean player2FullBoard = gf.computerTotalPlayed == 9 && gf.getComputerTotal() <= 20;

        if (player1FullBoard && !player2FullBoard) {
             // Player 1 has a full board and the score is <= 20
             playerWins++;
             System.out.println("PLAYER WON THIS ROUND TIME FOR NEXT ROUND"+playerWins);
             if(playerWins==3) return true;
             int blueCards = 0;
             for (int i = 0; i < gf.getPlayerTotalPlayed()+1; i++) {
                if(blueCards==gf.getPlayerTotalPlayed()) return true;
                if(gf.playerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins);
             
        } else if (player2FullBoard && !player1FullBoard) {
             // Player 2 has a full board and the score is <= 20
             
             computerWins++;
             System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND"+computerWins);
             if(computerWins==3) return false;
             int blueCards = 0;
             for (int i = 0; i < gf.getComputerTotalPlayed()+1; i++) {
                if(blueCards==gf.getComputerTotalPlayed()) return false;
                if(gf.computerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins);
             
        }

        // Both players stood without having a full board or tied scores
        if (gf.playerTotal <= 20 && gf.computerTotal <= 20) {
            if (20 - gf.playerTotal < 20 - gf.computerTotal) {
                  // Player 1 is closest to but not over 20
                  playerWins++;
                  System.out.println("PLAYER WON THIS ROUND TIME FOR NEXT ROUND"+playerWins);
                  if(playerWins==3) return true;
                  int blueCards = 0;
             for (int i = 0; i < gf.getPlayerTotalPlayed()+1; i++) {
                if(blueCards==gf.getPlayerTotalPlayed()) return false;
                if(gf.playerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins);
            } else if (20 - gf.computerTotal < 20 - gf.playerTotal) {
                  // Player 2 is closest to but not over 20
                  
                  computerWins++;
                  System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND"+computerWins);
                  if(computerWins==3) return false;
                  int blueCards = 0;
             for (int i = 0; i < gf.getComputerTotalPlayed()+1; i++) {
                if(blueCards==gf.getComputerTotalPlayed()) return false;
                if(gf.computerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins);
            }
        }

          // No winner according to the rules tie
          System.out.println("TIE");
          return play(shuffledCards, playerHand, computerHand, playerWins, computerWins);
    }
 
      }  
    
    
    
    

