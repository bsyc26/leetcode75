// leetcode 901
// mono-stack
// T: O(N)
// S: O(N)

import java.util.Stack;

class StockSpanner {

    // field // DS - mono-stack
    private Stack<int[]> stk; // int[i] = [price, span]

    // constructor
    public StockSpanner() {
        stk = new Stack<>();
    }

    /** Return the span of the stock's price given today's price
      * span: max num of consecutive days backwards when price is less than or equal to price */
    public int next(int price) {
        // res
        int count = 1; // at least today
        // mono-stack
        while (!stk.isEmpty() && price >= stk.peek()[0]) {
            // pop
            int[] prev = stk.pop();
            // update res
            count += prev[1];
        }
        // push
        stk.push(new int[]{ price, count });
        // return
         return count;
    }

}
