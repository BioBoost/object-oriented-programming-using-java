---
description: This chapter introduces a hello world application in Java. As a reader you will get acquainted with the basic syntax of the Java programming language and you will develop your first small application.
---

# Starting in Java

<!-- TODO
Maybe some general things about Java? -->

## Hello World

A "Hello World!" program is a computer program that outputs or displays "Hello World!" to the user. Being a very simple program in most programming languages, it is often used to illustrate the basic syntax of a programming language for a working program. It is often the very first program people write when they are new to the language.

![Hello World](img/hello_world.jpg)

A "Hello world!" program is often used to introduce novice programmers to a programming language. In general, it is simple enough to be understood easily, especially with the guidance of a teacher or a written guide.

In addition, "Hello world!" can be a useful sanity test to make sure that a language's compiler, development environment, and run-time environment are correctly installed. Configuring a complete programming toolchain from scratch to the point where even trivial programs can be compiled and run can involve substantial amounts of work. For this reason, a simple program is used first when testing a new toolchain.

"Hello world!" is also used by computer hackers as a proof of concept that arbitrary code can be executed through an exploit where the system designers did not intend code to be executed - for example, on Sony's PlayStation Portable. This is the first step in using homemade content ("home brew") on such a device.

![Hello World on PSP](img/psp_hello_world.jpeg)

## Hello World in Java

Let's jump right in and create a "Hello World" application in Java.

Open NetBeans and create a new Project by selecting `File => New Project => Java Application`. Give it a sensible name such as "HelloWorld".

{% hint style="warning" %}
**Naming Things**

Naming things correctly is one of the main responsibilities of a programmer. By giving things (applications, variables, methods, ...) decent names, you will make your own life and that of fellow programmers a lot easier.
{% endhint %}

One the wizard is finished it will automatically generate an empty application with the code shown below.

{% hint style="info" %}
**Console Applications**

When developing applications a choice must be made between a GUI and a console application. As discussed earlier, a console application has no real graphical user interface and interacts with the user via the terminal (console). The default options for input and output are essentially text. This course will first focus on console applications after which it will introduce JavaFX allowing the creation of graphical applications.
{% endhint %}

```java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author Nico De Witte
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
```

Running this application will output something like shown below.

```java
BUILD SUCCESSFUL (total time: 0 seconds)
```

While not diving into many details here, there are however a couple of things which can be clarified about the code above.

## Comments

First of all, not all lines of text that are shown in the program are considered code. Some are actually comments which are not executed. There are
two ways in Java to indicate that some text is a comment. The first is prepending a double slash `//` before your comment. This needs to
be placed before each line of comments.

```java
// This is a line of comments
// This is another line of comments
// Yet again some comments
```

Because this can be a bit of a nuisance when you have a big block of comments, you can also place `/*` before your block and `*/` after the block (also called a block-comment). This allows a programmer to easily create a paragraph as comments.

```java
/*
  This is a bigger paragraph
  that consists of multiple lines.
  It is typically also called a block-comment.
  */
```

Do note that the initial code shows an `*` before each line in a block-comment. This is a special notation that is called Javadoc. It allows automatic generation of Javadoc manual pages similar to the Java API at [https://docs.oracle.com/javase/10/docs/api/](https://docs.oracle.com/javase/10/docs/api/). More information about Javadoc can be found at [http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html).

{% hint style="warning" %}
**Too much Information**

It is completely normal as a beginning programmer to place a lot of comments inside your code. While this is helpful when learning to program, it is also kind of dangerous. Code typically changes while the project evolves and often comments do not. They can therefore contain wrong information about the code and become useless and even misleading. A good programmer (one that takes care of code) will not need a lot of comments. The best documentation is the code itself, of course provided that you take care of your naming of things and your code in general.
{% endhint %}

## The main Method

A second important part of your first program in Java is the main method shown again below.

```java
public static void main(String[] args) {
    // TODO code application logic here
}
```

This piece of code needs to be in every Java program and is the start-point of your program. Without it your program would not be able to be executed.
It is also called the **entry-point of the application**.

The piece of code shown above is also more general known as a **method**. A method consists of some code that can be executed by **calling** it somewhere else in your code using the name of the method. Here the name of the method is `main`. Most of the applications that are used as examples in this chapter will contain code that needs to be placed inside this main method, between the curly braces `{}`. That is why NetBeans provides the comment inside the curly braces, to show new programmers where to place their first lines of code.

From this point forward most code outside of the main method will not be shown anymore unless something needs to change to the standard code.
This because it will mostly stay the same (apart from the actual name of the application which will change if you create a new project).

Let's start by creating the famous "Hello World" application. For this a single line of code must be added inside the curly braces of the *main* method which outputs the text `Hello World` to the console.

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("Hello World!");
}
```

## Terminal Output

A lot can be said about this single line of code.

```java
System.out.println("Hello World!");
```

Most lines of code such as shown above are called `statements`. A statement is an action that is performed in code, often acting on some part of data or information. In the example above, the information is a piece of text, namely "Hello World!". This piece of text is called a **String** in programming languages and is most often specified between two quotes `"Place some text between quotes to make a string"`. A statement is also typically terminated using a semicolon `;`. By placing this at the end of a statement, the Java interpreter knows that the line of code has ended.

If you run the code you will get the following result inside the terminal:

```text
Hello World!
BUILD SUCCESSFUL (total time: 0 seconds)
```

The first example also showed the "BUILD SUCCESSFUL (total time: 0 seconds)" part so this is not new (and this will not be shown in this course anymore from this point on). However before that, the text "Hello World!" was outputted to the terminal. This immediately explains what the new line of code does. It outputs some text to the terminal.

Actually `println` is the name of a method that prints a new line of text to the terminal every time it is used. Try placing multiple statements with `println` below each other, every time with a different string. For example

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("Hello World!");
    System.out.println("My name is Nico De Witte");
    System.out.println("I am 31 years old and I am a teacher at VIVES University College");
}
```

This will result in the following output:

```text
Hello World!
My name is Nico De Witte
I am 31 years old and I am a teacher at VIVES University College
```

Notice how every statement in the code is terminated (ended) with a semicolon. Also note that `println` starts a new line every time it is called with a string to display. The string we provide to `println` is called an **argument**. It is a piece of information that is given to a method so it can be used inside the method - to be displayed, processed or handled in another way.

Forgetting to place a semicolon at the end of a statement will throw of the Java interpreter and generate what is known as a **syntax error**. Take for example the code below where the second `println` has not terminated correctly. In this case NetBeans will warn you, even before actually running the code. It will generate a message stating that a `;` is expected. The line of code will also be marked using red squiggly lines below the code. If you hover over the exclamation mark on the left side, the message *; expected* is shown.

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("Hello World!");
    System.out.println("My name is Nico De Witte")
    System.out.println("I am 31 years old and I am a teacher at VIVES University College");
}
```

![Syntax Error indicated by NetBeans](img/semicolon_expected.png)

Strings can be concatenated in Java by placing a `+` sign between the different parts. Java can also concatenate strings
with other types such as numbers. When Java detects that a string is required for an operation, it will automatically
try to convert the given information to a string. The code below shows different examples of string concatenations.

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("It is now " + "7:44 PM");
    System.out.println("My class counts " + 18 + " students");
    System.out.println("I am currently about " + 980106323 + " seconds old");
    System.out.println("Number of cats in my house: " + 0);
    System.out.println("I am " + 1.86 + "meters tall");
}
```

This code outputs:

```text
It is now 7:44 PM
My class counts 18 students
I am currently about 980106323 seconds old
Number of cats in my house: 0
I am 1.86 meters tall
```

The code above shows both integer numbers and floating point numbers. Floating point numbers use a point `.` as a decimal separator when specifying floating point numbers.

## Escape Characters

The `println` method also has a variant which does not print a new line at the end of the string.
This method is called `print`. A newline can be displayed by
calling `println` with an empty string `""` as argument or you can add a special character `\n` inside your string
to output newlines. These special characters that are prefixed with a `\` are called escape characters. Most programming languages have them. The code below shows examples of all these techniques.

```java
public static void main(String[] args) {
    System.out.println("There\tis\ta\ttab\tbetween\teach\tword");
    System.out.println("You can also use quotes here but they need to be escaped:");
    System.out.println("--------------------------------------------------------");
    System.out.println("\"C makes it easy to shoot yourself in the foot; C++ makes it harder,\nbut when you do it blows your whole leg off.\"");
    System.out.println("by Bjarne Stroustrup");
    System.out.println("--------------------------------------------------------");
}
```

Which generates the following output:

```text
There	is	a	tab	between	each	word
You can also use quotes here but the need to be escaped:
--------------------------------------------------------
"C makes it easy to shoot yourself in the foot; C++ makes it harder,
but when you do it blows your whole leg off."
by Bjarne Stroustrup
.............

BUILD SUCCESSFUL (total time: 0 seconds)
```

The table below lists the escape sequences supported by Java.

| Escape Sequence | Description |
| --- | --- | --- |
| `\t` | Insert a tab in the text at this point. |
| `\b` | Insert a backspace in the text at this point. |
| `\n` | Insert a newline in the text at this point. |
| `\r` | Insert a carriage return in the text at this point. |
| `\f` | Insert a formfeed in the text at this point. |
| `\'` | Insert a single quote character in the text at this point. |
| `\"` | Insert a double quote character in the text at this point. |
| `\\` | Insert a backslash character in the text at this point. |


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