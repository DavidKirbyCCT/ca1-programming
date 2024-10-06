
import java.util.HashMap;

public class MapCustomerData {
// creates hashmap and assigns customer data as key value pairs

    private HashMap<String, String> customerInfo;

    public MapCustomerData() {
            customerInfo = new HashMap<>();
        }

    public void addCustomer(String firstName, String surname, String totalPurchase, String lastPurchase) {
        String fullName = firstName + " " + surname;
        customerInfo.put("First Name", firstName);
        customerInfo.put("Surname", surname);
        customerInfo.put("Full Name", fullName);
        customerInfo.put("Total Purchase", totalPurchase);
        customerInfo.put("Last Purchase", lastPurchase);
    }

}
