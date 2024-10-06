import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {
  public static void main(String[] args) {
    ArrayList<Object> customerDataArray = new ArrayList<Object>();

    try {
      File customerDataArrayFile = new File("customers.txt");

      Scanner customerScanner = new Scanner(customerDataArrayFile);

      while (customerScanner.hasNextLine()) {
        String arrayValue = customerScanner.next();
        customerDataArray.add(arrayValue);
        
        System.out.println(customerDataArray);
         
      }
      customerScanner.close();
    } 
    
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
    }