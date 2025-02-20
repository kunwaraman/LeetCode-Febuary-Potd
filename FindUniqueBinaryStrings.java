import java.util.*;
/*
time : O(2^n)
space : O(n)
ps : https://leetcode.com/problems/find-unique-binary-string/
 */

public class FindUniqueBinaryStrings {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String num:nums){
            set.add(num);
        }
        return recur(set,sb,n);
    }
    public String recur(HashSet<String> set,StringBuilder sb,int n){
        if(sb.length()==n){
            String curr = sb.toString();
            if(!set.contains(curr)){
                return curr;
            }
            return null;
        }
        sb.append('0');
        String res=recur(set,sb,n);
        if(res!=null){
            return res;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append('1');
        res=recur(set,sb,n);
        if(res!=null){
            return res;
        }
        sb.deleteCharAt(sb.length()-1);
        return null;
    }
}
