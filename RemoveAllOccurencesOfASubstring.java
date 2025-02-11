import java.util.*;
/*
ps: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
time: O(n)
space: O(n)
 */

public class RemoveAllOccurencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(s.charAt(i));
            if(stack.size()>=part.length() && ispossible(stack,part,m)==true){
                for(int j=0;j<m;j++){
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public boolean ispossible(Stack<Character>stack,String part,int m){
        Stack<Character> stack1 = new Stack<>();
        stack1.addAll(stack);
        for(int i=part.length()-1;i>=0;i--){
            if(stack1.peek()!=part.charAt(i)){
                return false;
            }
            stack1.pop();
        }
        return true;
    }
}
