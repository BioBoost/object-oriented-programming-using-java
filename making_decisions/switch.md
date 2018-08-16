## The Switch Statement

Let us take a look at some code that will allow the user to enter the number of the day of the week. The program will than determine the name of the day and output it to the user.

```java
Scanner console = new Scanner(System.in);
int dayOfTheWeek = 0;

do {
  System.out.print("What day of the week is it today [1-7]?");
  dayOfTheWeek = console.nextInt();

  if (dayOfTheWeek == 1) {
      System.out.println("Ah ok, than it's Monday today");
  } else if (dayOfTheWeek == 2) {
      System.out.println("Ah ok, than it's Tuesday today");
  } else if (dayOfTheWeek == 3) {
      System.out.println("Ah ok, than it's Wednesday today");
  } else if (dayOfTheWeek == 4) {
      System.out.println("Ah ok, than it's Thursday today");
  } else if (dayOfTheWeek == 5) {
      System.out.println("Ah ok, than it's Friday today");
  } else if (dayOfTheWeek == 6) {
      System.out.println("Ah ok, than it's Saturday today");
  } else if (dayOfTheWeek == 7) {
      System.out.println("Ah ok, than it's Sunday today");
  } else {
      System.out.println("Not a valid day of the week");
  }
} while (dayOfTheWeek < 1 || dayOfTheWeek > 7);
```

When checking a single variable for equality using multiple if-else statements, it can be replaced with another structure called a switch structure. The template of the switch structure is shown below. Each case needs a single integral literal value to compare the variable against. If it matches (equals) than the code between the colon `:` and the `break;` statement is executed. The break is required for the switch to be stopped when a match is found.

```java
switch (<variable>) {
  case <integral_literal_1>:
    // Code to be executed
    break;
  case <integral_literal_2>:
    // Code to be executed
    break;
  case <integral_literal_3>:
    // Code to be executed
    break;
  // ...
  default:
    // Code to be executed in case no match found
}
```

Replacing the if-else structure of the day-of-the-week example with a switch statement results in the following code.

```java
Scanner console = new Scanner(System.in);
int dayOfTheWeek = 0;

do {
  System.out.print("What day of the week is it today [1-7]?");
  dayOfTheWeek = console.nextInt();

  switch (dayOfTheWeek) {
      case 1:
          System.out.println("Ah ok, than it's Monday today");
          break;
      case 2:
          System.out.println("Ah ok, than it's Tuesday today");
          break;
      case 3:
          System.out.println("Ah ok, than it's Wednesday today");
          break;
      case 4:
          System.out.println("Ah ok, than it's Thursday today");
          break;
      case 5:
          System.out.println("Ah ok, than it's Friday today");
          break;
      case 6:
          System.out.println("Ah ok, than it's Saturday today");
          break;
      case 7:
          System.out.println("Ah ok, than it's Sunday today");
          break;
      default:
          System.out.println("Not a valid day of the week");
  }
} while (dayOfTheWeek < 1 || dayOfTheWeek > 7);
```

No general rule exists for when to use which construct. Some programmers don't like the switch statement. In most cases it is a case of preference.
