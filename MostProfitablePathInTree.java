import java.uti.*;
/*
ps : https://leetcode.com/problems/most-profitable-path-in-a-tree/
time : O(n)
space : O(n)
 */
public class MostProfitablePathInTree {
    HashMap<Integer,Integer> bobtimemap = new HashMap<>();
    int aliceincome;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        aliceincome=Integer.MIN_VALUE;
        boolean vis[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u= edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // dfs on bob to finding time to reach node till 0
        int time=0;
        Dfsbob(bob,0,adj,vis);

        int income=0;
        Arrays.fill(vis,false);
        DfsAlice(0,0,income,amount,vis,adj);
        return aliceincome;
    }
    public void DfsAlice(int curr,int t,int income,int amount[],boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[curr]=true;
        if(!bobtimemap.containsKey(curr)||t<bobtimemap.get(curr)){
            income+=amount[curr];
        }else if(t==bobtimemap.get(curr)){
            income+=(amount[curr]/2);
        }
        if(adj.get(curr).size()==1 && curr!=0){
            aliceincome=Math.max(aliceincome,income);
        }
        for(int ngbr:adj.get(curr)){ // we just update alcie income jab jab mujh eleaf node milega so in this function we not returnn
            if(!vis[ngbr]){
                DfsAlice(ngbr,t+1,income,amount,vis,adj);
            }
        }

    }
    public boolean Dfsbob(int curr,int t,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[curr]=true;
        bobtimemap.put(curr,t);
        if(curr==0){
            return true;
        }
        for(int ngbr:adj.get(curr)){
            if(vis[ngbr]==false){
                if(Dfsbob(ngbr,t+1,adj,vis)==true){
                    return true;
                }
            }
        }
        bobtimemap.remove(curr);
        return false;
    }


}
