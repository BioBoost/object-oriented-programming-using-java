## The while loop

The while loop is used when the code block may not even run at all if the condition is not met. The condition is checked before the code block is executed.

While every while loop can also be written as a for loop that does not mean it should. Complex for loops can often be refactored into less complex while or do-while loops.

The while loop adheres to the following construction template:

```java
while (condition) {
  // Code block
}
```

The code below prints out a list of random numbers that are dividable by a certain number. In this case it prints 10 numbers that are dividable by 5.

```java

final int DIVIDER = 5;
final int NUMBERS_TO_FIND = 10;
final int MAX_NUMBER = 10000;

Random randomizer = new Random();

int numbersFound = 0;
while (numbersFound <= NUMBERS_TO_FIND) {
  int currentNumber = randomizer.nextInt(MAX_NUMBER);

  if (currentNumber % DIVIDER == 0) {
    System.out.println(currentNumber + " is dividable by " + DIVIDER);
    numbersFound++;
  }
}
```
