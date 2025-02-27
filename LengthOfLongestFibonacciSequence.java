import java.util.*;
/*
time : O(n^3)
space : O(n)
 */

public class LengthOfLongestFibonacciSequence {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int maxlen=0;
        for(int j=1;j<n;j++){
            for(int k=j+1;k<n;k++){
                int len=recur(j,k,arr,map);
                if(len>=3){
                    maxlen=Math.max(maxlen,len);
                }
            }
        }
        return maxlen;
    }
    public int recur(int j,int k,int arr[],HashMap<Integer,Integer> map){
        int target=arr[k]-arr[j];
        if(map.containsKey(target) && map.get(target)<j){
            int i=map.get(target);
            return recur(i,j,arr,map)+1;
        }
        return 2;
    }
}
