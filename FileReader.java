import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
  public static void main(String[] args) {
    // reads data from file and creates an array, array is then looped through and
    // customer profiles created

    ArrayList<Object> customerDataArray = new ArrayList<Object>();

    try {
      File customerImportFile = new File("customers.txt");
      Scanner sc = new Scanner(customerImportFile);

      while (sc.hasNextLine()) {
        String arrayValue = sc.next();
        customerDataArray.add(arrayValue);
      }

      System.out.println(customerDataArray);
      sc.close();

      MapCustomerData mapCustomerData = new MapCustomerData();
      mapCustomerData.mapArray(customerDataArray);

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}