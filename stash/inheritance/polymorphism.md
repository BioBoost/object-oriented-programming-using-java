NEEDS TO BE REFACTORED !!!!!!!!!




#### Polymorphism

This comes from Greek and means:
* Poly = many
* Morph = form, shape

So polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.

This basically means that you can do the following in our `Product` example application:

```java
Product canOfTomatoSoup = new Food("Can of tomato soup with meat balls",
        2.99, dateFormat.parse("21/12/2018"));

Product socks = new Clothing("Pair of black socks for men", 3.45, "XL");
Product metallicaShirt = new Clothing("Cool t-shirt of Metallica", 18.99, "L");
```

This is often used when storing subtypes inside and array or container class:

```java

Product listOfProduct[] = new Product[10];

listOfProduct[0] = new Food("Can of tomato soup with meat balls",
        2.99, dateFormat.parse("21/12/2018"));

listOfProduct[1] = new Clothing("Pair of black socks for men", 3.45, "XL");
listOfProduct[2] = new Clothing("Cool t-shirt of Metallica", 18.99, "L");
```

Of course in a realistic application we would populate the list from a database or a file.

Java tracks the actually type of object. This basically means that while all the objects created above
are Products because of inheritance, Java still knows that some are Clothing or Food.

Lets take a look at another example. Take a class `Animal` and two subclasses `Cat` and `Dog`.
We implement a `talk()` method for each of these as shown below.

```java
class Animal {
    public String talk() {
        return "Grrrrr!";
    }
}

class Cat extends Animal {
    @Override
    public String talk() {
        return "Meow!";
    }
}

class Dog extends Animal {
    @Override
    public String talk() {
        return "Woof!";
    }
}
```

Now note that polymorphism allows us to create a single method `lets_hear_it()` that
takes an argument of type `Animal`. When we call it on either type of Animal or subclasses
the correct implementation will automatically be called by Java.

```java
public class AnimalApp {
    public static void lets_hear_it(Animal animal) {
        System.out.println(animal.talk());
    }

    public static void main(String[] args) {
        lets_hear_it(new Cat());            // Meow!
        lets_hear_it(new Dog());            // Woof!
        lets_hear_it(new Animal());         // Grrrrr!
    }
}
```

If we did not have this polymorphic behavior we would have to create a `lets_hear_it()`
method for each type of Animal. This would definitely cause lots of errors and headaches.

So polymorphism is again another technique that allows us to write short, clean and maintainable code.
