package listofhighscores;

import java.util.ArrayList;

public class ListOfHighScores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating a list to hold highscores
        // Automatically loads highscores.txt if it exists
        HighScoreList scores = new HighScoreList();
        
        // You can clear the scores
        scores.clearAllScores();
        
        // You can add scores
        scores.addHighScore(new HighScore("Marki the Sixth", 2878));
        scores.addHighScore(new HighScore("Mary Polu", 125));
        
        // Negative scores or 0-scores are ignored
        scores.addHighScore(new HighScore("Jane", 0));
        
        // You can save the scores to a file
        scores.saveToFile();
        
        // You can print the scores directly to the screen        
        System.out.println("Scores:");
        System.out.println(scores);
        
        // Or you can get an arraylist of scores and print a custom layout
        // or for example a top 10
        ArrayList<HighScore> scoreList = scores.getHighScores();
        System.out.println("Top 10 scores:");
        int i = 0;
        while (i < scoreList.size() && i < 10) {
            HighScore score = scoreList.get(i);
            System.out.println((i+1) + " => " + score.getPlayerName() + " has a score of " + score.getScore());
            i++;
        }
    }
}
