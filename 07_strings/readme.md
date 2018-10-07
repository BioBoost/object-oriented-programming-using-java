---
description: The data processed by a application often consists of text. To store this type of data we need String and the possibility to manipulate them.
---

# Strings

`String` is probably the most commonly used data type for variables in Java. It is so popular that you actualle already have been using strings since the beginning of this course. Remember your first statement?

```java
System.out.println("Hello World");
```

Well, this application was outputting the `String` `"Hello World"` to the terminal.

## String is a Class

A keen eye may also have noticed that while `int`, `double` and such data types are not capitalized, `String` is. That is because `String` is actually a **class**, where those other types are not.

Java actually has two categories of data types:

* **Primitive data types**: char, byte, short, int, long, double, float and boolean.
* **Non-primitive data types**: String, ArrayList, Complex, Random, ...

Primitive data types are simple and integrated in the language (they are most of the time keywords in the language itself). Non-primitive data types are actually classes. This means that when we use the String data type we are actually using objects of the class String. The cool thing about non-primitive data types is that we can create our own as we shall see later in this course.

All you need to know at the moment about a class is the following:

* The name of a class, in this case `String`, **acts just as a data type**. This means that we can create variables of type `String`. Actually the variable points to **an object of that class**.
* A class internally **contains data**, in the case of a `String` this is a sequence of characters.
* A class **has methods**, which are like actions that can be requested from the objects create from the class.

## Creating Strings

There are two options to create strings. The first we have already used, which is direct assignment of a String literal. The second option is using the approach of using the `new` keyword, as we have done already with classes such as `Scanner` and `Random`.

### Using String literals

The most direct way to create a string is to assign a string **literal** to a variable of type `String` as shown in the next code example.

```java
String greetings = "Hello there. What a fascinating world we live in";

// Print the greetings String to the terminal
System.out.println(greetings);
```

When Java encounters a string literal in our code (`"Hello there. What a fascinating world we live in"` in the previous example), it will automatically create an object of the class `String` and place our literal value inside of it.

### Using the new keyword

As with any other class, you can create objects by using the `new` keyword.

```java
String greetings = new String("Hello there. What a fascinating world we live in");

// Print the greetings String to the terminal
System.out.println(greetings);
```

This approach is the **general way of creating objects from classes**, but is rarely seen in cases of strings. This because the previous approach is shorter.