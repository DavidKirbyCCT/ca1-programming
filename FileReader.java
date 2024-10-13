import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
  public static ArrayList<Object> readInputFile() {
    // reads data from file and returns an array to be looped through for mapping

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

    } catch (FileNotFoundException e) {
      System.out.println("File does not exist.");
      e.getCause();
      return null;
    }

    return customerDataArray;
  }

  public static void CreateExportFile() {
    try {
      File customerDiscountExport = new File("customerdiscount.txt");
      if (customerDiscountExport.createNewFile()) {

        System.out.println("File created: " + customerDiscountExport.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void writeDatatoFile(String customerDiscountData) {
    try {
      FileWriter myWriter = new FileWriter("customerdiscount.txt");
      myWriter.write(customerDiscountData);
      myWriter.close();
      System.out.println("Successfully written data to file.");
    } catch (IOException e) {
      System.out.println("An error occurred while writing data to file.");
      e.printStackTrace();
    }
  }
}
