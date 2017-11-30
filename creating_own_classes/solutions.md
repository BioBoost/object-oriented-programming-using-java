## Exercise 1 - Modeling an Advanced Light Bulb

## Exercise 2 - Circumference and area of a parallelogram

## Exercise 3 - A resistor model

```java
public class Resistor {
  // Attributes (properties of a resistor)
  private double resistance;
  private double voltage;
  private double current;

  // Constructor (method that initializes the object)
  // - same name as the class
  // - no return type
  // - arguments needed to initialize new objects
  public Resistor(double resistance) {
    this.resistance = resistance;

    // Make sure to initialize all attributes
    voltage = 0;
    current = 0;
  }

  // A default constructor takes no arguments and initializes all the
  // attributes to their default values
  public Resistor() {
    resistance = 0;
    current = 0;
    voltage = 0;
  }

  // Getter methods to access the attributes of the Resistor
  public double getResistance() {
    return resistance;
  }

  public double getVoltage() {
    return voltage;
  }

  public double getCurrent() {
    return current;
  }

  // Methods to change the inner state of the object
  // Here setting the voltage also changes the current and vise versa
  // See the Law of Ohm
  public void setCurrent(double current) {
    this.current = current;
    voltage = resistance * current;
  }

  public void setVoltage(double voltage) {
    this.voltage = voltage;
    current = voltage / resistance;
  }
}
```

## Exercise 4 - A Command Parser

The start of a command parser. Needs more implementation and refactoring to a class.

```java
public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Please enter commands");
    String userInput;
    do {
        System.out.print("> ");
        userInput = console.nextLine().trim();
            // trim() to remove whitespace at beginning and end

        int space = userInput.indexOf(" ");
        if (space < 0) {
            // No space (single command?)
        } else {
            // Command with data
            String command = userInput.substring(0, space);

            String data = userInput.substring(space+1,
                            userInput.length());

            if (command.equals("say")) {
                System.out.println(data);
            } else if (command.equals("join")) {
                System.out.println("Joining " + data);
            }
        }

        //System.out.println(userInput);
    } while(!userInput.equals("exit"));
}
```

## Exercise 5 - A Player List

A Player class

```java
public class Player {
  // Attributes (properties of a player)
  private String nickname;
  private int points;

  // Constructor (method that initializes the object)
  // - same name as the class
  // - no return type
  // - arguments needed to initialize new objects
  public Player(String nickname) {
    this.nickname = nickname;
    points = 0;
  }

  // Getter methods return values of attributes.
  // Necessary because attributes are private
  public String getNickname() {
    return nickname;
  }

  public int getPoints() {
    return points;
  }

  // We also need a method to add points for a player
  public void addPoints(int points) {
    this.points += points;
  }
}
```

There are two possible solutions here. We can use an ArrayList to store the players or we can use an array to store them. However as players can join and leave on the fly it is probable easier to track them in an ArrayList.

A PlayerList class with an ArrayList
```java
public class PlayerList {
    // Attributes (properties of a PlayerList)
    private ArrayList<Player> list;
    private int maxNumberOfPlayers;

    // Constructor
    public PlayerList(int maxNumberOfPlayers) {
      this.maxNumberOfPlayers = maxNumberOfPlayers;
      list = new ArrayList();
    }

    // Method to add player
    // return true if ok, or false if full
    public boolean add(Player player) {
      if (list.size() >= maxNumberOfPlayers) {
        return false;
      } else {
        list.add(player);
        return true;
      }
    }
}
```
