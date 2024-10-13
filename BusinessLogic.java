import java.util.HashMap;
import java.util.Map;

public class BusinessLogic {
    // calculates the final price price for the customer with their discount based
    // on customer class

    public static double calculateFinalValue(
            String customerClass,
            String lastPurchase,
            String totalPurchase) {

        double finalValue;
        int thisYear = 2024;

        // cast to types needed for expressions/calcs
        
        int convertedClass = Integer.parseInt(customerClass);
        int convertedLastPurchase = Integer.parseInt(lastPurchase);
        double convertedTotalPurchase = Double.parseDouble(totalPurchase);

        if (convertedClass == 1) {

            if (convertedLastPurchase == thisYear) {
                finalValue = convertedTotalPurchase * 0.7; // 30% discount
            }

            else if (convertedLastPurchase < thisYear && convertedLastPurchase > (thisYear - 5)) {
                finalValue = convertedTotalPurchase * 0.8; // 20% discount
            }

            else {
                finalValue = convertedTotalPurchase * 0.9; // 10% discount
            }
        }

        else if (convertedClass == 2) {

            if (convertedLastPurchase == thisYear) {
                finalValue = convertedTotalPurchase * 0.85; // 15% discount
            }

            else if (convertedLastPurchase < thisYear && convertedLastPurchase > (thisYear - 5)) {
                finalValue = convertedTotalPurchase * 0.87; // 13% discount
            }

            else {
                finalValue = convertedTotalPurchase * 0.95; // 5% discount
            }
        }

        else {

            if (convertedLastPurchase == thisYear) {
                finalValue = convertedTotalPurchase * 0.97; // 3% discount
            } else {
                finalValue = convertedTotalPurchase; // no discount applied
            }

        }

        return finalValue;

    };

    public static void outputFinalCustomerPurchase(Map<Integer, HashMap<String, String>> database) {
        // outputs full customer name and final purchase price including discount,
        // formatted to 2 decimal places

        database.forEach((key, value) -> {
            String fullName = value.get("fullName");
            double purchase = calculateFinalValue(
                    value.get("customerClass"),
                    value.get("lastPurchase"),
                    value.get("totalPurchase"));

            System.out.println("Customer Name: " + fullName);
            System.out.printf("Final Purchase: %.2f\n", purchase);
        });
    }
}