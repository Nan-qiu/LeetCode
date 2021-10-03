package leetcode.digitalProblem;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args){
        int[] a = {1,79,80,1,1,1,200,1};
        System.out.println(maxScore(a,3));
    }

    public static int maxScore(int[] cardPoints,int k){
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum+=cardPoints[i]; // 从左端开始的k个数的和
        }
        int res = sum;
        for(int i = 0; i < k; i++){
            sum+=cardPoints[cardPoints.length-1-i]; // 把数组右端的数加上
            sum-=cardPoints[k-1-i]; // 把k-1位置的数减去
            res= Math.max(res,sum);
        }
        return res;

        // nt做法 （我写的）
//        int sum = 0;
//        for(int cardPoint : cardPoints){
//            sum += cardPoint;
//        }
//        int last = cardPoints.length - k - 1;
//        int res = 0;
//        for(int i = 0; i < cardPoints.length; i++){
//            int s = 0;
//            for(int j = i; j <= last + i; j++){
//                s += cardPoints[j];
//            }
//            res = Math.max(res,sum - s);
//            if (i == k) return res;
//        }
//        return res;
    }
}
