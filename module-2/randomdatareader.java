import java.io.*;
import java.util.Scanner;

public class RandomDataReader {
    public static void main(String[] args) {
        String fileName = "yourname_datafile.dat";
        
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }
    }
}
