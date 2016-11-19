## Inheritance

Inheritance is one of the main pillars of an object-oriented programming language. It allows us to reuse classes, make our code cleaner and more hierarchical.

### An store application example

Let's image we have to build an application to track all the goods that are sold in a specific store. The store owner asked us to create a simple application in Java. Since he only started a few weeks ago his supply of goods is very limited. He currently only sells some food products and some basic clothing.

To start of we create a *Clothing* class and a *Food* class. The UML diagrams of both classes are depicted below.

![Clothing class UML diagram](img/clothing_class_without_inheritance.png)

For the *Clothing* class we define the properties to be a description, a price and a size. The type of size is set to `string` to be able to contain sizes like "XL" and "M".

![Food class UML diagram](img/food_class_without_inheritance.png)

The *Food* class is similar as it also has the properties description and price. On top of those it also has an expiration date of type `Date` (more info on this class can be found at [https://docs.oracle.com/javase/8/docs/api/java/util/Date.html](https://docs.oracle.com/javase/8/docs/api/java/util/Date.html)). Note that it also contain a method `hasExpired()` which returns true if the expiration date is greater than or equal to todays date.

Both classes contain constructors, some getters and a `toString()` method that returns a full description of the product (containing description, price and depending on the class the size or the expiration date).

#### Code always changes

Something to remember is that code evolves. It changes over time as things get added, removed or refactored. Static code will eventually become outdated and die.

So let's take the store example from the previous section as an example. You created the *Clothing* and *Food* class after which your boss shows up and tells you to add a product identifier to all the goods. This means you need to change both classes as shown in the following UML class diagrams.

![Clothing class UML diagram with Product ID](img/clothing_class_without_inheritance_adding_productid.png)

Note that the product id is not added as an argument to the constructor of the class but instead set using a setter method `setProductId()`. This because of the assumption that most of the time the product id will be generated based on the ones that are already taken (product are most likely to be stored in a database).

![Food class UML diagram with Product ID](img/food_class_without_inheritance_adding_productid.png)

Notice that we had to change two classes to add a product id attribute, a getter and a setter. We actually also need to change the implementation of the constructor to generate an id based on the ones already taken. And if we are not careful we might forget to change the `toString()` implementation.

It should feel awkward to change two classes for a single change based on a single property. And what if we had like 10, 20 or a 100 sorts of goods. It would be a days work to add such a simple thing to our application.

Let's be lazier but smarter programmers and take another approach to this problem.

### Back to inheritance

The extension of the classes with a product id can be easily solved (literally minutes, even with 100 different types of products) if we had some sort of general product class that held all the common properties and actions of all the products our client sells. This is exactly what inheritance provides for us.

Inheritance allows a class to inherit (get) the properties and methods of another class. In other words, the **subclass** inherits the states and behaviors from the **base class**. The subclass is also called the **derived class** while the base class is also known as the **super-class**. The derived class can add its own additional variables and methods. These additional variable and methods differentiates the derived class from the base class.

A super-class can have any number of subclasses. But a subclass can have only one superclass. This is because Java does not support *multiple inheritance*.

So going back to our example we could create a `Product` class and put all the common properties of `Clothing` and `Food` in this class. The same can be done for the methods of the `Clothing` and `Food` class. Do take note that the constructor of the `Product` class can only be used to create a general `Product` object and does not know of the `Food` and `Clothing` classes and their more specific properties such as expiration date and size.

![Base class Product UML Diagram](img/product_class_with_inheritance.png)

Also notice how we changed the name of the `productId` attribute to `id`. As it is part of the `Product` class it is not necessary to call it `productId`.

We also provided an implementation for the `toString()` method.

Now our derived class `Clothing` can be refactored to a very simple class with only the specific size attribute, a constructor, a getter and a more specific implementation of `toString()`.

![Dervived Clothing class UML Diagram](img/clothing_class_with_inheritance.png)

Note how we do need to add the necessary arguments of the base class to the constructor in order to make an object of `Clothing`. So to create a piece of clothing we do need to provide it's description, price and size. Description and price are part of the base class `Product` but are inherited by the `Clothing` class.

A similar refactor needs to be done to the `Food` class.

![Dervived Food class UML Diagram](img/food_class_with_inheritance.png)


[TODO: UML of all classes]




### Is-a relationship

The superclass and subclass have “is-a” relationship between them. Let’s have a look at the example below.
