package leetcode.digitalProblem;

public class PalindromeNumber {

    public boolean isPalindrome1(int x){
        return x >= 0 && new StringBuilder().append(x).reverse().toString().equals(Integer.toString(x));
    }

    public boolean isPalindrome(int x){
        if (x < 0) return false;
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == num;
    }
}
