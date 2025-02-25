/*
time : O(n)
space : O(1)
 */

public class NumberOfSubArrayWithOddSum {
    class Solution {
        int M = (int) (1e9 + 7);
        public int numOfSubarrays(int[] arr) {
            int n = arr.length;
            int sum=0;
            int count=0;
            int odd=0;
            int even=1;
            for(int i=0;i<n;i++){
                sum+=arr[i];
                if(sum%2==0){
                    count=(count+odd)%M;
                    even++;
                }else{ // odd dikha hai
                    count=(count+even)%M;
                    odd++;
                }
            }
            return count;
        }
    }
}
