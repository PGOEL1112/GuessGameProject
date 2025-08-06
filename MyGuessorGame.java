package GuessGameProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Guesser{
    private int GuesserNum; //Instance variable
    private Scanner sc;

    Guesser(Scanner sc){
        this.sc=sc;
    }

    public int GuesserNumber(){
        do {
            System.out.print("Guesser, enter a number between 0 and 100: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a valid number: ");
                sc.next(); // clear invalid input
            }
            GuesserNum = sc.nextInt();
        } while(GuesserNum<0 || GuesserNum>100);
        return GuesserNum;
    }
}

class PlayerParticipators{
    String name;
    int score = 0;
    private Scanner sc;

    PlayerParticipators(String name, Scanner sc) {
        this.name = name;
        this.sc = sc;
    }
    public int PlayerNumber(){
         int guess;
        do {
            System.out.print(name + ", Enter your guess (0-100): ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a valid number: ");
                sc.next(); // clear invalid input
            }
            guess = sc.nextInt();
        } while (guess < 0 || guess > 100);

        return guess;
    }

    public void increaseScore() {
        score++;
    }
}

class Umpire{
    int Guessernum;
    PlayerParticipators[] players;

    Umpire(PlayerParticipators[] players) {
        this.players = players;
    }

     
    public void CollectNumberFromGuesser(Guesser g){
        Guessernum = g.GuesserNumber();
    }

    public void CollectNumberFromPlayer(){
        for (PlayerParticipators p : players) {
            int playerGuess = p.PlayerNumber();
            if (playerGuess == Guessernum) {
                p.increaseScore();
                System.out.println("✅ " + p.name + " guessed correctly!");
            } else {
                System.out.println("❌ " + p.name + " guessed wrong.");
            }
        }
    }
    public void showScores() {
        System.out.println("\n📊 Current Scores:");
        for (PlayerParticipators p : players) {
            System.out.println(p.name + ": " + p.score + " points");
        }
        System.out.println();
    }

    public void declareFinalWinner() {
        int maxScore = 0;
        for (PlayerParticipators p : players) {
            if (p.score > maxScore) maxScore = p.score;
        }

        List<String> winners = new ArrayList<>();
        for (PlayerParticipators p : players) {
            if (p.score == maxScore) {
                winners.add(p.name);
            }
        }

        if (winners.size() == 1) {
            System.out.println("🏆 Winner of the game is: " + winners.get(0));
        } else {
            System.out.println("🏆 It's a tie between: " + String.join(", ", winners));
        }
    }
}

public class MyGuessorGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<--------------GAME START ------------>  ");
        
        System.out.print("Enter number of rounds you want to play: ");
        int rounds = sc.nextInt();
        sc.nextLine(); // consume newline

        // Get player names
        PlayerParticipators[] players = new PlayerParticipators[3];
        for (int i = 0; i < players.length; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = sc.nextLine();
            players[i] = new PlayerParticipators(name, sc);
        }

        Guesser guesser = new Guesser(sc);
        Umpire up = new Umpire(players);

        for(int r=1; r<=rounds; r++){
            System.out.println("\n Round " + r + " starts...");
            up.CollectNumberFromGuesser(guesser);
            up.CollectNumberFromPlayer();
            up.showScores();
        }

        System.out.println("<--------------- GAME OVER ----------->  ");
        up.declareFinalWinner();
        sc.close();
    } 
}
