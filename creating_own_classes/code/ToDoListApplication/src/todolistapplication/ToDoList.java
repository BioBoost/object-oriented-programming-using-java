package todolistapplication;

import java.util.ArrayList;

public class ToDoList {
    // Attributes
    private String title = "Unnamed";
    private ArrayList<ToDo> items = new ArrayList();
        // Notice that the ArrayList holds references to ToDo objects

    // Default constructor (no arguments)
    public ToDoList() {}

    // Constructor with title
    // Multiple constructors = Constructor overloading
    public ToDoList(String title) {
        setTitle(title);
    }

    public void add(ToDo item) {
        items.add(item);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        String output = "ToDo: " + title + "\n";

        // It is no problem that the list is empty for the foreach but we
        // want to print a personalized message when the list is empty, so for this
        // we need an if
        if (items.size() > 0) {
            for (ToDo item : items) {
                output += item + "\n";     // Implicit call to toString() of item
            }
        } else {
            output += "List has no ToDo items";
        }

        return output;
    }
}
