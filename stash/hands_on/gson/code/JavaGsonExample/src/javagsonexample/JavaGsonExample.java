/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagsonexample;

import com.google.gson.Gson;

public class JavaGsonExample {
    public static void main(String[] args) {
//        Motorcycle myZx = new Motorcycle("Kawasaki", "ZX6R", 2006);
//        
//        Motorcycle myVulcan = new Motorcycle("Kawasaki", "VN800", 1997);
//        myVulcan.setPrice(3500);
//        
//        System.out.println(myZx);
//        System.out.println(myVulcan);
//        
//        // Serialization
//        Gson gson = new Gson();
//        String zxJson = gson.toJson(myZx);  
//        String vulcanJson = gson.toJson(myVulcan);
//        
//        System.out.println("Json of ZX: " + zxJson);
//        System.out.println("Json of Vulcan: " + vulcanJson);
//        
//        // Deserialization
//        System.out.println("Deserialization of some Motorcycles");
//        String hondaJson = "{\"brand\":\"Honda\",\"model\":\"CBR600RR\",\"yearOfManufacturing\":2007,\"price\":5990.0}";
//        String ducatiJson = "{\"brand\":\"Ducati\",\"model\":\"Monster 600\",\"yearOfManufacturing\":1995}";
//        
//        Motorcycle ducati = gson.fromJson(ducatiJson, Motorcycle.class);
//        Motorcycle honda = gson.fromJson(hondaJson, Motorcycle.class);
//        
//        System.out.println(ducati);
//        System.out.println(honda);

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
