// leetcode 739
// mono-stack
// T: O(N)
// S: O(N)

import java.util.Stack;

class Solution {

    /** Return an arr[] where arr[i] is the num of days to wait after i-th day to get warm temp
      * if no future day is warn, arr[i] is 0 */
    public int[] dailyTemperatures(int[] temperatures) {
        // const
        int N = temperatures.length;
        // res
        int[] res = new int[N];
        // DS - Stack
        Stack<Integer> stk = new Stack<>(); // stores next index of warmer temp
        // mono-stack
        for (int i = N-1; i >= 0; i--) { // reverse
            // pop
            while (!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i])
                stk.pop();
            // update res
            res[i] = stk.isEmpty() ? 0 : stk.peek()-i;
            // push
            stk.push(i);
        }
        // return
        return res;
    }

}
