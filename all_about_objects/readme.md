<!-- toc -->

# All About Objects

This chapter will teach you some basics of the Object Oriented Programming, particularly on using objects.

## Object Oriented Thinking

Object Oriented Programming (OOP) has been around since the early 1960s but it gained only decent momentum since the 1990s. The emergence of the Internet for business and entertainment lies mainly at the base of this popularity gain of OOP.

While this course will teach you the basics of Java, it's main focus will be object oriented concepts and the thought process behind object oriented design of software. If you understand the mechanics behind the object oriented world you will be able to apply it to any OOP language. Concepts stay more consistent over time and evolve at a slower rate. Technologies and programming languages on the other hand evolve quite rapidly. By the time you finish your studies the tools you have learned to use may have become deprecated.

<!-- TODO: Why objects oriented programming language? -->

### It's all about objects

What is an object ?

Sounds like a complex question, but the answer is actually really simple. Humans already tend to **think in terms of objects**, without taking to much effort. Students already know about objects, even if they don't realize it.

If you are reading this in a classroom, than take a look around you. Try to focus on a person in the room and identify some properties of this person. Some examples could be his/her:

* name
* age
* eye color
* gender
* state (sleeping, walking, sitting, ...)
* height
* ...

These properties are often referred to as the **attributes** of an object. They define the **data** that the object is holding or the state that it is in.

What actions can that person perform ? He/she can:

* walk
* sleep
* talk
* eat
* stand up
* ...

These are called the **methods** of an object. They define the possible **behavior** or actions of an object.

This leads to a more formal definition of an object:

> #### Definition::Object
>
>  An object is an entity that contains both **data** (*attributes*) and **behavior** (*methods*).

### Objects Talk to Each other

Most objects will only become useful if they can **interact with other objects**. Take for example a chair in the middle of a room full of people. The chair is pretty useless until someone decides to sit on it.

Interaction between objects in a software program is accomplished by an object sending a **message** to another object. Of course it is part of your job as a programmer to determine which objects send messages to each other and when. In an object oriented programming language sending a message from one object to another is accomplished by **calling a method** of an object.

Take a look at the following example. It defines two people (objects): Xander and Elysa. Both have their own state (attributes or data) and have certain actions that they can perform (run, sleep, eat, ...). The diagram shows that Elysa is sending a message to (calling the awake() method) Xander who is asleep.

![Objects sending messages](img/objects_sending_messages.png)

While the diagram above is no official standard it does however places a base for the UML standard that will later be used in this course. Note how attributes and methods are separated. It also shows some programming basics such as the parentheses after a name of a method or the naming conventions of the attributes. More on all of this later.

### Quick summary

* Objects are the building blocks of an OO program
* A program is basically a **collection of objects**
* An **object** is an **entity** that contains both data and behavior
  * **Data** represents the state of the object and is represented by **attributes** of the object
  * **Behavior** represents what the object can do in the form of **methods**
* Objects **interact** with each other by sending messages
  * In the form of **method calls**

### Prototype-based languages
Not all object oriented programming languages follow this concept. For example prototype-based languages, a style of object-oriented languages, remove the distinction between classes and instances. In these languages existing objects are used as prototype to create more objects or subtypes of that particular object.

Lets use the idea of "fruit" as one example. A "fruit" object would represent the properties and functionality of fruit in general. A "banana" object would be cloned from the "fruit" object, and would also be extended to include general properties specific to bananas. Each individual "banana" object would be cloned from the generic "banana" object.

The first prototype-oriented programming language was Self, developed by David Ungar and Randall Smith in the mid-1980s to research topics in object-oriented language design. Since the late 1990s, the classless paradigm has grown increasingly popular. Some current prototype-oriented languages are JavaScript (and other ECMAScript implementations, JScript and Flash's ActionScript 1.0), Lua, Cecil, NewtonScript, Io, Ioke, MOO, REBOL, Lisaac and AHk.

## Creating and Using Objects

Object do not just sprout from memory when needed. They are created based on a sort of blueprint.

![Objects are created based on a blueprint](img/object_blueprint.png)

From this point on this blueprint will be called a **class**, while the objects that are created based on this particular class are called it's **instances**. So basically a class is *defined* and instances of this class called objects are created from it.

Metaphorically you can compare creating objects with baking cookies.

The dough we use is basically the computer memory we have at our disposal.

![Cookie Dough - Computer memory](img/dough.jpg)

The template for our cookie is the class.

![Cookie Template - Class](img/template.jpg)

The resulting cookies are the instances of the class called objects.

![Baked Cookies - Object instances](img/cookies.jpg)

When we create objects we instantiate totally distinct instances of a class. **Each object contains its own copy of the data**. This means that if you change the data of one object, it will not affect the data of another object; at least not for primitive data types as we will see later on.

Creating objects (instances of a class) in Java is done using the `new` keyword. The `new` keyword is then followed by a call to a **constructor**. The constructor is a special method that **initializes** the new object. The constructor has the **same name as the class**. More on this later.

To be able to use the object, it needs to be accessible through a variable. For this reason the result of the `new` operator (a **reference** to the object) is stored in a variable.

Let us take a look at a simple example where we create an object of type `Rectangle`. Make sure to import the package `javafx.scene.shape.Rectangle;`.

```java
Rectangle livingRoom;
livingRoom = new Rectangle();

Rectangle bedroom = new Rectangle();

System.out.println("Living room: " + livingRoom);
System.out.println("Bedroom: " + bedroom);
```

Which outputs:

```text
Living room: Rectangle[x=0.0, y=0.0, width=0.0, height=0.0, fill=0x000000ff]
Bedroom: Rectangle[x=0.0, y=0.0, width=0.0, height=0.0, fill=0x000000ff]
```

The first part `Rectangle livingRoom` or `Rectangle bedroom` is actually the same syntax as used with a variable of a primitive type such as `int` or `double`. You first specify the type, in this case it is the **name of the class** instead of the primitive type, and next you choose a **name for your variable**.

Similar to initializing a primitive variable, you can also split the **declaration** and **initialization** in two lines. However most often you will see this being done using a single line of code.

Next comes the assignment using the assignment operator `=`. The next part consists of the `new` operator followed by the **call to a constructor** of the class, which returns a **reference to an object** of the class.

### Calling Methods on an Object

Objects store data but also have a behavioral part. This means that objects can perform actions that are defined for that class. The actions that an object can perform are called the `methods` of the object or class. For example a class `Radio` could have methods `turnOff()`, `turnOn()`, `changeFrequency()`, `setVolume()`, ...

In the example above the `Rectangle` has the methods such as `setWidth()`, `setHeight()`, `getX()`, `getY()`, `getWidth()`, ... More information can be found at [https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html).

To call a method we need to specify its name followed by round brackets. However you cannot just state `getWidth()`. Java will not know for which object to call the method. So when calling a method of an object, you also need to make clear to Java what method of which object needs to be called. This is done using the `.` (dot) operator as shown in the following code example.

```java
Rectangle bedroom = new Rectangle();

double width = bedroom.getWidth();

System.out.println("Bedroom: " + bedroom);
System.out.println("Width of bedroom: " + width + " meters");
```

Which outputs:

```text
Bedroom: Rectangle[x=0.0, y=0.0, width=0.0, height=0.0, fill=0x000000ff]
Width of bedroom: 0.0 meters
```

You actually already have used this syntax when printing information to the console:

```java
System.out.println("Println() is a method");
```

Methods often take information, use that information to manipulate the object the method is called on, and sometimes also output a result. So actually a method can considered to be a small process system on its own. It has a state (that of the object), it takes inputs and it can generate an output. The inputs to the method are called it's **arguments**. The output is called the **return value**.

Consider the example below where we set the width and the height of the bedroom object. The print statements show the before and after state of the object.

```java
Rectangle bedroom = new Rectangle();

System.out.println("Bedroom: " + bedroom);

bedroom.setWidth(12.8);
bedroom.setHeight(8.6);

System.out.println("Bedroom: " + bedroom);
```

Which outputs:

```text
Bedroom: Rectangle[x=0.0, y=0.0, width=0.0, height=0.0, fill=0x000000ff]
Bedroom: Rectangle[x=0.0, y=0.0, width=12.8, height=8.6, fill=0x000000ff]
```

How does one know which classes are available from Java and what methods the objects of these classes contain? Simple, google or the Java API documentation [https://docs.oracle.com/javase/8/docs/api/index.html](https://docs.oracle.com/javase/8/docs/api/index.html).

### The ArrayList class

While arrays allow us to store multiple items of a certain type in a single place they do have their limitations. The biggest one is that an array has a
predefined length that cannot be changed. If you wish to add more items you need to create a new array and copy the item from the original array to the new array.

This is where the `ArrayList` class comes in to play. It allows us to store items in a container without having to give the storage capacity beforehand. When items get added, the size of the ArrayList is automatically increased.

Each ArrayList instance (object) has a certain capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the number of elements. As elements are added to an ArrayList, its capacity grows automatically. The details of the growth policy are not specified.

An ArrayList is a **sequential list**. So, the order of the elements will not change.

More information about the ArrayList class can be found at [https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).
