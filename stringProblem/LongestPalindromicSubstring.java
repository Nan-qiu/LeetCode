package leetcode.stringProblem;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s){ // manacher
        char[] str = manacherArr(s);
        int C = -1;// 最大回文中心点
        int R = -1;// 最大回文半径的后一个位置
        int[] pArr = new int[str.length];//回文半径数组
        int firstMaxC = -1;//第一次发现的最大回文半径时的中心点
        int firstMaxpArr = -1;//第一次发现的最大回文半径

        for(int i = 0; i < str.length; i++){
            pArr[i] = R > i ? Math.min(pArr[2 * C - i],R - i) : 1;

            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) pArr[i]++;
                else break;
            }

            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > firstMaxpArr){
                firstMaxpArr = pArr[i];
                firstMaxC = C;
            }
            System.out.println(firstMaxC + ":" + firstMaxpArr);
        }

        return s.substring((firstMaxC - firstMaxpArr + 2) / 2,(firstMaxC + firstMaxpArr) / 2);
    }

    private static char[] manacherArr(String s){
        char[] cs = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : cs[index++];
        }
        return res;
    }
}
