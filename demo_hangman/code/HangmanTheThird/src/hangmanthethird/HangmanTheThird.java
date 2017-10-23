/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanthethird;

import java.util.Scanner;

/**
 *
 * @author nicod
 */
public class HangmanTheThird {

    public static void main(String[] args) {
        // Step 1 - Display info to user
        displayInfoAndRules();

        // Play the game
        play();
    }
    
    public static void play() {
        // Step 6 - Updating stats (part 1)
        final int MAX_NUMBER_OF_WRONG_GUESSES = 9;
        int numberOfWrongGuesses = 0;
        int numberOfCorrectGuesses = 0;
        
        // Remember the tried letters
        String wrongLettersTried = "";
        
        // Step 2 - The secret
        String secretWord = generateSecret();
        System.out.println("We are searching for a word with "
            + secretWord.length() + " letters");

        // Part 3 - Creating an array of guesses letters and placing underscores in the beginning
        char[] guessedLetters = createGuessedLetters(secretWord.length());

        // TODO: Remove print when finished
        //System.out.println("Guessed letters: " + guessedLetters);
        System.out.println("Guessed letters: " + String.valueOf(guessedLetters));
                
        boolean gameOver = false;
        do {
            // Making sure we get lower case letter and only a single letter
            char userGuess = askUserForGuess(wrongLettersTried, guessedLetters);
            
            // Step 5 - Check if guess is correct
            boolean correctGuess = updateGuessedLetters(secretWord, guessedLetters, userGuess);

            // Step 6 - Updating stats (part 2)
            if (correctGuess) {
                System.out.println("Correct guess. Nice!");
                numberOfCorrectGuesses++;
            } else {
                System.out.println("Incorrect guess.");
                numberOfWrongGuesses++;
                wrongLettersTried += userGuess;
            }

            // Step 7 - Displaying stats
            displayStats(numberOfWrongGuesses, numberOfCorrectGuesses, guessedLetters, MAX_NUMBER_OF_WRONG_GUESSES, wrongLettersTried);
            
            // Step 8 - Won or lost?
            gameOver = isGameOver(secretWord, guessedLetters, numberOfWrongGuesses, MAX_NUMBER_OF_WRONG_GUESSES);
        } while (!gameOver);
    }

    public static void displayInfoAndRules() {
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Hello and welcome to Hangman the Sequel");
        System.out.println("Hangman is a word guessing game.");
        System.out.println("The player needs to try to guess the secret word by suggesting letters.");
        System.out.println("The player needs to guess all letters and each miss generates a part of the gallow.");
        System.out.println("This continues until the player wins the game or the gallow is completed and the player loses.");
        System.out.println("In this version you have 9 wrong guessed before you lose the game.");
        System.out.println("Good luck and have fun");
        System.out.println("-----------------------------------------------------------------------------------------------\n\n");
    }
    
    public static String generateSecret() {
        // TODO: Select a random word instead of a literal
        return "hello";
    }
    
    public static char[] createGuessedLetters(int lengthOfSecret) {
        char[] guessedLetters = new char[lengthOfSecret];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
        return guessedLetters;
    }
    
    public static char askUserForGuess(String wrongLettersTried, char[] guessedLetters) {
        Scanner console = new Scanner(System.in);
        char userGuess;
        boolean isValidLetter;
        do {
            System.out.print("Please enter your guess (single letter): ");
            userGuess = console.next().toLowerCase().charAt(0);
            isValidLetter = true;
            if (!(userGuess >= 'a' && userGuess <= 'z')) {
                isValidLetter = false;
                System.out.println("Invalid character. Please specify letter between a and z");
            } else if (wrongLettersTried.indexOf(userGuess) >= 0
                    || String.valueOf(guessedLetters).indexOf(userGuess) >= 0) {
                isValidLetter = false;
                System.out.println("You have already tried that letter");
            }
                
        } while (!isValidLetter);
        return userGuess;
    }
    
    public static boolean updateGuessedLetters(String secretWord, char[] guessedLetters, char userGuess) {
        boolean correctGuess = false;
        for (int i = 0; i < guessedLetters.length; i++) {
            if (secretWord.charAt(i) == userGuess) {
                correctGuess = true;
                guessedLetters[i] = userGuess;      // Update guessed letters
            }
        }
        return correctGuess;
    }
    
    public static void displayStats(int numberOfWrongGuesses, int numberOfCorrectGuesses, char[] guessedLetters, int maxGuesses, String wrongLettersTried) {
        // Here we should make the mistake of just concatinating the guessedLetters
        System.out.println("\nYour current progress: " + String.valueOf(guessedLetters));
        System.out.println("You made " + numberOfCorrectGuesses + " correct guesses.");
        System.out.println("You did however make " + numberOfWrongGuesses + " mistakes.");
        System.out.println("Tried characters that are incorrect: " + wrongLettersTried);
        System.out.println("This leaves you with " + (maxGuesses-numberOfWrongGuesses)
                + " guesses left before you are hung.\n");
    }
    
    public static boolean isGameOver(String secret, char[] guessedLetters, int numberOfWrongGuesses, int maxGuesses) {
        if (secret.equals(String.valueOf(guessedLetters))) {
            System.out.println("\nCongratz! You won the guessing game.");
            return true;
        } else if (numberOfWrongGuesses == maxGuesses) {
            System.out.println("\nSorry, you failed to guess the word '" + secret + "'");
            return true;
        }
        return false;
    }
}
