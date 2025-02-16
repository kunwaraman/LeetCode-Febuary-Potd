import java.util.*;
/*
time : O(n!)
space : O(n) recursion stack space
 */
public class ConstructTheLexicographicallyLargestValidSequence {

    public int[] constructDistancedSequence(int n) {
        int res[] = new int[2*n-1];
        Arrays.fill(res,-1);
        boolean used[]=new boolean[n+1];
        recur(0,n,res,used);
        return res;
    }
    public boolean recur(int i,int n,int res[],boolean used[]){
        if(i>=res.length){
            return true;
        }
        if(res[i]!=-1){
            return recur(i+1,n,res,used);
        }
        for(int num=n;num>=1;num--){
            if(used[num]){
                continue;
            }
            // try if not used
            used[num]=true;
            res[i]=num;

            // explore
            if(num==1){
                if(recur(i+1,n,res,used)==true){
                    return true;
                }
            }else{
                int j=res[i]+i;
                if(j<res.length && res[j]==-1){
                    res[j]=num;
                    if(recur(i+1,n,res,used)==true){
                        return true;
                    }
                    res[j]=-1;
                }
            }
            // undo
            used[num]=false;
            res[i]=-1;
        }
        return false;
    }
}
