## One Dimensional Arrays

An array is a **container object** that holds a **fixed number of values** of a **single type**. The length of an array is established when the array is created. After creation, its length is fixed.

The example code below shows how to declare and create an array of 10 integers:

```java
int[] randomNumbers = new int[10];
```

Notice how square brackets after the element type specify that this is an array.

> #### Info::Info
>
> **An array is actually an object** so the actual creation needs to be done using the `new` operator, at which stage the length of the array also needs to be specified. We'll come back to this later.

A visualization of the array may look something like this:

![An array of 10 integers](img/arrays_of_ten_integers.gif)

Each item in an array is called an element, and each element is accessed by its numerical index. As shown in the preceding visualization, numbering begins with 0 (this is called **zero-indexed**). The 9th element, for example, would therefore be accessed at index 8.

Let us take a look at some code that stores 5 integers requested from the user. Once all numbers are inputted the total and average is calculated and reported back to the user.

```java
Scanner console = new Scanner(System.in);
int[] numbers = new int[5];
int i = 0;
int sum = 0;

do {
    System.out.print("Please enter an integer number: ");
    int number = console.nextInt();
    numbers[i] = number;
    sum += number;
    i++;
} while (i < 5);

System.out.println("\n\nYou entered the following numbers:");
for (i = 0; i < 5; i++) {
    System.out.print(i + " ");
}
System.out.println("\nTotal sum = " + sum + " Average = " + sum/5);
```

From the code above it can be seen that the array elements can be accessed by using `[]` with the index specified between them.

You can also initialize an array by using the following syntax:

```java
int[] anArray = {
    25, 66, 876,
    54645, 0, -10,
    12, 914, 88, 545645
};
```

Here the length of the array is determined by the number of values provided between braces and separated by commas.
