package gamelogic;

public class Player {
    private String nickname;
    private int points = 0;
    
    public Player(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Player " + nickname + " has " + points + " points.";
    }
}
