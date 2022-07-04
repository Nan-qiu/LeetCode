package leetcode.stringProblem;

public class IntegertoRoman {

    public String intToRoman(int num){
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 13; i++){
            while (num - number[i] >= 0) {
                num -= number[i];
                res.append(str[i]);
            }
        }
        return res.toString();
    }
}
