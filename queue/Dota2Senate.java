import java.util.Queue;
import java.util.LinkedList;

/** Return the "Radiant"/"Dire" by which wins
  * senate: String composed of 'R' and 'D'
  * in each round, each senator can do two ops, starting from left to right
  * op1: ban a senator (jump turn); op2: annouce victory if only one party left */
public class Dota2Senate { // leetcode 649
    // queue:two-queues
    public String predictPartyVictory(String senate) { // T: O(N), S: O(N).
        // constants
        int N = senate.length();
        // data structures
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (senate.charAt(i) == 'R') rq.add(i);
            else dq.add(i);
        }
        // counter turns
        while (!rq.isEmpty() && !dq.isEmpty()) {
            int rIdx = rq.poll();
            int dIdx = dq.poll();
            if (rIdx < dIdx) // the low ban the high, earn next turn
                rq.offer(rIdx + N);
            else
                dq.offer(dIdx + N);
        }
        // return
        return rq.isEmtpy() ? "Dire" : "Radiant";
    }
}
