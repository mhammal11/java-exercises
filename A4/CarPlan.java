import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class CarPlan extends Plan {
    // CarPlan Tag
    static final String inputTag = "CAR_PLAN";
    RangeCriterion mileageCriterion = new RangeCriterion();

    // Add a new car plan
    CarPlan(HashMap<String, ArrayList<Tag>> tags) {
        super(tags);

        if (tags.get("CAR.MILEAGE") != null) {
            for (Tag tag : tags.get("CAR.MILEAGE")) {
                mileageCriterion.addCriterion(tag);
            }
        }
    }

    // Determine if car ie eligible for insurance
    @Override
    boolean isEligible(Insurable insurable, Date date) {
        if (!(insurable instanceof Car)) {
            return false;
        }
        Car car = (Car) insurable;
        return mileageCriterion.isInRange(car.getMileage());
    }

    // Getter function for the car in the plan
    @Override
    Insurable getInsuredItem(Customer customer, Database database) {
        return database.getCar(customer.getName());
    }
}
