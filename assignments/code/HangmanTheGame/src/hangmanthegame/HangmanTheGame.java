package hangmanthegame;

import java.util.Scanner;

public class HangmanTheGame {
    public static void main(String[] args) {
        printInfoAndRules();
        
        boolean playAgain = true;
        do {
            play();
            playAgain = askUserToPlayAgain();
        } while(playAgain);
    }
    
    private static void play() {
        final int NUMBER_OF_TRIES = 9;
        
        int numberOfCorrectGuesses = 0;
        int numberOfWrongGuesses = 0;
        
        // TODO: Read from file later
        String secret = generateSecretWord();
        
        char[] guessedLetters = createGuessedLetters(secret.length());
        String wronglyGuessedLetters = "";
        
        // Input from user
        boolean gameOver = false;
        do {
            char userGuess = askUserForGuess(wronglyGuessedLetters, guessedLetters);

            // Check user guess
            boolean userMadeCorrectGuess = updateGuessedLetters(secret,
                    userGuess, guessedLetters);

            if (userMadeCorrectGuess) {
                numberOfCorrectGuesses++;
            } else {
                numberOfWrongGuesses++;
                wronglyGuessedLetters += userGuess;
            }

            printProgress(guessedLetters,
                    numberOfCorrectGuesses,
                    numberOfWrongGuesses, NUMBER_OF_TRIES,
                    wronglyGuessedLetters);

            // Win or lose ?
            gameOver = checkForWinOrLose(numberOfWrongGuesses,
                    NUMBER_OF_TRIES, secret, guessedLetters);
            
        } while (!gameOver);
    }

    private static String generateSecretWord() {
        return "hello";
    }

    private static void printInfoAndRules() {
        System.out.println("Hangman is a paper and pencil guessing game for"
                + "two or more players."
                + "One player thinks of a word, phrase or sentence"
                + "and the other tries to guess it by suggesting"
                + "letters or numbers, within a certain number of guesses.");
        System.out.println("This game was made by Nico De Witte");
    }

    private static void printProgress(
            char[] guessedLetters, int numberOfCorrectGuesses,
            int numberOfWrongGuesses, int maxNumberOfTries,
            String wronglyGuessedLetters) {
        
        System.out.println("Your progress: "
                    + String.valueOf(guessedLetters));
        System.out.println("You have "
            + numberOfCorrectGuesses + " correct guesses");
        System.out.println("You however made "
            + numberOfWrongGuesses + " mistakes");
        System.out.println("You have "
            + (maxNumberOfTries-numberOfWrongGuesses)
                + " tries left");
        System.out.println("You have already tried these wrong letters: "
            + wronglyGuessedLetters);
    }

    private static boolean checkForWinOrLose(
            int numberOfWrongGuesses, int maxNumberOfTries,
            String secret, char[] guessedLetters 
    ) {
        if (numberOfWrongGuesses == maxNumberOfTries) {
            System.out.println("LLLoser!");
            System.out.println("The secret word was " + secret);
            return true;
        } else if (secret.equals(String.valueOf(guessedLetters))) {
            System.out.println("You rock!!!");
            return true;
        }
        return false;
    }

    private static char askUserForGuess(String wrongGuesses, char[] correctGuesses) {
        Scanner console = new Scanner(System.in);
        boolean isValid;
        char userGuess;
        do {
            System.out.print("Please guess a letter: ");
            userGuess = console.next().toLowerCase().charAt(0);

            isValid = true;
            if (!(userGuess >= 'a' && userGuess <= 'z')) {
                isValid = false;
                System.out.println("Invalid character");
            } else if (wrongGuesses.indexOf(userGuess) != -1
                    || String.valueOf(correctGuesses).indexOf(userGuess) != -1) {
                isValid = false;
                System.out.println("You have already tried this letter");
            }
        } while(!isValid);
        
        return userGuess;
    }

    private static boolean updateGuessedLetters(String secret, char userGuess,
            char[] guessedLetters) {
        boolean userMadeCorrectGuess = false;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == userGuess) {
                guessedLetters[i] = userGuess;
                userMadeCorrectGuess = true;
            }
        }
        return userMadeCorrectGuess;
    }

    private static char[] createGuessedLetters(int length) {
        char[] guessedLetters = new char[length];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
        return guessedLetters;
    }

    private static boolean askUserToPlayAgain() {
        Scanner console = new Scanner(System.in);
        
        String answer;
        do {
            System.out.print("Would you like to play again [yes/no]: ");
            answer = console.next().toLowerCase();
        } while(!(answer.equals("yes") || answer.equals("no")));

        return answer.equals("yes");
    }
    
}
