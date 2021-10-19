package leetcode.digitalProblem;

public class MountainArray {
    public static void main(String[] args){
        int[] a = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(a));
    }

    public static int peakIndexInMountainArray(int[] arr){
        int L = 0;
        int R = arr.length - 1;
        int i = L + (R - L + 1) / 2;
        while (L != R) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) return i;
            else if (arr[i - 1] < arr[i] && arr[i] < arr[i + 1]){
                L = i;
                i = L + (R - L + 1) / 2;
            } else if (arr[i - 1] > arr[i] && arr[i] > arr[i + 1]){
                R = i;
                i = L + (R - L + 1) / 2;
            }
        }
        return R;
    }
}
