import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueCost {

        // A custom comparator that compares two Strings by their length.
        Comparator<String> stringTuple = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.parseInt(s1.split(",")[2]) - Integer.parseInt(s2.split(",")[2]);
            }
        };

        /*
        The above Comparator can also be created using lambda expression like this =>
        Comparator<String> stringLengthComparator = (s1, s2) -> {
            return s1.length() - s2.length();
        };

        Which can be shortened even further like this =>
        Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);
        */

        // Create a Priority Queue with a custom Comparator
        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(stringTuple);

        // Add items to a Priority Queue (ENQUEUE)



        // Remove items from the Priority Queue (DEQUEUE)

}
