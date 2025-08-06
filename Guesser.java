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

