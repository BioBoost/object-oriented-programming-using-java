package todolistapplication;

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
