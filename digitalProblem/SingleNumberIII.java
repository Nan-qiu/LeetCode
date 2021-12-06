package leetcode.digitalProblem;

import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args){
        int[] a = {1,1,2,3,3,4};
        System.out.println(Arrays.toString(singleNumber(a)));
    }

    public static int[] singleNumber(int[] nums){
        int xor = 0;
        for(int a : nums){
            xor ^= a;
        }
        int bit = xor & (-xor);//取出xor中最右边的1，两数在这个1的位置上必不同
        int[] res = new int[2];
        //根据这个1把所有数分两类，& 后为0或不为0
        for(int a : nums){
            if ((a & bit) == 0) res[0] ^= a; //判断条件必须是(a & bit) == 0
            else res[1] ^= a;
        }
        return res;
    }
}
