package leetcode.digitalProblem;

public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(reverse(Integer.MAX_VALUE - 1));
    }

    public static int reverse(int x){
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res > 214748364 || (res == 214748364 && tmp > 7)) return 0;
            if (res < -214748364 || (res == -214748364 && tmp < -8)) return 0;
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
//        if (x<10&&x>-10) return x;
//        StringBuilder builder = new StringBuilder();
//        char[] chars = String.valueOf(x).toCharArray();
//        Stack<Character> stack = new Stack<>();
//        if (chars[0] == '-'){
//            for(int i = 1; i < chars.length; i++){
//                stack.push(chars[i]);
//            }
//            while (stack.peek() == '0') {
//                stack.pop();
//            }
//            builder.append('-');
//        } else{
//            for(char aChar : chars){
//                stack.push(aChar);
//            }
//            while (stack.peek() == '0') {
//                stack.pop();
//            }
//
//        }
//        while (!stack.isEmpty()) {
//            builder.append(stack.pop());
//        }
//        try {
//            return Integer.parseInt(builder.toString());
//        } catch (Exception e) {
//            return 0;
//        }
    }
}
