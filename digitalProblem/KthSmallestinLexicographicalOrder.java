package leetcode.digitalProblem;

public class KthSmallestinLexicographicalOrder {
    public int findKthNumber(int n,int k){
        int cur = 1;
        k -= 1;
        while (k > 0) {
            int count = getCount(n,cur);
            if (count > k){
                cur *= 10;
                k -= 1;
            } else{
                cur += 1;
                k -= count;
            }
        }
        return cur;
    }

    private int getCount(long n,long cur){
        long next = cur + 1;
        long total = 0;
        while (cur <= n) {
            total += Math.min(n - cur + 1,next * 10 - cur * 10);
            next *= 10;
            cur *= 10;
        }
        return (int) total;
    }
}
