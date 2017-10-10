<!-- toc -->

# Creating a Simple Hangman Game
https://en.wikipedia.org/wiki/Hangman_(game)
It is a good idea to build a bigger application or game to really apply all the knowledge that you gained so far. This section will help you create a simple version of the Hangman game.

> Hangman is a paper and pencil guessing game for two or more players. One player thinks of a word, phrase or sentence and the other tries to guess it by suggesting letters or numbers, within a certain number of guesses.
>
> Source: https://en.wikipedia.org/wiki/Hangman_(game)

An example game of Hangman in progress is shown in the image below. The underlined letters appear in the word in their correct places, while the crossed-out letters do not appear, and each crossed-out letter corresponds to one part of the drawing. In this case, the secret word is "hangman".

![Hangman game in progress[^1]](img/Hangman_game.jpg)
[^1]: Source: https://en.wikipedia.org/wiki/Hangman_(game)

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

Let us create the game step by step and improve the code as we advance.

This application will also try to build upon the logic of keeping methods small and easy to understand. As we advance through this chapter the use of methods should become more clear and you should start to feel when to create separate methods for certain pieces of code.

Methods are mainly created for two reasons:
1. To make your code more clear and understandable
2. To allow the code inside the method to be reused by different parts of your application

### Step 1 - The secret word

A starting point for this application could be the word that the player has to guess. This should be a randomly selected word from a list of words (an array of Strings). Ideally this list is read from a file. However to start of it is better to keep it simple. To store the word, a variable of type String can be used. For the moment a pre-defined word like `hello` can be used until the guessing logic has been implemented. While one could just use the code `String secretWord = 'hello';`, it would be better to create a method that returns the randomly selected String (which is for the moment just the string `"hello"`). Later on the implementation of this method can easily be changed, while the rest of the application can be left unchanged.

It is also a good idea to add some print statements to test if your application is behaving as it should. Of course once the application is finished some of these print statements need to be removed. Especially in the case of a game you do not wish to display the solution at the start of the game.

```java
public class HangmanTheGame {

    public static String selectRandomWord() {
        return "hello";
    }

    public static void main(String[] args) {
        String secretWord = selectRandomWord();

        System.out.println("Secret Word: " + secretWord);
    }
}
```

Notice how the method `selectRandomWord()` is used to create a String for the main method where the result is then saved in a String variable.

### Step 2 - The guessed letters

Next a representation of the letters that the user has already guessed is needed. This information can be stored in a variable of type `String`, which can for example be called `guessedLetters`. It should contain the same number of characters as the word that needs to be guessed. This is an indication to the user how many letters the secret word contains. It should also be initialized to for example all underscores `_`, where each underscore corresponds to a letter that has not yet been guessed. This can be achieved using a for-loop that uses the `length()` method of the `secretWord` string. The `length()` method of a string returns how many characters the String contains.

Again a print statement is added to view the result.

```java
public class HangmanTheGame {

    public static String selectRandomWord() {
        return "hello";
    }

    public static void main(String[] args) {
        String secretWord = selectRandomWord();

        String guessedLetters = "";
        for (int i = 0; i < secretWord.length(); i++) {
            guessedLetters += "_";
        }

        System.out.println("Secret Word: " + secretWord);
        System.out.println("Guessed Letters: " + guessedLetters);
    }
}
```

One of our goals is to keep our methods as short as possible (in a sensible way of course) and to make sure our code stays understandable. A good idea here would be to create a method that generates the `guessedLetters` String and returns the result. Important to see here is that the method requires knowledge of the `secretWord` or actually to be more exact, its length needs to be known. This means the `initializeGuessedLetters()` methods will need to take an argument of type `int`, namely the length of the secret word.

```java
public class HangmanTheGame {

    public static String selectRandomWord() {
        return "hello";
    }

    public static String initializeGuessedLetters(int lengthOfSecretWord) {
        String guessedLetters = "";
        for (int i = 0; i < lengthOfSecretWord; i++) {
            guessedLetters += "_";
        }
        return guessedLetters;
    }

    public static void main(String[] args) {
        String secretWord = selectRandomWord();        
        String guessedLetters = initializeGuessedLetters(secretWord.length());

        System.out.println("Secret Word: " + secretWord);
        System.out.println("Guessed Letters: " + guessedLetters);
    }
}
```

Notice how the length of the secret word is passed to the `initializeGuessedLetters()` method. No variable is first created; the result of `length()` is directly passed as a value to the `initializeGuessedLetters()` method.

While the code actually became longer, it did also become more easy to read. If you got this code from someone and had to try to understand what is happening it would take you less time than when no methods would have been used. This only works when your methods have clear names that tell exactly what that method does.

Note that we first implemented the logic inside the main method and later created a separate method for it. This also happens a lot in real-life. Even advanced programmers don't always create methods immediately. Often they are the result of code that already works and is then refactored (changed without adding more functionality).

### Step 3 - User Input

Next is user input. The user needs to supply his/her guess. Once retrieved from the terminal, the game needs to check if the guess of the user is a letter that is part of the secret word. If so the all the occurrences of that letter need to be placed in the `guessedLetters` variable. If the user his/her guess is incorrect, we need to make this clear to the user.

To read a letter from the terminal a `Scanner` can be used. The `next()` method supplies the next token/word entered by the user. To make sure the letter is lowercased we can also call the method `toLowerCase()`. Special about these methods is that they all return the resulting String. This means that one method can be called after another. This is called method chaining and we will come back to this later.

However the result is a String, while we actually need a single character (type `char`), even while the String only contains a single letter it is still a String. To fix this the last method we call is the `charAt()` method that will return the character at the specified index. So by passing the value `0` to the `charAt()` method, we get the first character of the String.

This results in the following piece of code:

```java
Scanner console = new Scanner(System.in);

System.out.print("Please supply a letter as a guess: ");
char userGuess = console.next().toLowerCase().charAt(0);
```

To check if the letter the user supplied is part of the secret word, a for-loop can be used to check all the letters of the secret word (by calling the `charAt()` method with the value of iteration variable `i` of the for-loop). If a match is found, the corresponding underscore of the `guessedLetters` should be replaced by the actual letter.

For example:
```text
secretWord:     hello
guessedLetters: _____

User guess: e

secretWord:     hello
guessedLetters: _e___
```

Replacing a single letter of String is not that straight forward, at least not based on its index. The most simple method is to use a method called `subString()` with the following description (source: [https://docs.oracle.com/javase/7/docs/api/java/lang/String.html](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)):

```text
public String substring(int beginIndex, int endIndex)
  Returns a new string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.

Examples:
 "hamburger".substring(4, 8) returns "urge"
 "smiles".substring(1, 5) returns "mile"

Parameters:
  beginIndex - the beginning index, inclusive.
  endIndex - the ending index, exclusive.
Returns:
  the specified substring.
```

Very important to notice is that the `beginIndex` is **inclusive** and the `endIndex` is **exclusive**.

In other words to replace the underscore at index `i`, we need to take the substring before it, concatenate it with the letter that needs to be revealed, and also concatenate that with the substring after that index.

The first part can be selected by supplying the following arguments to the substring:
* `0` as `beginIndex`
* `i` as `endIndex`, as this is exclusive

The second part is the actual letter that the user guessed.

The third part can be selected by supplying the following arguments to the substring:
* `i+1` as `beginIndex`
* `guessedLetters.length()` as `endIndex`, as this is exclusive

However there is an exception that needs to be taken into consideration. What if the first underscore needs to be replaced, then there is no substring on the left of it to take into account. The same can be said about the last underscore. If the user guesses that letter, only the substring to the left of it needs to be taken into account.

All of this could result in the following code:

```java
for (int i = 0; i < guessedLetters.length(); i++) {
    if (secretWord.charAt(i) == userGuess) {

        if (i == 0) {
            guessedLetters = userGuess + guessedLetters.substring(i+1, guessedLetters.length());
        } else if (i == guessedLetters.length()) {
            guessedLetters = guessedLetters.substring(0, i) + userGuess;
        } else {
            guessedLetters = guessedLetters.substring(0, i) + userGuess
                    + guessedLetters.substring(i+1, guessedLetters.length());
        }

    }
}
```

Not the most beautiful code that was ever written. It would actually contain less duplication if we made use of temporary variable of type String that represents the new value of the `guessedLetters`. Then we would be able to reform the if-else statements and concatenate the necessary parts. This would lead to the code shown below with less duplication:

```java
for (int i = 0; i < secretWord.length(); i++) {
    if (secretWord.charAt(i) == userGuess) {
        String newGuessedLetters = "";

        if (i != 0) {
            newGuessedLetters += guessedLetters.substring(0, i);
        }

        newGuessedLetters += userGuess;

        if (i != guessedLetters.length()) {
            newGuessedLetters += guessedLetters.substring(i+1, guessedLetters.length());
        }            

        guessedLetters = newGuessedLetters;
    }
}
```

Placing this code and the code to retrieve the input from the user into our main method, would result in the code shown below. To check if everything is working as expected it is also a good idea to add a print statement of the `guessedLetters` after the for-loop. This allows us to experiment a bit and see the result of our coding efforts.

```java
public class HangmanTheGame {

    public static String selectRandomWord() {
        return "hello";
    }

    public static String initializeGuessedLetters(int lengthOfSecretWord) {
        String guessedLetters = "";
        for (int i = 0; i < lengthOfSecretWord; i++) {
            guessedLetters += "_";
        }
        return guessedLetters;
    }

    public static void main(String[] args) {
        String secretWord = selectRandomWord();        
        String guessedLetters = initializeGuessedLetters(secretWord.length());

        System.out.println("Secret Word: " + secretWord);
        System.out.println("Guessed Letters: " + guessedLetters);

        Scanner console = new Scanner(System.in);

        System.out.print("Please supply a letter as a guess: ");
        char userGuess = console.next().toLowerCase().charAt(0);

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == userGuess) {
                String newGuessedLetters = "";

                if (i != 0) {
                    newGuessedLetters += guessedLetters.substring(0, i);
                }

                newGuessedLetters += userGuess;

                if (i != guessedLetters.length()) {
                    newGuessedLetters += guessedLetters.substring(i+1, guessedLetters.length());
                }            

                guessedLetters = newGuessedLetters;
            }
        }

        System.out.println("Guessed Letters: " + guessedLetters);
    }
}
```

Let us refactor this again. The code to retrieve a letter as a guess from the user can again be placed in a separate method. Let us call it `getGuessFromUser()` which has a return type of `char`.

```java
public class HangmanTheGame {

    public static String selectRandomWord() {
        return "hello";
    }

    public static String initializeGuessedLetters(int lengthOfSecretWord) {
        String guessedLetters = "";
        for (int i = 0; i < lengthOfSecretWord; i++) {
            guessedLetters += "_";
        }
        return guessedLetters;
    }

    public static char getGuessFromUser() {
        Scanner console = new Scanner(System.in);

        System.out.print("Please supply a letter as a guess: ");
        return console.next().toLowerCase().charAt(0);
    }

    public static void main(String[] args) {
        String secretWord = selectRandomWord();        
        String guessedLetters = initializeGuessedLetters(secretWord.length());

        System.out.println("Secret Word: " + secretWord);
        System.out.println("Guessed Letters: " + guessedLetters);

        char userGuess = getGuessFromUser();

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == userGuess) {
                String newGuessedLetters = "";

                if (i != 0) {
                    newGuessedLetters += guessedLetters.substring(0, i);
                }

                newGuessedLetters += userGuess;

                if (i != guessedLetters.length()) {
                    newGuessedLetters += guessedLetters.substring(i+1, guessedLetters.length());
                }            

                guessedLetters = newGuessedLetters;
            }
        }

        System.out.println("Guessed Letters: " + guessedLetters);
    }
}
```

The for-loop is harder to extract because it actually accesses multiple variables (`secretWord`, `guessedLetters` and `userGuess`). However the replacement of a letter of the `guessedLetters` String can be easily extracted. This will actually make the main code a lot easier to understand. So let us start by making a method of that. For this we need a couple of pieces of information:
* the `guessedLetters` String which is actually the original string with the underscores still inside
* the index of the letter to replace in the original string
* the letter that needs to be placed inside the new string at the position of index

This would lead to this method:
```java
    public static String replaceCharacterInString(String original, int index, char letter) {
        String newString = "";

        if (index != 0) {
            newString += original.substring(0, index);
        }

        newString += letter;

        if (index != original.length()) {
            newString += original.substring(index+1, original.length());
        }            

        return newString;
    }
```

Notice that the names of the arguments have been chosen to make more sense in a general way. The names of the arguments have no influence on the names of the variables inside the main code. It does however imply that we also had to change the names inside the actual code of the `replaceCharacterInString()` method. This method might actually be useful in another place later on. Who knows.

Of course the main code also has to be changed to make use of our new method:

```java
public static void main(String[] args) {
    String secretWord = selectRandomWord();        
    String guessedLetters = initializeGuessedLetters(secretWord.length());

    System.out.println("Secret Word: " + secretWord);
    System.out.println("Guessed Letters: " + guessedLetters);

    char userGuess = getGuessFromUser();

    for (int i = 0; i < secretWord.length(); i++) {
        if (secretWord.charAt(i) == userGuess) {
            guessedLetters = replaceCharacterInString(guessedLetters, i, userGuess);
        }
    }

    System.out.println("Guessed Letters: " + guessedLetters);
}
```

Did that main just became a lot more readable or what?
