## Assignment - Linear Equation - Solution

```java
public class LinearEquationSolution {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Welcome to the linear equation solver.");

    int userChoice = 0;
    double aCoefficient = 0;
    double bCoefficient = 0;
    do {
      System.out.println("\n1. Input linear coefficients");
      System.out.println("2. Output equation and intercept points");
      System.out.println("3. Exit the application");
      System.out.print("\nYour choice? ");
      userChoice = console.nextInt();

      if (userChoice == 1) {
        System.out.print("\nPlease enter the a-coefficient: ");
        aCoefficient = console.nextDouble();
        System.out.print("Please enter the b-coefficient: ");
        bCoefficient = console.nextDouble();

        System.out.println("\n\nThank you");
      } else if (userChoice == 2) {
        System.out.println("\nThe linear equation: y = " + aCoefficient + "x + " + bCoefficient);

        System.out.println("The y-intercept occurs for y = " + bCoefficient);
        System.out.println("The x-intercept occurs for x = " + -bCoefficient/aCoefficient);
      }
    } while (userChoice != 3);
  
    System.out.println("\nThank you for using the linear equation printer.");
  }
}
```