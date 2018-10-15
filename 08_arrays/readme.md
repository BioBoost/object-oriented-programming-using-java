---
description: Applications often have to process lists of data. To store this information arrays are a basic necessity.
---

# Chapter 08 - Arrays

An array is a **data structure** consisting of a **collection of elements**, each identified by at least one array **index** or **key**. An array is stored so that the **position of each element can be computed from its index** by a mathematical formula. The simplest type of data structure is a linear array, also called **one-dimensional array**.

> **INFO** - **Zero-based indexing**
>
> When information is stored in an array, individual elements are selected by an index that is usually a non-negative scalar integer. An index maps the array to the stored information. Most programming languages use **zero-based indexing** (index starts at 0). This leads to simpler implementation where the index refers to an offset from the starting position of an array, so the first element has an offset of zero.

For example, an array of ten 32-bit (4 bytes) integer variables, with indices 0 through 9, may be stored as 10 words at memory addresses 2000, 2004, 2008, ... 2036, so that the element with index `i` has the address `2000 + 4 × i`. The memory address of the first element of an array is called first address or foundation address.

Arrays are among the oldest and most important data structures, and are used by almost every program. They are also used to implement many other data structures, such as **lists** and **strings**. They effectively **exploit the addressing logic of computers**. In most modern computers and many external storage devices, the memory is a one-dimensional array of words, whose indices are their addresses.

Arrays are useful mostly because the element indices can be computed at run time. Among other things, this feature allows a single iterative statement to process arbitrarily many elements of an array. For that reason, the elements of an array data structure are **required to have the same size** and **should use the same data representation**.

Arrays are often used to implement tables, especially lookup tables; the word **table** is sometimes used as a synonym of array.

> **INFO** - **Lookup Tables**
>
> In computer science, a lookup table is an array that replaces runtime computation with a simpler array indexing operation. The savings in terms of processing time can be significant, since retrieving a value from memory is often faster than undergoing an "expensive" computation or input/output operation. The tables may be precalculated and stored in static program storage, calculated (or "pre-fetched") as part of a program's initialization phase.

Because the mathematical concept of a matrix can be represented as a two-dimensional grid, two-dimensional arrays are also sometimes called matrices.

## One-Dimensional Arrays

An array is a **container object** that holds a **fixed number of values** of a **single type**. The length of an array is established when the array is created. After creation, its length is fixed.

### Creating 1D arrays

A one-dimensional array is created using the following syntax template:

```java
<type>[] <variable_name> = new <type>[<size>];
```

where

* `<type>` can be either a primitive (`int`, `double`, ...) or non-primitive (class) datatype.
* `<variable_name>` is the name of the variable that represents the array.
* `<size>` is a positive integral value indicating how many elements the array consists of.

Notice the square brackets `[]` that declare this variable to be an array of elements of the given type.

The example code below shows how to declare and create an array of 10 integers:

```java
int[] someNumbers = new int[10];
```

> **INFO** - **Arrays are created using `new`**
>
> **An array is actually an object** so the actual creation needs to be done using the `new` operator, at which stage the length/size of the array also needs to be specified.

A visualization of the array may look something like this:

![An array of 10 integers](img/array_of_ten_integers.png)

Each item in an array is called an **element**, and each element is accessed by its numerical index. As shown in the preceding visualization, numbering begins with 0 (this is called **zero-indexed**). The 9th element, for example, would therefore be accessed at index 8.