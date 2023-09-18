import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Customer {
    private String name;
    private Date dateOfBirth;
    private long income;
    // Customer Tag
    static final String inputTag = "CUSTOMER";

    // Fill in customer information
    Customer(HashMap<String, ArrayList<Tag>> tags) throws ParseException {
        name = tags.get("NAME").get(0).getValue();
        dateOfBirth = Utils.convertDate(tags.get("DATE_OF_BIRTH").get(0).getValue());
        income = Long.parseLong(tags.get("INCOME").get(0).getValue());
    }

    // Getter functions for the different fields of a customer
    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public long getIncome() {
        return income;
    }

    public static String getInputTag() {
        return inputTag;
    }
}
