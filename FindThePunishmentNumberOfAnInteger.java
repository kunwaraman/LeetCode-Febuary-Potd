/*
ps : https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
time : O(n^3)
space : O(n^2)

 */

public class FindThePunishmentNumberOfAnInteger {
    public int punishmentNumber(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            int sq=i*i;
            String s = Integer.toString(sq);
            if(check(0,0,s,i)==true){
                res+=sq;
            }
        }
        return res;
    }
    boolean check(int i,int currsum,String s,int num){
        if(i==s.length()){
            return currsum==num;
        }
        if(currsum>num){
            return false;
        }
        boolean posbl=false;
        for(int j=i;j<s.length();j++){
            String curr=s.substring(i,j+1);
            int val=Integer.parseInt(curr);
            posbl=posbl||check(j+1,currsum+val,s,num);


        }
        return posbl;
    }
}
