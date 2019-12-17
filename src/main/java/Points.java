public enum Points {

    LOVE(0), THIRTY(30), FIFTHEEN(15),FORTY(40),DEUCES(45);

    private int nbPoints;

    Points(int Points){
        this.nbPoints = Points;
    }

    public int getNbPoints() {
        return nbPoints;
    }


    public String action() {
        switch(this) {
            case LOVE : return "Love-All";
            case THIRTY: return "Thirty-All";
            case FIFTHEEN:return "Fiftheen-All";
            case FORTY: return "Thirty-All";
            case DEUCES: return "Deuces";
            default : return "All";
        }
    }

    public Points getNextPoints() {
        switch(this) {
            case LOVE : return FIFTHEEN;
            case FIFTHEEN: return THIRTY;
            case THIRTY:return FORTY;
            case FORTY: return DEUCES;
            default : return LOVE;
        }
    }

    @Override
    public String toString() {
        return "Points{" +
                "nbPoints=" + this.getNbPoints() +
                '}';
    }

    public static void main (String[] args){
        System.out.println("Hello World");
    }

}
