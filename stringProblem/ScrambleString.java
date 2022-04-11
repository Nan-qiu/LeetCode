package leetcode.stringProblem;

public class ScrambleString {
    public static void main(String[] args){
        String a = "123456";
        String substring = a.substring(2);
        String substring1 = a.substring(0, a.length() - 2);
        System.out.println(substring);
        System.out.println(substring1);

    }

    public boolean isScramble(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        return process(s1, s2);
    }

    private boolean process(String s1, String s2){
        if (s1.equals(s2)) return true;
        if (!check(s1, s2)) return false;
        for(int i = 0; i < s1.length(); i++){
            String p1 = s1.substring(0, i);
            String p2 = s1.substring(i);
            String t1 = s1.substring(0, s1.length() - i);
            String t2 = s1.substring(s1.length() - i);
            String q1 = s2.substring(0, i);
            String q2 = s2.substring(i);
            if ((process(p1, q1) && process(p2, q2)) || (process(t2, q1) && process(t1, q2))) return true;
        }
        return false;
    }

    private boolean check(String s1, String s2){
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int[] t1 = new int[26];
        int[] t2 = new int[26];
        for(char c : char1){
            t1[c - 'a']++;
        }
        for(char c : char2){
            t2[c - 'a']++;
        }

        for(int i = 0; i < t1.length; i++){
            if (t1[i] != t2[i]) return false;
        }
        return true;
    }
}
