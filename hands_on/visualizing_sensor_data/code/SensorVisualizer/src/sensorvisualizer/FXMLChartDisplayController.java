/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorvisualizer;

import helpers.RangedNumberGenerator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

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
//        ((XYChart.Series)(temperatureChart.getData().get(0))).getData().add(new XYChart.Data(xValue++, randomTemperature));
    }
    
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
    
    private XYChart.Series createXYSeries(String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        return series;
    }
}
