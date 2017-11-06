package listofhighscores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighScoreList {
    
    private ArrayList<HighScore> highscores;
    private final static String HIGH_SCORES_FILE = "highscores.txt";
    
    public HighScoreList() {
        highscores = new ArrayList<>();
        loadFromFile();
    }
    
    public void clearAllScores() {
        highscores = new ArrayList<>();
    }
    
    public void addHighScore(HighScore score) {
        if (score.getScore() <= 0) {
            System.out.println("Negative scores or scores == 0 cannot be added to highscores");
            return;
        }
        
        highscores.add(score);
        sortScores();
    }
    
    public ArrayList<HighScore> getHighScores() {
        return highscores;
    }
    
    private void sortScores() {
        Collections.sort(highscores, new Comparator<HighScore>() {
            @Override
            public int compare(HighScore left, HighScore right) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                if (left.getScore() > right.getScore()) {
                    return -1;
                } else if (left.getScore() < right.getScore()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < highscores.size(); i++) {
            output += "[" + (i+1) + "] " + highscores.get(i) + "\n";
        }
        return output;
    }
    
    public void saveToFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(HIGH_SCORES_FILE));
            pw.println(this);
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Failed to write highscores to file: " + ex);
        } finally {
            pw.close();
        }
    }
    
    private void loadFromFile() {
        if (!doesHighscoreFileExist()) {
            return;
        }

        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(HIGH_SCORES_FILE));
            String line = input.readLine();
            while (!line.isEmpty()) {
                addHighScore(parseScore(line));
                line = input.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No highscores file yet. Please save one first");
        } catch (IOException ex) {
            System.out.println("Could not read from highscores file");
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                System.out.println("Could not close the highscores file: " + ex);
            }
        }
    }
    
    private boolean doesHighscoreFileExist() {
        File file = new File(HIGH_SCORES_FILE);
        return file.exists();
    }
    
    private HighScore parseScore(String line) {
        Pattern pattern = Pattern.compile(".*?\\[\\d+\\](.*?):.*?(\\d+).*");

        Matcher matcher = pattern.matcher(line);
        matcher.matches();

        String name = matcher.group(1).trim();
        int score = Integer.parseInt(matcher.group(2));
        return new HighScore(name, score);
    }
}
