// Adrian Marquez
// 05/13/2025
// Module 6.2 

import java.util.Comparator;

public class GenericBubbleSort {

    // Method 1: Sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Method 2: Sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Main method to test both versions
    public static void main(String[] args) {
        // Test with Comparable
        Integer[] intArray = {5, 2, 9, 1, 3};
        System.out.println("Original (Comparable):");
        printArray(intArray);
        bubbleSort(intArray);
        System.out.println("Sorted (Comparable):");
        printArray(intArray);

        // Test with Comparator
        String[] strArray = {"banana", "apple", "orange", "grape"};
        System.out.println("\nOriginal (Comparator):");
        printArray(strArray);
        bubbleSort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted (Comparator):");
        printArray(strArray);
    }

    public static <E> void printArray(E[] array) {
        for (E e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}

