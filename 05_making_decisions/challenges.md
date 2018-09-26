## Challenges

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

Start with the following code:

```java
public static void main(String[] args) {
    int number = 12;
    
    // Check number below and output message
}
```

Now output a message based on the value of number:

* if `number` is negative, output the message: "The number is negative"
* if `number` is 0, output the message: "The number is zero"
* if `number` is positive, output the message: "The number is positive"

Change the value of `number` to test your code.