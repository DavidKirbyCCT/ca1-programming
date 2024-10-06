import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {
  public static void main(String[] args) {
    // reads data from file and creates an array, array is then looped through and customer profiles created 

    ArrayList<Object> customerDataArray = new ArrayList<Object>();

    try {
      File customerImportFile = new File("customers.txt");
      Scanner customerScanner = new Scanner(customerImportFile);

      while (customerScanner.hasNextLine()) {
        String arrayValue = customerScanner.next();
        customerDataArray.add(arrayValue);
      }
      customerScanner.close();
    } 
    
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
    }