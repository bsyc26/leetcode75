import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/** Return true if two words are close
  * close: one word can convert into another using two ops any times
  * op1: swap two chars
  * op2: swap all occurrence of two chars */
public class DetermineIfTwoStringsAreClose { // leetcode 1657
    // hash-set + sort
    public boolean closeStrings(String word1, String word2) { // T: O(MlogM+NlogN), S: O(M+N).
        // edge case
        if (word1.length() != word2.length())
            return false;
        // data structures
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c1 : word1.toCharArray())
            map1.put(c1, map1.getOrDefault(c1,0)+1);
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c2 : word2.toCharArray())
            map2.put(c2, map2.getOrDefault(c2,0)+1);
        // char must be same
        if (!map1.keySet().equals(map2.keySet()))
            return false;
        // freq must be same
        List<Integer> freq1 = new ArrayList<>();
        for (int val : map1.values())
            freq1.add(val);
        freq1.sort((a, b) -> (a - b));
        List<Integer> freq2 = new ArrayList<>();
        for (int val : map2.values())
            freq2.add(val);
        freq2.sort((a, b) -> (a - b));
        if (!freq1.equals(freq2))
            return false;
        // return fallback
        return true;
    }
}
