<!-- toc -->

## Variables in Java

The programs that we create need to store all sorts of data. From simple things such as
integers, floating point numbers, characters and Strings to complex data types that we
define ourselves.

This data is stored, manipulated and outputted through our program. The data itself
is stored inside the memory of the computer or system the program is running on.

### Declaring a variable

To allow for easy access inside our programs source code, the variables have a symbolic name
that can be used from within the source code.

In Java, each variable has a specific type, which determines the size and layout of the variable's memory; the range of values that can be stored within that memory; and the set of operations that can be applied to the variable.

> #### Hint::Declare a variable before using it
>
>  You must declare a variable before it can be used.

In Java you need to specify the **type** of the variables followed by a **chosen name**. Optionally you can immediately initialize the variable by assigning a value to it.

Examples of variable declaration with and without initialization:

```java
int age;
int numberOfStudents = 55;    // Initialize to 55
char startOfAlfabet = 'a';    // Initialize to 'a'
double vatOnSalery;
String helloWorld = "Hello World!";    // Initialize to "Hello World!"
String nameOfStudent;
```

### Primitive and non-primitive data types

Java actually has two categories of data types:

* **Primitive data types**: char, byte, short, int, long, double, float and boolean.
* **Non-primitive data types**: String, ArrayList, Complex, Random, ...

Primitive data types are simple and integrated in the language (they are most of the time keywords in the language itself). Non-primitive data types are actually classes. This means that when we use the String data type we are actually using objects of the class String. The cool thing about non-primitive data types is that we can create our own.

### Variable types

Variables in Java can be defined anywhere in the code (inside a class, inside a method or as a method argument) and can have different modifiers. Depending on these conditions variables in Java can be divided into four categories:

* Instance variables or class attributes
* Static class variables
* Local variables
* Method arguments

#### Instance variables or class attributes

Instance variables are actually the attributes of a class. They are the data members that
store the state of objects. Instance variables are declared inside a class but outside of a method or constructor.
Such variables are called instance variables because their values are instance (object) specific and values of these variables are not shared among instances.

For example the following Bicycle class has three instance variables:

```java
public class Bicycle {
  private int numberOfGears;
  private String brand;
  private double priceExcludingVat;
}
```

Below is an object diagram of three instances of the class `Bicycle`. As can be
seen from the diagram each instance variable has its own separate memory storage and can contain
it's own values.

![Object diagram of three instances of the class `Bicycle`](img/object_diagram_bicycle.png)

#### Static class variables

Variables which are declared with a `static` keyword inside a class (outside any method) are known as class variables or static variables. They are known as class level variables because values of these variables are not specific to any instance but are common to all instances of a class. Such variables will be shared by all instances of an object of that class.

A common example of a static class variable is an object counter that keeps track of
the number of objects that where created of that class. Let's see an example:

```java
public class SnakeSegment {
  private static int objectCounter = 0;

  public SnakeSegment() {
    // ...
    objectCounter++;
    System.out.println("You have created " + objectCounter + " instances of this class so far.");
  }
}
```

A more common use for static variables however is the use of constants. Constants are variables that cannot be
changed once they have been assigned.

```java
public class Snake {
  private static final int MAX_SNAKE_SEGMENTS = 100;
}
```

There are two things you need to note in the example above:

* The keyword `final` which states that the variable is a constant and cannot be changed
anymore after it has been assigned a value.
* The **capital letters** of the variable name. This is common in almost all programming languages.
Variables that are constant should have a name with only capital letters.

Their use is strongly encouraged to remove the use of what are called **magic numbers**.
Magic numbers are literal values (ex. 10, 125, 13.2, ...) that are used in your code. They may seem obvious in the beginning
but their clearness decreases as time passes. They are also dangerous in use as code changes.
It is very easy to forget to change all the occurrences of the value that needs to change. On top of that you may change an occurrence
of the magic number to many.

Take a look at the following example. Can you identify within 10 seconds what literals
need to change to make the snake longer than 100 segments ?

```java
public class Snake {
  // ...
  public void evolve() {
    for (int i = 0; i < 100; i++) {
        int x = 100;
        int y = 100 + i;
        SnakeSegment segment = new SnakeSegment(x, y);
        // ...
        snake.addSegment(segment);
        totalLength += 1;
    }
    score = score + (totalLength - 100) * 3.872;
  }
}
```

Now let's see the exact same code but with constants replacing the magic numbers:

```java
public class Snake {
  private static final int SNAKE_EVOLVE_LENGTH = 100;
  private static final int CENTER_OF_SCREEN_X = 100;
  private static final int CENTER_OF_SCREEN_Y = 100;
  private static final double SCORE_SEGMENT_MULTIPLIER = 3.872;

  // ...

  public void evolve() {
    for (int i = 0; i < SNAKE_EVOLVE_LENGTH; i++) {
        int x = CENTER_OF_SCREEN_X;
        int y = CENTER_OF_SCREEN_Y + i;
        SnakeSegment segment = new SnakeSegment(x, y);
        // ...
        snake.addSegment(segment);
        totalLength += 1;
    }
    score = score + (totalLength - SNAKE_EVOLVE_LENGTH) * SCORE_SEGMENT_MULTIPLIER;
  }
}
```

#### Local variables

When a variable is declared inside a method or code block it is known as a local variable.
The scope of local variables is only inside the method or code block,
meaning that local variables cannot be accessed outside that method or code block.

In the example below the attribute `diameter` is an instance variable. The variables
`circumference`, `radius` and `radiusSquared` are local variables. When the method is
called from another object, memory is reserved for the local variables. Once the method
is finished the variable's memory space is freed for other data.

```java
public class Circle {

  private double diameter;

  public double calculateCircumference() {
    double circumference = Math.PI * diameter;
    return circumference;
  }

  public double calculateArea() {
    double radius = diameter / 2;
    double radiusSquared = radius * radius;
    return Math.PI * radiusSquared;
  }
}
```

Another example of a local variable can be found often in a for-loop. Here a variable
is used as an iteration counter to keep track of the number of times the code inside
the loop has been executed. The variable is often abbreviated as `i` or `k`. The code
below shows an example of a simple for-loop. The scope of the variable `i` is limited to
the body and header of the for-loop.

```java
// Say hello a number of times
for (int i = 0; i < NUMBER_OF_TIMES_TO_SAY_HELLO; i++) {
  System.out.println(i + ": Hello");
}
// i is not accessible anymore, it is out of scope
```

#### Method arguments

Method arguments are actually the same as local variables. Their scope is limited to the
method they belong too and they are also freed once the method call has passed.

An example of some arguments are shown in the code below.

```java
public class Student {

  private String firstname;
  private String lastname;

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
```

Note that in the code above the arguments have the same name as the attributes
(instance variables) of a Student. This means that stating `firstname = firstname` is wrong.
In the code above `this.firstname` refers to the attribute and `firstname` refers to the
argument of the method `setFirstname`.


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

You may have noticed that the value of `studentScore` can satisfy more than one expression in the compound statement. However the conditions are checked sequentially and once a condition is satisfied, the appropriate statements are executed and the remaining conditions are not evaluated.

## Loop statements

There may be a situation when you need to execute a block of code several number of times. In general, statements are executed sequentially: The first statement in a block is executed first, followed by the second, and so on. Programming languages provide various control structures that allow for more complicated execution paths.

Java programming language provides the following types of loops to handle looping requirements:

* **for loop**: Execute a code block multiple times and simplify the code that manages the loop variable.
* **while loop**: Repeats a code block while a given condition is true. It tests the condition before executing the body of the loop.
* **do-while loop**: Like a while statement, except that it tests the condition at the end of the loop body.

### The for loop

Basically a for loop is most often used when the number of iterations is pre-determined. A typical example would be a list of items where an actions needs to be applied to each item in the list.

The for loop adheres to the following construction template:

```java
for (initialization ; condition ; increment) {
  // Code block
}
```

* The initialization statement is executed only once before the loop mechanism is started.
* The condition is checked before each iteration and will determine if the code block is executed or not
* The increment expression is invoked after each iteration through the loop. Most often this expression is used to increment or decrement a condition variable.

Each of these can be left empty. For example an endless loop can be written as:

```java
for (;;) {
  /// Do something forever
}
```

Let's see the most simple example possible. A simple for loop that outputs the text `"Hello"` 10 times to the terminal.

```java
for (int i = 0; i < 10; i++) {
  System.out.print("Hello ");
}
```

In the example above the initialization step is used to create a local variable `i` which serves as a simple counter. Next the condition is checked and the text is outputted to the terminal. Next `i` is incremented (1 is added). Before the next iteration the value of `i` is checked in the condition and the loop continues.

The last iteration happens when `i` was incremented to 9. The loop is executed a last time and the value of `i` is incremented a last time to 10. Next the condition is checked but not met. The loop is terminated and execution jumps after the for loop.

Want to see the values of i? Use the following code:

```java
for (int i = 0; i < 10; i++) {
  System.out.println(i + ": Hello");
}
```

This outputs:

```
0: Hello
1: Hello
2: Hello
3: Hello
4: Hello
5: Hello
6: Hello
7: Hello
8: Hello
9: Hello
```

Important to note is that the variable `i` used here has local scope. This means that it only exists in the for-loop. If you wish to know the last value of `i` you can create a variable before the for-loop and skip the initialization step in the for-loop header. The code below shows an example of this. Do note that you still need to add a semicolon in the for-loop header to separate the initialization from the condition part.

```java
int i = 0;
System.out.println("i = " + i + " before for loop");
for (; i < 10; i++) {
  System.out.println(i + ": Hello");
}
System.out.println("i = " + i + " after for loop");
```

This outputs:

```
i = 0 before for loop
0: Hello
1: Hello
2: Hello
3: Hello
4: Hello
5: Hello
6: Hello
7: Hello
8: Hello
9: Hello
i = 10 after for loop
```

### The do-while loop

A do-while loop is used when the code block needs to be executed at least once. After the first iteration a condition is checked which determined if the code block should be executed again or not.

### The while loop

The while loop is used when the code block may not even run at all if the condition is not met. The condition is checked before the code block is executed.

While every while loop can also be written as a for loop that does not mean it should. Complex for loops can often be refactored into less complex while or do-while loops.





END OF FILE
