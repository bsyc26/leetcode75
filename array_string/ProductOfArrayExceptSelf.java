/** Return an arr whose elem is equal to the product of all elems of nums[] except nums[i]
  * T: O(N), and no division op */
public class ProductOfArrayExceptSelf { // leetcode 238
    // prefix-prod
    public int[] productExceptSelf(int[] nums) { // T: O(N), S: O(N).
        // constants
        int N = nums.length;
        // data structures
        int[] preProd = new int[N];
        preProd[0] = 1;
        for (int i = 1; i < N; i++)
            preProd[i] = preProd[i-1] * nums[i-1];
        int[] postProd = new int[N];
        postProd[N-1] = 1;
        for (int i = N-2; i >= 0; i--)
            postProd[i] = postProd[i+1] * nums[i+1];
        // variables
        int[] prodDeSelf = new int[N];
        for (int i = 0; i < N; i++)
            prodDeSelf[i] = preProd[i] * postProd[i];
        // return
        return prodDeSelf;
    }

    // opt:arr2state
    public int[] productExceptSelf(int[] nums) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // variables
        int[] prodDeSelf = new int[N];
        prodDeSelf[0] = 1;
        for (int i = 1; i < N; i++)
            prodDeSelf[i] = prodDeSelf[i-1] * nums[i-1];
        int prodRight = 1;
        for (int i = N-1; i >= 0; i--) {
            prodDeSelf[i] *= prodRight;
            prodRight *= nums[i]; 
        }
        // return
        return prodDeSelf;
    }
}
