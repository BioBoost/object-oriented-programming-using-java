## Chapter 08 - Arrays - Challenges

### Powers of Two

Create an array called `powersOfTwo` that stores 16 integers. Use a for loop to initialize the values of the array with the powers of `2` as shown in the example below.

![Powers of Two](img/powers_of_two.png)

> **HINT** - **Powers of Two**
>
> To calculate the 5th power of two, you can multiple the 4th power of two with `2`.

Print out the resulting list. An example is shown here:

```text
Below is a list of the powers of from 0 till 15.
0: 1
1: 2
2: 4
3: 8
4: 16
5: 32
6: 64
7: 128
8: 256
9: 512
10: 1024
11: 2048
12: 4096
13: 8192
14: 16384
15: 32768
```

Can you explain the last negative number if you increase the array to `32` numbers?

### Search an Array

Create an array of 100 random numbers. Now ask the user for a number and print **all** the indexes of where the number in the array can be found. Feel free to output the resulting array too.

### Frequency Table of Random Numbers

Generate 1000 random numbers between `0` and `20`. Do not store the numbers themselves that were generated. Instead create a frequency table to store the number of times each value was generated.

For example:

| Index | Counter |
| --- | --- |
| 0 | 7 |
| 1 | 11 |
| ... | ...

Meaning value `0` was generated 7 times out of 1000 and value `1` was generated 11 times out of a 1000.

Print the full frequency table after generating the 1000 numbers.

What did you expect as outcome ? Try increasing the number of values you generate.

### Sorting using Selection Sort

Generate an array of 10 random numbers (with a value below 100 for example). Sort the randomly generated numbers of integers in ascending order. Search the Internet for "selection sort". You will find enough information and examples. Do no copy / paste code, try to implement it for yourself.

Print the list of numbers before and after the sorting.

Example:

```text
Creating an array of 10 numbers:
54 6 2 66 99 31 1 0 87 44

Sorting ascending:
0 1 2 6 31 44 54 66 87 99
```

### Swapping Values

Often when reordering elements in an array (for example when sorting) two values need to be swapped places.

Take the following piece of code and write some code below the first `for` loop to swap the first and the last elements of the `values` array. In other words the arrays should contain the following values after swapping the elements: `3, 2, 1`.

```java
public static void main(String[] args) {
  // Array with 3 values
  int[] values = { 1, 2, 3 };

  System.out.println("Original array:");
  for (int i = 0; i < values.length; i++) {
    System.out.print(values[i] + " ");
  }

  // Write some code here to swap
  // the first and the last element of the array

  System.out.println("\n\nAltered array:");
  for (int i = 0; i < values.length; i++) {
    System.out.print(values[i] + " ");
  }
}
```

### 2D Array Summation

Create a matrix of random integer values. Print it to the terminal together with the sum of each row and each columns in the format shown below.

```text
[ 1   5   16  ] 22
[ 5   4   9   ] 18
[ 3   1   0   ] 4
  8   10  25
```