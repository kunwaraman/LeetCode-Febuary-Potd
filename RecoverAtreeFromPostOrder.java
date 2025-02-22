/*
time : O(n)
space : O(n)
 */
public class RecoverAtreeFromPostOrder {
    int n;
    public TreeNode recoverFromPreorder(String traversal) {
        n=traversal.length();
        int [] index={0};
        return recur(traversal,index,0);
    }
    public TreeNode recur(String traversal,int[] index,int depth){
        if(index[0]>=n){
            return null;
        }
        int j=index[0];
        while(j<n && traversal.charAt(j)=='-'){
            j++;
        }
        int dash=j-index[0];
        if(depth!=dash){
            return null;
        }
        index[0]+=dash;
        int value=0;
        while(index[0]<n && Character.isDigit(traversal.charAt(index[0]))){
            value=value*10+(traversal.charAt(index[0])-'0');
            index[0]++;
        }
        TreeNode root = new TreeNode(value);
        root.left=recur(traversal,index,depth+1);
        root.right=recur(traversal,index,depth+1);
        return root;
    }
}
