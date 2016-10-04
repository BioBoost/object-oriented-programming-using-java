## Control Flow Statements

The statements inside your source files are generally executed from top to bottom, in the order that they appear. Control flow statements, however, break up the flow of execution by employing decision making, looping, and branching, enabling your program to conditionally execute particular blocks of code. This section describes the decision-making statements (if-then, if-then-else, switch), the looping statements (for, while, do-while), and the branching statements (break, continue, return) supported by the Java programming language.

### Making Decisions in Java

#### The if statement

The `if` statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true.

Let's take for example a very simple example where we test if the students score (generated randomly for this example) is below 70% and if so we output an encouraging speech.

```java
Random random = new Random();
int studentScore = random.nextInt(101);
//...
System.out.println("Your score is " + studentScore + "%");
if (studentScore < 70) {
  System.out.println("Come on buddy, you will need to work a little harder.");
  System.out.println("You can do it. Still got some time till the exams.");
}
```

If this test evaluates to false (meaning that the score is equal or above 70), control jumps to the end of the if statement.

#### The if-else Statement

The if-else statement provides a secondary path of execution when an "if" clause evaluates to false. Taking the previous example you could output a "good job" speech when the students score is equal or above 70%.

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

The if-else statement can be extended with even more if-else statements. Each if-else will need a new condition that needs to be checked. The first one that evaluates to true is executed, after which control jumps to the end of the if-else statements.

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

You may have noticed that the value of studentScore can satisfy more than one expression in the compound statement. However the conditions are checked sequentially and once a condition is satisfied, the appropriate statements are executed) and the remaining conditions are not evaluated.
