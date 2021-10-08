package leetcode.stringProblem;

import java.util.HashSet;

public class LongestStringWithoutSame {//https://leetcode-cn.com/problems/wtcaE1/
    public static void main(String[] args){
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(a));
    }

    public static int lengthOfLongestSubstring(String s){
        int res = 0;
        int i = 0;
        HashSet<Character> set = new HashSet<>();
        for(int k = 0; k < s.length(); k++){
            while (set.contains(s.charAt(k))) {
                set.remove(s.charAt(i++));
                res = Math.max(res,set.size());
            }
            set.add(s.charAt(k));
            res = Math.max(res,set.size());
        }
        return res;
    }
}
