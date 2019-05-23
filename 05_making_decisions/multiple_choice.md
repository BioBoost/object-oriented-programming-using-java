## Chapter 05 - Making Decisions - Multiple Choice

1. How do we call the `number >= 15` part in the if statement below?

    ```java
    if (number >= 15) {
      System.out.println("Sorry, number is too large");
    }
    ```

    * [ ] The assignment
    * [ ] The initialization
    * [ ] A primitive type
    * [ ] The condition

2. When you wish to check if an integral number differs from another integral number, then you need to use the ... operator.

    * [ ] `==`
    * [ ] `!=`
    * [ ] `>=`
    * [ ] `&&`

3. How many `if else` clauses can we add to an if statement?

    * [ ] Maximum 20
    * [ ] Maximum 100
    * [ ] Limited by the RAM in your computer
    * [ ] There is no limitation

4. What is the output of the following code snippet?

    ```java
    boolean x = false;
    boolean y = true;
    int z = 13;

    if (z > 10 || (x != true && y == false)) {
      System.out.println("Sorry, access denied");
    } else {
      System.out.println("Nice one, access granted");
    }
    ```

    * [ ] `Sorry, access denied`
    * [ ] `Nice one, access granted`
    * [ ] Nothing
    * [ ] It crashes

5. What is the value of `a` that will be printed to the terminal?

    ```java
    int a = 15;
    if (true || (a > 100)) {
        a = a + 2;
    }
    System.out.println("a = " + a);
    ```

    * [ ] `17`
    * [ ] `16`
    * [ ] `15`
    * [ ] `2`

6. Which of the operators below is a comparison operator?

    * [ ] `!=`
    * [ ] `%`
    * [ ] `||`
    * [ ] `[]`

7. What is the resulting value in `E`?

    ```java
    boolean A = true;
    boolean B = false;
    boolean C = true;
    boolean D = (A && B ) || C;
    boolean E = (!D) || (!A);
    ```

    * [ ] `true`
    * [ ] `false`
    * [ ] `null`
    * [ ] `undefined`

8. What condition is required (in place of `<condition_here>`) to get a list of all even numbers between 0 (inclusive) and 100 (exclusive)?

    ```java
    System.out.print("All even numbers between 0 and 100: ");
    for (int i = 0; i < 100; i++) {
        if (<condition_here>) {
            System.out.print(i + " ");
        }
    }
    ```

    * [ ] `i / 2 == 0`
    * [ ] `i * 2 == 0`
    * [ ] `i - 2 == i + 2`
    * [ ] `i % 2 == 0`
