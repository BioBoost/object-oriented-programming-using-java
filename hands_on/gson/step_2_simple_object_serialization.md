## Step 2 - Simple Object Serialization

Gson can easily serialize and deserialize objects to and from json.

Serialization is the process of translating data structures or object state into a format that can be stored (for example, in a file or memory buffer) or transmitted (for example, across a network connection link) and reconstructed later (possibly in a different computer environment). When the resulting series of bits is reread according to the serialization format, it can be used to create a semantically identical clone of the original object. This process of serializing an object is also called **marshalling** an object. The opposite operation, extracting a data structure from a series of bytes, is deserialization (which is also called **unmarshalling**).

Some things to know about Gson serialization:
* You can not serialize objects with circular references since that will result in infinite recursion.
* It is perfectly fine (and recommended) to use private fields.
* There is no need to use any annotations to indicate an attribute is to be included for serialization and deserialization. All fields in the current class (and from all super classes) are included by default.
* If an attribute is marked transient, (by default) it is ignored and not included in the JSON serialization or deserialization.
* While serializing, a null attribute is omitted from the output.
* While deserializing, a missing entry in JSON results in setting the corresponding attribute in the object to its default value: null for object types, zero for numeric types, and false for booleans.
* If an attribute is synthetic, it is ignored and not included in JSON serialization or deserialization.
* Fields corresponding to the outer classes in inner classes, anonymous classes, and local classes are ignored and not included in serialization or deserialization.

### A Motorcycle class

Let us create a Motorcycle class with the following characteristics:
* a brand: `String` - for example "Kawasaki"
* a model: `String` - for example "VN800"
* a year of manufacturing: `int` - for example 1997
* a price: `double` - for example 5000

We create a simple class with a constructor that takes the first three attributes as arguments. The `price` is considered optional as we do not always know the price of the model.

```java
public class Motorcycle {

  private String brand;
  private String model;
  private int yearOfManufacturing;
  private double price;

  public Motorcycle(String brand, String model, int yearOfManufacturing) {
    this.brand = brand;
    this.model = model;
    this.yearOfManufacturing = yearOfManufacturing;
    this.price = 0;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    String output = brand + " " + model + " [" + yearOfManufacturing
      + "]: ";

    if (price > 0) {
      output += price + "eur";
    } else {
      output += "price unknown";
    }

    return output;
  }
}
```

Let us implement a small test application in main:

```java
public class JavaGsonExample {
    public static void main(String[] args) {
        Motorcycle myZx = new Motorcycle("Kawasaki", "ZX6R", 2006);

        Motorcycle myVulcan = new Motorcycle("Kawasaki", "VN800", 1997);
        myVulcan.setPrice(3500);

        System.out.println(myZx);
        System.out.println(myVulcan);
    }
}
```

This should output:

```text
Kawasaki ZX6R [2006]: price unknown
Kawasaki VN800 [1997]: 3500.0eur
```

Now we know our class works.

### Serialization of a Motorcycle

Let us serialize both these motorcycles using gson and see what the result is. For this you can start from the example on the Github UserGuide page of the Gson library [https://github.com/google/gson/blob/master/UserGuide.md#TOC-Object-Examples](https://github.com/google/gson/blob/master/UserGuide.md#TOC-Object-Examples).

Below is the part of the example that is of importance to us. `BagOfPrimitives` is the name of the class of the object that is being serialized.
```java
// Serialization
BagOfPrimitives obj = new BagOfPrimitives();
Gson gson = new Gson();
String json = gson.toJson(obj);  
```

So all we need to do is create an object of the class `Gson` and call the method `toJson()` with an instance of the object we want to serialize.

For example:

```java
public class JavaGsonExample {
    public static void main(String[] args) {
        Motorcycle myZx = new Motorcycle("Kawasaki", "ZX6R", 2006);

        Motorcycle myVulcan = new Motorcycle("Kawasaki", "VN800", 1997);
        myVulcan.setPrice(3500);

        System.out.println(myZx);
        System.out.println(myVulcan);

        // Serialization
        Gson gson = new Gson();
        String zxJson = gson.toJson(myZx);  
        String vulcanJson = gson.toJson(myVulcan);

        System.out.println("Json of ZX: " + zxJson);
        System.out.println("Json of Vulcan: " + vulcanJson);
    }
}
```

The result of this is:

```text
Kawasaki ZX6R [2006]: price unknown
Kawasaki VN800 [1997]: 3500.0eur
Json of ZX: {"brand":"Kawasaki","model":"ZX6R","yearOfManufacturing":2006,"price":0.0}
Json of Vulcan: {"brand":"Kawasaki","model":"VN800","yearOfManufacturing":1997,"price":3500.0}
```
