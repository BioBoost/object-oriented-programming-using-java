## Chapter 04 - Storing and processing data - Multiple Choice

1. What has the same result as `counter++`?

    * [ ] `counter += 2;`
    * [ ] `counter += counter + 1;`
    * [ ] `counter = counter + 2;`
    * [ ] `counter = counter + 1;`

2. What is the result of `89 % 4`?

    * [ ] `1`
    * [ ] `2`
    * [ ] `4`
    * [ ] `5`

3. What is the result of `number` after `int number = 7.0 / 2.0;`?

    * [ ] `3.5`
    * [ ] `3.0`
    * [ ] `3`
    * [ ] `4`

4. What is a valid value for a `boolean`?

    * [ ] `true`
    * [ ] `undefined`
    * [ ] `not`
    * [ ] `nill`

5. Suppose you want to store the age of your dog in a variable (the years). What would be the most obvious datatype for this?

    * [ ] `Scanner`
    * [ ] `String`
    * [ ] `char`
    * [ ] `int`

6. What is the result of `11 / 5`?

    * [ ] `0`
    * [ ] `1`
    * [ ] `2`
    * [ ] `3`

7. What is the correct definition of a primitive datatype?

    * [ ] A datatype that is integrated directly into the programming language
    * [ ] A datatype in Java that can only be used to save bytes
    * [ ] A datatype that can only save integral values
    * [ ] A datatype where the name starts with a lowercase letter

8. Which of the data types below is not a primitive datatype?

    * [ ] `int`
    * [ ] `byte`
    * [ ] `float`
    * [ ] `String`

9. What is the result of `83 % 4`?

    * [ ] `0`
    * [ ] `1`
    * [ ] `2`
    * [ ] `3`

10. What is the resulting value in `q`?

    ```java
    int x = 5;
    int y = 2;
    double q = (double) x / y;
    ```

    * [ ] `2`
    * [ ] `2.0`
    * [ ] `2.5`
    * [ ] `3`

11. What is the most correct and complete definition of a variable?

    * [ ] A variable is a symbolic name for a location in memory where the actual data resides.
    * [ ] A variable is a symbolic name for a location in memory where the actual data resides with a size determined by the datatype of that variable.
    * [ ] A variable is a symbolic name for a location in memory where the actual data resides with a size determined by the value with which the variable was initialized.
    * [ ] A variable is a symbolic name for a location in memory where the actual data resides with a size that is not constant.

12. Why are the operators `+`, `-`, `*`, `/`, ... called binary operators?

    * [ ] Because they are also applicable on binary numbers
    * [ ] Because they operandi are represented as binary numbers internally
    * [ ] Because they require two operandi
    * [ ] Because they exist in two versions, a prefix notation and postfix notation

13. Which of the following code blocks makes use of compound operators?

    ```java
    // Code block A
    int x = ( 25 / 3 ) * (15 % 4);
    ```

    ```java
    // Code block B
    int z = 0;
    for (int i = 0; i < 5; i++) {
      int y = i + 5;
      z++;
    }
    ```

    ```java
    // Code block C
    double vatPercent = 21;
    double priceTag = 55;
    double vat = priceTag * vatPercent / 100;
    ```

    ```java
    // Code block D
    int x = 32;
    int y = 88;

    while (x <= 1000) {
      x += 5;
    }
    ```

    * [ ] Code block A
    * [ ] Code block B
    * [ ] Code block C
    * [ ] Code block D

14. Which of the following code snippets will not result in the value of `b` incrementing with `1`?

    * [ ] Snippet A

    ```java
    int x = 15;
    int b = 3;
    x = b++;
    ```

    * [ ] Snippet B

    ```java
    int x = 15;
    int b = 3;
    x += (++b);
    ```

    * [ ] Snippet C

    ```java
    int x = 15;
    int b = 3;
    x = (b + 1);
    ```

    * [ ] Snippet D

    ```java
    int x = 15;
    int b = 3;
    b += 1;
    ```
