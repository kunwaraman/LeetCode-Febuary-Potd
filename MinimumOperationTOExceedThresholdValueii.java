import java.util.*;
/*
time: O(nlogn)
space: O(n)
 */
public class MinimumOperationTOExceedThresholdValueii {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long count=0;
        for(int val:nums){
            pq.add((long)val);
        }
        while(!pq.isEmpty() && pq.peek()<k){
            long first=pq.remove();
            long second=pq.remove();
            pq.add(Math.min(first,second)*2+Math.max(first,second));
            count++;

        }
        return (int)count;

    }
}
