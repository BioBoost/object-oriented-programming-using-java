---
description: A computer program typically stores and processed data. This chapter focusses on the building blocks available to store and manipulate primitive data types.
---

# Chapter 04 - Storing and processing data

The programs that we create need to store all sorts of data. From basic information such as numbers, characters and strings to complex data types that a programmer can define for himself.

This data is read, stored, manipulated and outputted through our application. The data itself is stored inside the memory of the computer or system the program is running on. Inside your application you do not need to access the memory directly, for this you can make use of variables.

## Variables

A variable is a **symbolic name** for information. The variable's name should represent what information the variable contains. They are called variables because they represent **information that can change**.

Computer memory can be thought of a huge cabinet with millions of small drawers. The content of the drawers is the information stored in memory that we use inside our application. While it is perfectly possible to refer to a drawer using its location (for example second row, third column), it is a lot harder to remember. There is also no link between the location and the actual content of the drawer. Now if we place a label on the drawer that is descriptive enough of its content, which is the analogy of our **variable name**, it is much easier to refer to the drawer using the descriptive name (for example nine inch nails).

![Memory is analogous to a huge cabinet with millions of small drawers](img/drawers_memory.png)

<!-- TODO: Talk about the type of a variable and the size of it -->

## Declaring a Variable

Before a variable can be used inside an application, it needs be **declared**. Declaring a variable can be thought of as stating to the Java interpreter that is needs to request memory for data and make it accessible using a symbolic variable name. Because the Java interpreter needs to know how much memory to set aside, you as a programmer need to specify what **type of data** the variable will hold.

The type of the variable determines the size and layout of the variable's memory; the range of values that can be stored within that memory; and the set of operations that can be applied to the variable.

Once you provided the type and name, the variable can be used to store data.

Let's take a look at an example where a variable stores the age of a person. In this case we need to define the variable to be of an **integral type**. In Java the data type is `int` (integer) for this, which can store **whole signed numbers**.

```java
public static void main(String[] args) {

    // Declaring a variable of type integer
    // and make it accessible using the symbolic name ageOfPerson
    int ageOfPerson;

    // Assign a value to the variable
    ageOfPerson = 31;

    // The variable name can also be used to retrieve the data
    System.out.println("I am " + ageOfPerson + " years old and I am a teacher at VIVES University");
}
```

The data referred to by the variable can be changed using the **assignment operator** `=`. This is basically the same as in math. On the left hand side you have the variable which you want to assign and on the right hand side the value.

When you wish to use the content of the variable, all you need to do is state the symbolic name where you would otherwise use a value.

This also means that one variable can be used to assign a value to another.

```java
public static void main(String[] args) {
  int numberOfStudents;
  numberOfStudents = 36;

  int numberOfEmailAddresses;
  numberOfEmailAddresses = numberOfStudents;

  System.out.println("We have " + numberOfStudents + " students meaning we also have " + numberOfEmailAddresses + " email addresses");
}
```

Note how the variable needs to be declared (created by stating a type and name) before it is used. The following code is therefore flawed and will not run. `numberOfStudents` and `numberOfEmailAddresses` are used before they are declared.

```java
public static void main(String[] args) {
  numberOfStudents = 36;
  numberOfEmailAddresses = numberOfStudents;

  System.out.println("We have " + numberOfStudents + " students meaning we also have " + numberOfEmailAddresses + " email addresses");

  int numberOfEmailAddresses;
  int numberOfStudents;
}
```

> **WARNING** - **Declare a variable before using it**
>
> You must declare a variable before it can be used. This is a rule for many programming languages but not for all. Some programming languages will automatically create variables as they are used.

While the code below is working perfectly, you will not often see it being written like this by a more experienced programmer.

```java
public static void main(String[] args) {
  int numberOfStudents;
  numberOfStudents = 36;
}
```

This because when a variable is declared, you can **immediately initialize it** with a value in a single line of code as shown below.

```java
public static void main(String[] args) {
  int numberOfStudents = 36;
}
```

It is important to always initialize a variable before using it. If you use the variable before initializing it, you may create bugs in your program. Java and NetBeans will not even allow the usage of a variable if it is not initialized. This safety net is not provided by all programming languages. For example C++ will allow you to use uninitialized variables. In this case their value is undetermined and often contains garbage data of the previous program that used that same location in memory.

Take for example the code below:

```java
public static void main(String[] args) {
    int sum;
    System.out.println("Sum = " + sum);
}
```

Forcing Java to run this application will result in a crash:

![Uninitialized Variable](img/uninitialized_variable.png)

## Primitive Data Types

The `int` (integer) data type is called a **primitive data type**. Primitive data types are simple data types that are integrated in the programming language itself (they are most of the time keywords in the language). They form the base of all data storage inside your application. While more complex data types are available, or can even be created by us, in the end it always comes down to primitive data types storing the actual data.

Integer is not the only type that is supported by Java. A full overview of the different primitive data types is given below.

* `byte`: The byte data type is an 8-bit signed two's complement integer. It has a minimum value of -128 and a maximum value of 127 (inclusive). The byte data type can be useful for saving memory in large arrays, where the memory savings actually matters.

* `short`: The short data type is a 16-bit signed two's complement integer. It has a minimum value of -32,768 and a maximum value of 32,767 (inclusive). As with byte, the same guidelines apply: you can use a short to save memory in large arrays, in situations where the memory savings actually matters.

* `int`: By default, the int data type is a 32-bit signed two's complement integer, which has a minimum value of -2^31 and a maximum value of 2^31-1.

* `long`: The long data type is a 64-bit two's complement integer. The signed long has a minimum value of -2^63 and a maximum value of 2^63-1.

* `float`: The float data type is a single-precision 32-bit IEEE 754 floating point. Its range of values is 3.40282347 x 10^38 to 1.40239846 x 10^-45. As with the recommendations for byte and short, use a float (instead of double) if you need to save memory in large arrays of floating point numbers. This data type should never be used for precise values, such as currency.

* `double`: The double data type is a double-precision 64-bit IEEE 754 floating point. Its range of values is 1.7976931348623157 x 10^308, 4.9406564584124654 x 10^-324. For decimal values, this data type is generally the default choice. As mentioned above, this data type should never be used for precise values, such as currency.

* `boolean`: The boolean data type has only two possible values: `true` and `false`. Use this data type for simple flags that track true/false conditions. This data type represents one bit of information, but its "size" isn't something that's precisely defined.

* `char`: The char data type is a single 16-bit Unicode character. It has a minimum value of 0 and a maximum value of 65,535 inclusive.

> **HINT** - **String is not a primitive datatype**
>
> Note that String is not listed above as a primitive datatype. That is because Strings are actually objects. More on this later.

Examples of variable declarations of different primitive data types:

```java
int numberOfStudents = 55;              // Simple integer

char startOfAlphabet = 'a';              // Characters (from the alphabet) or other symbols
char dollarSign = '$';
char endOfLine = '\n';

// Floating point numbers
float averageWaterUsage = 3870.35478;  
double averageStudentScore = 12.5;      

// Booleans can only be true or false
boolean isOlderThanEighteen = true;
boolean isStillATeenager = false;
```

A string in Java is always placed between double quotes, for example `"Hello my name is Nico"`. A single character is placed between single quotes, as also seen in the example code above. Special characters, such as an end-of-line `'\n'` can also be stored in a variable of type char. A character preceded by a backslash `\` is an escape sequence and has special meaning to the compiler.

These escape characters can be used inside a string or can be stored in a variable of type `char`.

## Mathematical Operators

The Java programming languages has a lot of operators. Two operators have already been discussed, namely the assignment operator `=` and the string concatenation operator `+`.

The most basic operators are the mathematical operators. They are easy to understand because they have the same functionality as in math. The following operators are available to do basic math operations:

* `+` Additive operator (also used for String concatenation)
* `-` Subtraction operator
* `*` Multiplication operator
* `/` Division operator
* `%` Remainder operator

These operators are part of the **binary operators** because they take **two operands**, namely a left and a right operator. For example in the summation below `L` is the left operand and `R` is the right operand. The result of the operation is stored in the variable `sum`.

```java
int R = 14;
int L = 12;

int result = L + R;     // Result is now 26
```

The `+`, `-` and `*` operators function the same as in math. Their use can be seen in the code below.

```java
int a = 2 + 3;      // a = 5
int b = a + 5;      // b = 10

int c = 6 * b;      // c = 60
int d = c - 120;    // d = -60
```

The division and remainder operators deserve some special attention. The division operator has a different result based on the types of its left and right operand. If both are of an integral type (`short`, `int`, `byte`) then a whole division will be performed. Meaning that `3 / 2` will result in `1`. If either operand is a floating point operand (`float` or `double`) than the division operator will perform a real division: `3.0 / 2` will result in `1.5`.

If your operands are of integral type and you wish to perform a real division, you can always multiply one of the operands with `1.0` to explicitly convert it to a floating point number without having to change its actual data type. Let us take a look at some examples.

```java
int x = 5;
int y = 2;

int z = x / y;              // z = 2 (whole division)
double w = x / y;           // w = 2.0 (still whole division)
double q = 1.0 * x / y;     // w = 2.5 (real division)

double a = 3.0;
double b = 2;       // 2 will actually be converted to 2.0

double k = a / b;   // k = 1.5 (real division)
```

Notice that even `double w = x / y;` results in `2.0`. The reason behind this is that `x / y` equals to `2` as it is a whole division since both operand are of integral type. The result is then implicitly converted to a double, and stored in `w`.

While the precedence (order) in which mathematical operations are performed is defined in Java, most programmers do not know all of them by heart. It is much more clear and simpler to use round brackets `()` to enforce the precedence of the calculations. Take a look at the following piece of code:

```java
int a = 5;
int b = 6;
int c = 10;
int d = 2;

int result = a * b + c - d * a / 5 - 3;     // result = 35

System.out.println("The result is " + result);
```

The result of the code above is `35`. Would you have known? By using round brackets this becomes much clearer and the chance of making a mistake is a lot smaller.

```java
int a = 5;
int b = 6;
int c = 10;
int d = 2;

int result = (a * b) + c - (d * a / 5) - 3;     // result = 35

System.out.println("The result is " + result);
```

### Compound Operators

Programmers are very lazy creatures that are always looking for ways to make their life's easier. That is why the compound operators were invented. They are a way to write shorter mathematical operations on the same variable as the result should be store in.

```java
int x = 5;

x += 4;   // Same as writing x = x + 4;
x -= 4;   // Same as writing x = x - 4;
x *= 4;   // Same as writing x = x * 4;
x /= 4;   // Same as writing x = x / 4;
x %= 4;   // Same as writing x = x % 4;
```

### Increment and Decrement

Incrementing (+1) and decrementing (-1) a variable is done very often in a programming language. It is one of the most used operations on integral values. It is most common used in loop-constructs as we will see in this chapter later on.

Because of this a shorter way has been introduced using an increment `++` or decrement `--` operator as shown below.

```java
int i = 5;

i++;    // Same as writing i = i + 1;
i--;    // Same as writing i = i - 1;
```

There is however a caveat to keep in mind. Both operators come in a **suffix** (e.g. `i++`) and a **prefix** (e.g. `++i`) version. The end result of both versions is exactly the same, but there is a difference if you assign their value to another variable while using the increment or decrement operator.

Let us take a look at two examples. First we take a look at the prefix version. In this case the value of `i` will be incremented to 6 before its value assigned to the variable `b`. Meaning at the end of this code both `i` and `b` will have a value of 6.

```java
int i = 5;
int b = ++i;
```

Next we take a look at the suffix version. In this case the value of `i` will first be assigned to `b` before it is incremented. This results in a `b` having a value of 5 and `i` having a value of 6 at the end of the example.

```java
int i = 5;
int b = i++;
```

While this may not seem all that important at the moment we will require to know if once we start to work with arrays (lists).

## Generating Data

The main **goal of an application is to process data**. This data can be requested from the user, read from a file, retrieved from the Internet, be randomly generated, ...

### Requesting User Input

If requesting input from the application user, the application can be made more user-friendly and dynamic.

Requesting user input is not that hard. All one has to do is output a message to the user stating what is expected if him/her and allow the user to input the actual data.

Basically when a user enters something via the terminal, it is considered to be a `String`. If we wish to approach the data as an integer or another type of value, it needs to be **parsed** (converted). Java makes this really simple by providing a `Scanner` for this exact functionality.

#### Integral and Double Values

Below is a code snippet that shows how to use the Scanner to **parse the input from the user as an integer** by asking the Scanner for the `nextInt()`. Do take note that if the user inputted anything else than an integer, the application will crash. Feel free to test this. For the moment this cannot be solved with the knowledge we posses. This will be fixed later in the course.

```java
  // Create a Scanner called console and configure
  // it to get its input from the terminal
  Scanner console = new Scanner(System.in);

  // Next output a message to inform the user what we expect from him/her
  System.out.print("Please enter a number: ");

  // Read the input and parse (convert) it to an integer
  int number = console.nextInt();
  
  // Lets output the value the user inputted
  System.out.println("You entered the value " + number);
```

You will also need to add an import statement for the `Scanner` library at the top of your Java file, just below the `package` statement:

```java
package myjavapackage;

import java.util.Scanner;

// ...
```

If you wish to convert the user's input into a double you can request this from the `Scanner` by calling the `nextDouble()` method as shown in the next code snippet.

```java
  Scanner console = new Scanner(System.in);
  System.out.print("Please enter a floating point number: ");

  // Read the input and parse (convert) it to a double
  double number = console.nextDouble();
  
  System.out.println("You entered the value " + number);
```