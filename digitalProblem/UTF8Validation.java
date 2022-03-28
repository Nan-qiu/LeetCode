package leetcode.digitalProblem;

public class UTF8Validation {
    public static void main(String[] args){
        int[] n = {255};
        System.out.println(validUtf8(n));
    }

    public static boolean validUtf8(int[] data){
        for(int i = 0; i < data.length; i++){
            int index = find0Index(data[i]);
            if (index > 1 && index - 1 + i < data.length){
                while (index-- > 1) {
                    if (find0Index(data[++i]) != 1) return false;
                }
            } else if (index != 0) return false;
        }
        return true;
    }

    //0在 0 ，1 ，2 ，3，4 下标
    private static final int[] zero = {128,64,32,16,8};

    private static int find0Index(int num){
        for(int i = 0; i < zero.length; i++){
            if ((num & zero[i]) == 0) return i;
        }
        return -1;
    }
}
