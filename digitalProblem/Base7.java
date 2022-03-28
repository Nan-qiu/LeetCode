package leetcode.digitalProblem;

public class Base7 {
    public static void main(String[] args){
        System.out.println(convertToBase7(-100));
    }

    public static String convertToBase7(int num){
        StringBuilder builder = new StringBuilder();
        if (num > 0){
            while (num >= 7) {
                builder.append(num % 7);
                num /= 7;
            }
            builder.append(num);
            return builder.reverse().toString();
        } else if (num < 0){
            num = -num;
            while (num >= 7) {
                builder.append(num % 7);
                num /= 7;
            }
            builder.append(num);
            return builder.append("-").reverse().toString();
        }
        return "0";
    }
}
