/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagsonexample;

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
