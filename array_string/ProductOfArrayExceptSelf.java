// leetcode 238
// prefix:pre-prod + prefix:post-prod
// T: O(N) // N: num of elems in nums[]
// S: O(N) // N: num of elems in nums[]

class Solution {
    /** Return an arr whose elem is equal to the product of all elems of nums[] except nums[i]
      * T: O(N), and no division op */
    public int[] productExceptSelf(int[] nums) {
        // const
        int N = nums.length;
        // DS@pre-prod
        int[] preProd = new int[N];
        preProd[0] = 1;
        for (int i = 1; i < N; i++)
            preProd[i] = preProd[i-1] * nums[i-1];
        // DS@post-prod
        int[] postProd = new int[N];
        postProd[N-1] = 1;
        for (int i = N-2; i >= 0; i--)
            postProd[i] = postProd[i+1] * nums[i+1];
        // res
        int[] res = new int[N];
        for (int i = 0; i < N; i++)
            res[i] = preProd[i] * postProd[i];
        // return
        return res;
    }
}

// follow-up
// mono-state
// T: O(N)
// S: O(1)
