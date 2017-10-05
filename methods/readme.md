<!-- toc -->

# Methods

Methods allow us to **group blocks of code** together and **separate** them from the rest of our code. Using the name of the method we can then ask the compiler/interpreter to execute the code inside of it. This is also known as **calling the method**. Why would we want to do this? Several reasons:
* It makes our code more clear to the reader/developer of it, if we name the methods correctly and clearly
* It allows us to call the method from different places, so actually we make our code shorter

Ideally a method should do only one thing, for example:
* display an array
* calculate the area of a shape
* determine the minimal of two numbers
* make the sum of an array of numbers
* ...

The general structure of a method looks like this:

```java
<modifier> <return_data_type> nameOfTheMethod(<list_of_parameters>) {
   // Code inside method (this is called the body)
   // return <value> or do not return a value in which case the <return_data_type> is void
}
```

* **modifier** - It defines the access type of the method (`public`, `protected` or `private`) and it defaults to `protected` if you specify none. We will return to this subject later when we talk about classes.

* **return_data_type** - A method **may or may not return a value** (a single result value of the method). This can be any datatype as used for variables (e.g. `int`, `double`, `String` even arrays such as for example `int[]`). If no value is returned, the *return_data_type* should be set to `void`.

* **nameOfTheMethod** - This is the name of the method. Make is **clear and informative**. Methods should always **start with a lower case letter** and use **camel casing** (a uppercase letter for each following word).

* **list_of_parameters** - Parameters are **similar to the variables** we have been using. They allow the code that is calling the method to pass data to the method. The parameters can then be used as variables and their usage is **contained to the method itself**. The different parameters in the parameter list are separated from each other using a comma `,`. You need to specify both a type and a name for every parameter. Parameters are optional, methods may contain zero parameters - the parenthesis `()` are however mandatory even if no parameters are defined.

* **The method body** - The part from the starting curly brace `{` till the closing curly brace `}` is called the body of the method. You should place the code statements that execute the task of the method between the two curly braces.

* The name of the method and the parameter list are together called the **signature** of the method.

The most simple method could be a method that prints a hello message to the user stating the purpose of your program.

```java
void printWelcome() {
  System.out.println("Hello and Welcome to this program.");
  System.out.println("Here we print a simple message stating the purpose of the program.");
  System.out.println("This application is made by none other than mister Java Himself.");
}
```

Note the return type which is set to `void` because the method actually does not return anything. It just prints some text to the terminal. Also notice that no parameters are needed as the method does not really need any data.


<!-- Voorbeeld programma voor de les: de oppervlakte berekenen van een aantal shapes (circle, rechthoek, triangle, ...). Alles in 1 blok code. Dan daarna beginnen met een aantal methodes te maken. -->


<!-- Some programmers also speak about functions and procedures. However for object oriented languages this is not entirely correct. Functions and procedures are part of functional programming languages such as C. In those languages a procedure is a function that does not return a result value. In object oriented programming this difference is not made and they are all called methods. Of course some object oriented languages allow you to define methods that are not part of a class, in this case the name functions can be considered correct. -->
