## Collections in Java

<!-- toc -->

### Introduction

While arrays allow us to store multiple items of a certain type in a single
place they do have their limitations. The biggest one is that an array has a
predefined length that cannot be changed. If you wish to add more items you need to
create a new array and copy the item from the original array to the new array.

This is where collections come in to play. They allow us to store items in containers
without having to give the storage capacity beforehand. When items get added, the size
of the collection is automatically increased.

Arrays are simple structures that only allow indexing based on integral values.
A lot of programming languages have array-like structures that allow indexing based on for
example strings. Typically these are called dictionaries or hashmaps[^1].

[^1]: Dictionaries and hashmaps are actually not part of the collections (they are part of the maps) and are not part of this course. However they are mentioned here to allow you to look them up yourself.

### Java collections

Java provides a set of standard collection classes that implement `Collection` interfaces. Some of the classes provide full implementations that can be used as-is and others are abstract classes, providing skeletal implementations that are used as starting points for creating concrete collections.

The standard collection classes are summarized in the following overview.

![Java Collections Hierarchy[^1]](img/java_collection_hierarchy.png)

[^1]: Source: http://www.beingjavaguys.com/2013/03/java-collection-framework.html

Collection is the root of the collection hierarchy. A collection represents a group of objects known as its elements. Some types of collections allow duplicate elements, and others do not. Some are ordered and others are unordered. The Java platform doesn’t provide any direct implementations of this interface but provides implementations of more specific sub interfaces, such as Set and List.

The following sections will discuss some of the basic collections that you should be able to
use in your programs.

### The ArrayList

The ArrayList is a resizable-array implementation of the List interface. It **allows** all elements including **null** elements and **duplicates**.

Each ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the list size. As elements are added to an ArrayList, its capacity grows automatically. The details of the growth policy are not specified.

An application can increase the capacity of an ArrayList instance before adding a large number of elements using the ensureCapacity operation. This may reduce the amount of incremental reallocation.

ArrayList is a **sequential list**. So, insertion and retrieval order is the same. If you always add to the end, then each element will be added to the end and stay that way until you change it.

### The Stack

A stack is a container of objects that are inserted and removed according to the last-in first-out (LIFO) principle. In the pushdown stacks only two operations are allowed: push the item into the stack, and pop the item out of the stack. A stack is a limited access data structure - elements can be added and removed from the stack only at the top. push adds an item to the top of the stack, pop removes the item from the top. A helpful analogy is to think of a stack of books; you can remove only the top book, also you can add a new book on the top.

![Stack actions[^1]](img/stack.png)

[^1]: Source: https://www.cs.cmu.edu/~adamchik/15-121/lectures/Stacks%20and%20Queues/Stacks%20and%20Queues.html

The Stack is a bit similar to the ArrayList as it also **allows** both **null** elements and **duplicates**. The Stack is also a **sequential list** that preserves the order of the elements.

### The for-each loop

The for-each loop construct is a simplified for-loop specially made to iterate over the elements of arrays and collections.

Let's first take a look at an example of a normal for-loop used to print the elements of an array of strings.

```java
String[] fruits = new String[] { "Orange", "Apple", "Pear", "Strawberry" };

System.out.println("Current Fruits: ");
for (int i = 0; i < fruits.length; i++) {
  System.out.println(fruits[i]);
}
```

This can be simplified using a for-each loop as follows:

```java

String[] fruits = new String[] { "Orange", "Apple", "Pear", "Strawberry" };

System.out.println("Current Fruits: ");
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

Note how the local variable `fruit` gets the value of the next element on each iteration.

While fruits is a simple array in this case, it can perfectly be replaced by a collection such as an ArrayList without having to change the for-each loop.

### An undo example program

The following code will allow the user to build a text line by line. By using a `Stack` it becomes very easy to build in an *undo* mechanism.

```java
public static void main(String[] args) {
    // TODO code application logic here

    Stack<String> text = new Stack();
    Scanner console = new Scanner(System.in);

    boolean keepAdding = true;
    do {
        System.out.print("\nEnter next part of text or UNDO to undo and STOP to stop: ");

        String input = console.nextLine();
        if (input.equals("STOP")) {
            keepAdding = false;
        } else if (input.equals("UNDO")) {
            text.pop();
        } else {
            text.push(input);
        }

        System.out.println("\nCurrent text: ");
        for (String line : text) {
            System.out.println(line);
        }
    } while (keepAdding);
}
```
