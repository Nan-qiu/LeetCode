package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    public static void main(String[] args){
        System.out.println(simplifiedFractions(88));
    }

    //最大公因数
    public static int gongying(int a,int b){
        int c = a % b;//使用辗转相除法
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    public static List<String> simplifiedFractions(int n){
        if (n == 1) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        for(int i = n; i > 1; i--){//分母
            for(int j = 1; j < i; j++){//分子
                if (gongying(i,j) == 1) res.add("" + j + "/" + i);
            }
        }
        return res;
    }
}
