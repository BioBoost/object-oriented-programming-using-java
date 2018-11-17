---
description: Defining custom methods is a daily job an OOP programmer. This chapter introduces the basics of methods
---

# Methods

Methods allow us to **group blocks of code** together and **separate** them from the rest of our code. Using the name of the method we can then ask the compiler/interpreter to execute the code inside of it. This is also known as **calling the method**. Why would we want to do this? Several reasons:

* It **makes our code more clear** to the reader/developer of it, if we name the methods correctly and clearly
* It allows us to call the method from different places, so actually we **reuse parts of our code**. **Code duplication is bad** and easily leads to bugs and what is called spaghetti code (a mess of code).

The fun thing about programming is that a lot of libraries are already available for us packed with things we can use. Take for example the `Scanner` and `String` classes we have been using for some time. On the other hand we, as programmers, can also create our own methods. This allows us to make our code more maintainable and reusable.

Ideally a method should **do only one thing**, for example:

* display an array
* calculate the area of a shape
* determine the minimal of two numbers
* make the sum of an array of numbers
* ...

A method can be though of as a building block of your application that performs some sort of processing.

* It can take input data to use inside the method via arguments
* It can produce an output value which the called of the method can use

![Method as a Building Block](img/method_processing.png)

## General Form of a Method

The general structure of a method in Java looks like:

```java
<access_modifier> <return_data_type> nameOfTheMethod(<list_of_parameters>) {
   // Code inside method (this is called the body)
   // return <value> or do not return a value in which case the <return_data_type> is void
}
```

* **access_modifier** - It defines the access type of the method (`public`, `protected` or `private`) and it defaults to package access if you specify none;
  
  * `public`: everyone can use the method - depicted with a plus sign `+` in UML.
  * `protected`: only classes that inherit from this class can use the method - depicted with a hashtag `#` in UML. More on this later
  * none specified - package access, meaning only other classes in the same package can call the method - there is no equivalent sign in UML for this (leave empty)
  * `private`: the method can only be used inside the class itself - depicted with a minus sign `-` in UML. Most often private methods are excluded from the UML class diagram as they are of part of the inner workings of the class.

* **return_data_type** - A method **may or may not return a value** (a single result value of the method). This can be any of the data types used for variables (e.g. `int`, `double`, `char`, references to objects such as `String` and any other types, even arrays such as for example `int[]`). If no value is returned, the *return_data_type* should be set to `void`.

* **nameOfTheMethod** - This is the name of the method. Make it **clear and informative**. Methods should always **start with a lower case letter** and use **camel casing** (an uppercase letter for each following word).

* **list_of_parameters** - Arguments (also called parameters) are **similar to the variables** we have been using.
  * They allow the code that is calling the method to pass data to the method. The arguments can then be used as variables and their usage is **contained to the method itself**.
  * The different arguments in the parameter list are separated from each other using a comma `,`. Both a type and a name need to be specified for every parameter.
  * Arguments are optional, methods may require zero arguments.
  * The argument variables only exist within the scope of the method itself (between the curly braces).

* The parenthesis `()` **are mandatory** even if no arguments are defined.

* **The method body** - The part from the starting curly brace `{` till the closing curly brace `}` is called the body of the method. You should place the code statements that execute the task of the method between these two curly braces.

* The name of the method and the parameter list are together called the **signature** of the method.

Remember the `main` method where most of our code is placed. Let us take a look at it.

```java
public static void main(String[] args) {
    // TODO code application logic here
}
```

The name of this method is `main` and it is `public`. It also takes an array of Strings named `args` as argument. These are actually parameters that you can pass to the method when you start your application. Notice that the main method does not return a value and therefore has its return type set to `void`. The `static` keyword you can ignore for the time being.

The main method is what is called the **entry point** of your application. It is the first method that is executed when you start your application.

> **INFO** - **Command Arguments**
>
> An example of arguments that are passed to an application can be seen in the command `git clone https://github.com/BioBoost/object-oriented-programming-using-java`. Here `git` is the name of the application. `clone` and `https://github.com/BioBoost/object-oriented-programming-using-java` are two arguments that are passed to the application so it can act upon this data.
