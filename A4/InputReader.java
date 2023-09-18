import java.util.ArrayList;
import java.util.Scanner;

class InputReader {
    private Scanner keyboard;
    private static InputReader instance = null;
    private int lineNumber = 0;
    // Create a new input reader
    private InputReader() {
        keyboard = new Scanner(System.in);
    }
    // Make sure multiple input readers are not created
    static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    // Read input from the terminal and split each block to get different commands
    ArrayList<Command> getCommands() {
        ArrayList<Command> commands = new ArrayList<>();
        String line = "";
        lineNumber = 0;
        // Try/Catch block to handle exceptions
        try {
            // While loop to continue reading input
            while (keyboard.hasNext()) {
                lineNumber++;
                line = keyboard.nextLine();
                if (line.startsWith("PRINT ")) {
                    commands.add(makePrintCommand(line));
                } else if (line.startsWith("BEGIN_")) {
                    commands.add(makeBlockCommand(line));
                } else if (line.equals("FINISH")) {
                    break;
                } else if (!line.equals("")) {
                    System.out.println(line);
                    throw new BadCommandException("Invalid command.");
                }
            }
        } catch (BadCommandException e) {
            throw new BadCommandException("Line " + lineNumber + " : " + e.getMessage());
        }
        return commands;
    }

    // Function to determine the command in each block
    private Command makeBlockCommand(String line) {
        // Removes "BEGIN_" from the current line to get the command type;
        BlockCommand command = new BlockCommand(line.substring(6));
        // While loop to continue reading input
        while (keyboard.hasNext()) {
            lineNumber++;
            line = keyboard.nextLine();
            // End of command
            if (line.equals("END_" + command.getBlockType())) {
                return command;
            } else if (line.equals("")) {
                ;
            } else {
                String [] tokens = line.split(" ", 3);
                // Exception for invalid tags
                if (tokens.length != 3 || tokens[1].length() != 1) {
                    throw new BadCommandException("Invalid tag.");
                }
                command.addTag(new Tag(tokens));
            }
        }
        return command;
    }

    // Catch an invalid input
    private Command makePrintCommand(String line) {
        String[] tokens = line.split(" ", 5);
        if (tokens.length > 4) {
            throw new BadCommandException("Invalid print command; too many tokens.");
        } else if (tokens.length < 4) {
                throw new BadCommandException("Invalid print command; too few tokens.");
        }
        return new PrintCommand(tokens);
    }
}