// Adrian Marquez
// 04/06/2025
// Module 3.2 

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        // Create and fill original list
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1); // random number between 1 and 20
        }

        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        System.out.println("\nList after removing duplicates:");
        System.out.println(noDuplicates);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        Set<E> set = new LinkedHashSet<>(list); // Removes duplicates and keeps order
        return new ArrayList<>(set);            // Convert back to ArrayList
    }
}

