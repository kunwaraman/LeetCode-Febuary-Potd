import java.util.*;
// time complexity: O(n)
// space complexity: O(n)
// ps: https://leetcode.com/problems/number-of-distinct-balls-in-a-box

public class NumberOfDistinctBallsAmongAllTheColor {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int ans[] = new int[n];
        HashMap<Integer,Integer> ballmap = new HashMap<>();
        HashMap<Integer,Integer> colormap = new HashMap<>();
        for(int i=0;i<n;i++){
            int ball= queries[i][0];
            int color=queries[i][1];
            if(ballmap.containsKey(ball)){
                int prevcolor=ballmap.get(ball);
                colormap.put(prevcolor,colormap.get(prevcolor)-1);
                if(colormap.get(prevcolor)==0){
                    colormap.remove(prevcolor);
                }
            }
            ballmap.put(ball,color);
            colormap.put(color,colormap.getOrDefault(color,0)+1);
            ans[i]=colormap.size();
        }
        return ans;

    }
}
