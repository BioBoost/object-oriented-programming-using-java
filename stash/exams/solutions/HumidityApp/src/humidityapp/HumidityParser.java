/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humidityapp;

/**
 *
 * @author nicod
 */
public class HumidityParser {
    
    public Humidity parse(String message) {
        //|sensor:garage|humid:85|
        String sensorKey = "|sensor:";
        String humidKey = "|humid:";
        
        int humidStart = message.indexOf(humidKey);
        
        String sensorId = message.substring(sensorKey.length(), humidStart);
        
        String humid = message.substring(humidStart+sensorKey.length()-1, message.length()-1);
        int humidity = Integer.parseInt(humid);
        
        return new Humidity(humidity, sensorId);
    }
    
}
