package todolistapplication;

import java.util.Scanner;

public class ToDoApp {

    // Attributes
    private boolean keepParsing = true;
    private ToDoList list;

    // Default constructor (no arguments)
    public ToDoApp() {
        list = new ToDoList();
        parse();
    }

    public void parse() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter your commands");
        String userInput;
        do {
            System.out.print("> ");
            userInput = console.nextLine().trim();
                // trim() to remove whitespace at beginning and end

            int space = userInput.indexOf(" ");
            if (space < 0) {        // No space ? (single command without data)
                identifyCommand(userInput);
            } else {   // Command with data
                String command = userInput.substring(0, space);
                String data = userInput.substring(space+1, userInput.length());
                identifyCommand(command, data);
            }
        } while(keepParsing);
    }

    // Command parsing methods
    private void identifyCommand(String command) {
        if (command.equals("help")) {
            printHelp();
        } else if (command.equals("quit") || command.equals("exit")) {
            keepParsing = false;
        } else if (command.equals("print")) {
            printList();
        } else if (command.equals("new")) {     // Without title
            list = new ToDoList();
            System.out.println("Created new list");
        } else {
            printUnknownCommand();
        }
    }

    private void identifyCommand(String command, String data) {
        if (command.equals("new")) {             // With title
            list = new ToDoList(data);
            System.out.println("Created new list");
        } else if (command.equals("title")) {
            list.setTitle(data);
        } else if (command.equals("add")) {
            list.add(new ToDo(data));
        } else {
            printUnknownCommand();
        }
    }

    // These are the available command methods. We make them private because
    // only the command parser class itself uses them
    private void printHelp() {
        System.out.println("Welcome to the ToDo app list creater.");
        System.out.println("-------------------------------------");
        System.out.println("The following commands are available:");
        System.out.println("- help: print this help");
        System.out.println("- new [title]: create new list (title is optional)");
        System.out.println("- add <description>: add a todo item");
        System.out.println("- title <title> : change title of list");
        System.out.println("- print: print the list");
        System.out.println("- exit: quit the application");
    }

    private void printUnknownCommand() {
        System.out.println("Unknown command. Type help for list of commands");
    }

    private void printList() {
        System.out.println("" + list);
    }
}
