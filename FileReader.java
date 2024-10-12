import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
  public static void main(String[] args) {
    // reads data from file and creates an array, array is then looped through and
    // customer profiles created, profiles are then inserted into hashmap with format - {UID:customerProfile}

    ArrayList<Object> customerDataArray = new ArrayList<Object>();


    try {
      File customerImportFile = new File("customers.txt");
      Scanner sc = new Scanner(customerImportFile);

      while (sc.hasNextLine()) {
        String arrayValue = sc.next();
        customerDataArray.add(arrayValue);
      }

      sc.close();

      MapCustomerData mapCustomerData = new MapCustomerData();
      mapCustomerData.mapArray(customerDataArray);
      mapCustomerData.printDatabase(mapCustomerData.getCustomerDatabase());

      BusinessLogic.outputFinalCustomerPurchase(mapCustomerData.getCustomerDatabase());


    } catch (FileNotFoundException e) {
      System.out.println("File does not exist.");
      e.printStackTrace();
    }
  }
}