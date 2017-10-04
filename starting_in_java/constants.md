<!-- toc -->

## Constant values

Constants are variables that cannot be changed once they have been assigned a value. To declare a variable as constant you will need to place the `final` keyword before the type and assign the variable a value as shown in the following examples.

```java
final int NUMBER_OF_VALUES = 100;
final double PI_APPROXIMATION = 3.14159265;
```

There are two things you need to note in the example above:
* The keyword `final` which states that the variable is a constant and cannot be changed after it has been assigned a value.
* The **capital letters** of the variable name. This is common in almost all programming languages. Variables that are constant should have a name with only capital letters and underscores to separate the words.

Their use is strongly encouraged to remove the use of what are called **magic numbers**. Magic numbers are literal values (ex. 10, 125, 13.2, ...) that are used in your code. Their meaning may seem obvious in the beginning but their clearness decreases as time passes. They are also dangerous in use as code changes. It is very easy to forget to change all the occurrences of the value that need to change. On top of that you may change an occurrence of the magic number to many.

The perfect example is the code from the previous section. Take a good look at it. What would have to change to make the program read 10 numbers from the user?

```java
Scanner console = new Scanner(System.in);
int[] numbers = new int[5];
int i = 0;
int sum = 0;

do {
    System.out.print("Please enter an integer number: ");
    int number = console.nextInt();
    numbers[i] = number;
    sum += number;
    i++;
} while (i < 5);

System.out.println("\n\nYou entered the following numbers:");
for (i = 0; i < 5; i++) {
    System.out.print(numbers[i] + " ");
}
System.out.println("\nTotal sum = " + sum + " Average = " + sum/5);
```

There are actually 4 occurrence of the literal `5` that need to be replaced. Did you get them all? Never user `find-and-replace all`. You may actually replace a literal that has the same value but has nothing to do with the values you were looking for.

Now if we wish to be good programmers we would refactor this code as shown below.

```java
final int NUMBERS_TO_PROCESS = 5;

Scanner console = new Scanner(System.in);
int[] numbers = new int[NUMBERS_TO_PROCESS];
int i = 0;
int sum = 0;

do {
    System.out.print("Please enter an integer number: ");
    int number = console.nextInt();
    numbers[i] = number;
    sum += number;
    i++;
} while (i < NUMBERS_TO_PROCESS);

System.out.println("\n\nYou entered the following numbers:");
for (i = 0; i < NUMBERS_TO_PROCESS; i++) {
    System.out.print(numbers[i] + " ");
}
System.out.println("\nTotal sum = " + sum + " Average = " + sum/NUMBERS_TO_PROCESS);
```

Does it also not help make the code more readable? If we wish to read 10 numbers from the users, we only have to change the single value. Magic numbers are never good. Even if they occur only once inside your code. Always try to avoid them.
