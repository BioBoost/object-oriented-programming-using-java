## Assignment - Linear Equation

For this assignment you will need to create an application that can **print linear equations**. A linear equation has the following form:

```math
y = ax + b
```

`a` and `b` are called the **coefficients** of the equation and actually determine the slope and y-intercept point of the equation.

Your application will need to be able to **do two things**:

* request the coefficients from the user
* output the equation and its intercept points (which need to be calculated)

To make your application a bit more user-friendly you should present these options to the user in the form of a **menu** as shown next:

```text
Welcome to the linear equation printer.

Please select a choice from the following options:
1. Input linear coefficients
2. Output equation and intercept points
3. Exit the application

Your choice?
```

### Inputting the coefficients

Allow the user to input the `a` and `b` coefficients when he/she selects the first menu option. Save these values inside variables of type `double` and make sure they are not lost or reset between menu switches. Remember that you can read doubles using the `Scanner` class by calling the `nextDouble()` method.

Example after choosing menu option `1`:

```text
Your choice? 1

Please enter the a-coefficient: 5.7
Please enter the b-coefficient: 3.5

Thank you.

Please select a choice from the following options:
1. Input linear coefficients
2. Output equation and intercept points
3. Exit the application

Your choice?
```

### Outputting the equation and determining the intercept points

If a user selects the second option from the menu, the equation should be printed to the console together with the intercept points.

Outputting the equation is straight forward. Just **print the equation to the terminal** in the following format:

```text
The linear equation: y = 5.7x + 3.5
```

where `5.7` is the a-coefficient and `3.5` is the b-coefficient the user supplied.

Next you need to determine the **y-intercept** (where `x` is `0`) and the **x-intercept** (where `y` is `0`).

In other words:

* `y-intercept: y = b`
* `x-intercept: x = -b/a`

Print them for the user as shown below:

```text
The linear equation: y = 5.7x + 3.5
The y-intercept occurs for y = 3.5
The x-intercept occurs for x = -0.61403
```

Do not worry if the number of decimals after the floating point are a bit different.

You can use the example above as a check for your program.