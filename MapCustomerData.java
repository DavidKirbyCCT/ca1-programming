
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapCustomerData {
    // creates a hashmap for each customer and assigns customer data as key value
    // pairs into database

    private HashMap<String, String> customerInfo = new HashMap<>();
    private HashMap<Integer, HashMap<String, String>> customerDatabase = new HashMap<>();

    public MapCustomerData() {
        // constructors
        customerInfo = new HashMap<>();
        customerDatabase = new HashMap<>();
    }

    public String validateData(int customerID, String key, String input) {
        boolean isDataValid = true;

        if (input.isEmpty()) {
            isDataValid = false;
            System.out.println("Check your data, field empty: " + "Customer ID - " + customerID + ": " + input);
        } else if (key.equals("firstName")) {
            if (input.matches(".*\\d.*")) {
                isDataValid = false;
                System.out.println("First name contains numbers: " + "Customer ID - " + customerID + ": " + input);
            }
        } else if (key.equals("lastPurchase")) {
            if (input.length() != 4) {
                isDataValid = false;
                System.out.println("Last Purchase value is invalid: " + "Customer ID - " + customerID + ": " + input);
            }
        } else if (key.equals("customerClass")) {
            int num1 = Integer.parseInt(input);
            if (num1 > 3 || num1 < 1) {
                isDataValid = false;
                System.out.println("Customer Class is invalid: "+ "Customer ID - " + customerID + ": " + input);
            }
        }

        if (!isDataValid) {
            return "CHECKDATA";
        } else {
            return input;
        }
    }

    public void addCustomer(
            // creates new customer and inserts into main database if data is validated
            int customerID,
            String firstName,
            String surname,
            String totalPurchase,
            String lastPurchase,
            String customerClass) {

        HashMap<String, String> customerInfo = new HashMap<>();

        String firstNameKey = "firstName";
        String surnameKey = "surname";
        String fullNameKey = "fullName";
        String totalPurchaseKey = "totalPurchase";
        String lastPurchaseKey = "lastPurchase";
        String customerClassKey = "customerClass";

        String validatedFirstName = validateData(customerID, firstNameKey, firstName);
        String validatedSurname = validateData(customerID, surnameKey, surname);
        String validatedTotalPurchase = validateData(customerID, totalPurchaseKey, totalPurchase);
        String validatedLastPurchase = validateData(customerID, lastPurchaseKey, lastPurchase);
        String validatedCustomerClass = validateData(customerID, customerClassKey, customerClass);
        
        if (validatedFirstName.equals("CHECKDATA") ||
            validatedSurname.equals("CHECKDATA") || 
            validatedTotalPurchase.equals("CHECKDATA")  ||
            validatedLastPurchase.equals("CHECKDATA") ||
            validatedCustomerClass.equals("CHECKDATA")
        ) {
            //  empty block so customer with invalid data is not added to database 
        } else {
            String fullName = validatedFirstName + " " + validatedSurname;
            customerInfo.put(firstNameKey, validatedFirstName);
            customerInfo.put(surnameKey, validatedSurname);
            customerInfo.put(fullNameKey, fullName);
            customerInfo.put(totalPurchaseKey, validatedTotalPurchase);
            customerInfo.put(lastPurchaseKey, validatedLastPurchase);
            customerInfo.put(customerClassKey, validatedCustomerClass);
    
            insertIntoDatabase(customerID, customerInfo);
        }

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
            customerID++;
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
