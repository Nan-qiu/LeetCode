package leetcode.digitalProblem;

import java.util.HashSet;

public class ReorderedPowerOf2 {
    public static void main(String[] args){
        System.out.println(reorderedPowerOf2(1));
    }

    public static boolean reorderedPowerOf2(int n){
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 30; i++){ // 把所有1e9以内的2的幂次方词频字符串存入集合
            set.add(count(1 << i));
        }
        return set.contains(count(n));
    }

    private static String count(int n){//输出n的词频字符串
        char[] res = new char[10];
        while (n != 0) {
            res[n % 10]++;
            n /= 10;
        }
        return new String(res);
    }
}
