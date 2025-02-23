public class ConstructBinaryTreeFromPreorderAndPostOrderTraversal {

   /*
   time : O(n)
   space : O(n)
    */

    class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int n = preorder.length;
            return recur(0,0,n-1,preorder,postorder);
        }
        public TreeNode recur(int prestart,int poststart,int preend,int preorder[],int postorder[]){
            if(prestart>preend){
                return null;
            }
            TreeNode root = new TreeNode(preorder[prestart]);
            if(prestart==preend){
                return root;
            }
            int nextnode=preorder[prestart+1];
            int j = poststart;
            while(postorder[j]!=nextnode){
                j++;
            }
            int num=j-poststart+1;
            root.left=recur(prestart+1,poststart,prestart+num,preorder,postorder);
            root.right=recur(prestart+num+1,j+1,preend,preorder,postorder);
            return root;
        }
    }
}
