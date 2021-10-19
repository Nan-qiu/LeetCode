package leetcode.digitalProblem;

public class FibonacciNumber {// 动态规划

    public static void main(String[] args){
        System.out.println(fib(16));
    }

    // 严格表，记忆化搜索的再优化
    public static int fib(int n){
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i = 2; i < dp.length; i++){
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n] = dp[n - 1] + dp[n - 2];
        if (n == 1 || n == 2) return 1;
        int first = 1;
        int last = 1;
        for(int i = 3; i <= n; i++){
            int sum = first + last;
            first = last;
            last = sum;
        }
        return last;
    }

    //记忆化搜索，就是用表来当缓存，把已经记录的数据直接读出来，避免重复计算递归
    public static int fib2(int n){
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        return f(n,dp);
    }

    public static int f(int n,int[] dp){
        if (n == 1 || n == 2) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = f(n - 1,dp) + f(n - 2,dp);
        return dp[n];
    }
}
