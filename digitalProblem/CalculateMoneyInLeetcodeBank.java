package leetcode.digitalProblem;

public class CalculateMoneyInLeetcodeBank {
    public static void main(String[] args){
        System.out.println(totalMoney(141));
    }

    public static int totalMoney(int n){
        int[] table = {1,3,6,10,15,21,28};
        int week = n / 7;
        int left = n % 7 - 1;
        if (week == 0) return table[left];
        else{
            int res = 0;
            if (week - 2 >= 0){
                int count = 1;
                for(int i = 0; i < week - 1; i++){
                    res += count++;
                }
            }
            if (left >= 0) return 28 * week + res * 7 + week * (left + 1) + table[left];
            else return 28 * week + res * 7;
        }
    }
}
//1234567=28
//2345678=35
//3456789=42   105
//456=15