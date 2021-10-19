package leetcode.stringProblem;

public class CountAndSay {
    public static void main(String[] args){
        int a = 5;
        System.out.println(countAndSay(a));
    }

    public static String countAndSay(int n){
        if (n == 1) return "1";
        StringBuilder res = new StringBuilder();
        String last = countAndSay(n - 1);
        for(int i = 0; i < last.length(); i++){
            int count = 1;
            while (i + 1 < last.length() && last.charAt(i) == last.charAt(i + 1)) {
                count++;
                i++;
            }
            res.append(count).append(last.charAt(i));
        }
        return res.toString();
    }
}
