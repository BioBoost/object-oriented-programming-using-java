---
description: This chapter introduces the basic constructs that allow branching inside your application.
---

# Making Decisions

The statements inside your source files are generally executed from top to bottom, in the order that they appear. Control flow statements, however, break up the flow of execution by employing decision making, enabling your program to conditionally execute particular blocks of code. This section describes the decision-making statements if, if-else, and switch supported by the Java programming language.

## Conditions

To allow our program to make certain decisions we first need to take a look at conditions and how they are evaluated.

A condition is some sort of comparison (or a combination of comparisons) that can be evaluated by the compiler or interpreter. After solving all comparisons and combining all the individual parts, the compiler resolves it to a single resulting value that is `true` or `false` (also keywords in Java), which are actually values the data type `boolean` can take. Generally spoken we state that the compiler evaluates the condition to be true or false.

The `true` and `false` values can differ from language to language, however internal in memory `false` is most of the time "0" and `true` is "not 0".

## Comparison Operators

The table below shows the available comparison operators that can be used in Java to build a condition.

| Operator | Description |
|---|---|
| == | equal to |
| != | not equal to |
| > | greater than |
| >= | greater than or equal to |
| < | less than |
| <= | less than or equal to |

Since a conditional statement actually produces a single `true` or `false` result, this result can actually be assigned to a variable of type `boolean`.

Let's take a look at some examples of comparison operators:

```java
int a = 4;
int b = 8;
boolean result;
result = (a < b);   // true
result = (a > b);   // false
result = (a <= 4);  // a smaller or equal to 4 - true
result = (b >= 9);  // b bigger or equal to 9 - false
result = (a == b);  // a equal to b - false
result = (a != b);  // a is not equal to b - true
```

Note how we need to use two equality signs `==` to test if two values are equal, while we use a single sign `=` for assignment.

While the comparison operators will not often be used in a situation as shown in the code above, they will often be used when making decisions in your program.

## Conditional Operators

When creating more complex conditional statements you will need to use the conditional operators to create combinations of conditions.

The table below gives an overview of the available conditional operators in Java.

| Operator | Description |
|---|---|
| && | AND |
| &#124;&#124; | OR |
| ! | NOT |

These work as you know them from the Boolean algebra. The `||` (OR) operator will return `true` if either of the operands evaluate to `true`. The `&&` (AND) operator will return `true` if both operands evaluate to `true`. A logical expression can be negated by placing the `!` (NOT) operator in front of it.

The code example below checks if a person is a child based on it's `age` (between 0 and 14 years of age).

```java
int age = 16;
boolean isAChild = (age >= 0 && age <= 14);      // false
```

> **HINT** - **Info::De Morgan's Laws**
>
> In some cases it can be useful to rewrite complex conditions using De Morgan's Laws [https://en.wikipedia.org/wiki/De_Morgan%27s_laws](https://en.wikipedia.org/wiki/De_Morgan%27s_laws). Do take note that shorter not always implies more readable or less complex.

<!-- How to break here? -->

> **WARNING** - **Lazy evaluation**
>
> These operators exhibit **"short-circuiting"** behavior, which means that the second operand is evaluated only if needed. This is also called lazy evaluation. So for example in an OR statement, if the first operand is true, the outcome must also be true. For this reason the second operand is not checked anymore.

## The if statement

The `if` statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular condition evaluates to true.

Let's take for example a very simple example where we test if the students score (generated randomly for this example) is below 70% and if so we output an encouraging speech.

```java
// Generate a random score between 0 and 100 (inclusive)
Random random = new Random();
int studentScore = random.nextInt(101);
//...
System.out.println("Your score is " + studentScore + "%");
if (studentScore < 70) {
  System.out.println("Come on buddy, you will need to work a little harder.");
  System.out.println("You can do it. Still got some time till the exams.");
}
```

If this test evaluates to `false` (meaning that the score is equal or above 70), control jumps to the end of the if statement.

## The if-else Statement

The if-else statement provides a secondary path of execution when an "if" clause evaluates to `false`. Taking the previous example you could output a "good job" speech when the students score is equal or above 70%.

```java
Random random = new Random();
int studentScore = random.nextInt(101);
//...
System.out.println("Your score is " + studentScore + "%");
if (studentScore < 70) {
  System.out.println("Come on buddy, you will need to work a little harder.");
  System.out.println("You can do it. Still got some time till the exams.");
} else {
  System.out.println("Good job. Keep up the good work.");
}
```

The if-else statement can be extended with **even more if-else statements**. Each if-else will need a new condition that needs to be checked. The first one that evaluates to true is executed, after which control jumps to the end of the if-else statements.

Let's extend our grading example to be a bit more student friendly:

```java
Random random = new Random();
int studentScore = random.nextInt(101);
//...
System.out.println("Your score is " + studentScore + "%");
if (studentScore >= 90) {
  System.out.println("Omg, good job. Keep up the work.");
} else if (studentScore >= 70) {
  System.out.println("Some room for improvement but you are on your way.");
} else if (studentScore >= 50) {
  System.out.println("Ok. But you may want to considering studying a bit more.");
} else if (studentScore >= 30) {
  System.out.println("Come on buddy, you will need to work a little harder.");
} else {
  System.out.println("You may want to cancel your holiday vacation for studying.");
}
```

You may have noticed that the value of `studentScore` can satisfy more than one expression in the compound statement. However the conditions are checked sequentially and once a condition is satisfied, the appropriate statements are executed and the remaining conditions are not evaluated.

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

No general rule exists for when to use which construct. Some programmers don't like the `switch` statement. In most cases it is a case of preference.