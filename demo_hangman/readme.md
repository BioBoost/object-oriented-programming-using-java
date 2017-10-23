<!-- toc -->

# Creating a Simple Hangman Game
https://en.wikipedia.org/wiki/Hangman_(game)
It is a good idea to build a bigger application or game to really apply all the knowledge that you gained so far. This section will help you create a simple version of the Hangman game.

> Hangman is a paper and pencil guessing game for two or more players. One player thinks of a word, phrase or sentence and the other tries to guess it by suggesting letters or numbers, within a certain number of guesses.
>
> Source: https://en.wikipedia.org/wiki/Hangman_(game)

An example game of Hangman in progress is shown in the image below. The underlined letters appear in the word in their correct places, while the crossed-out letters do not appear, and each crossed-out letter corresponds to one part of the drawing. In this case, the secret word is "hangman".

![Hangman game in progress](img/Hangman_game.jpg)

A graphical representation will be hard for us to build. However we could just show a textual progress bar or something similar or just a counter that display the number of tries remaining.

## Defining the minimum requirements

* Select a random word from a list (words should be between 5 and 8 letters)
* Allow the user to guess for letters
* Display the number of tries and the number of guesses left
* Initial display of word as underscores, replacing the letters guessed by the user
* Show a list of letters not part of the word but tried by the user

Example of output

```text
Word: h e _ _ o

Wrong letters: x, y, q, d, a

You have made 8 guesses, 5 of which were wrong. You have 4 wrong guesses left.
```

## Building it step by step

Let us create the game step by step and improve the code as we advance. In the first phase we will build the game using the single main method. In a second phase we will refactor this code so it makes use of some custom methods. In a third phase we will extend the game with some extra's.

This application will also try to build upon the logic of keeping methods small and easy to understand. As we advance through this chapter the use of methods should become more clear and you should start to feel when to create separate methods for certain pieces of code.

Methods are mainly created for two reasons:
1. To make your code more clear and understandable
2. To allow the code inside the method to be reused by different parts of your application

## Basic flow chart

A flowchart is a type of diagram that represents an algorithm, workflow or process, showing the steps as boxes of various kinds, and their order by connecting them with arrows. This diagrammatic representation illustrates a solution model to a given problem. Flowcharts are used in analyzing, designing, documenting or managing a process or program in various fields.

While you do need to know the shapes to create a flowchart, it is not a requirement to be able to understand one. This is a mayor advantage. It is also user often between developers to explain certain algorithms or flows inside software.

### Symbols

The American National Symbols Institute (ANSI) set standards for flowcharts and their symbols in the 1960s. The International Organizations for Standardization (ISO) adopted the ANSI symbols in 1970. The current standard was revised in 1985. Generally, flowcharts flow from top to bottom and left to right.

| Symbol | Name | Description |
| --- | --- | --- |
| ![](img/Flowchart_Line.svg.png) | Flowline (Arrowhead) | Shows the program's order of operation. A line coming from one symbol and ending at another. Arrowheads are added if the flow is not the standard top-to-bottom, left-to right. |
| ![](img/Flowchart_Terminal.svg.png) | Terminal | Beginning or ending of a program or sub-process. Represented as a stadium, oval or rounded (fillet) rectangle. They usually contain the word "Start" or "End", or another phrase signaling the start or end of a process, such as "submit inquiry" or "receive product". |
| ![](img/Flowchart_Process.svg.png) | Process | Set of operations that change value, form, or location of data. Represented as a rectangle. |
| ![](img/Flowchart_Decision.svg.png) | Decision | Conditional operation determining which of two paths the program will take. The operation is commonly a yes/no question or true/false test. Represented as a diamond (rhombus). |
| ![](img/Flowchart_IO.svg.png) | Input/Output | Input and output of data, as in entering data or displaying results. Represented as a parallelogram. |
| ![](img/Flowchart_Annotation.svg.png) | Annotation (Comment) | Additional information about a step the program. Represented as an open rectangle with a dashed or solid line connecting it to the corresponding symbol in the flowchart. |
| ![](img/Flowchart_Predefined_Process.svg.png) | Predefined Process | Named process which is defined elsewhere. Represented as a rectangle with double-struck vertical edges. |
| ![](img/Flowchart_Connector.svg.png) | On-page Connector | Pairs of labeled connectors replace long or confusing lines on a flowchart page. Represented by a small circle with a letter inside. |
| ![](img/50px-Off_page_connector.png) | Off-page Connector | A labeled connector for use when the target is on another page. Represented as a home plate-shaped pentagon. |

## Phase 1 - Hangman the First (single main method)

A possible flowchart is shown below. This can be a lead on how to start with building the game. it is however not written in stone and may change as we progress through the development of this application.

![Hangman the First - Possible flowchart](img/flowchart_hangman_the_first.png)

In this first phase we will create hangman the game without creating our own methods. In the next phase we will refactor our code to make use of some methods. This will make our code more readable and more maintainable.

### Step 1 - Displaying information and rules

A simple start for this application could be the displaying the information that the user needs to know. Always give the user enough information to use your application. Inform him/her about the rules and information it expects. This code it not hard, it's just some a lot of print statements.

```java
public class HangmanTheFirst {
    public static void main(String[] args) {
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
    }
}
```

### Step 2 - The secret word to guess

Next to implement is the word that the player has to guess. This should be a randomly selected word from a list of words (an array of Strings). Ideally this list is read from a file. However to start of it is better to keep it simple. To store the word, a variable of type String can be used. For the moment a pre-defined word like `hello` can be used until the guessing logic has been implemented.

Next we also show the user how many letters the secret word contains. This can be achieved my calling the method `length()` of the `secretWord` String.

It is also a good idea to add some print statements to test if your application is behaving as it should. Of course once the application is finished some of these print statements need to be removed. Especially in the case of a game you do not wish to display the solution at the start of the game.

```java
public class HangmanTheFirst {
    public static void main(String[] args) {
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
    }
}
```

Note how we added a `TODO` comment to our code to state that some implementation is still missing here. These `TODO` comments are supported by many IDE's these days and can often be displayed as a task list. In NetBeans you can open a list of TODO's by selecting `Window => Action Items`. This will open a list of all TODO's and will also allow you to double click them to jump to the correct part in your code.

![TODO List in NetBeans](img/todos_netbeans.png)

### Step 3 - Tracking Guessed Letters

Next a representation of the letters that the user has already guessed is needed. This information can be stored in a variable of type `String` or as an array of characters. The easiest solution is to store the letters in an array of characters. This way we can easily change them later on. It should contain the same number of characters as the word that needs to be guessed. This is an indication to the user how many letters the secret word contains. It should also be initialized to for example all underscores `_`, where each underscore corresponds to a letter that has not yet been guessed. This can be achieved using a for-loop that uses the `length()` method of the `secretWord` string. The `length()` method of a string returns how many characters the String contains.

Again a print statement is added to view the result. You can add a `TODO` to indicate that this print statement should be deleted later on.

```java
public class HangmanTheFirst {
    public static void main(String[] args) {
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
        System.out.println("Guessed letters: " + guessedLetters);
    }
}
```

However something goes wrong when we execute this code.

```text
-----------------------------------------------------------------------------------------------
Hello and welcome to Hangman the Sequel
Hangman is a word guessing game.
The player needs to try to guess the secret word by suggesting letters.
The player needs to guess all letters and each miss generates a part of the gallow.
This continues until the player wins the game or the gallow is completed and the player loses.
In this version you have 9 wrong guessed before you lose the game.
Good luck and have fun
-----------------------------------------------------------------------------------------------


We are searching for a word with 5 letters
Guessed letters: [C@15db9742
Please enter your guess (single letter):
```

The guessed letters are printed as a cryptic String. This is not the content of the array. Actually when we concatenate objects with a `String`, the `toString()` method of that object is called. The `toString()` method for an Object returns a string consisting of the name of the class of which the object is an instance, the at-sign character `@`, and the unsigned hexadecimal representation of the hash code of the object.

To display the actual content of an array of characters we can use the following line of code:

```java
String.valueOf(guessedLetters);
```

So the code of this third step would change to the following:

```java
        // Part 3 - Creating an array of guesses letters and placing underscores in the beginning
        char[] guessedLetters = new char[secretWord.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        // TODO: Remove print when finished
        System.out.println("Guessed letters: " + String.valueOf(guessedLetters));
```

This resolves to the output we were looking for.

### Step 4 - Asking the User for Input

Next is user input. The user needs to supply his/her guess. Once retrieved from the terminal, the game needs to check if the guess of the user is a letter that is part of the secret word. If so the all the occurrences of that letter need to be placed in the `guessedLetters` variable. If the user his/her guess is incorrect, we need to make this clear to the user.

To read a letter from the terminal a `Scanner` can be used. The `next()` method supplies the next token/word entered by the user. To make sure the letter is lowercased we can also call the method `toLowerCase()`. Special about these methods is that they all return the resulting String. This means that one method can be called after another. This is called **method chaining** and we will come back to this later.

However the result is a `String`, while we actually need a single character (type `char`), even while the String only contains a single letter it is still a String. To fix this the last method we call is the `charAt()` method that will return the character at the specified index. So by passing the value `0` to the `charAt()` method, we get the first character of the String.

This results in the following piece of code:

```java
// Step 4 - Asking user for input
Scanner console = new Scanner(System.in);

System.out.print("Please enter your guess (single letter): ");
char userGuess = console.next().toLowerCase().charAt(0);
```

While this is a valid starting option, we should add some more safety rules to make sure the user enters a letter of the alphabet and not a number of some exotic symbol. Validating user input is often done using a do-while loop as shown in the following code:

```java
// Making sure we get lower case letter and only a single letter
char userGuess;
do {
    System.out.print("Please enter your guess (single letter): ");
    userGuess = console.next().toLowerCase().charAt(0);
} while (!(userGuess >= 'a' && userGuess <= 'z'));
```

Notice how the variable `userGuess` needs to be declared outside the loop as we will need it later on outside the loop. The loop terminates when the user enters a character of the alphabet. This can actually be evaluated by checking if the input character is bigger than or equal to `'a'` and smaller than or equal to `'z'`.

```java
public class HangmanTheFirst {
    public static void main(String[] args) {
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
        System.out.println("Guessed letters: " + String.valueOf(guessedLetters));

        // Step 4 - Asking user for input
        Scanner console = new Scanner(System.in);

        // Making sure we get lower case letter and only a single letter
        char userGuess;
        do {
            System.out.print("Please enter your guess (single letter): ");
            userGuess = console.next().toLowerCase().charAt(0);
        } while (!(userGuess >= 'a' && userGuess <= 'z'));
    }
}
```

### Step 5 - Checking if User Guessed correct

To check if the letter the user supplied is part of the secret word, a for-loop can be used to check all the letters of the secret word (by calling the `charAt()` method with the value of the iteration variable `i` of the for-loop). If a match is found, the corresponding underscore of the `guessedLetters` should be replaced by the actual letter.

For example:
```text
We are searching for a word with 5 letters
Guessed letters: _____
Please enter your guess (single letter): e

Your current progress: _e___
```

```java
// Step 5 - Check if guess is correct
for (int i = 0; i < guessedLetters.length; i++) {
    if (secretWord.charAt(i) == userGuess) {
        guessedLetters[i] = userGuess;      // Update guessed letters
    }
}
```

While we did replace all the occurrences of the guessed letter of the user, if any, at the end of the for-loop we do not have an actual result stating if the user guessed a correct letter or not. Later we need to be able to change the stats/progress of the game based on the fact if the user made a correct or incorrect guess. This can be achieved by creating a variable of type `boolean` in which we place the value `false` if the user made an incorrect guess or `true` when he/she made a correct guess. Since we need this variable later on we do need to declare it outside of the for-loop.

```java
// Step 5 - Check if guess is correct
boolean correctGuess = false;
for (int i = 0; i < guessedLetters.length; i++) {
    if (secretWord.charAt(i) == userGuess) {
        correctGuess = true;
        guessedLetters[i] = userGuess;      // Update guessed letters
    }
}
```

The easiest solution is to initialize the variable to `false` and set it to `true` when a letter is guessed correctly. If no letter is correct, then the variable stays `false`.

We can also output some message to the user based on the value of the `correctGuess` variable. This leads to the following code:

```java
public class HangmanTheFirst {
    public static void main(String[] args) {
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
        System.out.println("Guessed letters: " + String.valueOf(guessedLetters));

        // Step 4 - Asking user for input
        Scanner console = new Scanner(System.in);

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

        if (correctGuess) {
            System.out.println("Correct guess. Nice!");
        } else {
            System.out.println("Incorrect guess.");
        }
    }
}
```

Running the game we get the following output:

```text
We are searching for a word with 5 letters
Guessed letters: _____
Please enter your guess (single letter): l
Correct guess. Nice!
```

Or with a wrong guess:

```text
We are searching for a word with 5 letters
Guessed letters: _____
Please enter your guess (single letter): x
Incorrect guess.
```

### Step 6 - Updating Stats and Progress

The next logical step would be to keep asking the user for guesses. However for this we need to keep track of some things such as the number of guesses the user has made, the number of wrong guesses, the letters that he/she guessed but are incorrect.

To keep track of the number wrong and correct guesses two variables are needed of type `int`. Both need to be initialized to `0`. So:

```java
int numberOfWrongGuesses = 0;
int numberOfCorrectGuesses = 0;
```

In the hangman game the player loses if he/she makes 9 wrong guesses. So we also need to implement the maximum number of wrong guesses the user has before he/she loses the game. This can be achieved using a constant value (indicated by the `final` keyword) as shown in the code below. This already makes sure we don't have magic numbers in our code.

```java
// Step 6 - Updating stats (part 1)
final int MAX_NUMBER_OF_WRONG_GUESSES = 9;
int numberOfWrongGuesses = 0;
int numberOfCorrectGuesses = 0;
```

This code can be placed at the top of our main method.

These stats can already be updated by adding some code to the if-else construct we implemented in the previous step. When the user makes a correct guess we increment `numberOfCorrectGuesses` and if he/she makes an incorrect guess we increment `numberOfWrongGuesses`.

Or in code:

```java
// Step 6 - Updating stats (part 2)
if (correctGuess) {
    System.out.println("Correct guess. Nice!");
    numberOfCorrectGuesses++;
} else {
    System.out.println("Incorrect guess.");
    numberOfWrongGuesses++;
}
```

### Step 7 - Displaying stats and progress

Now let's create some code that displays a nice print to the terminal each time the player makes a guess. We need to display the following information to the user:
* His/Her current correctly guessed letters, which can be found in the variable `guessedLetters`. Remember we need to use the `valueOf` method of `String` to get a string with the content of the character array.
* The number of wrong guesses he/she made: `numberOfWrongGuesses`
* The number of correct guesses he/she made: `numberOfCorrectGuesses`
* The number of tries he/she has left before losing the game. This needs to be calculated using the formula `MAX_NUMBER_OF_WRONG_GUESSES - numberOfWrongGuesses`. You will need to add parentheses around this mathematical operation because otherwise Java will think you want to subtract a string representation of `numberOfWrongGuesses` from the rest of the string already build. By adding parentheses Java will first determine the result of the math operation and then convert it to a string.

A possible implementation to display this information is:

```java
// Step 7 - Displaying stats
// Here we should make the mistake of just concatinating the guessedLetters
System.out.println("\nYour current progress: " + String.valueOf(guessedLetters));
System.out.println("You made " + numberOfCorrectGuesses + " correct guesses.");
System.out.println("You did however make " + numberOfWrongGuesses + " mistakes.");
System.out.println("This leaves you with " + (MAX_NUMBER_OF_WRONG_GUESSES-numberOfWrongGuesses)
        + " guesses left before you are hung.\n");
```

Our full code now looks like this:

```java
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
        System.out.println("Guessed letters: " + String.valueOf(guessedLetters));

        // Step 4 - Asking user for input
        Scanner console = new Scanner(System.in);

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
    }
}
```

Try out the code and make sure it works as it should.

### Step 8 - Winning or Losing

Next we should cehck if the user won or lost the game. Once this is determined we can also easily keep asking the user for more letters based on that outcome.

To determine if the user won the game we cannot just check if `numberOfCorrectGuesses == secretWord.length()` because this would be incorrect if the secret word contained double letters like for example the letter 'l' in the word "hello". There are two other solutions:
* We could check if the `guessedLetters` arrays still contains underscores. If not, the user has found all the letters.
* We could just compare the string `secretWord` with `String.valueOf(guessedLetters)`.

The last solution is actually the most logical and the most readable. Do take note that we cannot use the comparison operator `==` to compare the content of two strings. For this we need to use a method `equals()` of the strings as shown below.

To check if the user lost the game we just need to check if `numberOfWrongGuesses` equals `MAX_NUMBER_OF_WRONG_GUESSES`. In that case the user used up all his/her guesses and the game should end.

```java
// .......

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
} else if (numberOfWrongGuesses == MAX_NUMBER_OF_WRONG_GUESSES) {
    System.out.println("\nSorry, you failed to guess the word '" + secretWord + "'");
}
```

### Step 9 - Looping the game

It is a pretty useless guessing game if you can only guess for a single letter. To allow the user to make multiple guesses, we need to add a loop construct around most of the code we have created so far.

The condition for the loop has actually become quite simple. The only thing we need to do is check if the game was won or lost and if neither we need to continue playing. So in other words we can use the previous if-else construct to populate a variable 'gameOver' of type `boolean` and keep looping while the game is not over.

Important to note is that we need to create the variable outside of the loop. This because we need it inside the loop-condition. It should also be initialized to `false`. This way we can use the if-else construct to set it to `true` in both cases (won or lost), while it keeps it's false value as long as neither of those two conditions has been met.

```java
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
}
```

If all went well this should be a basic working version of the game.

```text
...
Please enter your guess (single letter): l
Correct guess. Nice!

Your current progress: __ll_
You made 1 correct guesses.
You did however make 2 mistakes.
This leaves you with 7 guesses left before you are hung.
...
```

### Bugs and Extensions

You may or may not have noticed but there is actually a bug in the game. The player can enter the same letter over and over again. This should not be possible.

There are however some improvements that should also be added to the game:
* Ask the player to play again when finished. With the current code we need to add another loop level in the hierarchy which leads to more complicated code.
* The game should also show a list of wrong letters that have already been tried by the user.

## Phase 2 - Refactoring using Methods

While we could keep working with the current code, it is not a good idea to do so. The code is becoming to long and it will become a mess. Extending it will also become harder as we advance.

The best option here is not add any functionality to the current state but change it until it is more maintainable. This is called **refactoring**.

Basically our goals is to make our main method as small as possible.

### Step 1 - Refactor info and rules to a method

The simplest step we can take in the refactor process is to put the print statements of the rules and welcome message into a method. This method will not take any arguments and does not need to return anything for the moment.

The method could be named `displayInfoAndRules`:

```java
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
```

Next replace the actual code in the main with a call to the new method:

```java
// ......

// Step 6 - Updating stats (part 1)
final int MAX_NUMBER_OF_WRONG_GUESSES = 9;
int numberOfWrongGuesses = 0;
int numberOfCorrectGuesses = 0;

// Step 1 - Display info to user
displayInfoAndRules();

// Step 2 - The secret
// TODO: Select a random word instead of a literal
String secretWord = "hello";
System.out.println("We are searching for a word with "
    + secretWord.length() + " letters");

  // ......
```

Test your app and make sure that everything still works.

### Step 2 - Initialize Guessed Letters

The initialization process of the guessed letters array can also be extracted to its own method. It will however require some basic information such as the length of the secret. This method can then return a ready to use char array.

```java
public static char[] createGuessedLetters(int lengthOfSecret) {
    char[] guessedLetters = new char[lengthOfSecret];
    for (int i = 0; i < guessedLetters.length; i++) {
        guessedLetters[i] = '_';
    }
    return guessedLetters;
}
```

Why take the length of the secret word and not the secret word itself? While it would not have been wrong to take the secret word itself, it is actually more information than the `createGuessedLetters` method needs. Basically, you need to consider which solutions you have to solve your problem and take the most logical one. Its a skill you will train as you advance in your programming career.

Do not forget to set the return type of the method to `char[]` and add a return statement after the for-loop. This way the method will create an array, initialize it and return it to the main method where the method is being called.

To actually make the call we need three things:
* the name of the method, which is `createGuessedLetters`
* the length of the secret word as an argument for the method, which is `secretWord.length()`
* a variable to store the result in that the method return, which is a variable of type `char[]`.

This leads to the following method call:

```java
// Part 3 - Creating an array of guesses letters and placing underscores in the beginning
char[] guessedLetters = createGuessedLetters(secretWord.length());
```

### Step 3 - Asking the User for a Guess

Next we can refactor the for-loop that requests a guess from the user to its own method. This method actually needs no outside information and should only return a single character. It does need the `Scanner` but no other code uses it, so we can actually also place it inside the method.

```java
public static char askUserForGuess() {
    Scanner console = new Scanner(System.in);

    // Making sure we get lower case letter and only a single letter
    char userGuess;
    do {
        System.out.print("Please enter your guess (single letter): ");
        userGuess = console.next().toLowerCase().charAt(0);
    } while (!(userGuess >= 'a' && userGuess <= 'z'));
    return userGuess;
}
```

The result of this method needs to be stored inside a local variable in the main method, where the method is called. We need it later on.

```java
// ....

boolean gameOver = false;
do {
    // Making sure we get lower case letter and only a single letter
    char userGuess = askUserForGuess();

    // Step 5 - Check if guess is correct
    boolean correctGuess = false;
    for (int i = 0; i < guessedLetters.length; i++) {
        if (secretWord.charAt(i) == userGuess) {
            correctGuess = true;
            guessedLetters[i] = userGuess;      // Update guessed letters
        }
    }
// ....
}
```

### Step 4 - Updating the Guessed Letters

Next the for-loop that updates the `guessedLetters` array and determines if the user made a correct guess can be extracted. It does require some outside information which needs to be passed to the method via arguments, namely: `secretWord`, `userGuess` and `guessedLetters`. The return value of the method can be if the guess was correct or not, so a `boolean` value.

```java
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
```

To call the method you need to store the result and pass the needed arguments:

```java
// Step 5 - Check if guess is correct
boolean correctGuess = updateGuessedLetters(secretWord, guessedLetters, userGuess);
```

### Step 5 - Displaying the stats

Next we can also extract the print statements of the different stats. The stats can be passed as arguments and the method does not need to return anything.

```java
public static void displayStats(int numberOfWrongGuesses, int numberOfCorrectGuesses, char[] guessedLetters, int maxGuesses) {
    // Here we should make the mistake of just concatinating the guessedLetters
    System.out.println("\nYour current progress: " + String.valueOf(guessedLetters));
    System.out.println("You made " + numberOfCorrectGuesses + " correct guesses.");
    System.out.println("You did however make " + numberOfWrongGuesses + " mistakes.");
    System.out.println("This leaves you with " + (maxGuesses-numberOfWrongGuesses)
            + " guesses left before you are hung.\n");
}
```

Note that the name of the `MAX_NUMBER_OF_WRONG_GUESSES` has been changed to `maxGuesses`. This is however local to the method.

Calling the method has to be done as shown below:

```java
// Step 7 - Displaying stats
displayStats(numberOfWrongGuesses, numberOfCorrectGuesses, guessedLetters, MAX_NUMBER_OF_WRONG_GUESSES);
```

### Step 6 - Won or Lost

The if-construct that checks if the game is over can also be placed inside its own method. The result of the method is a `boolean` that represents if the game is over or not. It does need some information that should be passed via arguments.

```java
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
```

Calling the method from main:

```java
// Step 8 - Won or lost?
gameOver = isGameOver(secretWord, guessedLetters, numberOfWrongGuesses, MAX_NUMBER_OF_WRONG_GUESSES);
```

### Step 7 - Create Secret

Later on we would like to replace the literal String `"hello"` with a randomly selected word from a file or words. Because of this it would be a good idea to create a method `generateSecret()` which returns a String that can be stored in the `secretWord` variable. This way if we want to change the actual selection of the secret we just need to change the implementation of that method. For the moment we just return `"hello"` from the method.

```java
public static String generateSecret() {
    // TODO: Select a random word instead of a literal
    return "hello";
}
```

Also move the TODO to the method implementation instead of the call. In main we call it using:

```java
// Step 2 - The secret
String secretWord = generateSecret();
System.out.println("We are searching for a word with "
    + secretWord.length() + " letters");
```

### Step 8 - A play method

Last but not least we could actually extract most of the code from the main by creating a method called `play()` that contains the game loop. We could actually just leave a call to the `displayInfoAndRules()` method and a call to the `play()` method as shown below:

```java
    public static void main(String[] args) {
        // Step 1 - Display info to user
        displayInfoAndRules();

        // Play the game
        play();
    }
```

Notice that even the stats can be moved to the play method.

```java
public static void play() {
    // Step 6 - Updating stats (part 1)
    final int MAX_NUMBER_OF_WRONG_GUESSES = 9;
    int numberOfWrongGuesses = 0;
    int numberOfCorrectGuesses = 0;

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
        char userGuess = askUserForGuess();

        // Step 5 - Check if guess is correct
        boolean correctGuess = updateGuessedLetters(secretWord, guessedLetters, userGuess);

        // Step 6 - Updating stats (part 2)
        if (correctGuess) {
            System.out.println("Correct guess. Nice!");
            numberOfCorrectGuesses++;
        } else {
            System.out.println("Incorrect guess.");
            numberOfWrongGuesses++;
        }

        // Step 7 - Displaying stats
        displayStats(numberOfWrongGuesses, numberOfCorrectGuesses, guessedLetters, MAX_NUMBER_OF_WRONG_GUESSES);

        // Step 8 - Won or lost?
        gameOver = isGameOver(secretWord, guessedLetters, numberOfWrongGuesses, MAX_NUMBER_OF_WRONG_GUESSES);
    } while (!gameOver);
}
```

### Final Result

There are also some print statements that can be removed from our code. We have tagged them using TODO comments so they are easy to identify.

This leads to our second version of the hangman game. It should be clear by now that while the code got a bit longer, it should also be a bit more understandable.

```java
public class HangmanTheSecond {

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
            char userGuess = askUserForGuess();

            // Step 5 - Check if guess is correct
            boolean correctGuess = updateGuessedLetters(secretWord, guessedLetters, userGuess);

            // Step 6 - Updating stats (part 2)
            if (correctGuess) {
                System.out.println("Correct guess. Nice!");
                numberOfCorrectGuesses++;
            } else {
                System.out.println("Incorrect guess.");
                numberOfWrongGuesses++;
            }

            // Step 7 - Displaying stats
            displayStats(numberOfWrongGuesses, numberOfCorrectGuesses, guessedLetters, MAX_NUMBER_OF_WRONG_GUESSES);

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

    public static char askUserForGuess() {
        Scanner console = new Scanner(System.in);
        char userGuess;
        do {
            System.out.print("Please enter your guess (single letter): ");
            userGuess = console.next().toLowerCase().charAt(0);
        } while (!(userGuess >= 'a' && userGuess <= 'z'));
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

    public static void displayStats(int numberOfWrongGuesses, int numberOfCorrectGuesses, char[] guessedLetters, int maxGuesses) {
        // Here we should make the mistake of just concatinating the guessedLetters
        System.out.println("\nYour current progress: " + String.valueOf(guessedLetters));
        System.out.println("You made " + numberOfCorrectGuesses + " correct guesses.");
        System.out.println("You did however make " + numberOfWrongGuesses + " mistakes.");
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
```

## Phase 3 - Bug Fixes and Extensions

### Step 1 - Bug Fix of already tried letters

To fix the bug where the user cannot input letters he/she has already tried we need to keep track of the letters that the user already tried. The letters the user has already tried that were correct are already stored in the variable `guessedLetters`. So we need to create a variable to store the letters that were not correct, for example in a `String` called `wrongLettersTried`.

This can be placed inside the `play()` method:

```java
// Step 6 - Updating stats (part 1)
final int MAX_NUMBER_OF_WRONG_GUESSES = 9;
int numberOfWrongGuesses = 0;
int numberOfCorrectGuesses = 0;

// Remember the tried letters
String wrongLettersTried = "";
```

When a user guesses a wrong letter, we just append it at the back of the String. We can do this in the if-construct that updates the stats:

```java
// Step 6 - Updating stats (part 2)
if (correctGuess) {
    System.out.println("Correct guess. Nice!");
    numberOfCorrectGuesses++;
} else {
    System.out.println("Incorrect guess.");
    numberOfWrongGuesses++;
    wrongLettersTried += userGuess;
}
```

As a help to the user we should also print the letters he/she already tried. This can be done inside the `displayStats()` method. For this we do need to pass the `wrongLettersTried` to the method. Of course an argument of type String needs to be added to the method.

```java
public static void displayStats(int numberOfWrongGuesses, int numberOfCorrectGuesses, char[] guessedLetters, int maxGuesses, String wrongLettersTried) {
    // Here we should make the mistake of just concatinating the guessedLetters
    System.out.println("\nYour current progress: " + String.valueOf(guessedLetters));
    System.out.println("You made " + numberOfCorrectGuesses + " correct guesses.");
    System.out.println("You did however make " + numberOfWrongGuesses + " mistakes.");
    System.out.println("Tried characters that are incorrect: " + wrongLettersTried);
    System.out.println("This leaves you with " + (maxGuesses-numberOfWrongGuesses)
            + " guesses left before you are hung.\n");
}
```

Changing the call to the method as shown below:

```java
// Step 7 - Displaying stats
displayStats(numberOfWrongGuesses, numberOfCorrectGuesses, guessedLetters, MAX_NUMBER_OF_WRONG_GUESSES, wrongLettersTried);
```

Last we need to take the letters that user tried into account. This can be done inside the `askUserForGuess()` method. Again we need to change the method a bit to take the `wrongLettersTried` and `guessedLetters` as arguments.

To check if a string contains a certain letter we could create a for-loop construct that checks each letter of the string. An easier approach is to use the method `indexOf()` of String that return the index of a substring inside a string. If it is not found, the methods returns `-1`.

It's best to create a boolean `isValidLetter` that contains `true` of the letter is valid or `false` if it is invalid. The value of that `boolean` can be used as condition for the do-while loop.

```java
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
```

While the method did get a bit more complex, we did get more feedback to the user.
