## Chapter 13 - Constructors - Multiple Choice

1. What do you lose when you add a constructor to a class?

   * [ ] The copy constructor that was generated automatically by Java
   * [ ] The default constructor that was generated automatically by Java
   * [ ] The basic constructor that was generated automatically by Java
   * [ ] The public constructor that was generated automatically by Java

2. What is the most correct description of a constructor?

   * [ ] A method that creates and initializes objects into a valid state
   * [ ] A method that creates objects and makes all methods accessible
   * [ ] A method that creates objects and gives it a name
   * [ ] A method that creates a class and allows you to make multiple objects

3. How do we call the constructor depicted in the code snippet below?

    ```java
    public class Point {
      private double x;
      private double y;

      // ...

      public Point(Point original) {
        this(original.x, original.y);
      }
    }
    ```

   * [ ] A copy constructor
   * [ ] A default constructor
   * [ ] A basic constructor
   * [ ] A public constructor

4. Which code block contains a default constructor?

    ```java
    // Code block A
    class Foo {
      public Bar() {
        // ...
      }
    }
    ```

    ```java
    // Code block B
    class Bar {
      public Bar(int x) {
        // ...
      }
    }
    ```

    ```java
    // Code block C
    class Bar {
      public Foo(int x) {
        // ...
      }
    }
    ```

    ```java
    // Code block D
    class Bar {
      public Bar() {
        // ...
      }
    }
    ```

   * [ ] Code block A
   * [ ] Code block B
   * [ ] Code block C
   * [ ] Code block D