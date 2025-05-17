// Adrian Marquez
// 05/17/2025
// Module 2.2 Redo

import java.io.*;
import java.util.Random;

public class randomdatawriter {
    public static void main(String[] args) {
        String fileName = "adrian_datafile.dat";
        Random rand = new Random();
        
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            pw.println("Integers:");
            for (int i = 0; i < 5; i++) {
                pw.print(rand.nextInt(100) + " ");
            }
            pw.println();
            
            pw.println("Doubles:");
            for (int i = 0; i < 5; i++) {
                pw.print(rand.nextDouble() * 100 + " ");
            }
            pw.println();
            
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}