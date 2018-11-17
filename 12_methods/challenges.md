## Chapter 12 - Methods - Challenges

### A Parallelogram

Create a class that stores the base and height of a parallelogram.

![Parallelogram](img/parallelogram.png)

Add two methods to the class. One to determine the area and one to determine the circumference of the parallelogram.

Make a small main program to show that the implementation works.

### Circle Properties

Write a `Circle` class that holds the radius of a circle. Also provide methods to calculate the **area**, **circumference** and diameter of the circle.

Make sure all the data types are `double`.

Next create a small main application that allows the user to input the radius of a circle. Output all the properties of that circle after the user inputted the radius.

> **HINT** - **Pi**
>
> You can create a variable to hold an approximation to the value of pi. However, Java can supply a more accurate version of PI. Can you find on the Internet how to access/use this value?

Once this all works alter the `Circle` class method `setRadius()` so it does not allow the user to provide a negative radius. A good option here might be to use the absolute value of that radius. So in other words, take the absolute value of the provided argument and assign that result to the attribute of Circle.