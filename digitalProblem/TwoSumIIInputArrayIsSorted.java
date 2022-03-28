package leetcode.digitalProblem;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers,int target){
        int fir = 0;
        int sec = numbers.length - 1;
        while (fir < sec) {
            int sum = numbers[fir] + numbers[sec];
            if (sum == target) return new int[]{fir + 1,sec + 1};
            else if (sum > target) sec--;
            else fir++;
        }
        return new int[]{};
    }
}
