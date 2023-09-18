import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Home extends Insurable {
    private String postalCode;
    private Date buildDate;
    // Home tag
    static final String inputTag = "HOME";

    // Fill in house information
    Home(HashMap<String, ArrayList<Tag>> tags) throws ParseException {
        super(tags);
        postalCode = tags.get("POSTAL_CODE").get(0).getValue();
        buildDate = Utils.convertDate(tags.get("BUILD_DATE").get(0).getValue());
    }

    // Getter functions for the different fields of a home
    public String getPostalCode() {
        return postalCode;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public static String getInputTag() {
        return inputTag;
    }
}
