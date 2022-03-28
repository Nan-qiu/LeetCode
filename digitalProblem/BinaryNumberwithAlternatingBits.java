package leetcode.digitalProblem;

public class BinaryNumberwithAlternatingBits {
    public static void main(String[] args){
        System.out.println(hasAlternatingBits(5));
    }

    public static boolean hasAlternatingBits(int n){
        byte f = (byte) (n & 1);
        while (n >= 1) {
            n >>= 1;
            byte k = (byte) (n & 1);
            if (f == k) return false;
            else f = k;
        }
        return true;
    }
}
