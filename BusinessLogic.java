public class BusinessLogic {
    // calculates the final price price for the customer with their discount

    public static double calculateFinalValue(
            int customerClass,
            int lastPurchase,
            double totalPurchase) {

        double finalValue = 0;
        int thisYear = 2024;

        if (customerClass == 1) {

            if (lastPurchase == thisYear) {
                finalValue = totalPurchase * 0.7;
            }

            else if (lastPurchase < thisYear && lastPurchase > (thisYear - 5)) {
                finalValue = totalPurchase * 0.8;
            }

            else {
                finalValue = totalPurchase * 0.9;
            }
        }

        else if (customerClass == 2) {

            if (lastPurchase == thisYear) {
                finalValue = totalPurchase * 0.85;
            }

            else if (lastPurchase < thisYear && lastPurchase > (thisYear - 5)) {
                finalValue = totalPurchase * 0.87;
            }

            else {
                finalValue = totalPurchase * 0.95;
            }
        }

        else {

            if (lastPurchase == thisYear) {
                finalValue = totalPurchase * 0.97;
            }
            else {
                finalValue = totalPurchase;
            }

        }

        return finalValue;

    };
}