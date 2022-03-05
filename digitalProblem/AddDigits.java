package leetcode.digitalProblem;

public class AddDigits {
    public static void main(String[] args){
        System.out.println(addDigits1(0));
    }

    public static int addDigits1(int num){
        return num != 0 && num % 9 == 0 ? 9 : num % 9;
    }

    public static int addDigits(int num){
        char[] numS;
        while (num >= 10) {
            numS = toChars(num);
            num = 0;
            for(char c : numS){
                num += c - '0';
            }
        }
        return num;
    }

    private static char[] toChars(int sum){
        return String.valueOf(sum).toCharArray();
    }
}
