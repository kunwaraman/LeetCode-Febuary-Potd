import java.util.*;
/*
time : O(n!)
space : O(n)
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        boolean used[] = new boolean[n];
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        recur(tiles,sb,set,used);
        return set.size()-1;
    }
    public void recur(String tiles,StringBuilder sb,HashSet<String> set,boolean[]used){
        set.add(sb.toString());
        for(int i=0;i<tiles.length();i++){
            if(used[i]==true){
                continue;
            }
            // do
            used[i]=true;
            sb.append(tiles.charAt(i));
            //explore
            recur(tiles,sb,set,used);
            // undo
            used[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
