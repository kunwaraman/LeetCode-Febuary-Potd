// time complexity : O(n^2)
// space complexity : O(1)
// ps: https://leetcode.com/problems/maximum-ascending-subarray-sum/

public class MaximumAscendingSubArray {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            int sum=nums[i];
            int j=i+1;
            while(j<n && nums[j]>nums[j-1]){
                sum+=nums[j];
                j++;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}
