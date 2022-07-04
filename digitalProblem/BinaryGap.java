package leetcode.digitalProblem;

public class BinaryGap {
    public static void main(String[] args){
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.binaryGap(22));
    }


    public int binaryGap(int n){
        int count = 1;
        int res = 0;
        while (n > 0 && (n & 1) != 1) n >>= 1;
        //再移一位
        n >>= 1;

        while (n > 0) {
            if ((n & 1) == 1){
                res = Math.max(res, count);
                count = 1;
            } else count++;
            n >>= 1;
        }
        return res;
    }
}
