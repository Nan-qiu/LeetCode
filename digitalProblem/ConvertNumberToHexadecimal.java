package leetcode.digitalProblem;

public class ConvertNumberToHexadecimal {
    public static void main(String[] args){
        System.out.println(toHex(0));
    }

    public static String toHex(int num){
        if (num == 0) return "0";
        //int limit = (1 << 4) - 1;
        char[] tmp = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder buffer = new StringBuilder(); // 要求速度用StringBuilder  线程安全用StringBuffer
        while (num != 0) {
            buffer.insert(0,tmp[num & 0xf]); // 4位二进制，表示1位16进制。 num与上1111，提取出最右4位，转化
            num = num >>> 4; // 无符号右移4位，进行下一个16进制位转化
        }
        return buffer.toString();
    }
}
