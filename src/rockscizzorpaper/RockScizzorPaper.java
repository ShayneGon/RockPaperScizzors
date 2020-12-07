package rockscizzorpaper;
import java.util.*;
public class RockScizzorPaper {
    static int[] matchUp = {0,0,0};
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean play = true;
        int pScore = 0;
        int bScore = 0;
        while (play == true){
            boolean win = false;
            while (win == false){
                matchUp(botChoice(), playerChoice());
                if (matchUp[0] == 1) {
                    pScore++;
                    win = true;
                    System.out.println("You win");
                }else if (matchUp[1] == 1){
                    bScore++;
                    win = true;
                    System.out.println("Bot wins");
                }else{
                    System.out.println("Draw");
                }
                System.out.println("Play again? [YES] or [NO]");
                String ans = input.next();
                if (ans.equalsIgnoreCase("No")){
                    play = false;
                    break;
                }
            }
        }
    }
    public static int botChoice(){
        Random rand = new Random();
        int choice = rand.nextInt(3)+1;
        System.out.println(choice);
        return choice;
    }
    public static int playerChoice(){
        boolean repeat;
        int choice = -1;
        do{
            try{
                System.out.println("Do you choose: Rock[1] Paper[2] Scissor[3]");
                choice = input.nextInt();
                repeat = false;
            }catch(Exception e){
                repeat = true;
                System.out.println("Enter valid choice");
                input.next();
            }
        }while(repeat == true);
        return choice;
    }
    
    public static int[] matchUp(int bChoice, int pChoice){
        
        if (pChoice == bChoice){
            matchUp[2] = 1;
        }else if (pChoice == 1){
            if (bChoice == 2){
                matchUp[1] = 1;
            }else{
                matchUp[0] = 1;
            }
        }else if (pChoice == 2){
            if (bChoice == 3){
                matchUp[1] = 1;
            }else{
                matchUp[0] = 1;
            }
        }else{
            if (bChoice == 1){
                matchUp[1] = 1;
            }else{
                matchUp[0] = 1;
            }
        }
        return matchUp;
    }
}
