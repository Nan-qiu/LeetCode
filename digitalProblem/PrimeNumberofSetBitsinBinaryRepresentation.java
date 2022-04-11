package leetcode.digitalProblem;

public class PrimeNumberofSetBitsinBinaryRepresentation {
    public static void main(String[] args){
        PrimeNumberofSetBitsinBinaryRepresentation p = new PrimeNumberofSetBitsinBinaryRepresentation();
        System.out.println(p.countPrimeSetBits(6, 10));
    }

    public int countPrimeSetBits(int left, int right){
        int cnt = 0;
        for(int i = left; i <= right; i++){
            if (isBinBit(i)) cnt++;
        }
        return cnt;
    }

    private boolean isBinBit(int i){
        int bitCnt = Integer.bitCount(i);
//        while (i > 0) {
//            if ((i & 1) == 1) bitCnt++;
//            i >>= 1;
//        }

        if (bitCnt==1) return false;

        for(int j = 2; j * j <= bitCnt; j++){
            if (bitCnt % j == 0) return false;
        }
        return true;
    }
}
