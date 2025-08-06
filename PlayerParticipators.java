class PlayerParticipators{
    int PlayerNum;    //Instance variable

    public int PlayerNumber(int PlayerId){
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + PlayerId + ", enter your guess: ");
        PlayerNum = sc.nextInt();
        return PlayerNum;
    }
} 
