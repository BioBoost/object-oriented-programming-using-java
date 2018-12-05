## Exercise 3 - 

## Exercise 4 - A Command Parser

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

## Exercise 5 - A Player List

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

## Exercise 7 - ToDo list printer

Create a small application that can hold a list of todo items. A todo item consists of a small descriptive string.

Allow the user of your application to create todo items. Track them in a list. This list should have a title. You do not need to implement functionality to complete to-do's and so on. The application just needs to be able to create an overview of todo items.

When the user is ready with adding items print them to the terminal in a nice form.

For example (be creative):
```text
ToDo by this weekend:
---------------------
[ ] Mow the lawn
[ ] Visit grandpa
[ ] Solve exercises for OOP1
[ ] Clean the bike
[ ] Read book on Databases
[ ] Study for exam of WebTech
```

Check out the [solution](../creating_own_classes/solutions.md#exercise-7---todo-list-printer) in the solution section.

Extra:
Add a priority to a todo item and sort the list of items based on the priority (highest on top). Decide for yourself how to implement the priority:
* for example integer value between 0 and 5
* or just a `boolean` to indicate high priorities

Example:
```text
ToDo by this weekend:
---------------------
High priorities
[ ] Read book on Databases
[ ] Study for exam of WebTech
[ ] Visit grandpa
[ ] Solve exercises for OOP1

Low priorities
[ ] Clean the bike
[ ] Mow the lawn
```
