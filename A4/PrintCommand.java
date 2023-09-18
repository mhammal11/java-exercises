import java.text.ParseException;

class PrintCommand extends Command {
    private String entityType;
    private String queryType;
    private String queryValue;

    // Function to separate the input line into three values
    PrintCommand(String[] tokens) {
        super();
        entityType = tokens[1];
        queryType = tokens[2];
        queryValue = tokens[3];
    }

    // Function to rint customer related or plan related information
    @Override
    void run(Database database) {
        if (entityType.equals("CUSTOMER")) {
            runPrintCustomer(database);
        } else if (entityType.equals("PLAN")) {
            runPrintPlan(database);
        } else {
            throw new BadCommandException("Bad print command.");
        }
    }

    // Function to print the total amount claimed or received by a customer
    private void runPrintCustomer(Database database) {
        if (queryType.equals("TOTAL_CLAIMED")) {
            // Use function totalClaimedAmountByCustomer from the Database Class
            System.out.println("Total amount claimed by "
                    + database.getCustomer(queryValue).getName() + " is "
                    + database.totalClaimAmountByCustomer(queryValue));
        } else if (queryType.equals("TOTAL_RECEIVED")) {
            // Use function totalReceivedAmountByCustomer from the Database Class
            System.out.println("Total amount received by "
                    + database.getCustomer(queryValue).getName() + " is "
                    + database.totalReceivedAmountByCustomer(queryValue));
        } else {
            // Throws an exception for invalid commands handled later in Try/Catch blocks
            throw new BadCommandException("Invalid PRINT CUSTOMER command.");
        }
    }

    // Function to print the number of customers in a plan or the total amount payed under that plan
    private void runPrintPlan(Database database) {
        if (queryType.equals("NUM_CUSTOMERS")) {
            // Use function totalNumberOfCustomersUnderPlan from the Database Class
            System.out.println("Number of customers under "
                    + database.getPlan(queryValue).getName() + " is "
                    + database.totalNumberOfCustomersUnderPlan(queryValue));
        } else if (queryType.equals("TOTAL_PAYED_TO_CUSTOMERS")) {
            // Use function totalAmountPayedUnderPlan from the Database Class
            System.out.println("Total amount payed under "
                    + database.getPlan(queryValue).getName() + " is "
                    + database.totalAmountPayedUnderPlan(queryValue));
        } else {
            // Throws an exception for invalid commands handled later in Try/Catch blocks
            throw new BadCommandException("Invalid PRINT PLAN command.");
        }
    }
}
