## Levels of programming languages

Programming languages are described in levels. **Low-level languages** are close to machine code, high-level programming languages are closer to natural languages. At the most basic level (or "lowest level") is assembly language. This language is just a direct translation of the binary instructions the computer executes - each assembly language instruction directly relates to one in machine code. Thus just as every kind of processor architecture has its own machine code, each processor architecture also has its own assembly language.

An assembly example:

```assembly
LUI  R1, #1
LUI  R2, #2
DADD R3, R1, R2
```

This just did the calculation `1 + 2 = 3`. Very roughly, the first two lines load the numbers "1" and "2" into the computer's memory, and the third instruction tells the computer to add the values together and store the result.

As you can see from the example, assembly language is quite dissimilar to natural languages. Higher level languages both get closer to natural languages and provide more efficient methods of expressing the instructions - thus to implement a given feature for a program in assembly language almost always requires more code than implementing the same feature in a higher level language such as C or C++. Assembly language gives the programmer the ultimate in flexibility and performance, at the expense of complexity and development time.

**High-level languages** look more like natural language with mathematical operations thrown in. These languages require more translation before the computer will understand them, but they are much easier to write. Here's what the same program might look like in a high-level language such as Java:

```java
x = 1 + 2;
```

The variation between different programming languages can be quite extensive.

### Graphical Programming Languages

A little less than fifteen years ago, Mitchel Resnick and friends at MIT introduced a programming environment called Scratch. It provides a new approach to teaching computer programming through a graphical user interface that eliminates the possibility of making certain mistakes common in text-based programming.

Programs are constructed by connecting blocks, each representing some functionality available in the system.

![Scratch Example)(img/scratch_example.png)

The image above shows a simple program that generates a random number and gives the user three goes at guessing it. The shapes of the blocks determine where they can be placed to form an acceptable program.

One of Scratch's strengths is the ease with which students can construct games and animated simulations and stories.  Another strength is the Scratch website itself which provides access to many tutorials and a community of users with programs they've written.

Blocks-based programming is a great way to get started. But, as the size of the programs you want to write grows or you need a feature not available in Scratch, it's time to switch to text-based programming.
