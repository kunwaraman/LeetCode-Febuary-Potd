// ps: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
// time complexity : O(n)
// space complexity : O(1) 26 as a constant  


public class CheckIfOneStringSwapCanMakeStringsEquals {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        if(s1==s2){
            return true;
        }
        int diff =0;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
            if(diff>2){
                return false;
            }
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        // new character jo ek main present na ho
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;

    }
}
