import java.util.Queue;
import java.util.LinkedList;

/** Implement the RecentCounter class
  * RecentCounter(): init the obj with zero recent req
  * int ping(int t): add a new req at time t, return the num of req happened in [t-3000, t] */
public class NumberOfRecentCalls { // leetcode 933
    public class RecentCounter {
        // data structures
        Queue<Integer> q;
        // constructors
        public RecentCounter() {
            q = new LinkedList<>();
        }
        // queue
        public int ping(int t) { // T: O(N), S: O(N).
            q.offer(t);
            while (q.peek() < t-3000) // maintain a window
                q.poll();
            return q.size();
        }
    }
}
