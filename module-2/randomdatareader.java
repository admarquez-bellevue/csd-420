// Adrian Marquez
// 05/17/2025
// Module 2.2 Redo

import java.io.*;
import java.util.Scanner;

public class randomdatareader {
    public static void main(String[] args) {
        String fileName = "adrian_datafile.dat";
        
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
