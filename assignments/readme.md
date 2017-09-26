# Assignments

Create a new project for each assignment. Give it the same name as the exercise. If the exercise consists of multiple steps than you should code all these in the same project. Do not create new projects for each step.

Make sure to upload your solution to the git remote. Also do not forget to add a `README.md` report file to each assignment.

* [Function Printer](2017/function_printer.md)

## Week 1

# Assignment - Function Printer

## Step 1

Create a Java program that can print a linear function as shown below:

```text
y = ax + b
y = 5x + 13
```

The a and b parameters should be variables in your program (you can take integer types for both). Give them an initial value in this first version of your program.

## Step 2

The code below can be used to read 2 integral values from the terminal. This way the user of the program can enter them. It is not a problem that you do not understand the code, but try to read it and find out what happens.

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Please enter the a-parameter: ");
int a = scanner.nextInt();
System.out.print("Please enter the b-parameter: ");
int b = scanner.nextInt();
```

Now place this block of code in the correct place in your code so the user can first enter both parameters for the linear function.

What happens when you do not enter an integral value but for example a floating point number of a character?

## Step 3

Determine the "y-intercept" (where x is 0) and the "x-intercept" (where y is 0). Print them for the user as shown below:

```text
Please enter the a-parameter: 2
Please enter the b-parameter: -2
y = ax + b
y = 2x + -2
The y intercept = -2.0
The x intercept = 1.0
```

You can use the example above as a check for your program.

# Assignment - Circle Properties

Write a Java program to determine the area and perimeter of a circle. They can be calculated using the formulas below:

```math
area = radius x radius x pi
perimeter = 2 x radius x pi
```

Make sure all the variables are of type `double`.

Print all the parameters to the console (radius, diameter, area and perimeter) so the user had a nice overview.

Allow the user to input the radius of the circle via the console (if you haven't done this yet). You can use the code from the previous assignment. You will have to change the datatype from `int` to `double`.

You can create a variable to hold an approximation to the value of pi. However, Java can supply a more accurate version of PI. Can you find on the Internet how to access/use this value?
