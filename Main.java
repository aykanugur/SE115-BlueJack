import java.util.Scanner;
import java.util.Random;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        PlayStrings ps = new PlayStrings();
        String[] computerDeck = new String[10];
        String[] playerDeck = new String[10];

            String[][] gameDeck = new String[4][10];
            gameDeck = ps.gamedeckCreator(gameDeck);
            
            String[] shuffledCards = new String[40];
            for (int i = 0; i < 40; i++) {
            
                int color = random.nextInt(4);
                int number = random.nextInt(10);
                
                while (gameDeck[color][number]=="--") {                    
                 color = random.nextInt(4);
                 number = random.nextInt(10);
                }
                
                shuffledCards[i] = gameDeck[color][number];
                gameDeck[color][number] = "--";  
        }
            for (int i = 0; i < 5; i++) {
                playerDeck[i] = shuffledCards[39-i];
                shuffledCards[39-i] = "--";
            }
            for (int i = 0; i < 5; i++) {
                computerDeck[i] = shuffledCards[i];
                shuffledCards[i] = "--";
            }
            playerDeck = ps.secondStepDeckGenerator(playerDeck);
            computerDeck = ps.secondStepDeckGenerator(computerDeck);
            playerDeck = ps.thirdStepDeckGenerator(playerDeck);
            computerDeck = ps.thirdStepDeckGenerator(computerDeck);
            for (int i = 0; i < 10; i++) {
                System.out.println(playerDeck[i]);
        }

        while (true) {
            ps.startText();
            int choice = sc.nextInt();
            if(choice==1) play();
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
    public static void play(){

        PlayStrings ps = new PlayStrings();
        ps.playText();
        
    }
}
