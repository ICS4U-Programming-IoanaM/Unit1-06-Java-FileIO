import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public final class FileIO {
  // constructor
  public FileIO() {
    // empty constructor
  }

  public static String calcSum (String[] fileArrayStr, int sum) throws FileNotFoundException {
    try {
      int[] fileArray = new int[fileArrayStr.length];

      for (int index = 0; index < fileArrayStr.length; index++) {
        fileArray[index] = Integer.parseInt(fileArrayStr[index]);
        sum += fileArray[index];
      }
      return String.valueOf(sum);

    } catch (NumberFormatException e) {
      return "Invalid input, could not calculate.";
    }
  }

  public static void main(String[] args) {
    try {
      // finding input file and setting scanner to read it
      File inputFile = new File("Unit2/Unit2-02/Unit1-06-Java-FileIO/input.txt");
      Scanner scanner = new Scanner(inputFile);

      // finding output file and setting FileWriter to it
      File outputFile = new File("Unit2/Unit2-02/Unit1-06-Java-FileIO/output.txt");
      FileWriter writer = new FileWriter(outputFile);

      // loops until there is nothing to read
      while (scanner.hasNextLine()) {
        // reads line in file and splits it by space char
        String[] fileArrayStr = scanner.nextLine().split(" ");

        // variables
        int sum = 0;

        // calling function and writing to file
        writer.write(calcSum(fileArrayStr, sum));
        writer.write("\n");
      }
      // message to console confirming the process finished with no errors
      System.out.println("Successfully completed task!");

      // close scanner and writer
      scanner.close();
      writer.close();

    // file could not be found
    } catch (IOException e) {
      System.out.println("The file does not exists.");
    }
  }
}