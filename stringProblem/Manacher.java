package leetcode.stringProblem;

public class Manacher {// manacher算法 O(n)

    //返回字符串里的最大回文的数量
    public static void main(String[] args){
        String a = "1234321";
    }

    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for(int i = 0; i != res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : charArr[index++]; //i为偶就加 #
        }
        return res;
    }

    public static int maxPldLength(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] str = manacherString(s); // 123 -> #1#2#3#
        int[] pArr = new int[str.length];//回文半径数组
        int C = -1; // 中心点
        int R = -1;// 回文的右边界再往右的一个位置，就是右边界为R-1
        int max = Integer.MIN_VALUE;// R扩出来的最大值
        for(int i = 0; i != str.length; i++){
            //i现在至少有的回文区域，给pArr[i]
            pArr[i] = R > i ? Math.min(pArr[2 * C - i],R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i]++;
                } else break;
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max - 1;//原始串的最大回文数就是处理串的最大的回文半径-1
    }
}
