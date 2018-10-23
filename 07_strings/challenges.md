## Chapter 07 - Strings - Challenges

### Uppercase a String

Create a String variable inside your application and initialize it with `"The quick brown fox jumps over the lazy dog"`. Now output this String to the terminal together with an uppercase version of the String. Check the API of the String class. String objects have a method to do just this.

```text
Normal version: The quick brown fox jumps over the lazy dog
Uppercase version: THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG
```

### Reading the Users Name

Ask the user of your application for his/her name and store this data inside a String variable. Output a personalized message.

For example:

```text
Please supply your full name: Nico De Witte

Oh hello there Nico De Witte. Did you know that the DeLorean DMC-12, the car used in Back to the Future is a sports car manufactured by John DeLorean's DeLorean Motor Company for the American market in 1981–83?

Well I did ...
```

### Reversing a String

Request a single word from the user and reverse it. Make sure to lowercase it first, otherwise it might look weird.

Use a basic for loop for the reversing process. Make use of the `length()` method to get the number of characters in the String.

For example:

```text
Please enter a word to reverse: Banana

The word "banana" reversed is "ananab".
```

### Palindrome

Request a single word from the user and check if it is a palindrome.

> **INFO** - **Palindrome**
>
> A palindrome is a word, number, sentence, or verse that reads the same backward or forward. It derives from the Greek palin dromo, which means "running back again"

Example output:

```text
Please enter a word to check for palindrome: Banana

The word "banana" reversed is "ananab". This is not a palindrome.
```

Another example:

```text
Please enter a word to check for palindrome: Radar

The word "radar" reversed is "radar". This is a palindrome.
```

### Check for Character

Request a single word from the user. This can be accomplished using the `next()` method of `Scanner`.

Now creating the following String variable inside your application:

```java
String vowels = "aeiou";
```

Next select a random vowel from the String. Search the word that was provided by the user and display an appropriate message to the user if the vowel was found inside the string provided by the user.

Example:

```text
Please enter a word to search for random vowel: Banana

I picked the random vowel 'u' and did not find it in "banana".
```

Another example:

```text
Please enter a word to search for random vowel: asparagus

Eurika!! I picked the random vowel 'a' and found it in "asparagus".
```

### Search in a String

Create an application that requests a sentence from the user. Save the sentence in a String variable. Next check if the sentence contains a specific word. You can choose this word yourself. Check the String API for a method that allows you to search in a String.

For example:

```text
Please enter sentence: The quick brown fox jumps over the lazy dog
Searching for the word "cat"
No "cat" found in "The quick brown fox jumps over the lazy dog".
```

Another example:

```text
Please enter sentence: The quick brown cat jumps over the lazy dog
Searching for the word "cat"
Found the word "cat"!
```

### Splitting a String

Create an application that requests a sentence from the user. Now split the sentence into words and print each word on a separate line. There are several ways to do this. Pick one you understand.

Example:

```text
Please enter sentence: The quick brown fox jumps over the lazy dog

Cutting the sentence into words:
The
quick
brown
fox
jumps
over
the
lazy
dog
```