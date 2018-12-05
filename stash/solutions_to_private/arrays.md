### Powers of TWo

```java
    int powersOfTwo[] = new int[16];

    System.out.println("Below is a list of the powers of from 0 till 15.");
    powersOfTwo[0] = 1;
    System.out.println("0: " + powersOfTwo[0]);
    for (int i = 1; i < 16; i++) {
      powersOfTwo[i] = powersOfTwo[i-1] * 2;
      System.out.println(i + ": " + powersOfTwo[i]);
    }

```

## Search the Array

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

    int i = 0;
    while(i < MAX_NUMBERS && randomNumbers[i] != number) {
        i++;
    }

    if (i < MAX_NUMBERS) {
        System.out.println("Found " + number + " at index = " + i);
    } else {
        System.out.println("Did not find the number " + number);
    }
}
```