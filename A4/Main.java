import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Try/Catch block to handle exceptions
        try {
            InputReader inputReader = InputReader.getInstance();
            // Store commands in an arraylist
            ArrayList<Command> commands = inputReader.getCommands();
            // Iterate through commands
            Iterator<Command> currentCommand = commands.iterator();
            // New object from the CommandHandler class to deal with commands from the input
            CommandHandler commandHandler = new CommandHandler(new Database());
            // While loop to continue reading commands from input
            while (currentCommand.hasNext()) {
                commandHandler.run(currentCommand.next());
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (BadCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}
