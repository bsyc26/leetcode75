import java.util.Stack;

/** Return the state of asteorids after collision
  * asteroids[i] is its size, the sign is its direction, all moves at the same speed
  * larger size covers minor size, same size cancel out each other */
public class AsteroidCollision { // leetcode 735
    // stack
    public int[] asteroidCollision(int[] asteroids) { // T: O(N), S: O(N).
        // data structures
        Stack<Integer> stk = new Stack<>();
        for (int ast : asteroids) {
            boolean isAstKept = true;
            while (!stk.isEmpty() && stk.peek()>0 && ast<0) { // will collision: pos meet neg
                if (Math.abs(stk.peek()) < Math.abs(ast)) { // top of stk is desroyed
                    stk.pop();
                    continue; 
                } else if (Math.abs(stk.peek()) == Math.abs(ast)) { // cancel out top and ast
                    stk.pop(); 
                    isAstKept = false;
                    break;
                } else { // ast is destroyed
                    isAstKept = false;
                    break;
                }
            }
            if (isAstKept)
                stk.push(ast);
        }
        // variables
        int[] resAst = new int[stk.size()];
        for (int i = stk.size()-1; i >= 0; i--) // reversely load elems
            resAst[i] = stk.pop();
        // return
        return resAst;
    }
}
