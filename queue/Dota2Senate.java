import java.util.Queue;
import java.util.LinkedList;

/** Return the "Radiant"/"Dire" by which wins
  * senate: String composed of 'R' and 'D'
  * in each round, each senator can do two ops, starting from left to right
  * op1: ban a senator (jump turn); op2: annouce victory if only one party left */
public class Solution { // leetcode 649
    // queue:two-queues
    public String predictPartyVictory(String senate) { // T: O(N), S: O(N).
        // constants
        int N = senate.length();
        // data structures
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qD = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (senate.charAt(i) == 'R') qR.add(i);
            else qD.add(i);
        }
        // counter turns
        while (!qR.isEmpty() && !qD.isEmpty()) {
            int idxR = qR.poll();
            int idxD = qD.poll();
            if (idxR < idxD) // the low ban the high, earn next turn
                qR.offer(idxR + N);
            else
                qD.offer(idxD + N);
        }
        // return
        return qR.isEmpty() ? "Dire" : "Radiant";
    }
}
