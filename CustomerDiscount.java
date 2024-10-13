
import java.util.ArrayList;

public class CustomerDiscount {
    public static void main(String[] args) {
        // creates array from returned input file and maps it out to a hashmap/database.
        // Data then has business logic applied for discount and is exported to new customerdiscount.txt file

        ArrayList<Object> customerDataArray = FileReader.readInputFile();

        if (customerDataArray != null) {
            MapCustomerData mapCustomerData = new MapCustomerData();
            mapCustomerData.mapArray(customerDataArray);
            System.out.println(customerDataArray);
            mapCustomerData.printDatabase(mapCustomerData.getCustomerDatabase());

            String discountData = BusinessLogic.outputFinalCustomerPurchase(mapCustomerData.getCustomerDatabase());

            FileReader.CreateExportFile();
            FileReader.writeDatatoFile(discountData);
        } else {
            System.out.println("Your export data file is empty.");
        }

    }
}
