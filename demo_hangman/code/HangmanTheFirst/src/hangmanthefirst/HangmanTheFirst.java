/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanthefirst;

import java.util.Scanner;

/**
 *
 * @author nicod
 */
public class HangmanTheFirst {

    public static void main(String[] args) {
        // Step 6 - Updating stats (part 1)
        final int MAX_NUMBER_OF_WRONG_GUESSES = 9;
        int numberOfWrongGuesses = 0;
        int numberOfCorrectGuesses = 0;
        
        // Step 1 - Display info to user
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Hello and welcome to Hangman the Sequel");
        System.out.println("Hangman is a word guessing game.");
        System.out.println("The player needs to try to guess the secret word by suggesting letters.");
        System.out.println("The player needs to guess all letters and each miss generates a part of the gallow.");
        System.out.println("This continues until the player wins the game or the gallow is completed and the player loses.");
        System.out.println("In this version you have 9 wrong guessed before you lose the game.");
        System.out.println("Good luck and have fun");
        System.out.println("-----------------------------------------------------------------------------------------------\n\n");
        
        // Step 2 - The secret
        // TODO: Select a random word instead of a literal
        String secretWord = "hello";
        System.out.println("We are searching for a word with "
            + secretWord.length() + " letters");
        
        // Part 3 - Creating an array of guesses letters and placing underscores in the beginning
        char[] guessedLetters = new char[secretWord.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
        
        // TODO: Remove print when finished
        //System.out.println("Guessed letters: " + guessedLetters);
        System.out.println("Guessed letters: " + String.valueOf(guessedLetters));
                
        // Step 4 - Asking user for input
        Scanner console = new Scanner(System.in);
                
        boolean gameOver = false;
        do {
            // Making sure we get lower case letter and only a single letter
            char userGuess;
            do {
                System.out.print("Please enter your guess (single letter): ");
                userGuess = console.next().toLowerCase().charAt(0);
            } while (!(userGuess >= 'a' && userGuess <= 'z'));
            
            // Step 5 - Check if guess is correct
            boolean correctGuess = false;
            for (int i = 0; i < guessedLetters.length; i++) {
                if (secretWord.charAt(i) == userGuess) {
                    correctGuess = true;
                    guessedLetters[i] = userGuess;      // Update guessed letters
                }
            }

            // Step 6 - Updating stats (part 2)
            if (correctGuess) {
                System.out.println("Correct guess. Nice!");
                numberOfCorrectGuesses++;
            } else {
                System.out.println("Incorrect guess.");
                numberOfWrongGuesses++;
            }

            // Step 7 - Displaying stats
            // Here we should make the mistake of just concatinating the guessedLetters
            System.out.println("\nYour current progress: " + String.valueOf(guessedLetters));
            System.out.println("You made " + numberOfCorrectGuesses + " correct guesses.");
            System.out.println("You did however make " + numberOfWrongGuesses + " mistakes.");
            System.out.println("This leaves you with " + (MAX_NUMBER_OF_WRONG_GUESSES-numberOfWrongGuesses)
                    + " guesses left before you are hung.\n");
            
            // Step 8 - Won or lost?
            // Cannot just compare numberOfCorrectGuesses to number of guessed letters because of double letters
            // Solution 1: Check if guessedLetters contains '_'? OK, maybe
            // Solution 2: Compare secretWord to guessedLetters? More logical so this one
            if (secretWord.equals(String.valueOf(guessedLetters))) {
                System.out.println("\nCongratz! You won the guessing game.");
                gameOver = true;
            } else if (numberOfWrongGuesses == MAX_NUMBER_OF_WRONG_GUESSES) {
                System.out.println("\nSorry, you failed to guess the word '" + secretWord + "'");
                gameOver = true;
            }
        } while (!gameOver);


        // This code has a bug:
        // - You can enter the same letter over and over again (stats update)
        
        // Our boss want an extension to this. Asking the user to play again.
        // - This will lead to not such nice code (the while thing has to be put into another loop
        // - Show a list of the wrong letters already tried
    }
    
}
