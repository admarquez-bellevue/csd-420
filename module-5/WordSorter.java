import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSorter {
    public static void main(String[] args) {
        // Read words from file into a Set to eliminate duplicates
        Set<String> wordSet = new HashSet<>();

        try {
            File file = new File("collection_of_words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    wordSet.add(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        // Convert set to list for sorting
        List<String> wordList = new ArrayList<>(wordSet);

        // Ascending order
        Collections.sort(wordList);
        System.out.println("Non-duplicate words in ascending order:");
        for (String word : wordList) {
            System.out.println(word);
        }

        // Descending order
        Collections.sort(wordList, Collections.reverseOrder());
        System.out.println("\nNon-duplicate words in descending order:");
        for (String word : wordList) {
            System.out.println(word);
        }
    }
}

