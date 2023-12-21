import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
public class Main {
    static boolean isTie = false;
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         Random random = new Random();
         GameFunctions gf = new GameFunctions(5);
         Cards[] shuffledCards = gf.startCreateCards();
         Cards[] playerHand =gf.firstStepDeckGenerator(shuffledCards, true);
         Cards[] computerHand = gf.firstStepDeckGenerator(shuffledCards, false);
         boolean whoWon;
         String user = "";
         int choice;
        while (true) {
            try {
                gf.startText();
                choice = sc.nextInt();
                 if (choice != 1 && choice != 2) {
                    System.out.println("You entered a value other than 1 or 2. Try again.");
                    continue; 
                }
                 if(choice==1)
                 {
                     while (true) {                    
                    try {
                        sc.nextLine();
                        System.out.print("Please enter your name: ");
                         user = sc.nextLine().toUpperCase();
                          break;
                    } catch (Exception e) {
                        System.err.println("Pls enter valid user name");
                    }
                }
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
                
              whoWon = play(shuffledCards, playerHand, computerHand,0,0,5,gf.getComputerHandPlayed(),gf.getPlayerHandPlayed(),user);
            if(whoWon)
            {
               if(isTie)
              {
               System.out.println("");
               System.out.println("GAME IS TIE");
               choice = 2;
              }else
               {
                System.out.println("");
               System.out.println(user+" won");
               choice = 2;
             }
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
    public static boolean play(Cards[] shuffledCards,Cards[] playerHand,Cards[] computerHand,int playerWins,int computerWins,int totalPlayed,int[] computerHandPlayed,int[]playerHandPlayed,String user){
        
        
          GameFunctions gf = new GameFunctions(totalPlayed,computerHandPlayed,playerHandPlayed);
          gf.playText(shuffledCards,playerHand,computerHand,true);//start of player turn
        
 
            while ((gf.getstand()||gf.isComputerstand())&&gf.getComputerTotal()<=20&&gf.playerTotal<=20&&gf.computerTotalPlayed<=9&&gf.playerTotalPlayed<=9) {            
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
            if(totalPlayed==35)
            {
                System.out.println("");
                System.out.println("Game Deck Cards Are Finished");
                System.out.println("");
                if(playerWins==computerWins)
              {
                recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                isTie = true;
                 return true;
                  }else
                 {
                   if(playerWins>computerWins)
                  {
                    recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                     return true;
                  }
                    if(playerWins<computerWins)
                    {
                     recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                      return false;
                       }
                   }
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
             if(totalPlayed==35)
            {
                System.out.println("");
                System.out.println("Game Deck Cards Are Finished");
                System.out.println("");
                if(playerWins==computerWins)
              {
                recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                isTie = false;
                 return true;
                  }else
                 {
                   if(playerWins>computerWins)
                  {
                    recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                     return true;
                  }
                    if(playerWins<computerWins)
                    {
                     recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                      return false;
                       }
                   }
            }
  
        }
            
            gf.playText(shuffledCards, playerHand, computerHand,true);
            
           
          if(gf.playerTotal==20&&gf.computerTotal==20)
          {
             int computerBlueCards = 0;
             int playerBlueCards = 0;
              
              for (int i = 0; i < gf.getPlayerTotalPlayed(); i++) {
                    
                      if(gf.playerBoardCards[i].getCardColor().equals("B")) playerBlueCards++;
                
                }
              for (int i = 0; i < gf.getComputerTotalPlayed(); i++) {
                    
                      if(gf.computerBoardCards[i].getCardColor().equals("B")) computerBlueCards++;
                
            } 
              if(playerBlueCards==gf.getPlayerTotalPlayed()&&computerBlueCards==gf.getComputerTotalPlayed())
              {
            System.out.println("");
            System.out.println("TIE");
            System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
            return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
              }else
              {
              if(playerBlueCards==gf.getPlayerTotalPlayed())
                     {
                         recordGame(user+": ", 3, "COMPUTER: ", computerWins);
                         return true;
                     } 
                    if(computerBlueCards==gf.getComputerTotalPlayed())
                     {
                         recordGame(user+": ", playerWins, "COMPUTER: ", 3);
                         return false;
                     }
              }   
            System.out.println("");
            System.out.println("TIE");
            System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
            return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user); 
          }
          else
          {
              if(gf.playerTotal==20)
              {
                    playerWins++;
                    System.out.println("");
                    System.out.println(user+" WON THIS ROUND TIME FOR NEXT ROUND");
                    System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
                   if(playerWins==3)
                   {
                       recordGame(user+": ", playerWins, "Computer: ", computerWins);
                       return true;
                   } 
                     int blueCards = 0;
                   for (int i = 0; i < gf.getPlayerTotalPlayed(); i++) {
                    
                      if(gf.playerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
                   if(blueCards==gf.getPlayerTotalPlayed())
                     {
                         recordGame(user+": ", 3, "COMPUTER: ", computerWins);
                         return true;
                     } 
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
             
              }
              else
              {
                  if(gf.computerTotal==20)
                  {
                      computerWins++;
                      System.out.println("");
                      System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND");
                      System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
                        if(computerWins==3)
                        {
                            recordGame(user+": ", playerWins, "Computer", computerWins);
                             return false;
                        } 
                         int blueCards = 0;
                   for (int i = 0; i < gf.getComputerTotalPlayed(); i++) {
                    
                      if(gf.computerBoardCards[i].getCardColor().equals("B")) blueCards++;
                
            }
                   if(blueCards==gf.getComputerTotalPlayed())
                     {
                         recordGame(user+": ", playerWins, "COMPUTER: ", 3);
                         return false;
                     } 
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
             
                  }
                  else
                  {
                    boolean player1FullBoard = gf.playerTotalPlayed == 9 && gf.getPlayerTotal() <= 20;
                    boolean player2FullBoard = gf.computerTotalPlayed == 9 && gf.getComputerTotal() <= 20;
                   if (player1FullBoard && !player2FullBoard) {
                   // Player 1 has a full board and the score is <= 20
                     playerWins++;
                     System.out.println("");
                     System.out.println(user+" WON THIS ROUND TIME FOR NEXT ROUND");
                     System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
                       if(playerWins==3)
                       {
                           recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                           return true;
                       } 
                      
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
             
        }else if (player2FullBoard && !player1FullBoard) {
             // Player 2 has a full board and the score is <= 20
               computerWins++;
               System.out.println("");
               System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND");
               System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
                 if(computerWins==3)
                 {
                     recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                      return false;
                 } 
                  
             return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
             
        }if (gf.playerTotal <= 20 && gf.computerTotal <= 20) {
            if (20 - gf.playerTotal < 20 - gf.computerTotal) {
                  // Player 1 is closest to but not over 20
                  playerWins++;
                  System.out.println("");
                  System.out.println(user+" WON THIS ROUND TIME FOR NEXT ROUND");
                  System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
                    if(playerWins==3)
                    {
                        recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                        return true;
                    } 
                     
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
            }else if (20 - gf.computerTotal < 20 - gf.playerTotal) {
                  // Player 2 is closest to but not over 20
                  
                  computerWins++;
                  System.out.println("");
                  System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND: ");
                  System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
                    if(computerWins==3)
                    {
                        recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                        return false;
                    } 
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
            }
        }if(gf.playerTotal>20&&gf.computerTotal<20)
        {
              computerWins++;
              System.out.println("");
              System.out.println("COMPUTER WON THIS ROUND TIME FOR NEXT ROUND: ");
              System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
                 if(computerWins==3)
                 {
                     recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                     return false;
                 } 
                  
        }
        if(gf.playerTotal<20&&gf.computerTotal>20)
        {
           playerWins++;
           System.out.println("");
           System.out.println(user+" WON THIS ROUND TIME FOR NEXT ROUND: ");
           System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
             if(playerWins==3)
             {
                 recordGame(user+": ", playerWins, "COMPUTER: ", computerWins);
                 return true;
             } 
              
                  return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
        } // No winner according to the rules tie
         if(gf.playerTotal==gf.computerTotal)
         {
           System.out.println("");
           System.out.println("TIE");
           System.out.println(user+": "+playerWins+" "+"COMPUTER: "+computerWins);
           
         }
           return play(shuffledCards, playerHand, computerHand, playerWins, computerWins,totalPlayed,computerHandPlayed,playerHandPlayed,user);
        
                  }
              }
          }
       
          }
    public static void recordGame(String player1, int score1, String player2, int score2) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String gameResult = player1 + ":" + score1 + " - " + player2 + ":" + score2 + ", " + dateFormat.format(new Date());
        File file = new File("GameLog.txt");    
        FileWriter fw = null;
        Formatter f = null;
        String[] textArray = null;
        Scanner reader = null;
        String text= "";
        if(file.exists()!=true)
        {
            try {
                file.createNewFile();
            } catch (Exception e) {
                
            }
        }
        
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {                
                
                text += reader.nextLine()+"\n";
                textArray = text.split("\n");
                
            }
        } catch (Exception e) {
            
        } finally {
            reader.close();
        }
        try {
            fw = new FileWriter(file,false);
            f = new Formatter(fw);
            f.format("%s\n", "");
            fw = new FileWriter(file,true);
            f = new Formatter(fw);
            int a = 1;
            f.format("%s\n", gameResult);
            
            if(textArray!=null)
            {
            for (String s : textArray) {
                a++;
                 f.format("%s\n", s);
                 if(a==10) break;
                
             }
            }
           
            fw.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
     }
    

