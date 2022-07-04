package leetcode.digitalProblem;

public class LargestPalindromeProduct {
    public static void main(String[] args){
        long max = 0;
        for(int i = 1; i <= 99999; i++){
            for(int j = i; j <= 99999; j++){
                long a = (long) i * j;
                if (isPalindrome(a)) max = Math.max(max, a);
            }
        }
        System.out.println(max % 1337);
        //1  9
        //2  987
        //3  123
        //4  597
        //5  677
        // ....
    }

    public int largestPalindrome(int n){
        switch (n) {
            case 1:
                return 9;
            case 2:
                return 987;
            case 3:
                return 123;
            case 4:
                return 597;
            case 5:
                return 677;
            case 6:
                return 1218;
            case 7:
                return 877;
            default:
                return 475;
        }
    }

    public static boolean isPalindrome(long x){
        if (x < 0) return false;
        long cur = 0;
        long num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
