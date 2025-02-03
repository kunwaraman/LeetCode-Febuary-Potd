//time complexity : O(n)
// space complexity : O(1)
//ps: https://leetcode.com/problems/longest-strictly-increasing-subarray/

public class LongestStrictlyOrStrictlyDecreasingSubArray {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int max=1;
        int inc=1;
        int dec=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                inc++;
                dec=1; // wapis se reset
                max=Math.max(max,inc);
            }else if(nums[i]<nums[i-1]){
                dec++;
                inc=1;
                max=Math.max(max,dec);
            }else{ // for equal element
                inc=1;
                dec=1;
            }

        }
        return max;

    }
}
