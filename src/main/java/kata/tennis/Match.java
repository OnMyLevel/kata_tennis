import kata.tennis.Player;

import java.util.Random;

public class Match {

    private Player playerOne;
    private Player playerTwo;
    private int currentSet;
    private int nbBallPlay;

    @Override
    public String toString() {
        return "\nInfo Match :" +
                "\n" +
                "Ball plays: "+ this.nbBallPlay+
                "\nNumber of the Set: "+ (this.getCurrentSet()+1)+
                "\n " + this.getPlayerOne() +
                "\n " + this.getPlayerTwo() +
                '\n';
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }


    public Match(int nbSet, String playerOne, String playerTwo) {
        this.playerOne = new Player(playerOne,nbSet);
        this.playerTwo = new Player(playerTwo,nbSet);
        this.nbBallPlay = 0;
    }

    public void getPoint(){
        /* faire jouer automatiquement */
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(1 - 0 + 1) + 0;

        switch (nombreAleatoire){
            case 0:
                System.out.println(this.getPlayerOne().getNamePlayer()+" win the point "+this.playerOne.gamePoints().getNbPoints());
                this.playerOne.setGamePoint(this.playerOne.gamePoints().getNextPoints());
                System.out.println(" "+this.playerOne.gamePoints().action()+".");
                if(this.playerOne.gamePoints().getNbPoints()==Points.FORTY.getNbPoints()
                        && this.playerTwo.gamePoints().getNbPoints() < Points.FORTY.getNbPoints()) {
                    System.out.println("And win the game ! ");
                    this.playerOne.getGamePoint(this.currentSet);
                    this.playerOne.newGame();
                    this.playerTwo.newGame();
                }
                else if (this.playerOne.gamePoints()==Points.DEUCES){
                    if(this.playerTwo.gamePoints()==Points.DEUCES){
                        this.playerOne.setGamePoint(Points.FORTY);
                        this.playerTwo.setGamePoint(Points.FORTY);
                    }else{
                        System.out.println("And win the game ! ");
                        this.playerOne.getGamePoint(this.currentSet);
                        this.playerOne.newGame();
                        this.playerTwo.newGame();
                    }
                }
                if(this.playerOne.getNbGameWin()> 6 ) {
                    this.changementSet();
                    this.playerOne.getSetWin();
                }
                else if (this.playerTwo.getNbGameWin()> 6 ){
                    this.changementSet();
                    this.playerTwo.getSetWin();
                }
                this.nbBallPlay ++;
                break;
            case 1:
                System.out.println(this.getPlayerTwo().getNamePlayer()+" win the point ");
                this.playerTwo.setGamePoint(this.playerTwo.gamePoints().getNextPoints());
                System.out.println(this.playerTwo.gamePoints().action()+".");
                if(this.playerTwo.gamePoints().getNbPoints()==Points.FORTY.getNbPoints()
                        && this.playerOne.gamePoints().getNbPoints() < Points.FORTY.getNbPoints()) {
                    System.out.println("And win the game ! ");
                    this.playerTwo.getGamePoint(this.currentSet);
                    this.playerTwo.newGame();
                    this.playerOne.newGame();
                }
                else if(this.playerTwo.gamePoints()==Points.DEUCES){
                    if(this.playerOne.gamePoints()==Points.DEUCES){
                        this.playerOne.setGamePoint(Points.FORTY);
                        this.playerTwo.setGamePoint(Points.FORTY);
                    }else{
                        System.out.println("And win the game ! ");
                        this.playerTwo.getGamePoint(this.currentSet);
                        this.playerTwo.newGame();
                        this.playerOne.newGame();
                    }
                }
                if(this.playerOne.getNbGameWin()> 6 ) {
                    this.changementSet();
                    this.playerOne.getSetWin();
                }
                else if (this.playerTwo.getNbGameWin()> 6 ){
                    this.changementSet();
                    this.playerTwo.getSetWin();
                }
                this.nbBallPlay ++;
                break;
        }

    }

    public void changementSet(){
        this.playerTwo.newSet();
        this.playerOne.newSet();
        this.currentSet = this.currentSet+1;
    }

    public Player winSet(){

        if(this.playerOne.getNbGameWin() > 5
                && this.playerOne.getNbSetWin()- this.playerTwo.getNbSetWin() >= 2 ){
            this.changementSet();
            this.playerOne.getSetWin();
            return this.playerOne;

        }else if(this.playerTwo.getNbGameWin() > 5
                && this.playerTwo.getNbGameWin() - this.playerOne.getNbGameWin() >= 2 ){
            this.changementSet();
            this.playerTwo.getSetWin();
            return this.playerTwo;
        }
        else{
            return null;
        }
    }

    public Player winMatch(){
       if(this.playerOne.getNbSetWin() >= 2 ){
           return playerOne;
       }else if(this.playerTwo.getNbSetWin() >= 2 ){
            return playerTwo;
       }
       else{
           return null;
       }
    }

    public void playMatch(){
        System.out.println("Start");
        Player winnerPlayer=null;
        while (winnerPlayer==null){
            while (this.winSet()==null){
                this.getPoint();
                System.out.println(this.toString());
            }
            winnerPlayer=this.winMatch();
        }
        System.out.println("Full-Time");
        System.out.println("Winner is : ");
        System.out.println(winnerPlayer);
    }

    public int getCurrentSet() {
        return currentSet;
    }


    public static void main (String[] args){
        System.out.println("Hello World");
        Match match = new Match(7,"P1","P2");
        match.playMatch();
    }
}
