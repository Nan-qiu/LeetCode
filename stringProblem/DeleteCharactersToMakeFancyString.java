package leetcode.stringProblem;

public class DeleteCharactersToMakeFancyString {
    public static void main(String[] args){
        System.out.println(makeFancyString("leeetcode"));
    }

    public static String makeFancyString(String s){
        StringBuilder builder = new StringBuilder(s);
        for(int i = 0; i < builder.length(); i++){
//            if (i + 1 < builder.length() && i + 2 < builder.length()
//                    && builder.charAt(i) == builder.charAt(i + 1)
//                    && builder.charAt(i + 1) == builder.charAt(i + 2)){
//                builder.deleteCharAt(i);
//                i--;
//            }
            if (i > 2 && builder.charAt(i) == builder.charAt(i - 1)
                    && builder.charAt(i) == builder.charAt(i - 2)){
                builder.deleteCharAt(i);
                i--;
            }
        }
        return builder.toString();
    }
}
