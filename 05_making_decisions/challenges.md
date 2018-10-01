## Challenges

This chapter may require you to request input from the user. This can be achieved by using the code below:

```java
public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    System.out.print("Please enter a number: ");
    int number = console.nextInt();
    System.out.println("You entered the value " + number);
}
```

This code snippet requests a number from the user and stores it in the variable `number`. It then outputs it back to the terminal. Feel free to change the name of the variable to suit your application.

Do note that if you input anything else than a integral number, the application will crash. Don't worry about it for the moment. This will be fixed later on in the course.

### Boolean Expressions

Fill in the table below with the correct outcomes of the boolean expressions.

| A | B | C | Expression | Outcome of Expression |
| --- | --- | --- | --- | --- |
| `false` | `false` | `false` | <code>A && B</code> | |
| `true` | `true` | `false` | <code>(!A) && B</code> | |
| `true` | `true` | `true` | <code>(!A) && (!B) && C</code> | |
| `false` | `false` | `false` | <code>A &#124;&#124; B</code> | |
| `false` | `true` | `false` | <code>!(B && C)</code> | |
| `false` | `true` | `false` | <code>C &#124;&#124; (!C)</code> | |
| `false` | `false` | `false` | <code>!(B &#124;&#124; C)</code> | |
| `false` | `false` | `true` | <code>!((!B) &#124;&#124; (!C))</code> | |
| `false` | `true` | `true` | <code>A && (!A)</code> | |
| `true` | `true` | `false` | <code>((!A) &#124;&#124; (!B) && C) && !C</code> | |

### Check if negative

Start with the code snippet provided at the start of this challenge chapter to request a number from the user.

Now output a message based on the value of number:

* if `number` is negative, output the message: "The number is negative"
* if `number` is 0, output the message: "The number is zero"
* if `number` is positive, output the message: "The number is positive"

Run the application multiple times with different input to test your app.

### Square

Create an application that requests the length of a side of a square. Calculate the circumference and the area. Output both to the user.

For example:
```text
Please enter side of square in meters: 5

The circumference is: 20 meters
The area is: 25 square meters
```

### Minimum and Maximum

Create an application that requests two numbers from the user. Determine which number of the two is the biggest and then output your findings to the user.

For example:
```text
Please enter first number: 15
Please enter second number: 88

The biggest number is: 88
The smallest number is: 15
```