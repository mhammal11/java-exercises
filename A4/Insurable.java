import java.util.ArrayList;
import java.util.HashMap;

class Insurable {
    protected String ownerName;
    protected long value;

    // Add a new insurable item
    Insurable(HashMap<String, ArrayList<Tag>> tags) {
        ownerName = tags.get("OWNER_NAME").get(0).getValue();
        value = Long.parseLong(tags.get("VALUE").get(0).getValue());
    }

    // Getter functions for the different fields of an insurable
    public String getOwnerName() {
        return ownerName;
    }

    public long getValue() {
        return value;
    }
}
