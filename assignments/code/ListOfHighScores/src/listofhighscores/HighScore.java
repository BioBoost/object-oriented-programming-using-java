package listofhighscores;

public class HighScore {
    private String playerName;
    private int score;
    
    public HighScore(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return playerName + ": " + score;
    }
}
