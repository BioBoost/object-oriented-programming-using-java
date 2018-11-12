---
description: This chapter will teach you some basics of the Object Oriented Programming, particularly on using objects.
---

# Chapter 10 - All About Objects

<!-- TODO: Descent intro -->

## Creating and Using Objects

Objects are created based on a blueprint, called a **class**. The objects of a class are also called **instances** of that class. When objects are created, distinct entities are instantiated, meaning that **each object contains its own copy of data**. This means that if you change the data of one object, it will not affect the data of another object.

<!-- Caution needed when using reference types -->

Creating objects (instances of a class) in Java is done using the `new` keyword. The `new` keyword is then followed by a call to a **constructor** method. The constructor is a special method that **initializes** the new object. The constructor has the **same name as the class**.

To be able to use the object, it needs to be accessible through a variable. For this reason the result of the `new` operator (a **reference** to the object) is stored in a variable.

Take a look at the example below that creates a new instance of the `Random` class.

```java
Random generator = new Random();

for (int i = 0; i < 10; i++) {
  System.out.print(generator.nextInt() + " ");
}
```

Which will output 10 random values:

```text
15 81 20 81 16 13 73 24 52 37
```

The first part `Rectangle livingRoom` or `Rectangle bedroom` is actually the same syntax as used with a variable of a primitive type such as `int` or `double`. You first specify the type, in this case it is the **name of the class** instead of the primitive type, and next you choose a **name for your variable**.

Similar to initializing a primitive variable, you can also split the **declaration** and **initialization** in two lines. However most often you will see this being done using a single line of code.

Next comes the assignment using the assignment operator `=`. The next part consists of the `new` operator followed by the **call to a constructor** of the class, which returns a **reference to an object** of the class.

![Creating objects of Classes](img/creating_an_object.png)