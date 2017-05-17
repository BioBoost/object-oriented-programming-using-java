<!-- toc -->

# All About Objects

This chapter will teach you the basics of the Object Oriented Programming.

## Object Oriented Thinking

Object Oriented Programming (OOP) has been around since the early 1960s but it gained only decent momentum since the 1990s. The emergence of the Internet for business and entertainment lies mainly at the base of this popularity gain of OOP.

While this course will teach you the basics of Java and C++ it's main focus will be object oriented concepts and the thought process behind object oriented design of software. If you understand the mechanics behind the object oriented world you will be able to apply it to any OOP language. Concepts stay more consistent over time and evolve at a slower rate. Technologies and programming languages on the other hand evolve quite rapidly. By the time you finish your studies the tools you have learned to use may have become deprecated.

### It's all about objects

What is an object ?

Sounds like a complex question, but the answer is actually really simple. Humans already tend to thinks in terms of objects, without taking to much effort. Students already know about objects, even if they won't realize it.

If you are reading this in a public room, than take a look around you. Try to focus on a person in the room and identify some properties of this person. Some examples could be his/her:

* name
* age
* eye color
* gender
* state (sleeping, walking, ...)
* height
* ...

These properties are often referred to as the **attributes** of an object. They define the data that the object is holding or the state that it is in.

What actions can that person perform ? He/she can:

* walk
* sleep
* talk
* eat
* stand up
* ...

These are called the **methods** of an object. They define the possible behavior or actions of an object.

This leads to a more formal definition of an object:

> #### Definition::Object
>
>  An object is an entity that contains both **data** (*attributes*) and **behavior** (*methods*).

### Talking objects

Most objects will only become useful if they can interact with other objects. Take for example a chair in the middle of a room full of people. The chair is pretty useless until someone decides to sit on it.

Interaction between objects in a software program is accomplished by an object sending a **message** to another. Of course it is part of your job as a programmer to determine which objects send messages to each other and when. In an object oriented programming language sending a message from one object to another is accomplished by **calling a method** of an object.

Take a look at the following example. It defines two people (objects): Xander and Elysa. Both have their own state (attributes or data) and have certain actions that they can perform (run, sleep, eat, ...). The diagram shows that Elysa is sending a message to (calling the awake() method) to Xander who is asleep.

![Objects sending messages](img/objects_sending_messages.png)

While the diagram above is no official standard it does however places a base for the UML standard that will later be used in this course. Note how attributes and methods are separated. It also shows some programming basics such as the parentheses after a name of a method or the naming conventions of the attributes. More on all of this later.

> #### Assignment::Samsung Smart TV
>
>  Search for the specs of a smart TV on the website of an Internet vendor (for example CoolBlue). Can you identify the attributes and methods of the TV?

> #### Assignment::A Pidgey Pokemon
>
>  Take a look at the screenshot below of a Pokemon game. Can you identify the attributes and actions of Pidgey ?

![A Pidgey Pokemon](img/pokemon_pidgey.jpg)

### Quick summary

* Objects are the building blocks of an OO program
* A program is basically a collection of objects
* An object is an entity that contains both data and behavior
  * **Data** represents the state of the object and is represented by **attributes** of the object
  * **Behavior** represents what the object can do in the form of **methods**
* Objects interact with each other by sending messages
  * In the form of method calls

## Objects and Classes

Object do not just sprout from memory when needed. They are created based on a sort of blueprint.

![Objects are created based on a blueprint](img/object_blueprint.png)

From this point on this blueprint will be called a **class**, while the objects that are created based on this particular class are called it's **instances**. So basically a class is *defined* and instances of this class called objects are created from it.

Not all object oriented programming languages follow this concept. For example prototype-based languages, a style of object-oriented languages, remove the distinction between classes and instances. In these languages existing objects are used a prototype to create more objects or subtypes of that particular object.

Lets use the idea of "fruit" as one example. A "fruit" object would represent the properties and functionality of fruit in general. A "banana" object would be cloned from the "fruit" object, and would also be extended to include general properties specific to bananas. Each individual "banana" object would be cloned from the generic "banana" object.

The first prototype-oriented programming language was Self, developed by David Ungar and Randall Smith in the mid-1980s to research topics in object-oriented language design. Since the late 1990s, the classless paradigm has grown increasingly popular.Some current prototype-oriented languages are JavaScript (and other ECMAScript implementations, JScript and Flash's ActionScript 1.0), Lua, Cecil, NewtonScript, Io, Ioke, MOO, REBOL, Lisaac and AHk.

### Baking Cookies

Metaphorically you can compare creating objects with baking cookies.

The dough we use is basically the computer memory we have at our disposal.

![Cookie Dough - Computer memory](img/dough.jpg)

The template for our cookie is the class we define.

![Cookie Template - Class](img/template.jpg)

The resulting cookies are the instances of our class called objects.

![Baked Cookies - Object instances](img/cookies.jpg)

## Creating and using Objects

Before we delve into creating and using objects, consider the following example. A fictive `LightBulb` class that contains the characteristics and the behavior of a simple lightbulb. You can create objects from this class and you can turn each lightbulb on or off.

![A Lightbulb](https://www.lucidchart.com/publicSegments/view/16e1cb4b-efa6-4566-bfff-cfaa5b25210c/image.png)

Creating objects (instances of a class) in Java is done using the `new` keyword. The `new` keyword is then followed by a call to a constructor. The constructor is a special method that initializes the new object. More on this later.

To be able to use the object, it needs to be accessible through a variable. For this reason the result of the `new` operator (a reference to the object) is stored in a variable.

Let us take a look at a simple example where we create an object of type `LightBulb`.

```java
LightBulb kitchenLight;
kitchenLight = new LightBulb();

LightBulb cellarLight = new LightBulb();
```

The first part `LightBulb kitchenLight` or `LightBulb cellarLight` is actually the same syntax as used with a variable of a primitive type such as `int` or `double`. You first specify the type, in this case it is the name of the class instead of the primitive type, and next you choose a name for your variable.

Similar to initializing a primitive variable, you can also split the declaration and initialization in two lines. However most often you will see this being done using a single line of code.

Next comes the assignment using the assignment operator `=`. The next part consists of the `new` operator followed by the call to a constructor of the class, which returns a reference to an object of the class.

### Methods

Objects store data but also have a behavioral part. This means that objects can perform actions that are defined for that class. The actions that an object can perform are called the `methods` of the object or class. For example a class `Radio` could have methods `turnOff()`, `turnOn()`, `changeFrequency()`, `setVolume()`, ...

In the example above the LightBulb has the methods `turnOff()` and `turnOn()`.

To execute the method we need to specify the name followed by round brackets. However you cannot just state `turnOn()`. Java will not know what to turn on. So when calling a method of an object, you also need to make clear to Java what method of which object needs to be called. This is done using the `.` (dot) operator as shown in the following code example.

```Java
LightBulb cellarLight = new LightBulb();

cellarLight.turnOn();
```

You actually already have used this syntax when printing information to the console:

```java
System.out.println("Println() is a method");
```

Methods often take information, use that information to manipulate the object the method is called on, and sometimes also output a result. So actually a method can considered to be a small process system on its own. It has a state (that of the object), it takes inputs and it can generate an output. The inputs to the method are called it's **arguments**. The output is called the **return value**.

Consider the example below. Here a `Point` object is created using a special constructor, one that takes an `x` and a `y` argument to initialize its coordinate attributes. A point objects represents a location in *(x,y)* coordinate space.

```java
Point origin = new Point(0, 0);
```

But how does one know what constructor to call or even which constructors for a class exists. Because there can be more than one constructor for a class, each different in the arguments that they take. Actually either by looking at the code or by looking at the documentation. Luckely there is an extensive documentation system for Java classes that are included with Java. This documentation is called the Java API and can be found at https://docs.oracle.com/javase/8/docs/api/

For example for the `Point` class: https://docs.oracle.com/javase/8/docs/api/java/awt/Point.html
Here you can see that the Point class has three constructors. One that takes no arguments and initializes its attributes x and y to 0. One that takes an x and y as arguments and one that takes another Point as argument. The latter puts the Point at the same location as the Point provided to the constructor.
