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
    
        while (true) {
            gf.startText();
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

        
    }
}
