package leetcode.digitalProblem;

public class NQueens {

    public static void main(String[] args){
        int n=13;
        long start= System.currentTimeMillis();
        System.out.println(num2(n));
        long end= System.currentTimeMillis();
        System.out.println("优化方法的时间："+(end-start)+"ms");

        start= System.currentTimeMillis();
        System.out.println(num1(n));
        end= System.currentTimeMillis();
        System.out.println("普通方法的时间："+(end-start)+"ms");
    }

    //普通方法
    public static int num1(int n){
        if (n < 1) return 0;
        int[] record = new int[n];
        return process(0,record,n);
    }

    // i是代表当前行，record是之前记录的信息：record[0]=0 就是说在0行0列放了一个皇后，n是总数
    public static int process(int i,int[] record,int n){
        if (i == n) return 1; // i==n说明都填满了，返回1种可能
        int res = 0;
        for(int j = 0; j < n; j++){
            if (isValid(record,i,j)){
                record[i] = j; // 把j放进数组record[i] 位置，在i行j列放一个皇后
                res += process(i + 1,record,n); // 进入递归，把之后所有可能全考虑完！
            }
        }
        return res;
    }

    // i是当前行，j是当前列
    // k从0开始，一直遍历到i行，如果record[k] == j，说明当前位置与k行的皇后同列
    // Math.abs(record[k] - j) == Math.abs(k - i)，则表示当前位置与k行的皇后同斜线，她是通过斜率计算
    // record[k]表示k行皇后所在的列，k表示她所在的行
    // 若k行皇后的列减去当前位置的列j的绝对值等于k行减去当前位置的行i的绝对值，就说明她们斜率相等，在一条斜线上
    public static boolean isValid(int[] record,int i,int j){
        for(int k = 0; k < i; k++){
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) return false;
        }
        return true;
    }

    //---------------------------------------------------------
    // 优化版本，靠位运算优化，大大减少常数时间

    public static int num2(int n){
        if (n < 1 || n > 32) return 0;
        int limit = n == 32 ? -1 : (1 << n) - 1;// 当n=32时，-1表示的二进制就是32个1
        return process2(limit,0,0,0);
    }

    //limit表示总限制
    // colLim为列限制，1的位置不能放皇后，0位置可以
    // leftDiaLim为左斜线限制，1的位置不能放皇后，0位置可以
    // rightDiaLim为右斜线限制，1的位置不能放皇后，0位置可以
    public static int process2(int limit,int colLim,int leftDiaLim,int rightDiaLim){
        if (colLim == limit) return 1;// 当列限制等于总限制时，就说明皇后全都放完了
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim)); //pos表示当前能放皇后的位置为1
        int res = 0;
        int mostRightOne = 0;
        while (pos != 0){
            mostRightOne = pos & (~pos + 1); // 获得pos里最右边的1，其余位置都是0，就是当前皇后确定的位置
            pos=pos-mostRightOne; //更新pos
            res += process2(limit,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,//在下一个循环开始时，当前的左限制 | 当前皇后的位置，再左移，就是下一个循环的左限制
                    (rightDiaLim | mostRightOne) >> 1);
        }
        return res;
    }
}
