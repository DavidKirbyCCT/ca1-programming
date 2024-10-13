import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
  public static void main(String[] args) {
    // reads data from file and creates an array, array is then looped through and
    // customer profiles created, profiles are then inserted into  with format - {UID:customerProfile}

    ArrayList<Object> customerDataArray = new ArrayList<>();


    try {
      File customerImportFile = new File("customers.txt");
      Scanner sc = new Scanner(customerImportFile);

      while (sc.hasNextLine()) {
        // remove whitespace
        String arrayValue = sc.next().replaceAll("\\s", "");
        customerDataArray.add(arrayValue);
      }
      sc.close();

      // constructs mapcustomerdata object and maps customer data into an array
      MapCustomerData mapCustomerData = new MapCustomerData();
      mapCustomerData.mapArray(customerDataArray);
      mapCustomerData.printDatabase(mapCustomerData.getCustomerDatabase());
      
      // outputs customer name and final purchase price 
      BusinessLogic.outputFinalCustomerPurchase(mapCustomerData.getCustomerDatabase());


    } catch (FileNotFoundException e) {
      System.out.println("File does not exist.");
      e.getCause();;
    }
  }
}