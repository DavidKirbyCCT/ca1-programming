
import java.util.ArrayList;
import java.util.HashMap;

public class MapCustomerData {
    // creates hashmap and assigns customer data as key value pairs

    private HashMap<String, String> customerInfo;

    public MapCustomerData() {
        customerInfo = new HashMap<>();
    }

    public void addCustomer(String firstName, String surname, String totalPurchase, String lastPurchase,
            String customerClass) {
        String fullName = firstName + " " + surname;
        customerInfo.put("First Name", firstName);
        customerInfo.put("Surname", surname);
        customerInfo.put("Full Name", fullName);
        customerInfo.put("Total Purchase", totalPurchase);
        customerInfo.put("Last Purchase", lastPurchase);
        customerInfo.put("Customer Class", customerClass);
    }

    public void mapArray(ArrayList<Object> dataArray) {
        int counter = 0;

        while (counter + 4 < dataArray.size()) {
            // sets variables and calls addcustomer method and creates individual hashmaps for customer 
            String firstName = (String) dataArray.get(counter);
            String surname = (String) dataArray.get(counter + 1);
            String totalPurchase = (String) dataArray.get(counter + 2);
            String customerClass = (String) dataArray.get(counter + 3);
            String lastPurchase = (String) dataArray.get(counter + 4);
            
            addCustomer(firstName, surname, totalPurchase, lastPurchase, customerClass);

            counter += 5;

            System.out.println(customerInfo);
        }
    }

    public void printCustomerInfo() {
        System.out.println(customerInfo);
    }
}
