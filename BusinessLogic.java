import java.util.HashMap;
import java.util.Map;

public class BusinessLogic {
    // calculates the final price price for the customer with their discount

    public static double calculateFinalValue(
            String customerClass,
            String lastPurchase,
            String totalPurchase) {

        double finalValue = 0;
        int thisYear = 2024;

        int convertedClass = Integer.parseInt(customerClass);
        int convertedLastPurchase = Integer.parseInt(lastPurchase);
        double convertedTotalPurchase = Double.parseDouble(totalPurchase);


        if (convertedClass == 1) {

            if (convertedLastPurchase == thisYear) {
                finalValue = convertedTotalPurchase * 0.7;
            }

            else if (convertedLastPurchase < thisYear && convertedLastPurchase > (thisYear - 5)) {
                finalValue = convertedTotalPurchase * 0.8;
            }

            else {
                finalValue = convertedTotalPurchase * 0.9;
            }
        }

        else if (convertedClass == 2) {

            if (convertedLastPurchase == thisYear) {
                finalValue = convertedTotalPurchase * 0.85;
            }

            else if (convertedLastPurchase < thisYear && convertedLastPurchase > (thisYear - 5)) {
                finalValue = convertedTotalPurchase * 0.87;
            }

            else {
                finalValue = convertedTotalPurchase * 0.95;
            }
        }

        else {

            if (convertedLastPurchase == thisYear) {
                finalValue = convertedTotalPurchase * 0.97;
            }
            else {
                finalValue = convertedTotalPurchase;
            }

        }

        return finalValue;

    };

    public static void outputFinalCustomerPurchase(Map<Integer, HashMap<String, String>> database) {
        database.forEach((key, value) -> {
            String fullName = value.get("fullName");
            double purchase = calculateFinalValue(
                value.get("customerClass"), 
                value.get("lastPurchase"), 
                value.get("totalPurchase"));
        });
    }
}