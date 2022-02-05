package leetcode.digitalProblem;

public class SumOfUniqueElements {
    public static void main(String[] args){
        int[] n = {1,1,1,1};
        System.out.println(sumOfUnique(n));
    }

    public static int sumOfUnique(int[] nums){
        int res = 0;
        int[] table = new int[101];
        for(int num : nums){
            if (table[num] == 0){
                res += num;
                table[num] = 1;
            } else if (table[num] == 1){
                res -= num;
                table[num] = 2;
            }
        }
        return res;
    }
}
