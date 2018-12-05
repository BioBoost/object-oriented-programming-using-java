/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painterwithoutinterfaces;

import java.util.ArrayList;

public class Painter {

    private ArrayList<House> houses = new ArrayList(); 
    private ArrayList<SpaceShuttle> shuttles = new ArrayList();
    private ArrayList<Turtle> turtles = new ArrayList();
    private ArrayList<MotorCycle> motorcycles = new ArrayList();

    public Painter() {
        // Let us create some fake objects to demonstrate
        houses.add(new House());
        shuttles.add(new SpaceShuttle());
        turtles.add(new Turtle());
        turtles.add(new Turtle());
        turtles.add(new Turtle());
        turtles.add(new Turtle());
        motorcycles.add(new MotorCycle());
    }

    public void paintScenery() {
        for (House house : houses) {
            house.paint();
        }
        for (SpaceShuttle shuttle : shuttles) {
            shuttle.display();
        }
        for (Turtle turtle : turtles) {
            turtle.draw();
        }
        for (MotorCycle motorcycle : motorcycles) {
            motorcycle.paint();
        }
    }
}
