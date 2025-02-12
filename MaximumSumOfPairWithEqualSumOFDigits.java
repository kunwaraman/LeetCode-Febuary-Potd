import java.util.HashMap;
/*
time: O(n)
space: O(n)
 */
public class MaximumSumOfPairWithEqualSumOFDigits {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int res=-1;
        for(int i=0;i<n;i++){
            int digit=digitsum(nums[i]);
            if(map.containsKey(digit)){
                res=Math.max(res,nums[i]+map.get(digit));
            }
            map.put(digit,Math.max(map.getOrDefault(digit,0),nums[i]));

        }
        return res;

    }
    public int digitsum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
