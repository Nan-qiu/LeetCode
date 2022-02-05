package leetcode.stringProblem;

public class SortingTheSentence {
    public static void main(String[] args){
        System.out.println(sortSentence("QcGZ4 TFJStgu3 HvsRImLBfHd8 PaGqsPNo9 mZwxlrYzanuVOUZoyNjt1 fzhdtYIen6 mV7 LKuaOtefsixxo5 pwdEK2"));
    }

    public static String sortSentence(String s){
        StringBuilder res = new StringBuilder();
        String[] arr = new String[10];
        String[] s1 = s.split(" ");
        for(String s2 : s1){
            arr[s2.charAt(s2.length() - 1) - '0'] = s2;
        }
        for(String a : arr){
            if (a == null) continue;
            res.append(a).deleteCharAt(res.length() - 1).append(" ");
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }
}
