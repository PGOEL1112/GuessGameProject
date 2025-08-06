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
