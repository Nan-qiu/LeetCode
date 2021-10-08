package leetcode.stringProblem;

public class KMP { //KMP算法，有s 和m 两个字符串，求m是否在s里，返回m在s里的第一个下标
    public static void main(String[] args){
        String s = "abcabcabcabc";
        String m = "bcabca";
        System.out.println(getIndexOf(s,m));
    }

    public static int getIndexOf(String s,String m){
        if (s == null || m == null || m.length() < 1 || m.length() > s.length()) return -1;
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2); //生成每个下标左边对应的最长前缀和最长后缀的匹配长度,前后缀不能取整体
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]){
                i1++;
                i2++;
            } else if (next[i2] == -1) i1++; // str2中比对的位置已经无法往前跳了
            else i2 = next[i2]; // 把str2往右推，i2跳到i2的最长前缀和的下一个位置
        }
        // 如果是i2越界，就说明str2全部都配出来了，返回i1-i2，就是str2在str1里的第一个下标
        // 否则就是i1越界，str2里没有在str1里，返回-1
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms){
        if (ms.length == 1) return new int[]{-1};
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; //next数组从2开始
        int cn = 0;
        while (i < ms.length) {
            if (ms[i - 1] == ms[cn]) next[i++] = ++cn; //当i-1位置的值等于cn位置的值，把cn+1赋给next[i]，然后i++
            else if (cn > 0) cn = next[cn]; //cn来到cn位置的最长前缀的下一个位置
            else next[i++] = 0;
        }
        return next;
    }
}
