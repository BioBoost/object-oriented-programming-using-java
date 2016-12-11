## Code Duplication

<!-- toc -->

### Introduction

One of the first code smells that are created by each beginning programmer is code duplication. Sometimes we write code at different times and just forget we already did it once. Or we are working together with someone else and we both created very similar code. Other times we are lazy and copy-past parts of code to get the problem solved quicker.

But is it quicker ? Maybe at the time of copy-pasting that code, yes. But in the end it will always cost you more then it will earn you. Because duplication will bite you in the ass when one of its parts needs to change or if it contains a bug.

### Fix by Extraction

Some code duplication in can be easily solved by extracting the duplicated part and placing it in a method. The method can then be called from the places where the code was originally situated.

Let's take a look at an example:

```java
public class Snake {
    private static final int START_LENGTH = 10;
    private static final int INITIAL_LIVES = 3;
    private static final int MAX_LENGTH = 120;
    private SnakeSegment[] segments;
    private int currentLength;
    private int lives;
    private int score;

    public Snake() {
        lives = INITIAL_LIVES;
        segments = new SnakeSegment[MAX_LENGTH];
        for (int i = 0; i < START_LENGTH; i++) {
            segments[i] = new SnakeSegment();
        }
        currentLength = START_LENGTH;
        score = 0;
    }

    // ...

    public void respawn() {
        lives--;
        segments = new SnakeSegment[MAX_LENGTH];
        for (int i = 0; i < START_LENGTH; i++) {
            segments[i] = new SnakeSegment();
        }
        currentLength = START_LENGTH;
    }
}
```

Both the `constructor` and the `respawn` method of the `Snake` have duplicate code. By extracting the assignment of the `segments` array, the for-loop and the assignment of the `currentlength` to a separate (`private` in this case) method, we can remove the code duplication and make our code smell nicer.

Solution:

```java
public class Snake {
    private static final int START_LENGTH = 10;
    private static final int INITIAL_LIVES = 3;
    private static final int MAX_LENGTH = 120;
    private SnakeSegment[] segments;
    private int currentLength;
    private int lives;
    private int score;

    public Snake() {
        lives = INITIAL_LIVES;
        resetToStartLength();
        score = 0;
    }

    // ...

    public void respawn() {
        lives--;
        resetToStartLength();
    }

    private void resetToStartLength() {
        segments = new SnakeSegment[MAX_LENGTH];
        for (int i = 0; i < START_LENGTH; i++) {
            segments[i] = new SnakeSegment();
        }
        currentLength = START_LENGTH;
    }
}
```

While the code did not get smaller in this case (exactly the same number of lines actually) it did get cleaner and more readable, more maintainable and less stinky.
