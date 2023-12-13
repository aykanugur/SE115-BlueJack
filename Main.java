import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Random random = new Random();
          GameFunctions gf = new GameFunctions(5);
           Cards[] shuffledCards = gf.startCreateCards();
            Cards[] playerHand =gf.firstStepDeckGenerator(shuffledCards, true);
             Cards[] computerHand = gf.firstStepDeckGenerator(shuffledCards, false);
              boolean whoWon;
               int choice;
        while (true) {
            try {
                gf.startText();
                choice = sc.nextInt();
                 if (choice != 1 && choice != 2) {
                    System.out.println("You entered a value other than 1 or 2. Try again.");
                    continue; 
                }
                break; 
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("You have entered unvalid value. Please enter an integer value.");
                sc.nextLine(); 
            }
        }
        
        if(choice==1) 
            {
              whoWon = play(shuffledCards, playerHand, computerHand,0,0,5,gf.getComputerHandPlayed(),gf.getPlayerHandPlayed());
            if(whoWon)
            {
               System.out.println("");
                System.out.println("User won");
                 choice = 2;
            } 
            else
            {
             System.out.println("");
              System.out.println("PC won");
               choice = 2;
             }
            }
         System.out.println("");
          System.out.println("Thx for playing bluejack made by Aykan Ugur");
           System.out.println("");
           sc.close();
    }
    public static boolean play(Cards[] shuffledCards,Cards[] playerHand,Cards[] computerHand,int playerWins,int computerWins,int totalPlayed,int[] computerHandPlayed,int[]playerHandPlayed ){
        
        
         GameFunctions gf = new GameFunctions(totalPlayed,computerHandPlayed,playerHandPlayed);
          gf.playText(shuffledCards,playerHand,computerHand,true);//start of player turn
        
 
            while ((gf.getstand()||gf.isComputerstand())&&gf.getComputerTotal()<=20&&gf.playerTotal<=20) {            
            if(gf.getstand())// oyuncu
            {
              gf.startTurn();
               gf.playText(shuffledCards,playerHand,computerHand,false);
            
           if(gf.getPlayerTotal()>=20)
             {
                 gf.stand = false;
             }
              totalPlayed= gf.getTotalPlayed();
              playerHandPlayed = gf.getPlayerHandPlayed();
              
            }
            if(gf.isComputerstand())
            {
              gf.startToThink();
               gf.playText(shuffledCards, playerHand, computerHand,true);
              
              if(gf.getComputerTotal()>=20)
             {
                 gf.computerstand= false;
             }

            }
              totalPlayed= gf.getTotalPlayed();
              computerHandPlayed = gf.getComputerHandPlayed();
  
        }
            
            gf.playText(shuffledCards, playerHand, computerHand,true);
           
          if(gf.playerTotal==20&&gf.computerTotal==20)
          {
               System.out.println("");
                System.out.println("TIE");
                 System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
               return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
          }
          else
          {
              if(gf.playerTotal==20)
              {
                   playerWins++;
                    System.out.println("");
                     System.out.println("PLAYER WON THIS ROUND TIME FOR NEXT ROUND");
                      System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
                   if(playerWins==3)
                   {
                       recordGame("USER: ", playerWins, "Computer: ", computerWins);
                       return true;
                   } 
                     int blueCards = 0;
                   for (int i = 0; i < gf.getPlayerTotalPlayed(); i++) {
                     if(blueCards==gf.getPlayerTotalPlayed())
                     {
                         recordGame("USER: ", 3, "COMPUTER: ", computerWins);
                         return true;
                     } 
                      if(gf.playerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
             
              }
              else
              {
                  if(gf.computerTotal==20)
                  {
                     computerWins++;
                      System.out.println("");
                       System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND");
                        System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
                        if(computerWins==3)
                        {
                            recordGame("USER: ", playerWins, "Computer", computerWins);
                             return false;
                        } 
                         int blueCards = 0;
             for (int i = 0; i < gf.getComputerTotalPlayed(); i++) {
                if(blueCards==gf.getComputerTotalPlayed())
                {
                    recordGame("USER: ", playerWins, "COMPUTER: ", 3);
                    return false;
                } 
                 if(gf.computerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
             
                  }
                  else
                  {
                    boolean player1FullBoard = gf.playerTotalPlayed == 9 && gf.getPlayerTotal() <= 20;
                     boolean player2FullBoard = gf.computerTotalPlayed == 9 && gf.getComputerTotal() <= 20;
                   if (player1FullBoard && !player2FullBoard) {
                   // Player 1 has a full board and the score is <= 20
                    playerWins++;
                     System.out.println("");
                      System.out.println("PLAYER WON THIS ROUND TIME FOR NEXT ROUND");
                       System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
                       if(playerWins==3)
                       {
                           recordGame("USER: ", playerWins, "COMPUTER: ", computerWins);
                           return true;
                       } 
                        int blueCards = 0;
                   for (int i = 0; i < gf.getPlayerTotalPlayed(); i++) {
                     if(blueCards==gf.getPlayerTotalPlayed())
                     {
                         recordGame("USER: ", 3, "COMPUTER: ", computerWins);
                         return true;
                     } 
                      if(gf.playerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
             
        }else if (player2FullBoard && !player1FullBoard) {
             // Player 2 has a full board and the score is <= 20
              computerWins++;
               System.out.println("");
                System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND");
                 System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
                 if(computerWins==3)
                 {
                     recordGame("USER: ", playerWins, "COMPUTER: ", computerWins);
                      return false;
                 } 
                  int blueCards = 0;
             for (int i = 0; i < gf.getComputerTotalPlayed(); i++) {
                  if(blueCards==gf.getComputerTotalPlayed())
                  {
                      recordGame("USER: ", playerWins, "COMPUTER: ", 3);
                       return false;
                  } 
                   if(gf.computerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
             
        }if (gf.playerTotal <= 20 && gf.computerTotal <= 20) {
            if (20 - gf.playerTotal < 20 - gf.computerTotal) {
                  // Player 1 is closest to but not over 20
                  playerWins++;
                  System.out.println("");
                   System.out.println("PLAYER WON THIS ROUND TIME FOR NEXT ROUND");
                    System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
                    if(playerWins==3)
                    {
                        recordGame("USER: ", playerWins, "COMPUTER: ", computerWins);
                        return true;
                    } 
                     int blueCards = 0;
             for (int i = 0; i < gf.getPlayerTotalPlayed(); i++) {
                if(blueCards==gf.getPlayerTotalPlayed())
                {
                    recordGame("USER: ", 3, "COMPUTER: ", computerWins);
                    return true;
                } 
                 if(gf.playerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
            }else if (20 - gf.computerTotal < 20 - gf.playerTotal) {
                  // Player 2 is closest to but not over 20
                  
                 computerWins++;
                  System.out.println("");
                   System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND: ");
                    System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
                    if(computerWins==3)
                    {
                        recordGame("USER: ", playerWins, "COMPUTER: ", computerWins);
                        return false;
                    } 
                     int blueCards = 0;
             for (int i = 0; i < gf.getComputerTotalPlayed(); i++) {
                if(blueCards==gf.getComputerTotalPlayed())
                {
                    recordGame("USER: ", playerWins, "COMPUTER: ", 3);
                    return false;
                } 
                 if(gf.computerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
            }
        }if(gf.playerTotal>20&&gf.computerTotal<20)
        {
              computerWins++;
               System.out.println("");
                System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND: ");
                 System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
                 if(computerWins==3)
                 {
                     recordGame("USER: ", playerWins, "COMPUTER: ", computerWins);
                     return false;
                 } 
                  int blueCards = 0;
             for (int i = 0; i < gf.getComputerTotalPlayed(); i++) {
                if(blueCards==gf.getComputerTotalPlayed())
                {
                     recordGame("USER: ", playerWins, "COMPUTER: ", 3);
                     return false;
                } 
                 if(gf.computerBoardCards[i].getCardColor().equals("B")) blueCards++;
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);  
            }
        }
        if(gf.playerTotal<20&&gf.computerTotal>20)
        {
          playerWins++;
           System.out.println("");
            System.out.println("PLAYER WON THIS ROUND TIME FOR NEXT ROUND: ");
             System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
             if(playerWins==3)
             {
                 recordGame("USER: ", playerWins, "COMPUTER: ", computerWins);
                 return true;
             } 
              int blueCards = 0;
             for (int i = 0; i < gf.getPlayerTotalPlayed(); i++) {
                if(blueCards==gf.getPlayerTotalPlayed())
                {
                    recordGame("USER: ", 3, "COMPUTER: ", computerWins);
                    return true;
                } 
                 if(gf.playerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
        } // No winner according to the rules tie
         System.out.println("");
          System.out.println("TIE");
           System.out.println("PLAYER: "+playerWins+" "+"COMPUTER: "+computerWins);
           return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed);
        
                  }
              }
          }
       
          }
    public static void recordGame(String player1, int score1, String player2, int score2) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            String gameResult = player1 + ":" + score1 + " - " + player2 + ":" + score2 + ", " + dateFormat.format(new Date());
            File file = new File("GameLog.text");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader("GameLog.text"));
            String line;
            StringBuilder history = new StringBuilder();
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (count < 20) {
                    history.append(line).append("\n");
                    count++;
                }
            }
            reader.close();
            FileWriter fileWriter = new FileWriter("GameLog.text");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(gameResult + "\n");
            writer.write(history.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
    

