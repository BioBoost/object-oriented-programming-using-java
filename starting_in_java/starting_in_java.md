# Starting in Java

This chapter lays the foundation of a simple application. As a reader you will get acquainted with the basic building blocks of programming language.

## Hello World

A "Hello World!" program is a computer program that outputs or displays "Hello World!" to the user. Being a very simple program in most programming languages, it is often used to illustrate the basic syntax of a programming language for a working program. It is often the very first program people write when they are new to the language.

![Hello World [^1]](img/hello_world.jpg)

[^1]: Source https://www.haikudeck.com/test-deck-uncategorized-presentation-0b3abf30c5

A "Hello world!" program is often used to introduce novice programmers to a programming language. In general, it is simple enough to be understood easily, especially with the guidance of a teacher or a written guide.

In addition, "Hello world!" can be a useful sanity test to make sure that a language's compiler, development environment, and run-time environment are correctly installed. Configuring a complete programming toolchain from scratch to the point where even trivial programs can be compiled and run can involve substantial amounts of work. For this reason, a simple program is used first when testing a new tool chain.

"Hello world!" is also used by computer hackers as a proof of concept that arbitrary code can be executed through an exploit where the system designers did not intend code to be executed—for example, on Sony's PlayStation Portable. This is the first step in using homemade content ("home brew") on such a device.

![Hello World on PSP [^2]](img/psp_hello_world.jpeg)

[^2]: Source https://en.wikipedia.org/wiki/%22Hello,_World!%22_program

### Hello World in Java

Let's jump right in and create a "Hello World" application in Java.

Open NetBeans and create a new Project by selecting "File => New Project => Java Application". Give is a sensible name such as "HelloWorld".

It will automatically generate an empty application with the code shown below.

> #### Info::Console Applications
>
> When developing applications a choice must be made between a GUI and a terminal application.
> As discussed earlier, a terminal application has no real graphical user interface and interacts
> with the user via the terminal (console). The only option for input and output are essentially text.
> This course will focus on terminal applications. Object Oriented Programming 2 will introduce JavaFX
> allowing the creation of graphical applications in Java.

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

While not diving into many details there are however a couple of things which can be clarified about the code above.

First of all, not all lines of text that are shown in the program are considered code. Some are actually comments which are not executed. There are
two ways in Java to indicate that some text is a comment. The first is prepending a double slash `//` before your comment. This needs to
be placed before each line of comments.

```java
// This is a line of comments
// This is another line of comments
// Yet again some comments
```

Because this can be a bit of a nuisance when you have a big block of comments, you can also place
`/*` before your block and `*/` after the block (also called a block-comment). This allows a programmer to easily create a paragraph as comments.

```java
/*
  This is a bigger paragraph
  that consists of multiple lines.
  It is typically also called a block-comment.
  */
```

Do note that the initial code shows an `*` before each line in a block-comment. This is a special notation that is called Javadoc. It allows automatic generation
of Javadoc manual pages similar to the Java API at https://docs.oracle.com/javase/8/docs/api/. More information about Javadoc can be found at http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html.

A second important part of your first program in Java is the main method shown again below.

```java
public static void main(String[] args) {
    // TODO code application logic here
}
```

This piece of code needs to be in every Java program and is the start-point of your program. Without it your program would not be able to be executed.
It is also called the **entry-point of the application**.

The piece of code shown above is also more general known as a **method**. A method consists of some code that can be executed by **calling** it somewhere else in
your code using the name of the method. Here the name of the method is `main`. Most of the applications that are used as examples in this chapter will contain
code that needs to be placed inside this main method, between the curly braces `{}`. That is why NetBeans provides the comment inside the curly braces, to show new programmers
where to place their first lines of code.

From this point forward most code outside of the main method will not be shown anymore unless something needs to change to the standard code.
This because it will mostly stay the same (apart from the actual name of the application which will change if you create a new project).

Let's start by creating the famous "Hello World" application. For this a single line of code must be added inside the curly braces of the *main* method which
outputs the text `Hello World` to the console.

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("Hello World!");
}
```

A lot can be said about this single line of code.

```java
System.out.println("Hello World!");
```

Most lines of code such as shown above are called `statements`. A statement is an action that is performed in code, often acting on some part of data or information.
In the example above, the information is a piece of text, namely "Hello World!".
This piece of text is called a **String** in programming languages and is most often specified between two quotes `"Place some text between quotes to make a string"`.
A statement is also typically terminated using a semicolon `;`. By placing this at the end of a statement, the Java interpreter knows that the line of code has ended.

If you run the code you will get the following result inside the terminal:

```text
Hello World!
BUILD SUCCESSFUL (total time: 0 seconds)
```

The first example also showed the "BUILD SUCCESSFUL (total time: 0 seconds)" part so this is not new (and this will not be shown in this course anymore from this point on).
However before that, the text "Hello World!" was outputted
to the terminal. This immediately explains what the new line of code does. It outputs some text to the terminal.

Actually `println` is the name of a method that prints a new line of text to the terminal every time it is used. Try placing multiple statements with `println` below each other,
every time with a different string. For example

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

Notice how every statement in the code is terminated (ended) with a semicolon. Also note that `println`
starts a new line every time it is called with a string to display. The string we provide to `println` is
called an **argument**. It is a piece of information that is given to a method so it can be used inside the
method - to be displayed, processed or handled in another way.

Forgetting to place a semicolon at the end of a statement will throw of the Java interpreter and generate what is known as syntax error.
Take for example the code below where the second `println` has not terminated correctly. In this case NetBeans will warn you, even
before actually running the code. It will generate a message stating that a `;` is expected. The line of code will also be marked
using red squiggly lines below the code. If you hover over the exclamation mark on the left side, the message *; expected* is shown.

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("Hello World!");
    System.out.println("My name is Nico De Witte")
    System.out.println("I am 31 years old and I am a teacher at VIVES University College");
}
```

![Syntax Error indicated by NetBeans](img/semicolon_expected.png)

Strings can be concatenated in Java using a `+` between the different parts. Java can also concatenate strings
with other things such as numbers. The code below shows different examples of string concatenations.

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

The code above shows both integer numbers and floating point numbers. Floating point numbers
use a point `.` as a decimal separator when specifying floating point numbers.

The `println` method also has a variant which does not print a new line at the end of the string.
This method is called `print`. A newline can be displayed by
calling `println` with an empty string `""` as argument or you can add a special character `\n` inside your string
to output newlines. The code below shows examples of all these techniques.

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.print("You can also print ");
    System.out.print("text to the terminal ");
    System.out.print("without starting a newline.");
    System.out.println("");   // Force a newline
    System.out.print("Or you can also force newlines\nusing escape characters.\n");
    System.out.print(".............\n\n");
}
```

Which outputs

```text
You can also print text to the terminal without starting a newline.
Or you can also force newlines
using escape characters.
.............

BUILD SUCCESSFUL (total time: 0 seconds)
```

More information about escape characters can be found at https://en.wikipedia.org/wiki/Escape_character.























<!-- Variables and data types -->
<!-- Operators -->
<!-- If else -->
<!-- Doing things twice - loops -->
<!-- Programming in Style -->



<!-- ## Storing data

Every application out there will store and process some sort of data. Data can be simple things such as numbers, floating point values, text, ... or more complex things that we define ourselves.

The **primitive data types** that are incorporated into the Java language allow you store simple data. There are many libraries that allow you to store more complex data but this is material for later in this course.




Primitive types are the most basic data types available within the Java language. There are 8: boolean, byte, char, short, int, long, float and double. These types serve as the building blocks of data manipulation in Java. Such types serve only one purpose — containing pure, simple values of a kind. Because these data types are defined into the Java type system by default, they come with a number of operations predefined. You can not define a new operation for such primitive types. -->
