package leetcode.stringProblem;

import java.util.Arrays;
import java.util.HashSet;

public class LongestStringWithoutSame {//https://leetcode-cn.com/problems/wtcaE1/

    public static void main(String[] args){
        String a = "abcabcbb";
        System.out.println(maxUnique(a));
    }

    public static int lengthOfLongestSubstring(String s){
        int res = 0;
        int i = 0;
        HashSet<Character> set = new HashSet<>();
        for(int k = 0; k < s.length(); k++){
            while (set.contains(s.charAt(k))) { // 滑动窗口
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(k));
            res = Math.max(res,set.size());
        }
        return res;
    }

    public static int maxUnique(String s){
        int[] map = new int[256];// 这个数组存放每个字符上次出现的位置，初始化都为-1，若0位置是'a'，则map['a']=0
        char[] chs = s.toCharArray();
        Arrays.fill(map,-1);
        int len = 0, pre = -1, cur = 0;
        for(int i = 0; i < chs.length; i++){
            pre = Math.max(pre,map[chs[i]]); //离当前字符最近的瓶颈，瓶颈就是出现过第二次字符的下标，
            cur = i - pre; // 当前字符的最大距离就是  当前位置减去上一次出现
            len = Math.max(len,cur); // 全局的最大距离
            map[chs[i]] = i; //更新map
        }
        return len;
    }
}
