## Chapter 03 - Starting in Java - Challenges

### Printing Personalized Hello

Create a program that prints out a message to the user saying hello and stating your name.

For example:

```text
Hello, this application was developed by Nico De Witte.
```

### Fix the Syntax Errors

Fix the syntax errors in the following applications. Take note of the different error messages given by NetBeans.

#### Application 1

```java
public static void main(String[] args) {
    System.out.println("Hello world")
}
```

#### Application 2

```java
public static void main(String[] args) {
    System.out.println("Hello user");
    System.out.printn("I am a student at VIVES University");
    System.out.print("I really like playing games and going out.\n");
}
```

#### Application 3

```java
public static void main(String[] args) {
    System.out.println("I have a total of " + 124 " achievements on Steam.");
}
```

#### Application 4

```java
public static void main(String[] args) {
    System.out.println("The circumference of the planet is " + "40,075 km";
}
```

#### Application 5

```java
public static void main(String[] args) {
    system.out.println("One programmer said to another:");
    system.out.println("I need a </br>");
}
```

### Personal Details

Create an application that prints out some personal information about yourself, like for example:
* your name
* your age
* your height
* your weight
* the color of your eyes
* ...

Try to concatenate strings with actual numbers like for example:
```java
System.out.println("I am " + 3 + " feet tall");
```

### Escape Characters

Try to output the information below using Java. Make sure to use escape characters to create extra new lines, tabs and such.

```text
Hello there. I am a student learning to program.
I follow courses at VIVES University. Their address is
    Spoorwegstraat 12
    8200 BRUGES

My favorite course is "Object Oriented Programming".

You can find the course documents @ https://vives.gitbook.io/oop-with-java/
```