
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapCustomerData {
    // creates a hashmap for each customer and assigns customer data as key value pairs into database

    private HashMap<String, String> customerInfo = new HashMap<>();
    private HashMap<Integer, HashMap<String, String>> customerDatabase = new HashMap<>();

    public MapCustomerData() {
        // constructors
        customerInfo = new HashMap<>();
        customerDatabase = new HashMap<>();
    }

    public void addCustomer(
        // creates new customer and inserts into main database

            int customerID,
            String firstName,
            String surname,
            String totalPurchase,
            String lastPurchase,
            String customerClass) {

        HashMap<String, String> customerInfo = new HashMap<>();

        String fullName = firstName + " " + surname;
        customerInfo.put("firstName", firstName);
        customerInfo.put("surname", surname);
        customerInfo.put("fullName", fullName);
        customerInfo.put("totalPurchase", totalPurchase);
        customerInfo.put("lastPurchase", lastPurchase);
        customerInfo.put("customerClass", customerClass);
        
        insertIntoDatabase(customerID, customerInfo);
    }

    public void insertIntoDatabase(int uniqueID, HashMap<String, String> map) {
        // inserts unique customer ID and customer data as key/value pair
        customerDatabase.put(uniqueID, map);
    }

    public void mapArray(ArrayList<Object> dataArray) {
        // maps the arrayList output from the Scanner class  

        int counter = 0;
        int customerID = 0;

        while (counter + 4 < dataArray.size()) {
            String firstName = (String) dataArray.get(counter);
            String surname = (String) dataArray.get(counter + 1);
            String totalPurchase = (String) dataArray.get(counter + 2);
            String customerClass = (String) dataArray.get(counter + 3);
            String lastPurchase = (String) dataArray.get(counter + 4);

            addCustomer(customerID, firstName, surname, totalPurchase, lastPurchase, customerClass);

            counter += 5;
            customerID ++;
        }
    }

    public Map<Integer, HashMap<String, String>> getCustomerDatabase() {
        // returns the customer database for use in Main
        return customerDatabase;
    }
    
    public void printDatabase(Map<Integer, HashMap<String, String>> database) {
        // prints each customer record on new line
        database.forEach((key, value) -> {
            System.out.println("Customer ID: " + key + ", Customer Data:" + value);
        });
    }
}
