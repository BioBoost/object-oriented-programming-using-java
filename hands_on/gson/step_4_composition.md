## Composition

But what if we included a reference to an object of another class? Take for example a class `Engine` that contains the specific engine specs.

```java
public class Engine {
  private int capacity;
  private double maxPower;

  public Engine(int capacity, double maxPower) {
    this.capacity = capacity;
    this.maxPower = maxPower;
  }

  @Override
  public String toString() {
    return maxPower + "kW @ " + capacity + "cc";
  }
}
```

Of course we also need to adjust our `Motorcycle` class a bit to take this `Engine` class in account.

```java
public class Motorcycle {

  private String brand;
  private String model;
  private int yearOfManufacturing;
  private double price;
  private Engine engine;

  public Motorcycle(String brand, String model, int yearOfManufacturing, Engine engine) {
    this.brand = brand;
    this.model = model;
    this.yearOfManufacturing = yearOfManufacturing;
    this.price = 0;
    this.engine = engine;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    String output = brand + " " + model + " [" + yearOfManufacturing
      + "] (" + engine + "): ";

    if (price > 0) {
      output += price + "eur";
    } else {
      output += "price unknown";
    }

    return output;
  }
}
```

### A new Main

Since we changed quite a bit we'll start over with a new main (you can also comment out the previous code so not to lose it).

The `Motorcycle` constructors requires us to pass it an `Engine` object, so we will need to create this before we create a new `Motorcycle`. Once that is done we can just serialize and deserialize and we did before.

```java
public class JavaGsonExample {
    public static void main(String[] args) {
        Engine vTwin800 = new Engine(800, 40.8);
        Motorcycle vulcan800 = new Motorcycle("Kawasaki", "VN800A", 1996, vTwin800);
        System.out.println("Original vulcan 800: " + vulcan800);

        // Serialization
        Gson gson = new Gson();
        String vulcanJson = gson.toJson(vulcan800);
        System.out.println("Json: " + vulcanJson);

        // Deserialization
        String ducatiJson = "{\"brand\":\"Ducati\",\"model\":\"Monster 600\","
                + "\"yearOfManufacturing\":1995,\"price\":0.0,"
                + "\"engine\":{\"capacity\":583,\"maxPower\":38.7}}";
        Motorcycle ducati = gson.fromJson(ducatiJson, Motorcycle.class);
        System.out.println(ducati);
    }
}
```

which results in:

```text
Original vulcan 800: Kawasaki VN800A [1996] (40.8kW @ 800cc): price unknown
Json: {"brand":"Kawasaki","model":"VN800A","yearOfManufacturing":1996,"price":0.0,"engine":{"capacity":800,"maxPower":40.8}}
Ducati Monster 600 [1995] (38.7kW @ 583cc): price unknown
```
