package GuessGameProject;
import java.util.Scanner;

class Guesser{
    int GuesserNum; //Instance variable

    public int GuesserNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Guesser, Enter your number: ");
        GuesserNum = sc.nextInt();
        return GuesserNum;
    }
}

class PlayerParticipators{
    int PlayerNum;    //Instance variable

    public int PlayerNumber(int PlayerId){
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + PlayerId + ", enter your guess: ");
        PlayerNum = sc.nextInt();
        return PlayerNum;
    }
} 

class Umpire{
    int Guessernum;
    int Playernum1,Playernum2,Playernum3;
     
    public void CollectNumberFromGuesser(){
        Guesser Gu = new Guesser();
        Guessernum = Gu.GuesserNumber();
    }

    public void CollectNumberFromPlayer(){
        PlayerParticipators Pl = new PlayerParticipators();
        PlayerParticipators P2 = new PlayerParticipators();
        PlayerParticipators P3 = new PlayerParticipators();

        Playernum1 = Pl.PlayerNumber(1);
        Playernum2 = P2.PlayerNumber(2);
        Playernum3 = P3.PlayerNumber(3);
        
    }

    public void CompareTheNumber(){
        boolean p1Correct = (Guessernum==Playernum1);
        boolean p2Correct = (Guessernum==Playernum2);
        boolean p3Correct = (Guessernum==Playernum3);

            if(p1Correct && p2Correct && p3Correct){
                System.out.println("CONGRATULATIONS! ALL THE PLAYERS HAD WON THE GAME..");
            }
            else if(p1Correct && p2Correct){
                System.out.println("CONGRATULATIONS! BOTH PLAYER1 AND PLAYER2 HAD WON THE GAME..");
            }
            else if(p1Correct && p3Correct){
               System.out.println("CONGRATULATIONS! BOTH PLAYER1 AND PLAYER3 HAD WON THE GAME.."); 
            }
            else if(p2Correct && p3Correct){
               System.out.println("CONGRATULATIONS! BOTH PLAYER2 AND PLAYER3 HAD WON THE GAME.."); 
            }
            else if(p1Correct) {
                System.out.println("CONGRATULATIONS! PLAYER1 HAD WON THE GAME..");
            }
            else if(p2Correct) {
                System.out.println("CONGRATULATIONS! PLAYER2 HAD WON THE GAME..");
            }
            else if(p3Correct){
                System.out.println("CONGRATULATIONS! PLAYER3 HAD WON THE GAME..");
            }
            else {
                System.out.println("All players lost. Better luck next time!");
            }
    }
}

public class MyGuessorGame {
    public static void main(String[] args) {
        System.out.println("<--------------GAME START ------------>  ");
        
        Umpire up = new Umpire();
        up.CollectNumberFromGuesser();
        up.CollectNumberFromPlayer();
        up.CompareTheNumber();

        System.out.println("<--------------- GAME OVER ----------->  ");
    } 
}
