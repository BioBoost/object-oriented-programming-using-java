## Nesting control structures

Each of the control structures (if, for, while, do-while, switch, ...) discussed in the previous sections can actually be nested. This means that we can place a loop inside an if code block, or an if inside another if.

Let us for example take a look at the code below where we ask the user to input positive and negative integers. By setting the condition of the do-while loop to `number != 0`, we keep asking for more numbers until the user enters `0`. Each number is then added to a `totalPositive` or `totalNegative` based on whether it's greater or less than zero. If the condition for the do-while is not met anymore (user enters `0`), the loop finishes and the results are shown to the user.

```java
Scanner console = new Scanner(System.in);

int totalPositive = 0;
int totalNegative = 0;
int number = 0;

do {
  System.out.print("Please enter a positive or negative integer [0 to stop]: ");
  number = console.nextInt();

  if (number < 0) {
    totalNegative += number;
  } else {
    totalPositive += number;
  }
} while (number != 0);

System.out.println("Total Positive: " + totalPositive);
System.out.println("Total Negative: " + totalNegative);
```

The example above shows how an if-else construct can be nested inside a while loop. While the number of times you can nest a structure inside another is directly limited it should be kept to a minimum. The deeper structures get nested the more complex your code starts to become. Later we will see different strategies to overcome this complexity.
