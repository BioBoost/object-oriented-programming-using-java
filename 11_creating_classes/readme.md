---
description: This chapter teaches how to create custom objects and classes.
---

# Chapter 11 - Creating our own Classes

Creating custom classes is one of the main responsibilities of an object oriented programmer. As stated before, an application is a collection of objects that interact with each other. These objects are created based on a class developed by a programmer. If we wish to implement some functionality that is not yet available in the language or it is not exactly what we need, we are required to build it ourselves.

<!-- Luckily even if a class is not readily available for us, we will be able to reuse other classes which contain a partial functionality of the class we which to create. -->

It's natural to think of **objects as collections of other objects**. Think about a television which contains a tuner, a screen, a power supply, an embedded system, ... We say that a television object is **composed** of these other objects. Luckily this same concept is available to us in an object oriented programming language. We can also create objects by bundling other objects. This has the big advantage that we can use objects from classes that someone else made or are part of the language libraries. This saves us a lot of time and effort. This sort of code reuse is one of the major advantages of object oriented languages.

## UML Class Diagrams

When creating an application it can often be useful to put some diagrams on paper on how you are going to take on the problem. One of the most used diagrams in the world of object oriented programming is the UML (Unified Modeling Language) class diagram.

UML is a general-purpose, modeling language in the field of software engineering, that is intended to provide a standard way to visualize the design of a system.

A class diagram is a static diagram that describes the attributes and methods of a class and the also the relationships between the different classes in an application. Class diagrams are widely used in the modeling of object oriented systems because they are the only UML diagrams, which can be mapped directly with object-oriented languages.

While methods can be made private, often these are omitted from the UML diagram. This is often the case because most programmers find them cluttering the class diagram and they are often created as needed and not important for the outside user.

When modeling software it's normal that not all details are available from the start. For example the type of the attributes should also be documented in the UML diagram, as are the arguments and return types of the methods. However sometimes those details haven't been decided yet. In that case we just leave them out and add them later.

As an example take a look at the UML class diagram of a Hotel Management System below.

![UML Class Diagram of a Hotel Management System](img/uml_class_diagram_hotel.png)

<!-- Another example would be nice. Maybe something with IoT -->

Even if your are not an experienced programmer yet, you should be able to understand the concept of the application (not the details, only the general idea) just by looking at the diagram. If that is the case, its usefulness has just been proven.

## Creating a Class

When creating custom classes in Java it is convention to place the whole class and nothing but the class inside its own Java file. In NetBeans this can be achieved by traversing to `File => New File => Java => Java Class`.

Consider a class that represents a simple lightbulb in your house. The class is called `LightBulb` because the convention in Java for class names is that they should be named using **Pascal Case**.

> **INFO** - **Pascal Case and camel Case**
>
> Pascal case is a subset of Camel Case where the first letter is capitalized. That is, userAccount is a camel case and UserAccount is a Pascal case. In Java the convention is that methods names are camel cased while class names are Pascal cased. It is easy to remember. Pascal is a proper noun so capitalize the first letter, while camel is a common noun, so you do not capitalize the first letter.

<!-- How to break these? -->

> **INFO** - **snake_case**
>
> Snake case (or snake_case) is the practice of writing compound words or phrases in which the elements are separated with one underscore character `_` and no spaces, with each element's initial letter usually lowercased within the compound and the first letter either upper or lower case - as in "foo_bar" and "Hello_world".

```java
package javalightbulbapplication;

public class LightBulb {

}
```

The first line of code states the name of the package to which the class belongs. This allows a programmer to bundle classes together that logically belong together.

> **INFO** - **Packages**
>
> A Java package organizes Java classes into namespaces, providing a unique namespace for each type it contains. Classes in the same package can access each other's package-private and protected members. Java packages can be stored in compressed files called JAR files, allowing classes to be downloaded faster as groups rather than individually. A package allows a developer to group classes (and interfaces) together. These classes will all be related in some way – they might all have to do with a specific application or perform a specific set of tasks. Programmers also typically use packages to organize classes belonging to the same category or providing similar functionality.

Notice the `public` keyword which is called an **access modifier**. An access modifier is a special Java keyword that states **who can access the specified resource**. Access modifiers can be applied to classes, attributes and methods. Java allows a programmer to choose from the following access modifiers when declaring a class:

* The **default Java access modifier**, which is declared **by not writing any access modifier at all**. This means that class can only be used by other resources included in the same package. This is why it is also often referred to as package access.
* `public`, meaning that any other resource can make use of this class.

### Creating Objects

To create objects from the `LightBulb` class one just needs to call the default constructor as shown below and save the reference to the new object inside a variable of the same type as the class.

```java
public static void main(String[] args) {
  // Creating a LightBulb object and storing its reference inside a variable
  LightBulb kitchen = new LightBulb();
}
```

Notice the similarity again with creating an object of the class `Random` or `Scanner`.

For the moment this is all the functionality that LightBulb has. Not much use for us like this.

### UML Class Diagram of LightBulb

In its current state the `LightBulb` class can be visualized using the class diagram shown below.

![Start of a class diagram of LightBulb](img/light_bulb_class.png)

The class shape in a class diagram consists of a rectangle with three rows. The top row contains the **name of the class**, the middle row contains the **attributes of the class** (the data of the objects), and the bottom section expresses the **methods and/or constructors** (the behavior) that the class has. In a class diagram, classes and subclasses are grouped together to show the relationship between objects of these classes.