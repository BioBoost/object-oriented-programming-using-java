## A Painter with Interfaces

Would it not be a lot cleaner of we would just have **a single list of objects inside Painter that all can be painted** by calling a method `paint()` on each of them? If ever the need arises for the application to be extended with more classes that can be painted, it would not require our `Painter` class to change.

This is where interfaces come into play. They allow us to define what methods a class should implement that want to adhere to the interface. In other words, we can force a class that wants to be **paintable** by our `Painter` class to implement a method `paint()`.

Also very important is that our `Painter` will become dependent on the interface instead of being dependent on the classes that implement the interface. In other words we will **decouple** the `Painter` from the paintables.

An interface is similar to a class in the following ways:
* An interface can contain any number of methods, they do however not provide any implementation
* An interface is written in a file with a `.java` extension, with the name of the interface matching the name of the file.
* Interfaces appear in packages
* An interface can be used as a type

However, an interface is different from a class in several ways:
* You cannot instantiate an interface (you cannot create an object from an interface).
* An interface does not contain any constructor.
* All of the methods in an interface are abstract (no implementation)
* An interface cannot contain instance fields (attributes). The only fields that can appear in an interface must be declared both static and final.
* An interface is not extended by a class; it is implemented by a class.
* An interface can extend multiple interfaces.
* A class can implement multiple interfaces

### A Paintable interface

To realize this, an interface `Paintable` can be created. This name immediately states it's purpose. Classes that implement the interface will become `Paintable`.

The content of the interface is very simple, it only states that methods the class must have to be considered paintable. So for this example:

```java
public interface Paintable {
    // All classes that implement this interface will become
    // paintable by the Painter class
    public void paint();
}
```

### Implementing Paintable

[TODO]