## The ArrayList class

While arrays allow us to store multiple items of a certain type in a single place they do have their limitations. The biggest one is that an array has a predefined length that cannot be changed. If you wish to add more items you need to create a new array and copy the item from the original array to the new array.

This is where the `ArrayList` class comes in to play. It allows us to store items in a container without having to give the storage capacity beforehand. When items get added, the size of the ArrayList is automatically increased.

Each ArrayList instance (object) has a certain capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the number of elements. As elements are added to an ArrayList, its capacity grows automatically. The details of the growth policy are not specified.

An ArrayList is a **sequential list**. So, the order of the elements will not change.

More information about the ArrayList class can be found at [https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).

An example application is shown below. It creates `Rectangle` objects and stores them in the `ArrayList`. The user is asked to supply both the *width* and *height* of the rectangles (which represent rooms of a house).

```java
ArrayList listOfRooms = new ArrayList();
Scanner console = new Scanner(System.in);

double width = 0;
double height = 0;

System.out.println("Please specify width and height of rooms. Enter negative for either to stop.");
do {
    System.out.print("Please enter the width of the chamber: ");
    width = console.nextDouble();

    System.out.print("Please enter the height of the chamber: ");
    height = console.nextDouble();

    if (width > 0 && height > 0) {
        Rectangle room = new Rectangle(width, height);
        listOfRooms.add(room);
    }
} while (width > 0 && height > 0);

for (int i = 0; i < listOfRooms.size(); i++) {
    System.out.println("Room: " + listOfRooms.get(i));
}
```

If you do not understand each line of code above, make sure to read the online documentation of the class and methods.

The example code above makes use of different classes and objects. It shows the actual power of object oriented programming. The instances of the different classes provide a certain functionality, accessible via the methods of the objects of those classes. The different objects interact with one another by sending messages to each other. For example: *the `room` objects that are created in the for-loop actually send a message to the `listOfRooms` with a request to be added to the list.*
