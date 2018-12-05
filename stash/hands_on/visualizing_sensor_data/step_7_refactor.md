## Step 7 - Refactor

Again some refactoring is needed if you take a good look at the current code. A lot of duplication can be identified.

### A Random Number Generator

The button handler contains a lot of duplication. First of all there is the generation of the random numbers within a certain range. This can best be refactored to a new class called for example `RangedNumberGenerator`. We can then also place the `Random` generator inside that new class.

Start by creating a new class called `RangedNumberGenerator`. Place it inside a separate package called for example `helpers`.

![Random Number Generator in Separate Package](img/new_class_random_number_generator.png)

The best approach here would be to create a constructor that takes the minimum and maximum values. In the constructor we also create an instance of `Random`.

```java
public class RangedNumberGenerator {

    private int minimum;
    private int maximum;
    private Random generator;

    public RangedNumberGenerator(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.generator = new Random();
    }
}
```

Now we can implement a method called for example `generate()` which takes the range into account. Since most of the time we will be needing doubles, we make it return a double. You can always cast it to an `int` or add a method `generateInt()` if ever needed.

```java
public class RangedNumberGenerator {

    private int minimum;
    private int maximum;
    private Random generator;

    public RangedNumberGenerator(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.generator = new Random();
    }

    public double generate() {
        return generator.nextDouble() * (maximum - minimum + 1) + minimum;
    }
}
```

A simple and elegant solution. Now we need to refactor to controller so it makes use of this `RangedNumberGenerator` class. We need to create an attribute that holds a reference to an instance of this class. After that we need to call the `generate()` method from the button handler. Make sure to remove the old `Random` generator as it is not needed anymore.

```java
public class FXMLChartDisplayController implements Initializable {

    @FXML private LineChart temperatureChart;
    private XYChart.Series temperatureValues[];
    private final int NUMBER_OF_TEMPERATURE_SERIES = 2;

    private int xValue = 0;

    private final int MAXIMUM_TEMPERATURE = 30;
    private final int MINIMUM_TEMPERATURE = 15;
    private RangedNumberGenerator dataGenerator;

    @FXML
    private void generateRandomDataHandler(ActionEvent event) {
        temperatureValues[0].getData().add(new XYChart.Data(xValue, dataGenerator.generate()));
        temperatureValues[1].getData().add(new XYChart.Data(xValue, dataGenerator.generate()));
        xValue++;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataGenerator = new RangedNumberGenerator(MINIMUM_TEMPERATURE, MAXIMUM_TEMPERATURE);

        temperatureValues = new XYChart.Series[NUMBER_OF_TEMPERATURE_SERIES];
        temperatureValues[0] = new XYChart.Series();
        temperatureValues[0].setName("Classroom 2.85");

        temperatureValues[1] = new XYChart.Series();
        temperatureValues[1].setName("Classroom 2.65");

        // Add series to chart
        temperatureChart.getData().add(temperatureValues[0]);
        temperatureChart.getData().add(temperatureValues[1]);

        // Set Axis
        temperatureChart.getYAxis().setLabel("Temperature [celcius]");
        temperatureChart.getXAxis().setLabel("Measurement");
    }    
}
```

If for some reason you need a different range for the random data, you will need to create another random number generator with that range.

### Creating a XYChart Series

The creation of the `XYChart.Series` can also be extracted to a method. This will also make the code cleaner. By adding a private method to the controller that can create a `XYChart.Series` with a given name, we can remove some duplication.

```java
private XYChart.Series createXYSeries(String name) {
    XYChart.Series series = new XYChart.Series();
    series.setName(name);
    return series;
}
```

Now we can refactor the `initialize()` method:

```java
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataGenerator = new RangedNumberGenerator(MINIMUM_TEMPERATURE, MAXIMUM_TEMPERATURE);

        temperatureValues = new XYChart.Series[NUMBER_OF_TEMPERATURE_SERIES];
        temperatureValues[0] = createXYSeries("Classroom 2.85");
        temperatureValues[1] = createXYSeries("Classroom 2.65");

        // Add series to chart
        temperatureChart.getData().add(temperatureValues[0]);
        temperatureChart.getData().add(temperatureValues[1]);

        // Set Axis
        temperatureChart.getYAxis().setLabel("Temperature [celcius]");
        temperatureChart.getXAxis().setLabel("Measurement");
    }   
```
