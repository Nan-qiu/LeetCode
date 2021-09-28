package leetcode.sort;

public class QuickSort {
    public static void main(String[] args){
        int[] a = {2,1,3,4,1,5,6};
        quickSort(a,0,a.length - 1);
        for(int t : a){
            System.out.println(t);
        }
    }

    public static void quickSort(int[] arr,int L,int R){
        if (L < R){
            swap(arr,L + (int) (Math.random() * (R - L + 1)),R);// 随机比较值，时间复杂度由O(N^2) 变为O(NlogN)
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]);
            quickSort(arr,p[1],R);
        }
    }

    public static int[] partition(int[] arr,int L,int R){ // L 为当前位置的下标 R 为比较数
        int less = L - 1;// < 区 左边界
        int more = R;// > 区 右边界
        while (L < more) {
            if (arr[L] < arr[R]){
                swap(arr,++less,L++);// 把左边界后面的数 和 当前数交换
            } else if (arr[L] > arr[R]){
                swap(arr,--more,L);// 把右边界前面的数 和 当前数交换，当前数下标不变
            } else{
                L++;
            }
        }
        swap(arr,more,R);// 把 右边界的数 和 比较数交换
        return new int[]{less,more + 1};// 返回中间 = 区 两头的下标
    }

    public static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
