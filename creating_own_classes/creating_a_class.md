## Creating a Class

When creating custom classes in Java it is convention to place the whole class and nothing but the class inside its own Java file. In NetBeans this can be achieved by traversing to `File => New File => Java => Java Class`.

Consider a class that represents a simple lightbulb in your house. The class is called `LightBulb` because the convention in Java for class names is that they should be named using **Pascal Case**.

> #### Info::Pascal Case and camel Case
>
> Pascal case is a subset of Camel Case where the first letter is capitalized. That is, userAccount is a camel case and UserAccount is a Pascal case.
> In Java the convention is that methods names are camel cased while class names are Pascal cased.
> It is easy to remember. Pascal is a proper noun so capitalize the first letter.
camel is a common noun, so you do not capitalize the first letter.

<!-- How to break these? -->

> #### Info::snake_case
> Snake case (or snake_case) is the practice of writing compound words or phrases in which the elements are separated with one underscore character `_` and no spaces, with each element's initial letter usually lowercased within the compound and the first letter either upper or lower case - as in "foo_bar" and "Hello_world".

The newly created file for a `LightBulb` class would contain the following:

```java
package javalightbulbapplication;

public class LightBulb {

}
```

The first line of code states the name of the package to which the class belongs. This allows a programmer to bundle classes together that logically belong together.

> #### Info::Packages
>
> A Java package organizes Java classes into namespaces, providing a unique namespace for each type it contains. Classes in the same package can access each other's package-private and protected members. Java packages can be stored in compressed files called JAR files, allowing classes to be downloaded faster as groups rather than individually. A package allows a developer to group classes (and interfaces) together. These classes will all be related in some way – they might all have to do with a specific application or perform a specific set of tasks. Programmers also typically use packages to organize classes belonging to the same category or providing similar functionality.

Notice the `public` keyword which is called an **access modifier**. An access modifier is a special Java keyword that states **who can access the specified resource**. Access modifiers can be applied to classes, attributes and methods. Java allows a programmer to choose from the following access modifiers when declaring a class:
* The default Java access modifier, which is declared by not writing any access modifier at all. This means that class can only be used by other resources included in the same package. This is why it is also often referred to as package access.
* `public`, meaning that any other resource can make use of this class.

### The Default Constructor

Constructors are special methods that belong to classes and **take care of the creation of objects of that class**. They are **responsible for the initialization** of the newly created objects and they make sure that the freshly created objects are left in a stable and readily usable state.

Constructor methods actually have the exact same name as the class itself.

When a programmer does not define his/her own constructor(s), Java creates one for us, called a **default constructor**. This constructor is not called the default constructor because it is created by default for us, but because **it does not take any arguments**. This constructor is called by default in many situations (from which it gets it name) as will be seen later in this course.

> #### Alert::Default Constructor
>
> Important to know is that once you create your own constructor for a class, you lose the default constructor created by Java. This means that if you wish your class to have a default constructor (one that takes no arguments), you should add one yourself. However, more on this later.

### Creating Objects

To create objects from the `LightBulb` class one just needs to call the default constructor as shown below and save the reference to the new object inside a variable of the same type as the class.

```java
public static void main(String[] args) {
  // Creating a LightBulb object and storing its reference inside a variable
  LightBulb kitchen = new LightBulb();
}
```

For the moment this is all the functionality that LightBulb has. Not much use for us like this.

### UML Class Diagram of LightBulb

In its current state the `LightBulb` class can be visualized using the class diagram shown below.

![Start of a class diagram of LightBulb](img/light_bulb_class.png)

The class shape in a class diagram consists of a rectangle with three rows. The top row contains the **name of the class**, the middle row contains the **attributes of the class**, and the bottom section expresses the **methods and/or constructors** that the class has. In a class diagram, classes and subclasses are grouped together to show the relationship between objects of these classes.

Note how the default constructor is added to the list of methods. Constructors are most of the time placed on top in the method list. This because these are the first methods you will need when making use of the class. Also notice the plus sign `+` in front of the constructor. This means that constructor is also `public` as is the class itself. More on access modifiers for methods later in this chapter.
