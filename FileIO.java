import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program reads and writes to a file the sum of a set of ints.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-04-01
 */

// sourced from https://chat.openai.com
@SuppressWarnings("HideUtilityClassConstructor")
public final class FileIO {
  /**
   * Constructor for the FileIO class.
   */
  public FileIO() {
    // empty constructor
  }
  
  /**
   * Calculates the sum of integers from a string array.
   *
   * @param fileArrayStr Array of strings representing integers.
   * @return String representation of the sum.
   */
  public static String calcSum(final String[] fileArrayStr) {
    // variables
    int sum = 0;
    int[] fileArray = new int[fileArrayStr.length];

    try {
      // loops until index = length of array
      for (int index = 0; index < fileArrayStr.length; index++) {
        // converts each element in array to int and adds it to int array
        fileArray[index] = Integer.parseInt(fileArrayStr[index]);

        // calculates the sum of int being added to array
        sum += fileArray[index];
      }
      // return sum as string
      return String.valueOf(sum);

      // fails to convert to int
    } catch (NumberFormatException e) {
      return "Invalid input, could not calculate.";
    }
  }

  /**
   * Reads input from a file, calculate sum, and write to an output file.
   *
   * @param args Command line arguments (unused).
   */
  public static void main(final String[] args) {
    try {
      // finding input file and setting scanner to read it
      File inFile = new File("Unit2/Unit2-02/Unit1-06-Java-FileIO/input.txt");
      Scanner scanner = new Scanner(inFile);

      // finding output file and setting FileWriter to it
      File outFile = new File("Unit2/Unit2-02/Unit1-06-Java-FileIO/output.txt");
      FileWriter writer = new FileWriter(outFile);

      // loops until there is nothing to read
      while (scanner.hasNextLine()) {
        // reads line in file and splits it by space char
        String[] fileArrayStr = scanner.nextLine().split(" ");

        // calling function and writing to file
        writer.write(calcSum(fileArrayStr));
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
