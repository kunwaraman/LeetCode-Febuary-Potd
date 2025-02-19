import java.util.*;
/*
time complexity n*(2^n)
space complexity O(n*2^n)
 */
public class TheKthLexixographicallyStringOfAllHappyStrings {
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        recur(sb,list,n);
        if(k>list.size()){
            return "";
        }
        return list.get(k-1);
    }
    public void recur(StringBuilder sb,ArrayList<String> list,int n){
        if(sb.length()==n){
            list.add(sb.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==ch){ // curr emplty bhi nahi hona chahiye
                continue;
            }
            sb.append(ch);
            recur(sb,list,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
