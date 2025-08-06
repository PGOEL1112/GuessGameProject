class Guesser{
    int GuesserNum; //Instance variable

    public int GuesserNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Guesser, Enter your number: ");
        GuesserNum = sc.nextInt();
        return GuesserNum;
    }
}
