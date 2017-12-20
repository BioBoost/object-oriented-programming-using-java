/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistapplication;

/**
 *
 * @author nicod
 */
public class ToDo {
    
    // Attributes
    private String description;
    
    // Constructor
    public ToDo(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[ ] " + description;
    }
}
