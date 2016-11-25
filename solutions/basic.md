## Basic Exercises

### Circumference and area of a parallelogram

[TODO]

### A resistor model

The Resistor class:

```java
public class Resistor {
    // All attributes should be private
    private double resistance;
    private double voltage;
    private double current;

    // Non-default constructor (it takes arguments) to
    // initialize the attributes
    public Resistor(double resistance) {
        this.resistance = resistance;
            // this.resistance: attribute
            // resistance: argument of constructor

        // Initialize rest of attributes here (here we don't need to use this)
        voltage = 0;
        current = 0;
    }

    public void set_voltage(double voltage) {
        this.voltage = voltage;
        current = voltage / resistance;
    }

    public void set_current(double current) {
        this.current = current;
        voltage = current * resistance;
    }

    // Best is to use toString() and return a String object
    // You could make print() method but than you force user of your class
    // to output to screen.
    @Override
    public String toString() {
        String output = "Resistor with R = " + resistance + "ohm\n";
            // \n = newline
        output += "U = " + voltage + "V, I = " + current + "A";

        return output;
    }
}
```

An example program:

```java
public class GitBookResistor {
    public static void main(String[] args) {
        Resistor pullUp = new Resistor(10000);
        pullUp.set_voltage(3.3);
        System.out.println("Pullup:");
        System.out.println(pullUp + "\n");
            // Java will call pullUp.toString() here for you because it expects
            // a string as input argument for println()

        Resistor redLed = new Resistor(680);
        redLed.set_current(0.020);
        System.out.println("Red LED:");
        System.out.println(redLed);
    }
}
```

Output of main program:

```text
Pullup:
Resistor with R = 10000.0ohm
U = 3.3V, I = 3.3E-4A

Red LED:
Resistor with R = 680.0ohm
U = 13.6V, I = 0.02A
```

### ASCII valued Strings

[TODO]

### Randomizer checker

[TODO]
