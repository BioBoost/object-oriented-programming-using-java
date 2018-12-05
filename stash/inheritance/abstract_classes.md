NEEDS TO BE REFACTORED !!!!!!!!

### Abstract classes

Abstract classes are classes that cannot be instantiated. In other words you cannot construct objects from it.

A common use of abstract classes is to provide an outline of a class. It can already provide functionality, i.e. some parts of the class are implemented and some parts are just outlined with a method declaration.

While an abstract class cannot be instantiated, you can create a concrete class based on an abstract class (through inheritance), which then can be instantiated. To do so you have to inherit from the abstract class and override the abstract methods, i.e. implement them.

An abstract class does a few things for the inheriting subclass:
* Define methods which can be used by the inheriting subclass.
* Define abstract methods which the inheriting subclass must implement.
* Provide a common interface which allows the subclass to be interchanged with all other subclasses.

A class is mostly made abstract because it contains some abstract methods. An abstract method is a method that is declared without an implementation (without braces, and followed by a semicolon), like this:

```java
abstract void draw();
```

If a class includes abstract methods, then the class itself must be declared abstract, as in:

```java
public abstract class Shape {
  // Notice how we can already add attributes and methods
  private Point origin;

  public Shape(Point origin) {
    this.origin = origin;
  }

   // Declare an abstract draw method
   // (we don't know how to draw this yet => subclass should know)
   abstract void draw();
}
```

When an abstract class is subclassed, the subclass usually provides implementations for all of the abstract methods in its parent class.
However, if it does not, then the subclass must also be declared abstract.

A class can also be made abstract to force the user of the class to create a subclass from the base class and not allow him/her to directly instantiate objects from the base class. This might also be useful if you wanted to add abstract methods in the future.
