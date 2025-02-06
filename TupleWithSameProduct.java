import java.util.*;
/*
https://leetcode.com/problems/tuple-with-same-product/
 time: O(n^2)
 space: O(n)

 */
public class TupleWithSameProduct {
    class Solution {
        public int tupleSameProduct(int[] nums) {
            int n = nums.length;
            HashMap<Integer,Integer> map = new HashMap<>();
            int tuples=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int p = nums[i]*nums[j];
                    map.put(p,map.getOrDefault(p,0)+1);
                }
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                int prod=entry.getKey();
                int freq = entry.getValue();
                tuples+=(freq*(freq-1))/2;

            }
            return tuples*8;
        }
    }
}
