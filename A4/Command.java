import java.text.ParseException;

// Class to run the commands based on the database
abstract class Command {
    abstract void run(Database database) throws ParseException;
}
