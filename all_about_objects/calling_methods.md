## Calling Methods on an Object

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

System.out.println("Bedroom before: " + bedroom);

bedroom.setWidth(12.8);
bedroom.setHeight(8.6);

System.out.println("Bedroom after: " + bedroom);
```

Which outputs:

```text
Bedroom before: Rectangle[x=0.0, y=0.0, width=0.0, height=0.0, fill=0x000000ff]
Bedroom after: Rectangle[x=0.0, y=0.0, width=12.8, height=8.6, fill=0x000000ff]
```

How does one know which classes are available from Java and what methods the objects of these classes contain? Simple, google or the Java API documentation [https://docs.oracle.com/javase/8/docs/api/index.html](https://docs.oracle.com/javase/8/docs/api/index.html).
