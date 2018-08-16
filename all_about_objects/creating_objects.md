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
