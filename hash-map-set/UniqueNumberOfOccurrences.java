import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/** Return true if every elem has unique occurrence */
public class UniqueNumberOfOccurrences { // leetcode 1207
    // hash-map + hash-set
    public boolean uniqueOccurrences(int[] arr) { // T: O(N), S: O(N).
        // data structures
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int elem : arr)
            freqMap.put(elem, freqMap.getOrDefault(elem,0)+1);
        Set<Integer> freqSet = new HashSet<>(freqMap.values()); // Set auto de-duplicates
        // return
        return freqSet.size() == freqMap.size();
    }
}
