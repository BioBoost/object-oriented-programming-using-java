


<!-- Dit is overgeslaan -->
### The Default Constructor

Constructors are special methods that belong to classes and **take care of the creation of objects of that class**. They are **responsible for the initialization** of the newly created objects and they make sure that the freshly created objects are left in a stable and readily usable state.

Constructor methods actually have the exact same name as the class itself.

When a programmer does not define his/her own constructor(s), Java creates one for us, called a **default constructor**. This constructor is not called the default constructor because it is created by default for us, but because **it does not take any arguments**. This constructor is called by default in many situations (from which it gets it name) as will be seen later in this course.

> #### Alert::Default Constructor
>
> Important to know is that once you create your own constructor for a class, you lose the default constructor created by Java. This means that if you wish your class to have a default constructor (one that takes no arguments), you should add one yourself. However, more on this later.









### UML Class Diagram of LightBulb

In a class diagram, classes and subclasses are grouped together to show the relationship between objects of these classes.

Note how the default constructor is added to the list of methods. Constructors are most of the time placed on top in the method list. This because these are the first methods you will need when making use of the class. Also notice the plus sign `+` in front of the constructor. This means that constructor is also `public` as is the class itself. More on access modifiers for methods later in this chapter.


### Access Modifiers - Data Hiding

While perfectly legal, in most cases it is considered blasphemy to make attributes `public` unless they are `final`.

> #### Info: Final (instance) variables
>
> Remember that final variables can only be assigned once, that is initialized. Once they are assigned a value, it cannot be changed anymore.

Why would one not make everything public and allow the user of the class access to everything? Because objects should NOT be able to directly change attributes of other objects. This is basically a necessity for two reasons: to **protect the user of the class** from himself and to **protect the class from the user**. *Things that are hidden cannot be misused*.

Restricting access to attributes and certain methods is called **data hiding**. The attributes of a class should always be made private. A user of your class should never be able to change the inner properties directly from outside the class. If you allow users access to the inner workings of your objects they will misuse it. **Declaring an attribute as public breaks data hiding.**

Then how can one than change the state of objects? Simple, by regulating the access to the state of the object using methods. This allows the developer of the class to place safeguards where needed.

Take for example a class `Rectangle` which has a `width` and a `height` attribute. If these were public, there would be nothing to stop us from assigning negative values to these attributes. This would be illogical. In many cases this can introduce bugs that the developer of the class never saw coming. By adding methods to set these attributes, the values can be checked for sanity.

### LightBulb Attributes

Let us consider a modern lightbulb which can be turned on, turned off or even dimmed. With that in mind one can identify the state of the lightbulb to be an integer value between 0 and 255, where 0 is off and 255 is full on.

Knowing this the LightBulb class can be extended by adding an attribute `brightness` of type integer. Keeping the *data hiding* principle in mind, the access modifier is chosen to be `private.` This results to the code shown below. From now on the name of the package will be omitted to save place.

```java
public class LightBulb {
  // Attributes (instance variables) of the class
  private int brightness = 0;
}
```

Note that we also initialize the brightness value to `0`, even while Java will do the same for us. This makes our code more clear to other programmers.

The actual usability of our lightbulbs has not yet changed much as the brightness attribute is kept private, meaning it cannot be access from outside of the class. You can try the following code below but it will not be executable.

```java
public static void main(String[] args) {
  // Creating a LightBulb object and storing its reference inside a variable
  LightBulb kitchen = new LightBulb();

  // This will fail as the brightness attribute is set to be private
  kitchen.brightness = 15;
}
```

The brightness property is actually a good example of where it could go wrong if we were to make the attributes public. Imagine for example that the brightness actually controls hardware that allows the brightness to be set of a real-world bulb. Now what would stop us from adding this to our code:

```java
kitchen.brightness = 600;
```

If no hardware limitation is at hand it might actually blow up the lamp. That is why you should never allow a user of your class to directly manipulate the attributes of an object. Or what if your were developing some software for a pace maker ...

### UML Class Diagram of LightBulb

UML class diagrams also display the datatype of the attributes. While we use the names of the data types available in Java, this is not actually necessary for a UML class diagram. Some applications are modelled partly before the actual programming language is chosen. In this case general types such as `text`, `integer`, `boolean`, ... are often used. Most programming languages do have some form of these available.

In a class diagram the type of a(n) (instance) variable is displayed after the name of the variable and delimited using a colon `:` as can be seen in the diagram below, which depicts the current state of the `LightBulb` class.

![LightBulb Brightness](img/light_bulb_brightness.png)

Notice that the `private` access modifier is depicted using a minus sign `-` in UML.

## Methods

Methods allow us to **group blocks of code** together and **separate** them from the rest of our code. Using the name of the method we can then ask the compiler/interpreter to execute the code inside of it. This is also known as **calling the method**. Why would we want to do this? Several reasons:
* It **makes our code more clear** to the reader/developer of it, if we name the methods correctly and clearly
* It allows us to call the method from different places, so actually we **reuse parts of our code**. **Code duplication is bad** and easily leads to bugs and what is called spaghetti code (a mess of code).

The fun thing about programming is that a lot of libraries are already available for us packed with things we can use. Take for example the `Scanner` and `String` classes we have been using for some time. On the other hand we, as programmers, can also create our own methods. This allows us to make our code more maintainable and reusable.

Ideally a method should do only one thing, for example:
* display an array
* calculate the area of a shape
* determine the minimal of two numbers
* make the sum of an array of numbers
* ...

A method can be though of as a building block of your application that performs some sort of processing.
* It can take input data to use inside the method via arguments
* It can produce an output value which the called of the method can use

![Method as a Building Block](img/method_processing.png)

The general structure of a method looks like this:

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

* **return_data_type** - A method **may or may not return a value** (a single result value of the method). This can be any of the datatypes used for variables (e.g. `int`, `double`, `char`, references to objects such as `String` and any other types, even arrays such as for example `int[]`). If no value is returned, the *return_data_type* should be set to `void`.

* **nameOfTheMethod** - This is the name of the method. Make it **clear and informative**. Methods should always **start with a lower case letter** and use **camel casing** (an uppercase letter for each following word).

* **list_of_parameters** - Arguments (also called parameters) are **similar to the variables** we have been using. They allow the code that is calling the method to pass data to the method. The arguments can then be used as variables and their usage is **contained to the method itself**. The different arguments in the parameter list are separated from each other using a comma `,`. You need to specify both a type and a name for every parameter. Arguments are optional, methods may contain zero arguments - the parenthesis `()` **are mandatory** even if no arguments are defined. The argument variables only exist within the scope of the method itself (between the curly braces).

* **The method body** - The part from the starting curly brace `{` till the closing curly brace `}` is called the body of the method. You should place the code statements that execute the task of the method between these two curly braces.

* The name of the method and the parameter list are together called the **signature** of the method.

Remember the `main` method where most of our code is placed. Let us take a look at it.

```java
public static void main(String[] args) {
    // TODO code application logic here
}
```

The name of this method is `main` and it is `public`. It also takes an array of Strings named `args` as argument. These are actually parameters that you can pass to the method when you start your application. Notice that the main method does not return a value and therefore has its return type set to `void`. The main method is what is called the **entry point** of your application. It is the first method that is executed when you start your application.

When creating methods inside the class that contains the main method of your program, you will also need to make the method `static`. This means that methods can be called without creating an object from the class. Most methods we create in our own classes should not be `static`. More on this later however. So a method inside the class with main will need to look like this:

```java
<access_modifier> static <return_data_type> nameOfTheMethod(<list_of_parameters>) {
  // Body
}
```

### Calling methods

Calling a method is not that hard. Actually you have already called a couple of methods without realizing it. To call a method you need to state it's name, supply the correct arguments and place parentheses around those arguments. Last but not least you need to place a semicolon `;` at the end.

#### The println method

Let us take a look at the `println` method you have been calling for some time.

```java
System.out.println("Hello and welcome to Java");
```

The actual name of the method here is `println`. The use of `System.out` is not important for the moment. The `println` method takes a single argument, namely a String that will be printed to the terminal.

#### The substring method of String

Let us first take a look at an existing method of the `String` class called `substring`. The following information has been grabbed from the official Java API [https://docs.oracle.com/javase/8/docs/api/java/lang/String.html](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html):

```text
public String substring(int beginIndex, int endIndex)

Returns a new string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.

Examples:
 "hamburger".substring(4, 8) returns "urge"
 "smiles".substring(1, 5) returns "mile"

Parameters:
  beginIndex - the beginning index, inclusive.
  endIndex - the ending index, exclusive.

Returns:
  the specified substring.
```

A graphical representation of this method is shown below. The method can extract a piece of String from a larger String based on the start and end positions you provide the method. The method is called on an object of type `String`, in other words, the method belongs to the class `String`. Also note from the description of the method above that the method is `public` is therefor be used from outside of the `String` class.

It takes two pieces of information as arguments (input data):
* `beginIndex` (of type `int`) that provides the starting point from where the extraction should start
* `endIndex` (of type `int`) that provides the ending point from where the extraction should stop

![A Graphical Representation of substring](img/method_substring.png)

The result of the method is again a value of type `String` that contains a part of the full string.

To call the method we first need to create an object of type `String`. Next we need to provide the input data (arguments) required by the method to perform it's job. Last we need to save the result that the method returns. This is again a `String` reference.

```java
public static void main(String[] args) {
  // We need a string object
  String helloWorld = "Hello World!";

  // Next we call the substring method on the String object and save the
  // result inside another String
  String hello = helloWorld.substring(0, 5);

  // Now we can use the result from the method
  System.out.println(hello);
}
```

which will output:

```text
Hello
```

#### The nextInt method of Scanner

Another example is the Scanner method `nextInt()`. An example is shown below.

```java
Scanner console = new Scanner(System.in);

System.out.print("Please enter a number: ");
int number = console.nextInt();
```

The `nextInt()` method does not take any arguments, however you do need to place the empty parentheses behind its name. It does however return a value of type `int`. This can be assigned to a variable so it can be used later in our code.

#### Java API

A lot of information about all the methods that are available in Java can be found at the API website of Oracle: [https://docs.oracle.com/javase/8/docs/api/](https://docs.oracle.com/javase/8/docs/api/). Try to look up some information on the `Scanner` class and the methods that it has available.

### Creating our own Methods

A method should be kept **as small as possible** to **do a single task**. Often it is stated that a perfect method has no more than 5 lines of code. The shorter the method the easier it will be to understand what it is doing. However, as a beginning programmer this will be hard to achieve.

A method will most often use some sort of input data, do some processing on it and return a result based on it's findings. The input data is often supplied using arguments passed to the method when it is called.

As stated before, arguments are very similar to a variable you create inside your main. They require both a **type** and a **name**. If you wish your method to take multiple arguments, you can separate them using a comma `,`. Important to note is that every argument needs a type, even if multiple arguments have the same type.

#### Where to place your own methods

For the moment there are two places where we can place our own methods:
* Inside our own classes such as `LightBulb`
* Inside the application class where `main` resides. In this case remember to make the method `static` to indicate that it should not be called on an object.

All methods need to be placed between the curly braces `{}` of the class itself. Make sure not to place methods inside the body of other methods. Some examples are shown below.

```java
public class Demo {
  public void someMethod() {
    // This is ok!
  }
}
```

In the same class as the main method (notice the `static` keyword).

```java
public class DemoApplication {
  public static void someMethod() {
    // This is ok!
  }

  public static void main(String[] args) {
      // TODO code application logic here
  }
}
```

Example below is wrong, the method is inside the body of another method.

```java
public class DemoApplication {
  public static void main(String[] args) {

    public static void someMethod() {
      // This is NOT OK!
    }

  }
}
```

The order of the methods has no influence. You can place them in any order inside the class body.

#### Naming your Methods

Giving your methods a clear name is very important. Methods that have names like *do_something*, *printit*, *count*, ... have no meaning at all. A method should always have a name that says exactly what it is doing. Do not be afraid of longer method names (do however be sensible about it).

There are some rules that are followed by all Java programmers concerning naming things. For methods the rules are:
* always start with a lowercase letter
* don't place spaces, underscores or other special characters between words
* start each consecutive word after the first with a capital letter (this is called **camel casing**)

Some good examples are:
* determineSumOfNumbers
* calculateAreaOfCircle
* getRadiusOfCircle
* isPlayerAlive
* ...

Method names should also reflect the result that they generate. For example `isPlayerAlive()` suggests that it returns a `boolean`, `getRadiusOfCircle()` suggests that it returns a `double`.

#### Methods that do not return a value

One of the most simple methods that can be created is one that prints a hello message to the user stating the purpose of your program.

```java
public class Demo {
  public void printWelcome() {
    System.out.println("Hello and Welcome to this program.");
    System.out.println("Here we print a simple message stating the purpose of the program.");
    System.out.println("This application is made by none other than mister Java Himself.");
  }
}
```

Notice that the return type is set to `void` - because the method actually does not return anything. It just prints some text to the terminal. Also notice that no parameters are needed as the method does not really need any data from outside of the method.

Calling this method inside your main would result in the following code:

```java
public static void main(String[] args) {
  Demo demo = new Demo();
  demo.printWelcome();
}
```

First an object of the class `Demo` is created. After which the method can be called on the object.

Let us extend the `LightBulb` class and add a method that prints some information about the state of the bulb to the screen. A possible implementation is shown below.

```java
public class LightBulb {
  // Attributes (instance variables) of the class
  private int brightness = 0;

  // Method without return value and no arguments
  public void printInfo() {
    if (brightness == 0) {
      System.out.println("Currently the light is turned off");
    } else if (brightness == 255) {
      System.out.println("Currently the light is turned on");
    } else {
      System.out.println("Currently the light is dimmed to a brightness of " + brightness);
    }
  }
}
```

Take note on how the `brightness` attribute can be accessed inside the `printInfo()` method. This is because the method is part of the class and can therefore access the private attributes of the `LightBulb`.

To use this method an object first needs to be instantiated upon which the method can be called. The method does not require any external data so it does not take any arguments. So the parentheses can be left empty.

```java
public static void main(String[] args) {
    LightBulb kitchen = new LightBulb();
    kitchen.printInfo();
}
```

which outputs:

```text
Currently the light is turned off
```

At the moment there is no way to turn the light on or off. Let us add two methods that allow us to do exactly that:
* a method `on()` that turns the bulb on at full brightness (255)
* a method `off()` that turns the bulb off, setting the brightness to 0

The code below shows the implementation of `LightBulb` with both the methods `on()` and `off()`. Neither of these two methods return any data and neither require external data.

```java
public class LightBulb {
  // Attributes (instance variables) of the class
  private int brightness = 0;

  // Method without return value and no arguments
  public void printInfo() {
    if (brightness == 0) {
      System.out.println("Currently the light is turned off");
    } else if (brightness == 255) {
      System.out.println("Currently the light is turned on");
    } else {
      System.out.println("Currently the light is dimmed to a brightness of " + brightness);
    }
  }

  public void on() {
      brightness = 255;
  }

  public void off() {
      brightness = 0;
  }
}
```

The `on()` and `off()` methods are an elegant way of letting us control the brightness of the bulb without giving public access to the brightness attribute itself. This makes sure that we, as developers of the `LightBulb` class, are in full control. They also make it more easy for the users of our class because they do not need to know of the limitations of the brightness. All they see are methods to turn the bulb on or off.

Let's adapt the main method a bit:
```java
public static void main(String[] args) {
    LightBulb kitchen = new LightBulb();
    kitchen.printInfo();
    kitchen.on();         // Turn the light on
    kitchen.printInfo();
    kitchen.off();         // Turn the light off
    kitchen.printInfo();
}
```

which results in the following output:

```text
Currently the light is turned off
Currently the light is turned on
Currently the light is turned off
```

At the moment our `LightBulb` class can be visualized in UML using the following class diagram:

![UML Class Diagram of LightBulb](img/light_bulb_methods_on_off.png)

#### Methods that return a value

Most methods will have some sort of result that they want to share with the code that made the call to the method. It is stated that the method **returns a value**. This is achieved using the `return` keyword in Java followed by a value or the name of a variable.

Methods can return a value without taking arguments. The most simple example would be the previous `printWelcome()` method. However instead of printing the message to the screen we could return it as a value allowing the code that calls the method to decide what to do with it (you could for example write it to a file, send it to a printer or put it into an html file).

```java
public class Demo {
  public String createWelcomeMessage() {
    String message = "Hello and Welcome to this program.";
    message += "Here we print a simple message stating the purpose of the program.";
    message += "This application is made by none other than mister Java Himself.";
    return message;
  }
}
```

Notice how we create a variable `message` of type `String` to create the full message. This makes our code more readable. The eventual message String is then returned by the method by stating `return message` as the last statement in the method. Once the interpreter encounters a return statement it returns the result from the method and jumps back to the place where the method is originally called.

The name of the method has also been changed from `printWelcome` to `createWelcomeMessage`. This because the method does something else compared to the previous one.

Calling this method inside your main would result in the following code:

```java
public static void main(String[] args) {
  // With a variable to store the return value of the method
  Demo demo = new Demo();
  String welcome = demo.createWelcomeMessage();
  System.out.println(welcome);

  // Or without a variable
  System.out.println(demo.createWelcomeMessage());
}
```

Two ways to print the return value of the `createWelcomeMessage()` are shown in the code above. A first stores the return value inside a variable and then prints the value of the variable. A second option consists of immediately passing the return value of `createWelcomeMessage()` to the `println` method. In this code either way works. It is up to you as a developer to decide which of these two options to use.

##### The toString method

In Java every object that is created automatically gets a number of methods that are provided by the Java language. One of these methods is the `toString()` method which is implicitly called when an object reference is placed inside a String context as for example:

```java
public static void main(String[] args) {
  Demo demo = new Demo();

  // Here an implicit call to demo.toString() is made by Java
  System.out.println(demo);

  // You can explicitly call the toString() method
  System.out.println(demo.toString());
}
```

The Java `toString()` method is used when we need a `String` representation of an object. It is defined in the class Object.

For some classes that are part of the Java classes this method generates a sensible result. However custom classes created by ourselves return a cryptic text consisting of the name of the class and a hashed value of its internal state as shown below.

```text
exampleprogram.Demo@15db9742
exampleprogram.Demo@15db9742
```

The result should be a concise but informative representation that is easy for a person to read. It is recommended that all classes override this method and add their own implementation.

This can be achieved by adding the following method to your class (the method signature must be exact and the `override` annotation must also be present):

```java
@Override
public String toString() {
    return super.toString();
}
```

Of course the return statement `return super.toString();` must be changed according to the representation you wish to return.

For the `LightBulb` class we can actually refactor the `printInfo()` method to a `toString()` method and return a `String` instead of printing to the terminal. This also allows the user of our classes to decide what he/she does with the String representation.

For example:
```java
public class LightBulb {
  // Attributes (instance variables) of the class
  private int brightness = 0;

  @Override
  public String toString() {
    if (brightness == 0) {
      return "Currently the light is turned off";
    } else if (brightness == 255) {
      return  "Currently the light is turned on";
    } else {
      return  "Currently the light is dimmed to a brightness of " + brightness;
    }
  }

  public void on() {
    brightness = 255;
  }

  public void off() {
    brightness = 0;
  }
}
```

This would require our main to be refactored to:

```java
public static void main(String[] args) {
    LightBulb kitchen = new LightBulb();
    System.out.println(kitchen);
    kitchen.on();         // Turn the light on
    System.out.println(kitchen);
    kitchen.off();         // Turn the light off
    System.out.println(kitchen);
}
```

Resulting in the following UML class diagram:

![Adding a toString method to LightBulb](img/light_bulb_to_string.png)

Notice how the return datatype of the `toString()` method is also specified in the UML diagram, in the same way as an attribute, by placing a colon `:` after the method and then stating the datatype (`String` in this case).

#### Methods that take arguments

Almost all methods do some sort of processing based on data. This data can be the attributes encapsulated in the class itself or it can be external information that is **passed via arguments** to the method.

Take for example the `setName()` method shown below of the class `User`. It takes two pieces of external information via arguments:
* the `firstname` of the user (as a String)
* the `lastname` of the user (as a String)

This information is then assigned to the internal attributes.

```java
public class User {
  // Attributes
  private String firstname;
  private String lastname;
  private String email;

  public void setName(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public void generateEMailAddress(int yearOfBirth) {
    this.email = firstname + "." + lastname +
      "_" + yearOfBirth + "@vives.be";
  }

  @Override
  public String toString() {
    return firstname + " " + lastname + " <" + email + ">";
  }
}
```

A second method `generateEMailAddress()` makes both use of internal information and external information to generate an e-mail address for the user in the form of "firstname.lastname_yearOfBirth@vives.be". To do this the method requires the year in which the user was born. This is however only required for this method and is therefor not saved as an internal attribute.

By adding a simple `toString()` method we can easily print the personal information of users in a form that can be used inside a mail program such as outlook.

An example application:

```java
public static void main(String[] args) {
  User mark = new User();
  mark.setName("Mark", "Hennep");
  mark.generateEMailAddress(1991);
  System.out.println(mark);
}
```

Which would output:

```text
Mark Hennep <Mark.Hennep_1991@vives.be>
```

As can be seen from the example code above, you can pass values to the method and/or variables. Do note that you have to pass them in the **correct order** and make sure they are of the **correct type**, otherwise your program will not run.

Let us again extend the `LightBulb` class with a method that can set the brightness of the bulb. This method can be called `dim()` and take an integer value which represents the percentage used to determine the actual brightness. This is where the power of data hiding is again shown. Notice how we first check if the brightness percentage is contained within the valid range. If not we limit the brightness to its extreme's.

```java
public class LightBulb {
  // Attributes (instance variables) of the class
  private int brightness = 0;

  @Override
  public String toString() {
    if (brightness == 0) {
      return "Currently the light is turned off";
    } else if (brightness == 255) {
      return  "Currently the light is turned on";
    } else {
      return  "Currently the light is dimmed to a brightness of " + brightness;
    }
  }

  public void on() {
    brightness = 255;
  }

  public void off() {
    brightness = 0;
  }

  public void dim(int percentage) {
    if (percentage < 0) {
      percentage = 0;
    } else if (percentage > 100) {
      percentage = 100;
    }

    brightness = (int)Math.round((1.0 * 255 / 100) * percentage);
  }
}
```

These safeguards can only be placed when access to internal state is regulated via methods. It makes the objects more resilient to errors and also more user-friendly. Note that the names of the arguments have no relation with the variables in the code that calls the method. They are local to the method itself.

The actual calculation of the brightness results in a `double`, which is then rounded by the `Math.round()` method. However this method returns a `long` which cannot be directly assigned to an `int` variable because Java fears loss of data. However here the value is well within range of an integer. Therefore we can force the conversion by placing `(int)` before the resulting value.

`percentage` is a local variable (actually an argument) of the `dim()` method. It only exists within the body of the dim method and can be changed and manipulated as required without actually changing the variable/value that was passed to the method in the calling code. This is because a copy of the actual value is made into the argument. This only works as-is because percentage is of a primitive datatype. The same is not true when passing objects to methods. In this case the object is not copied but the reference to the original object is. That means that the method to which the object reference is passed, has access to the original object and not to a copy of it.

<!-- Should we place a more concise example here of the passing-object-ref -->

Now our main application can finally change the brightness level of our bulb:

```java
public static void main(String[] args) {
    LightBulb kitchen = new LightBulb();
    System.out.println(kitchen);
    kitchen.dim(50);         // Turn the light on for 50%
    System.out.println(kitchen);
    kitchen.dim(500);        // Turn the light on for 500% !!!!!
    System.out.println(kitchen);
    kitchen.off();             // Turn the light off
    System.out.println(kitchen);
}
```

Which would output:

```text
Currently the light is turned off
Currently the light is dimmed to a brightness of 127
Currently the light is turned on
Currently the light is turned off
```

When the percentage exceeds the valid range, the brightness is set to its legal maximum (255). This results in the output text stating that bulb is turned on.

Again the UML diagram of `LightBulb` can be updated with the `dim()` method this time. Arguments of methods are placed between the parentheses following the same conventions of attributes, namely the *name* followed by a colon `:` and a *datatype*.

![Dim method of LightBulb](img/light_bulb_dim.png)

#### Methods that take arguments and return a result

Last but not least methods can take arguments and return a value. The example code below shows a method `square()` of a class `MathHelper` that calculates the square of a number.  The input data is a number of type `int` and the return value would be `number * number` also of type `int`.

```java
public class MathHelper {
  public int square(int number) {
    return number * number;
  }
}
```

Notice that no variable is created to hold the value of `number * number` inside the method. Instead, the value is immediately returned. While it would not have been wrong to create a temporary variable to hold the result, it would make the code longer than needed.

Calling this method inside your main would result in the following code:

```java
public static void main(String[] args) {
  MathHelper helper = new MathHelper();
  System.out.println("The square of 5 is " + helper.square(5));
}
```

### Functions and Procedures

Some programmers also speak about functions and procedures. However for object oriented languages this is not entirely correct. Functions and procedures are part of functional programming languages such as C. In those languages a procedure is a function that does not return a result value. In object oriented programming this distinction is not made and they are all called methods. Of course some object oriented languages allow you to define methods that are not part of a class, in this case the name functions can be considered correct.

### Magic Values Cleanup

Remember that a previous chapter stated that literal values inside your code are often a bad idea as they represent *magic values*. Take a look at the end result of the `LightBulb` class. We often used magic values such as `0` and `255`. Our code would be come a lot more maintainable if we were to replace these magic values with a `final` attribute initialized to these values. For example `MIN_BRIGHTNESS` and `MAX_BRIGHTNESS`.

Current `LightBulb` class

```java
public class LightBulb {
  // Attributes (instance variables) of the class
  private int brightness = 0;

  @Override
  public String toString() {
    if (brightness == 0) {
      return "Currently the light is turned off";
    } else if (brightness == 255) {
      return  "Currently the light is turned on";
    } else {
      return  "Currently the light is dimmed to a brightness of " + brightness;
    }
  }

  public void on() {
    brightness = 255;
  }

  public void off() {
    brightness = 0;
  }

  public void dim(int percentage) {
    if (percentage < 0) {
      percentage = 0;
    } else if (percentage > 100) {
      percentage = 100;
    }

    brightness = (int)Math.round((1.0 * 255 / 100) * percentage);
  }
}
```

Replacing the magic values with constant variables/attributes makes the code more clean and maintainable.

```java
public class LightBulb {
  // Final attributes
  private final int MIN_BRIGHTNESS = 0;
  private final int MAX_BRIGHTNESS = 255;
  private final int MIN_PERCENTAGE = 0;
  private final int MAX_PERCENTAGE = 100;

  // Attributes (instance variables) of the class
  private int brightness = MIN_BRIGHTNESS;

  @Override
  public String toString() {
    if (brightness == MIN_BRIGHTNESS) {
      return "Currently the light is turned off";
    } else if (brightness == MAX_BRIGHTNESS) {
      return  "Currently the light is turned on";
    } else {
      return  "Currently the light is dimmed to a brightness of " + brightness;
    }
  }

  public void on() {
    brightness = MAX_BRIGHTNESS;
  }

  public void off() {
    brightness = MIN_BRIGHTNESS;
  }

  public void dim(int percentage) {
    if (percentage < MIN_PERCENTAGE) {
      percentage = MIN_PERCENTAGE;
    } else if (percentage > MAX_PERCENTAGE) {
      percentage = MAX_PERCENTAGE;
    }

    brightness = (int)Math.round((1.0 * MAX_BRIGHTNESS / 100) * percentage);
  }
}
```

Notice that the last magic number `100` is not replaced by `MAX_PERCENTAGE`. This is because it actually is not the maximum percentage that the user can set. It is just a dividend to convert a number to a percentage. The minimum and maximum percentages allow us to limit the output brightness of the bulb. We could for example state that the maximum output percentage is 90% because then the lifespan of a bulb will be 1/3 longer (just a speculation here to make a point).


## Constructors

In object-oriented programming, a constructor is a special type of method called to create an object. It prepares the new object for use, often accepting arguments that the constructor uses to set required member variables.

A constructor resembles an instance method, but it differs from a method in that it has **no explicit return type**. In Java constructors have the **exact same name as the declaring class**. They have the task of initializing the object's data members. A properly written constructor leaves the resulting object in a **valid state**.

Most languages **allow overloading** the constructor in that there can be more than one constructor for a class, with differing parameters. Java is one of those languages.

Constructors are most of the time placed on top in the method list of the UML class diagram. This because these are the first methods you will need when making use of the class.

### Creating new Objects

When creating new objects (instances) from classes in Java you need a couple of things:
* Most of the time you need a reference to new object in the form of a variable
* The `new` keyword to indicate to Java that you wish to create a new object from a certain class
* The type of the variable (which is in most cases the name of the class)
* The name of the constructor that needs to be called to initialize the new object.

![Creating an Object](img/creating_an_object.png)

As mentioned before a class can have multiple constructors. Take for example the `Rectangle` class from JavaFX [https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html).

![Multiple Constructors](img/rectangle_constructors.png)

These give the freedom to the user of the class to tailor the initialization of the new objects to his/her needs. Do note that the constructors do not differ in name but do differ in the arguments that they take. Either the number of arguments or the types need to be different so Java can determine which constructor you are actually requesting. More on this later.

### Custom Constructor

When defining a constructor you should first determine what information is minimally required to initialize a new object of the class.

Let us take a look at a class `Player` that has an attribute `nickname` of type `String`. Because a player object is considered invalid if it has no nickname, a constructor is added that takes the nickname as an argument.

```java
public class Player {
  // Attributes
  private String nickname;

  // Constructor with arguments
  public Player(String nickname) {
    this.nickname = nickname;
  }
}
```

When creating Player objects the developer is required to provide a nickname for the Player object as is shown below:

```java
Player lebowski = new Player("The Big Lebowski");
```

### The Default Constructor

The default constructor is a special constructor that takes no arguments. It initializes the object in a default state.

If you do not provide a constructor for a class, Java will automatically create a default constructor that has no parameters. This default constructor is called if you specify the new keyword without passing parameters. For example:

```java
Rectangle livingRoom = new Rectangle();
```

**If you explicitly declare any constructors for a class, Java does not create a default constructor for the class**. As a result, if you declare a constructor that accepts arguments and still want to have a default constructor (with no arguments), you must explicitly declare a default constructor for the class.

Taking the previous Player example the code will not compile in the current state because we added a constructor to the class and thereby lost the default (no-argument) constructor:

```java
Player guest = new Player();
```

So to fix this we can add a default constructor to the class that for example generates a random nickname if none is provided:

```java
public class Player {
  // Attributes
  private String nickname;

  // Constructor with arguments
  public Player(String nickname) {
    this.nickname = nickname;
  }

  // Default constructor
  public Player() {
    Random rand = new Random();
    nickname = "guest_" + rand.nextInt();
  }
}
```

This would allow us to create objects using the default constructor.

### Constructor Overloading

Constructor overloading is a technique in Java in which a **class can have any number of constructors** that differ in parameter lists. The compiler differentiates these constructors by taking into account the number of parameters in the list and their type.

Let us for example take a Complex number class as an example:

```java
public class Complex {
  // Private properties (attributes)
  private int real;
  private int imaginary;

  // Constructor with arguments
  public Complex(int imaginary, int real) {
    this.imaginary = imaginary;
    this.real = real;
  }

  // Default constructor (without arguments)
  public Complex() {
    imaginary = 0;
    real = 0;
  }
}
```

Note how the constructors differ in the arguments they take. Java must be able to differentiate between the constructors in order to be able to select the correct constructor.

Do note that the names of the arguments has no meaning for the compiler to differentiate between different constructors, only the types and number of arguments count. This means that adding the following constructors to a class will fail:

```java
public class Rectangle {
  // ...

  public Rectangle(int width, int height) {
    // ....
  }

  public Rectangle(int x, int y) {
    // ....
  }
}
```

Both constructors look the same for Java. They both take two arguments, each of type `int` and thats it.

### Constructor Reuse

As lazy programmer we are always looking for ways to reuse even the smallest parts of code. This makes our code cleaner and more maintainable and on top of that it makes our life nicer.

Java allows us even to reuse constructors from our classes. In other words, you can call another constructor inside a constructor just by using the `this` keyword as it were a method - not just a method but a constructor method. There are however two **limitations**:
* `this()` can only be called **inside another constructor**
* it needs to be the **first statement inside the constructor** calling `this()`

Take for example the Complex class from before:

```java
public class Complex {
  // Private properties (attributes)
  private int real;
  private int imaginary;

  // Constructor with arguments
  public Complex(int imaginary, int real) {
    this.imaginary = imaginary;
    this.real = real;
  }

  // Default constructor (without arguments)
  public Complex() {
    imaginary = 0;
    real = 0;
  }
}
```

This can be refactored to the following:

```java
public class Complex {
  // Private properties (attributes)
  private int real;
  private int imaginary;

  // Constructor with arguments
  public Complex(int imaginary, int real) {
    this.imaginary = imaginary;
    this.real = real;
  }

  // Default constructor (without arguments)
  public Complex() {
    this(0, 0);
  }
}
```

While the gain is small here, it does make our code cleaner.

Another example from the Oracle website:

```java
public class Rectangle {
    private int x, y;
    private int width, height;

    public Rectangle() {
        this(0, 0, 1, 1);
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    // ...
}
```
The `Rectangle` class contains a set of constructors. Each constructor initializes some or all of the rectangle's member variables. The constructors provide a default value for any member variable whose initial value is not provided by an argument. For example, the no-argument constructor creates a 1x1 Rectangle at coordinates `0,0`. The two-argument constructor calls the four-argument constructor, passing in the `width` and `height` but always using the `0,0` coordinates. The compiler determines which constructor to call, based on the number and the type of arguments provided when creating a new object of the class.
