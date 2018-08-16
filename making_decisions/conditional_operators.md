## Conditional Operators

When creating more complex conditional statements you will need to use the conditional operators to create combinations of conditions.

The table below gives an overview of the available conditional operators in Java.

| Operator | Description |
|---|---|
| && | AND |
| &#124;&#124; | OR |
| ! | NOT |

These work as you know them from the Boolean algebra. The `||` (OR) operator will return `true` if either of the operands evaluate to `true`. The `&&` (AND) operator will return `true` if both operands evaluate to `true`. A logical expression can be negated by placing the `!` (NOT) operator in front of it.

The code example below checks if a person is a child based on it's `age` (between 0 and 14 years of age).

```java
int age = 16;
boolean isAChild = (age >= 0 && age <= 14);      // false
```

> #### Info::De Morgan's Laws
>
> In some cases it can be useful to rewrite complex conditions using De Morgan's Laws (https://en.wikipedia.org/wiki/De_Morgan%27s_laws). Do take note that shorter not always implies more readable or less complex.

<!-- How to break here ? -->

> #### Warning::Lazy evaluation
>
> These operators exhibit "short-circuiting" behavior, which means that the second operand is evaluated only if needed. This is also called lazy evaluations. So for example in an OR statement, if the first operand is truem the outcome must also be true. For this reason the second operand is not checked anymore.
