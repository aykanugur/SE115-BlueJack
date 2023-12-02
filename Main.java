import java.util.Scanner;
import java.util.Random;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        PlayStrings ps = new PlayStrings();
        String[] computerDeck = new String[10];
        String[] playerDeck = new String[10];
        //0 0 mavi 0 1 2 3 4 5 6 7 8 9
        //1 0 sarı 0
        //2 0 kırmızı 0
        //3 0 yesil 0
            String[][] gameDeck = new String[4][10];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <10 ; j++) {
                    if(i==0) gameDeck[0][j] = "B"+(j+1);
                    if(i==1) gameDeck[1][j] = "Y"+(j+1);
                    if(i==2) gameDeck[2][j] = "R"+(j+1);
                    if(i==3) gameDeck[3][j] = "G"+(j+1);
                }
            }
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
