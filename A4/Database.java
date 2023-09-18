import java.util.ArrayList;

// Database class to store all the information from the input
class Database {
    // Create arraylists for the different categories in the database
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Home> homes = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Plan> plans = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private ArrayList<Claim> claims = new ArrayList<>();

    // Insert data from the input based on the different block types
    void insertHome(Home home) {
        homes.add(home);
    }

    void insertCar(Car car) {
        cars.add(car);
    }

    void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    void insertPlan(Plan plan) {
        plans.add(plan);
    }

    void insertClaim(Claim claim) {
        claims.add(claim);
    }

    void insertContract(Contract contract) {
        contracts.add(contract);
    }

    // Getter functions for the different values in the database
    Plan getPlan(String name) {
        for (Plan plan : plans) {
            if (plan.name.equals(name)) {
                return plan;
            }
        }
        return null;
    }

    Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    Contract getContract(String name) {
        for (Contract contract : contracts) {
            if (contract.getContractName().equals(name)) {
                return contract;
            }
        }
        return null;
    }

    /**
     * There is at most one home owned by each person.
     */
    Home getHome(String ownnerName) {
        for (Home home : homes) {
            if (home.getOwnerName().equals(ownnerName)) {
                return home;
            }
        }
        return null;
    }

    /**
     * There is at most one car owned by each person.
     */
    Car getCar(String ownnerName) {
        for (Car car : cars) {
            if (car.getOwnerName().equals(ownnerName)) {
                return car;
            }
        }
        return null;
    }

    // Function that returns the total amount claimed by each customer from all plans
    long totalClaimAmountByCustomer(String customerName) {
        long totalClaimed = 0;
        // Loop through all the claims
        for (Claim claim : claims) {
            if (getContract(claim.getContractName()).getCustomerName().equals(customerName)) {
                totalClaimed += claim.getAmount();
            }
        }
        return totalClaimed;
    }

    // Function that returns the total amount received by each customer from all plans
    long totalReceivedAmountByCustomer(String customerName) {
        long totalReceived = 0;
        // Loop through all the claims to find successful ones
        for (Claim claim : claims) {
            Contract contract = getContract(claim.getContractName());
            if (contract.getCustomerName().equals(customerName)) {
                if (claim.wasSuccessful()) {
                    // Subtract the deductible based on the contract of each plan
                    long deductible = getPlan(contract.getPlanName()).getDeductible();
                    // Handle negative numbers of deductible is larger than claim amount
                    totalReceived += Math.max(0, claim.getAmount() - deductible);
                }
            }
        }
        return totalReceived;
    }

    // Function that returns the total number of customers in each plan
    long totalNumberOfCustomersUnderPlan(String planName) {
        long numberOfCustomers = 0;
        // Loop through all the contracts to find plans
        for (Contract contract : contracts) {
            if (contract.getPlanName().equals(planName)) {
                numberOfCustomers++;
            }
        }
        return numberOfCustomers;
    }

    // Function that returns the total amount payed under each plan
    long totalAmountPayedUnderPlan(String planName) {
        long totalPaid = 0;
        // Loop through all the claims to find successful ones
        for (Claim claim : claims) {
            Contract contract = getContract(claim.getContractName());
            if (contract.getPlanName().equals(planName)) {
                if (claim.wasSuccessful()) {
                    // Subtract the deductible based on the contract of each plan
                    long deductible = getPlan(contract.getPlanName()).getDeductible();
                    // Handle negative numbers of deductible is larger than claim amount
                    totalPaid += Math.max(0, claim.getAmount() - deductible);
                }
            }
        }
        return totalPaid;
    }
}
