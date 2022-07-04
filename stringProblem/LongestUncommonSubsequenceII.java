package leetcode.stringProblem;

public class LongestUncommonSubsequenceII {

    public static void main(String[] args){
        LongestUncommonSubsequenceII ii = new LongestUncommonSubsequenceII();

        String[] s = {"aaaa", "aaa", "aa"};

        System.out.println(ii.findLUSlength(s));
    }

    public int findLUSlength(String[] strs){
        int res = 0;
        out:
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs.length; j++){
                if (i == j) continue;
                //是否为子串
                if (isSubsequence(strs[i], strs[j])){
                    continue out;
                }
            }
            res = Math.max(res, strs[i].length());
        }
        return res == 0 ? -1 : res;
    }

    private boolean isSubsequence(String str1, String str2){
        if (str1.length() > str2.length()) return false;

        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)){
                i++;
            }
            j++;
        }

        return i == str1.length();
    }
}
