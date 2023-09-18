import java.text.ParseException;

// Class to handle the commands from the input and run them from the database
class CommandHandler {
    Database database;

    CommandHandler(Database database) {
        this.database = database;
    }

    void run(Command command) throws ParseException {
        command.run(database);
    }
}
