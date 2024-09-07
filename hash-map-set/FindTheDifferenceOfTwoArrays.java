import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

/** Return a list of size 2
  * list[0] is distinct elems in nums1[]
  * list[1] is distinct elems in nums2[] */
public class Solution { // leetcode 2215
    // hash-set
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) { // T: O(M+N), S: O(M+N).
        // data structures
        HashSet<Integer> set1 = new HashSet<>();
        for (int elem1 : nums1)
            set1.add(elem1);
        HashSet<Integer> set2 = new HashSet<>();
        for (int elem2 : nums2)
            set2.add(elem2);
        // unique set
        for (int elem2 : nums2)
            if (set1.contains(elem2))
                set1.remove(elem2);
        for (int elem1 : nums1)
            if (set2.contains(elem1))
                set2.remove(elem1);
        // return
        ArrayList<Integer> onlyNums1 = new ArrayList<>(set1);
        ArrayList<Integer> onlyNums2 = new ArrayList<>(set2);
        return Arrays.asList(onlyNums1, onlyNums2);
    }
}
