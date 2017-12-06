# Exercises

## Search the Array

Complete the code below to search a randomly generated array of numbers for a specific value (provided by the user). Give the user a message with the outcome (found or not, if found at what index was it found).

```java
public static void main(String[] args) {
    Random generator = new Random();
    Scanner console = new Scanner(System.in);

    final int MAX_NUMBERS = 50;
    final int MAX_VALUE = 100;
    int[] randomNumbers = new int[MAX_NUMBERS];

    for (int i = 0; i < MAX_NUMBERS; i++) {
        randomNumbers[i] = generator.nextInt(MAX_VALUE+1);
    }

    System.out.print("Please enter an integer number between 0 and "
            + MAX_VALUE + " to search for : ");
    int number = console.nextInt();

    // Complete the rest of the code
    // - Search the array randomNumbers for value number
    // - Report to the user if found (+ index) or not
}
```

## Sort an

Complete the code below to sort a randomly generated number of integers in ascending order. Search the Internet for "selection sort". You will find enough information and examples. Do no copy / paste code, try to implement it for yourself.

Print the list of numbers before and after the sorting.

```java
public static void main(String[] args) {
    Random generator = new Random();

    final int MAX_NUMBERS = 50;
    final int MAX_VALUE = 100;
    int[] randomNumbers = new int[MAX_NUMBERS];

    for (int i = 0; i < MAX_NUMBERS; i++) {
        randomNumbers[i] = generator.nextInt(MAX_VALUE+1);
    }

    // Print list of numbers before being sorted

    // Sort the numbers in ascending order

    // Print list of numbers after being sorted
}
```
