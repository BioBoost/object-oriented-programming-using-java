## Challenges

### Boolean Expressions

Fill in the table below with the correct outcomes of the boolean expressions.

| A | B | C | Expression | Outcome of Expression |
| --- | --- | --- | --- | --- |
| `false` | `false` | `false` | `A && B` | |
| `true` | `true` | `false` | `(!A) && B` | |
| `true` | `true` | `true` | `(!A) && (!B) && C` | |
| `false` | `false` | `false` | `A || B` | |
| `false` | `true` | `false` | `!(B && C)` | |
| `false` | `true` | `false` | `C || (!C)` | |
| `false` | `false` | `false` | `!(B || C)` | |
| `false` | `false` | `true` | `!((!B) || (!C))` | |
| `false` | `true` | `true` | `A && (!A)` | |
| `true` | `true` | `false` | `((!A) || (!B) && C) && !C` | |

### Checking if negative

Write an application that requests a number from the user. Tell the user of the number is negative, positive or 0.