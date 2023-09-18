import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Claim {
    private String contractName;
    private long amount;
    private Date date;
    private boolean successful;
    // Claim Tag
    static final String inputTag = "CLAIM";

    // Fill in claim information
    Claim(HashMap<String, ArrayList<Tag>> tags) throws ParseException {
        contractName = tags.get("CONTRACT_NAME").get(0).getValue();
        date = Utils.convertDate(tags.get("DATE").get(0).getValue());
        amount = Long.parseLong(tags.get("AMOUNT").get(0).getValue());
    }

    // Getter functions for the different fields of a claim
    public String getContractName() {
        return contractName;
    }

    public long getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    // Determine if claim is successful or not
    public boolean wasSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
