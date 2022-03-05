package leetcode.stringProblem;

public class ComplexNumberMultiplication {
    public static void main(String[] args){
        String a = "1+-1i";
        String b = "1+1i";
        System.out.println(complexNumberMultiply(a,b));
    }

    public static String complexNumberMultiply(String num1,String num2){
        String[] split1 = num1.split("\\+",2);
        String[] split2 = num2.split("\\+",2);
        int a = Integer.parseInt(split1[0]);
        int c = Integer.parseInt(split2[0]);
        int b = Integer.parseInt(split1[1].substring(0,split1[1].length() - 1));
        int d = Integer.parseInt(split2[1].substring(0,split2[1].length() - 1));
        int ac = a * c;
        int ad = a * d;
        int bc = b * c;
        int bd = -(b * d);
        return "" + (ac + bd) + "+" + (ad + bc) + "i";
    }

}
