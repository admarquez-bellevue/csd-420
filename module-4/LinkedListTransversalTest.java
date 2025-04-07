// Adrian Marquez
// 04/06/2025
// Module 4.2

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTransversalTest {

    public static void main(String[] args) {
        // Test with 50,000 elements
        System.out.println("Testing with 50,000 elements:");
        testLinkedListTraversal(50_000);

        // Test with 500,000 elements
        System.out.println("\nTesting with 500,000 elements:");
        testLinkedListTraversal(500_000);
    }

    public static void testLinkedListTraversal(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the list with sequential integers
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Test using iterator
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next(); // just access the element
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Iterator traversal time: " + (endTime - startTime) + " ms");

        // Test using get(index)
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i); // access element by index
        }
        endTime = System.currentTimeMillis();
        System.out.println("get(index) traversal time: " + (endTime - startTime) + " ms");
    }
}

/*
Explanation:

When using an `Iterator`, traversal is efficient because it moves sequentially through the list with O(1) time per element.

However, using `get(index)` on a `LinkedList` is slow because each call to `get(i)` starts from the beginning or end and walks through the list, resulting in O(n) time per access. So total traversal using `get(index)` is O(n^2) time.

Results:
- For 50,000 elements:
  - Iterator is very fast (milliseconds)
  - get(index) can be significantly slower (possibly seconds)

- For 500,000 elements:
  - Iterator still performs well.
  - get(index) becomes extremely inefficient and very slow (likely many seconds or more)

This test clearly demonstrates why `Iterator` is preferred for traversing `LinkedList`.

Conclusion:
Always use iterators for traversing LinkedLists. Using `get(index)` is extremely inefficient for large lists.
*/

