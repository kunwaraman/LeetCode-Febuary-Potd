import java.util.*;
/*
time: O(n)
space: O(n)
 */

public class ClearDigits {
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        for(char ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}
