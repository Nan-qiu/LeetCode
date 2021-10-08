package leetcode.stringProblem;

public class LicenseKeyFormatting {

    public static void main(String[] args){
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
    }

    public static String licenseKeyFormatting(String s,int k){
        s=s.replace("-","");
        char[] ss = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(int j = ss.length-1; j >= 0; j--){
            if (i < k){
                if (ss[j] == '-') continue;
                res.append(ss[j]);
                i++;
            }
            if (i == k&&j!=0){
                res.append('-');
                i = 0;
            }
        }
        return res.reverse().toString().toUpperCase();
        //        s=s.replaceAll("-","");
//        StringBuilder res = new StringBuilder(s);
//        int i = 0;
//        for(int j = res.length(); j >= 0; j--){
//            if (i==k&&j!=0){
//                res.insert(j,'-');
//                i=0;
//            }
//            i++;
//        }
    }
}
