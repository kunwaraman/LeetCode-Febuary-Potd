/*
ps: https://leetcode.com/problems/special-array-i/
time: O(n)
space: O(1)
 */

public class SpecialArray1 {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]%2==nums[i+1]%2){
                return false;
            }
        }
        return true;
    }
    // another way bit manipulation
    public boolean isArraySpecialbt(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if((nums[i]&1)!=(nums[i+1]&1)){
                return false;
            }
        }
        return true;
    }

}
