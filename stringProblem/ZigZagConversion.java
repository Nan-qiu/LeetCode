package leetcode.stringProblem;

public class ZigZagConversion {
    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s,int numRows){
        if (s.length() == 1 || numRows <= 1) return s;
        StringBuilder[] array = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            array[i] = new StringBuilder();
        }
        int flag = 1;
        int index = 0;
        for(char a : s.toCharArray()){
            array[index].append(a);
            index += flag;
            if (index == numRows - 1 || index == 0) flag = -flag;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            res.append(array[i]);
        }
        return res.toString();
    }
}
