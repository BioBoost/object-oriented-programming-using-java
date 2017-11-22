## Exercise 1 - Samsung Smart TV

Search for the specs of a smart TV on the website of an Internet vendor (for example CoolBlue). Can you identify the attributes and methods of the TV?

## Exercise 2 - A Pidgey Pokemon

Take a look at the screenshot below of a Pokemon game. Can you identify the attributes and actions of Pidgey?

![A Pidgey Pokemon](img/pokemon_pidgey.jpg)

## Exercise 3 - Randomizer checker

Create an application that calculates the average of a number of randomly generated numbers.

You can use the `nextInt(max)` method of the class `Random` to generate random integers.
Make sure to select a low max (for example 50) or your sum will overflow.

Make a small main program to show that the implementation works. Generate for example 5000 random numbers.

## Exercise 4 - Modeling an Advanced Light Bulb

Take the example from the course of a LightBulb. Now think about a more advanced light bulb where you wish to keep track of the number of hours that it was on (it breaks for example after 10'000 hours). Instead of two states this lightbulb can be dimmed. How would you save that property? Create a UML diagram of this LEDBulb.

## Exercise 5 - Circumference and area of a parallelogram

Create a class that stores the base and height of a parallelogram.

![Parallelogram](img/parallelogram.png)

Add two methods to the class. One to determine the area and one to determine the circumference of the parallelogram.

Make a small main program to show that the implementation works.

## Exercise 6 - A resistor model

Create a class that simulates the behavior of a resistor. You should be able
to only set the resistance once through a constructor of the class. This means that
the resistance cannot change after an object of the Resistor class has been created.

![Resistor](img/resistor.jpg)

You should supply methods to set the current that passes through the resistor.
In this case the resulting voltage is calculated using U = I x R.

It should also be possible to change the voltage that is applied across the resistor.
In that case the resulting current through the resistor should be calculated using
I = U / R.

You should make sure that the created objects are in a valid state at all times. This
means if the current changes, the voltage should also change and vice versa.

Make sure to choose floating point values for all attributes of the resistor class.

Make sure that the following main code works:

```java
public static void main(String[] args) {
  Resistor resistor = new Resistor(1000);
  Resistor bridge = new Resistor();

  resistor.setVoltage(1);
  System.out.println("Current = " + resistor.getCurrent() + " A");
  // Current = 0.001 A
}
```

## Exercise 7 - A Command Parser

Write an application that can call a number of methods based on the commands that the user types in the terminal. So for example implement the following commands:

* help: give a list of available commands
* exit: stop and exit the application
* say <message>: print a message to the terminal

Example:

```text
> say Hello world at all
Hello world at all
> help
The following commands are available:
  help: give a list of available commands
  exit: stop and exit the application
  say <message>: print a message to the terminal
> exit
Bye bye, see you next time.
```

## Exercise 8 - A Player List

Create a class Player that holds both a nickname (of type `string`) and his/her score (of type `int`).

Next create a class PlayerList that contains an expandable list of players (use for example an `ArrayList` for this). Create methods for your PlayerList class to add a player and to remove a player. To remove a player you will need to give his/her nickname as an argument to the remove method. Also add a method to find a player based on his/her nickname.

The following main method should work with your classes:
```java
public static void main(String[] args) {
  Player exeler = new Player("Exeler");
  exeler.addPoints(23);
  System.out.println("Player " + exeler.getNickname()
      + " has " + exeler.getPoints() + " points");

  final int MAX_PLAYERS = 5;
  PlayerList joinedPlayers = new PlayerList(MAX_PLAYERS);

  if (joinedPlayers.add(exeler)) {
    System.out.println("Player joined");
  } else {
    System.out.println("Cannot join. List is full");
  }
}
```
