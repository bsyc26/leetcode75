import java.util.HashSet;
import java.util.PriorityQueue;

/** Implement the SmallestInfiniteSet class:
  * SmallestInfiniteSet(): init the obj to contains all posotive ints
  * int popSmallest(): removes and returns the smallest int in set
  * void addBack(int num): adds a positive int num back */
// pq + hash-set
public class SmallestInfiniteSet { // leetcode 2336
    // fields
    // data structures
    private HashSet<Integer> set;
    private PriorityQueue<Integer> pq;
    private Integer curInt; // case pq && set is empty
    // constructors
    public SmallestInfiniteSet() {
        set = new HashSet<>();
        pq = new PriorityQueue<>();
        curInt = 1;
    }
    // remove methods
    public int popSmallest() { // T: O(logN).
        int min;
        if (!pq.isEmpty()) {
            min = pq.poll();
            set.remove(min);
        } else {
            min = curInt;
            ++curInt;
        }
        return min;
    }
    // insert methods
    public void addBack(int num) { // T: O(logN).
        if (curInt <= num || set.contains(num))
            return;
        pq.offer(num);
        set.add(num);
    }
}
