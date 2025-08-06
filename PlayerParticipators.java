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
