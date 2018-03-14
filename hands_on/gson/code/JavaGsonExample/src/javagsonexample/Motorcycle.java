/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagsonexample;

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