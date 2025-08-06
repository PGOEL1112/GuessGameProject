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
