## The for loop

Basically a for loop is most often used when the number of iterations is pre-determined. A typical example would be a list of items where an actions needs to be applied to each item in the list.

The for loop adheres to the following construction template:

```java
for (initialization ; condition ; increment) {
  // Code block
}
```

* The **initialization** statement is executed only once before the loop mechanism is started.
* The **condition** is checked before each iteration and will determine if the code block is executed or not
* The **increment** expression is invoked after each iteration through the loop. Most often this expression is used to increment or decrement a condition variable.

Each of these can be left empty. For example an endless loop can be written as:

```java
for (;;) {
  /// Do something forever
}
```

Let's see the most simple example possible. A simple for loop that outputs the text `"Hello"` 10 times to the terminal.

```java
for (int i = 0; i < 10; i++) {
  System.out.print("Hello ");
}
```

In the example above the initialization step is used to create a local variable `i` which serves as a simple counter. Next the condition is checked and the text is outputted to the terminal. Next `i` is incremented (1 is added). Before the next iteration the value of `i` is checked in the condition and the loop continues.

The last iteration happens when `i` was incremented to 9. The loop is executed a last time and the value of `i` is incremented a last time to 10. Next the condition is checked but not met. The loop is terminated and execution jumps after the for loop.

Want to see the values of i? Use the following code:

```java
for (int i = 0; i < 10; i++) {
  System.out.println(i + ": Hello");
}
```

This outputs:

```text
0: Hello
1: Hello
2: Hello
3: Hello
4: Hello
5: Hello
6: Hello
7: Hello
8: Hello
9: Hello
```

Important to note is that the variable `i` used here has local scope. This means that it only exists in the for-loop. If you wish to know the last value of `i` you can create a variable before the for-loop and skip the initialization step in the for-loop header. The code below shows an example of this. Do note that you still need to add a semicolon in the for-loop header to separate the initialization from the condition part.

```java
int i = 0;
System.out.println("i = " + i + " before for loop");
for (; i < 10; i++) {
  System.out.println(i + ": Hello");
}
System.out.println("i = " + i + " after for loop");
```

This outputs:

```text
i = 0 before for loop
0: Hello
1: Hello
2: Hello
3: Hello
4: Hello
5: Hello
6: Hello
7: Hello
8: Hello
9: Hello
i = 10 after for loop
```
