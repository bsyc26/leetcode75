import java.util.HashMap;
import java.util.HashSet;

/** Return true if every elem has unique occurrence */
public class Solution { // leetcode 1207
    // hash-map + hash-set
    public boolean uniqueOccurrences(int[] arr) { // T: O(N), S: O(N).
        // data structures
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int elem : arr)
            freqMap.put(elem, freqMap.getOrDefault(elem,0)+1);
        // unique set
        HashSet<Integer> freqSet = new HashSet<>(freqMap.values()); // Set auto de-duplicates
        // return
        return freqSet.size() == freqMap.size();
    }
}
