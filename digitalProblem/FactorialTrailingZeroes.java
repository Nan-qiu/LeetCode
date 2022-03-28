package leetcode.digitalProblem;

public class FactorialTrailingZeroes {

    public static void main(String[] args){
        System.out.println(trailingZeroes(50));
    }

    public static int trailingZeroes(int n){
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
//        long sum = 1;
//        while (n > 1) {
//            sum *= n;
//            n--;
//        }
//        System.out.println(sum);
//        StringBuilder builder = new StringBuilder();
//        char[] chars = builder.append(sum).toString().toCharArray();
//        int res = 0;
//        for(int i = chars.length - 1; i >= 0; i--){
//            if (chars[i] == '0') res++;
//            else return res;
//        }
//        return res;
    }
}
