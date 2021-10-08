package leetcode.digitalProblem;

public class PowerOfThree {
    public static void main(String[] args){
        int a = 0;
        int m = 0;
        for(int i = 0; i < 1000; i++){
            a = (int) Math.pow(4,i);
            m = i;
            if ((int) Math.pow(4,i + 1) == Integer.MAX_VALUE) break;
        }
        System.out.println(a);
        System.out.println(m);
    }

    public static boolean isPowerOfTwo(int n){
        return n > 0 && 1073741824 % n == 0;
        //return n>0&&(n&(n-1))==0;
    }

    public static boolean isPowerOfThree(int n){
        return n > 0 && 1162261467 % n == 0;
    }

    public static boolean isPowerOfFour(int n){
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

}
