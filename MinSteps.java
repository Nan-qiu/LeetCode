package leetcode;

public class MinSteps {
    public static void main(String[] args){
        System.out.println(minSteps(15));
    }

    public static int minSteps(int n){
        int res = 0;
        if (n <= 1) return 0;
        for(int i = 2; i <= n; i++){
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}
