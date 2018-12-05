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
public class Humidity {
    private String sensorId;
    private int relativeHumidity;
    
    private final int MIN_HUMIDITY = 0;
    private final int MAX_HUMIDITY = 100;
    
    public Humidity(int relativeHumidity, String sensorId) {
        this.sensorId = sensorId;
        setRelativeHumidity(relativeHumidity);
    }
    
    public void setRelativeHumidity(int relativeHumidity) {
        if (relativeHumidity > MAX_HUMIDITY) {
            relativeHumidity = MAX_HUMIDITY;
        } else if (relativeHumidity < MIN_HUMIDITY) {
            relativeHumidity = MIN_HUMIDITY;
        }
        
        this.relativeHumidity = relativeHumidity;
    }
    
    public String getSensorId() {
        return sensorId;
    }
    
    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    @Override
    public String toString() {
        return "{\"sensor\": \"" + sensorId + "\", \"relative_humidity\": "
                + relativeHumidity +"}";
    }
}
