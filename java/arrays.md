## Arrays

<!-- toc -->

### Introduction


### Arrays of object references

Arrays can actually hold any type of elements (each element should however be of the same type within an array).

This means that we can actually create an array of Points.

```java
final int NUMBER_OF_POINTS = 5;

Point[] polygon = new Point[NUMBER_OF_POINTS];
```

What is special about the array above is that it is an array of references to objects. This also implies that all the references are null at this point. In other words if you create an array of object references, all elements are null until you assign them the actual reference.

> #### Hint::Debug to confirm
>
>  You can actually confirm this by setting a breakpoint in NetBeans on the line where you declare the polygon variable. Then take a look at the _Variables_ window as shown in the image below.
>
> ![Confirming that the array contains nulls](img/confirm_netbeans_array_nulls.png)

To fix this we need to assign an object reference to each element of the array as shown in the next code snippet.

```java
final int NUMBER_OF_POINTS = 5;

Point[] polygon = new Point[NUMBER_OF_POINTS];

for (int i = 0; i < NUMBER_OF_POINTS; i++) {
  polygon[i] = new Point();
}
```



We can create arrays of primitive and non-primitive types. Non-primitive types are initialized to null and each element needs to be assigned an object reference before using it.
