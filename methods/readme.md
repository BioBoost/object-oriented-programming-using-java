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

Remember the `main` method where most of our code is placed. Let us take a look at it.

```java
public static void main(String[] args) {
    // TODO code application logic here
}
```

The name of this method is `main` and it is `public` (more on this later in chapter about classes). It also takes an array of Strings named `args` as argument. These are actually parameters that you can pass to the method when you start your application. Notice that the main method does not return a value and therefore has its return type set to `void`. The main method is what is called the **entry point** of your application. It is the first method that is executed when you start your application.

When creating methods inside the class that contains the main method of your program, you will also need to make the method `static`. This means that method can be called without creating an object from the class. More on this later however. So a method inside the class with main will need to look like this:

```java
<modifier> static <return_data_type> nameOfTheMethod(<list_of_parameters>) {
  // Body
}
```

A method should be kept **as small as possible** to **do a single task**. Often it is stated that a perfect method has no more than 5 lines of code. The shorter the method the easier it will be to understand what it is doing. However, as a beginning programmer this will be hard to achieve.

A method will most often use some sort of input data, do some processing on it and return a result based on it's findings. The input data is often supplied using arguments passed to the method when it is called.

As stated before, arguments are very similar to a variable you create inside your main. They require both a **type** and a **name**. If you wish your method to take multiple arguments, you can separate them using a comma `,`. Important to note is that every argument needs a type, even if multiple arguments have the same type.

## Calling methods

Calling a method is not that hard. Actually you have already called a couple of methods without realizing it. To call a method you need to state it's name, supply the correct arguments and place parentheses around those arguments. Last but not least you need to place a semicolon `;` at the end.

Let us take a look at the `println` method you have been calling for some time.

```java
System.out.println("Hello and welcome to Java");
```

The actual name of the method here is `println`. The use of `System.out` is not important for the moment. The `println` method takes a single argument, namely a String that will be printed to the terminal.

Another example is the Scanner method `nextInt()`. An example is shown below.

```java
Scanner console = new Scanner(System.in);

System.out.print("Please enter a number: ");
int number = console.nextInt();
```

The `nextInt()` method does not take any arguments, however you do need to place the empty parentheses behind its name. It does however return a value of type `int`. This can be assigned to a variable so it can be used later in our code.

## Where to place your own methods

For the moment the methods that we create ourselves need to be placed **on the same level as the main method**. However take care **not to place it inside the main method**. Take a look at the example code where `yourMethodsGoesHere()` is an exmaple of a custom method. Take notice of its placement. On the same level as main and between the curly braces `{}` of the class. The order of the methods has no influence. So you can place methods above and below main.

```java
package exampleapplication;

/**
 *
 * @author nicod
 */
public class ExampleApplication {

  public static void yourMethodsGoesHere() {
    // Do something
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      // TODO code application logic here
  }
}
```

## Naming Methods

Giving your methods a clear name is very important. Methods that have names like *do_something*, *printit*, *count*, ... have no meaning at all. A method should always have a name that says exactly what it is doing.

There are also some rules that are followed by all Java programmers concerning naming things. For methods the rules are:
* always start with a lowercase letter
* never place spaces, underscores or other special characters between words
* start each consecutive word after the first with a capital letter (this is called **camel casing**)

Some good examples are:
* determineSumOfNumbers
* calculateAreaOfCircle
* getRadiusOfCircle
* ...

## Methods without return

One of the most simple methods that can be created is one that prints a hello message to the user stating the purpose of your program.

```java
public static void printWelcome() {
  System.out.println("Hello and Welcome to this program.");
  System.out.println("Here we print a simple message stating the purpose of the program.");
  System.out.println("This application is made by none other than mister Java Himself.");
}

public static void main(String[] args) {
    // TODO code application logic here
}
```

Notice that the return type is set to `void` - because the method actually does not return anything - and the `static` keyword is placed before the return type. It just prints some text to the terminal. Also notice that no parameters are needed as the method does not really need any data.

Calling this method inside your main would result in the following code:

```java
public static void printWelcome() {
  System.out.println("Hello and Welcome to this program.");
  System.out.println("Here we print a simple message stating the purpose of the program.");
  System.out.println("This application is made by none other than mister Java Himself.");
}

public static void main(String[] args) {
  printWelcome();
}
```

## Methods that return a value

Most methods will have some sort of result that they want to share with the code that made the call to the method. It is stated that the method **returns a value**. This is achieved using the `return` keyword in Java followed by a value or the name of a variable.

Methods can return a value without taking arguments. The most simple example would be the previous method. However instead of printing the message to the screen we could return it as a value allowing the code that calls the method to decide what to do with it (you could for example write it to a file).

```java
public static void createWelcomeMessage() {
  String message = "Hello and Welcome to this program.";
  message += "Here we print a simple message stating the purpose of the program.";
  message += "This application is made by none other than mister Java Himself.";
  return message;
}

public static void main(String[] args) {
    // TODO code application logic here
}
```

Notice how we create a variable `message` of type `String` to create the full message. This makes our code more readable. The eventual message String is then returned by the method by stating `return message` as the last statement in the method.

The name of the method has also been changed from `printWelcome` to `createWelcomeMessage`. This because the method does something else compared to the previous one.

Calling this method inside your main would result in the following code:

```java
public static void main(String[] args) {
  // With a variable to store the return value of the method
  String welcome = createWelcomeMessage();
  System.out.println(welcome);

  // Or without a variable
  System.out.println(createWelcomeMessage());
}
```

Two ways to print the return value of the `createWelcomeMessage()` are shown in the code above. A first stores the return value inside a variable and then prints the value of the variable. A second option consists of immediately passing the return value of `createWelcomeMessage()` to the `println` method.


<!-- ## Methods that take arguments

You could for example create a method that calculates the square of a number. The input data would than be a number and the return value would be `number * number`.


## Methods that take arguments -->




<!-- Voorbeeld programma voor de les: de oppervlakte berekenen van een aantal shapes (circle, rechthoek, triangle, ...). Alles in 1 blok code. Dan daarna beginnen met een aantal methodes te maken. -->


<!-- Some programmers also speak about functions and procedures. However for object oriented languages this is not entirely correct. Functions and procedures are part of functional programming languages such as C. In those languages a procedure is a function that does not return a result value. In object oriented programming this difference is not made and they are all called methods. Of course some object oriented languages allow you to define methods that are not part of a class, in this case the name functions can be considered correct. -->
