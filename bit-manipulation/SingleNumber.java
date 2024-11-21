// leetcode 136
// bit-map
// T: O(N)
// S: O(1)

class Solution { // num ^= num == 0 // ^ onto same nums produce 0

    /** Return the only elem in nums[] that appears once */
    public int singleNumber(int[] nums) {
        // res
        int res = 0;
        for (int num : nums)
            res ^= num;
        // return res
        return res;
    }

}
