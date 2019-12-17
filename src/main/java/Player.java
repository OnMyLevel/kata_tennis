import java.util.Arrays;

public class Player {

   private Points gamePoint;
   private int[] sets;
   private int nbSetWin;
   private int nbGameWin;
   private String namePlayer;

    public String getNamePlayer() {
        return namePlayer;
    }


    public Player(String namePlayer, int nbSet) {
        this.gamePoint = Points.LOVE;
        this.nbGameWin = 0;
        this.nbSetWin = 0;
        this.namePlayer = namePlayer;
        this.sets = new int[nbSet];
    }

    public void newSet(){
        this.gamePoint = Points.LOVE;
        this.nbGameWin = 0;
    }
    public void newGame(){
        this.gamePoint = Points.LOVE;
    }

    @Override
    public String toString() {
        return this.getNamePlayer()+" " +
                "\n Points game: " + this.getGamePoint().getNbPoints() +
                "\n Games wins : " + this.getNbGameWin() +
                "\n All sets: " + Arrays.toString(this.getSets()) +
                "\n Sets wins: " + this.getNbSetWin() +
                " \n";
    }

    public void getGamePoint(int currentSet){
        this.sets[currentSet] = this.sets[currentSet] + 1;
        this.nbGameWin= this.nbGameWin+1;
    }

    public void getSetWin(){
        this.nbSetWin = this.getNbSetWin()+1;
    }

    public Points gamePoints() {
        return gamePoint;
    }

    public void setGamePoint(Points gamePoint) {
        this.gamePoint = gamePoint;
    }

    public int[] getSets() {
        return sets;
    }

    public int getNbSetWin() {
        return nbSetWin;
    }

    public int getNbGameWin() {
        return nbGameWin;
    }


    public Points getGamePoint() {
        return gamePoint;
    }

    public static void main (String[] args){
        System.out.println("Hello World");
    }
}