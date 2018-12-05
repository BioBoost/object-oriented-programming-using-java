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
public class HumidityApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Humidity garden = new Humidity(33, "garden");
        System.out.println(garden);

        HumidityParser parser = new HumidityParser();
        Humidity garage = parser.parse("|sensor:garage|humid:85|");
        System.out.println(garage);
    }

}
