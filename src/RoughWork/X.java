package RoughWork;

import java.util.HashMap;
import java.util.Map;

public class X {
    public static void main(String[] args) {
        int[] array = { 2, 5, 2, 8, 3, 5, 2, 6, 4, 8 };

        Map<Integer, Integer> occurrences = countDuplicateOccurrences(array);

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            System.out.println("Element " + element + " occurs " + count + " times");
        }
    }

    public static Map<Integer, Integer> countDuplicateOccurrences(int[] array) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int element : array) {
            if (occurrences.containsKey(element)) {
                occurrences.put(element, occurrences.get(element) + 1);
            } else {
                occurrences.put(element, 1);
            }
        }

        return occurrences;
    }
}
