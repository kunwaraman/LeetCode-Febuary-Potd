import java.util.*;
/*
ps: https://leetcode.com/problems/count-number-of-bad-pairs/
time: O(n)
space: O(n)
 */

public class CountABadPairs {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long res=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            nums[i]=nums[i]-i;
        }
        map.put(nums[0],1);
        for(int j=1;j<n;j++){
            int seenbeforej=map.getOrDefault(nums[j],0);
            int tnbj=j;
            int bp = tnbj-seenbeforej;
            res+=bp;
            map.put(nums[j],seenbeforej+1);
        }
        return res;
    }
}
