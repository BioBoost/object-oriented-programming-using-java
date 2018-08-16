## Deserialization of a Motorcycle

To deserialize a `Motorcycle` object from a json we start by creating our own json. For this we will need to adhere to the resulting json format outputted by the previous example.

```json
{"brand":"Honda","model":"CBR600RR","yearOfManufacturing":2007,"price":5990.0}
```

or one without a price:

```json
{"brand":"Ducati","model":"Monster 600","yearOfManufacturing":1995}
```

When you copy paste these json strings in NetBeans, they will automatically be escaped.

### Deserializing the json

Again we start with the example given on the GitHub UserGuide.

```java
// Deserialization
BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
```

Again we need an object of the class `Gson`. This time we need to call the method `fromJson()` and pass two arguments. First the json String and secondly the name of the class. The second argument is given by following the class with `.class`, for example `Motorcycle.class`.

Let us try it out:

```java
public class JavaGsonExample {
    public static void main(String[] args) {
        // ....

        // Deserialization
        System.out.println("Deserialization of some Motorcycles");
        String hondaJson = "{\"brand\":\"Honda\",\"model\":\"CBR600RR\",\"yearOfManufacturing\":2007,\"price\":5990.0}";
        String ducatiJson = "{\"brand\":\"Ducati\",\"model\":\"Monster 600\",\"yearOfManufacturing\":1995}";

        Motorcycle honda = gson.fromJson(hondaJson, Motorcycle.class);
        Motorcycle ducati = gson.fromJson(ducatiJson, Motorcycle.class);

        System.out.println(honda);
        System.out.println(ducati);
    }
}
```

Resulting in:

```text
Deserialization of some Motorcycles
Honda CBR600RR [2007]: 5990.0eur
Ducati Monster 600 [1995]: price unknown
```
