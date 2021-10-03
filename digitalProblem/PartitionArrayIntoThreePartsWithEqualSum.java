package leetcode.digitalProblem;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args){
        int[] a = {0,0,0,0};
        System.out.println(canThreePartsEqualSum(a));
    }

    public static boolean canThreePartsEqualSum(int[] arr){
        int sum = 0;
        for(int n : arr){
            sum += n;
        }
        if (sum % 3 != 0) return false;
        int s = 0;
        int flag = 0; // 信号
        for(int j : arr){
            s += j;
            if (s == sum / 3){
                flag++;
                s = 0;
            }
        }
        return flag >= 3;
    }
}
