# Week 9 - Home Domotics

The idea is to create an application to control a home filled with all sorts of domotic appliances. Some examples might be:
* lights
* garage door
* alarm
* gate
* front door
* ...

All external components are controlled via a small command line tool that is embedded in our application.

## Part 1 - A light

As a first part of the assignment you should create a class that models a light point in a house. You can take the example from the course to get you going. You should be able to turn the light on and off. The actual state of the light should be an integer value of `0` for off and `255` for on.

Add a toString method to your light that returns a nice textual representation of the object. Also make sure you can give your lights a name in the form of String. You can supply the name via the constructor to force the user of your class to give each light a name.

![UML Class Diagram of Light](img/light_uml.png)

## Part 2 - A gate

Next create a class that models a gate. The actions that can be performed on a gate are:
* close
* open
* lock
* unlock

When a gate is locked it cannot be opened. When a gate is open it cannot be locked.

Add a toString method to your gate that returns a nice textual representation of the object. Also make sure you can give your gate a name in the form of String. You can supply the name via the constructor to force the user of your class to give each gate a name.

![UML Class Diagram of Gate](img/gate_uml.png)

## Part 3 - The House

Next create a class `House` that keeps track of all the lights and gates via an `ArrayList` for lights and an `ArrayList` for gates. Add some objects to them and give them a decent name as you will need these names later on to access them via the command line parser.

![UML Class Diagram of House](img/house_uml.png)
