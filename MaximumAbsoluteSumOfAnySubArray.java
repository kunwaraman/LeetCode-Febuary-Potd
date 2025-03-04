/*
ps : https://leetcode.com/problems/maximum-absolute-subarray-sum/
time : O(n)
space : O(1)
 */
public class MaximumAbsoluteSumOfAnySubArray {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currsum=nums[0];
        int maxsubsum=nums[0];
        for(int i=1;i<n;i++){
            if(currsum>0){
                currsum+=nums[i];
            }else{
                currsum=nums[i];
            }
            if(currsum>maxsubsum){
                maxsubsum=currsum;
            }
        }

        int minsubsum=nums[0];
        currsum=nums[0];
        for(int i=1;i<n;i++){
            if(currsum<0){
                currsum+=nums[i];
            }else{
                currsum=nums[i];
            }
            if(currsum<minsubsum){
                minsubsum=currsum;
            }
        }
        return Math.max(Math.abs(maxsubsum),Math.abs(minsubsum));


    }
}
