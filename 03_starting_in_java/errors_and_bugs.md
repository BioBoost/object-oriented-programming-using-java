## Errors and Bugs

One thing all developers have in common is that they make mistakes also known as errors. Making mistakes in your code is not always bad, as it often leads to a deeper understanding of the problem or the language you are developing the solution in.

The process of tracking down the cause of an error is referred to as **debugging**.

Errors are often categorized as syntax/compilation errors, as runtime errors or as logic errors.

### Syntax Errors

Syntax or compilation errors are like **grammatical errors** in the English language. Some common examples are a missing semicolon `;`, the misspelling of a keyword `klass` or forgetting to place a closing bracket `}`. Since computer programs must follow strict syntax to compile correctly, any aspects of the code that **do not conform to the syntax of the programming language** will produce a syntax error.

Some software development IDEs check the source code for syntax errors in real-time, while others only generate syntax errors when a program is compiled. Even if source code contains one small syntax error, it will prevent an application from being successfully compiled. Similarly, if you run a script through an interpreter, any syntax errors will prevent the script from completing. In most cases, the compiler or interpreter provides the location (or line number) of the syntax error, making it easy for the programmer to find and fix the error.

Check out the example below, which contain a syntax error.

The first example is missing a semicolon at the end of print statement:

```java
public static void main(String[] args) {
    System.out.println("Syntax errors are easy to find.")
}
```

Next the String is not terminated using a closing quote:

```java
public static void main(String[] args) {
    System.out.println("Syntax errors are easy to find.);
}
```

In this last example, the `println` method call is misspelled:

```java
public static void main(String[] args) {
    System.out.printl("Syntax errors are easy to find.");
}
```

Try out all the examples above and take note on the errors messages provided by NetBeans. Try to keep them in your mind. Always read the descriptions as it will train your mind to spot syntax errors faster based on the description given by the compiler or interpreter.

It can sometimes occur that the IDE or compiler is tagging a line of code as faulty, while it is perfectly fine. In this case check the code right before that line, as the syntax error might be hiding in the code prior to the lines tagged as faulty.

### Runtime Errors

Runtime errors **occur during the execution** of your application. They often are produced by malformed or incorrect user input.

Take for example an application that calculates the division of two numbers provided by the user: `numerator / denominator`. If the user were to enter 0 as the denominator, then the program would crash with an "Exception in thread "main" java.lang.ArithmeticException: / by zero" error.

Or what if we asked the user to enter an integer value and he/she enters a non-numerical value. Then the application would crash because it would not be able to convert the given input into a number.

{% hint style="info" %}
**Exception**

An exception (or exceptional event) is a problem that arises during the execution of a program. When an Exception occurs the normal flow of the program is disrupted and the program/Application terminates abnormally, which is not recommended, therefore, these exceptions are to be handled.
{% endhint %}

During the design of an application it is important to anticipate for possible runtime errors that may occur due to the input of users. Most programming languages have mechanisms that can be used to handle these situations.

{% hint style="warning" %}
**User Input**

Always treat user input as unsafe and dangerous. Never thrust input from external sources. This is important for all sorts of applications. Even more so for database applications such as webapps.
{% endhint %}

### Logic or Semantic Errors

Logic or semantic errors are the hardest to catch. These are the kind of errors that are more often referred to as bugs. The application most likely will not crash and will generate output, however the generated outcome will be incorrect in some way.

Some common sources of bugs are bad understanding of the problem being solved, wrong implementation of the solution, errors in formulas or formatting.

These type of errors are the hardest to find as they will not always be obvious. Take for example a 3D shooter where in very rare cases you can glitch through a wall. Often these occasions are rare and often their cause is very hard to find (might be a model problem, a rounding error, a client-server deviation).

![PUBG - Glitch allows player to see through walls](img/pubg_glitch.jpg)