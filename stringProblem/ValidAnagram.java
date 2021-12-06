package leetcode.stringProblem;

public class ValidAnagram {
    public static void main(String[] args){
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s,String t){
        if (s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] tmp = new int[26];
        for(char c : cs){ //创建字符串s的词频表
            tmp[c - 'a'] += 1;
        }
        for(char c : ct){//
            tmp[c - 'a'] -= 1;
            if (tmp[c - 'a'] < 0) return false;
        }
        return true;
    }
}
