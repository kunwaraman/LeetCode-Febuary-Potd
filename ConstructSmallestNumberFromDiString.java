// ps : https://leetcode.com/problems/construct-the-lexicographically-smallest-string-from-a-digits-string/
// time : O(n)
// space : O(n)
import java.util.*;

public class ConstructSmallestNumberFromDiString {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int counter=1;
        for(int i=0;i<=n;i++){
            stack.push((char)('0'+counter++));
            if(i==n|| pattern.charAt(i)=='I'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        return sb.toString();
    }
}
