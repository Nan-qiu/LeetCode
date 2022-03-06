package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortTheJumbledNumbers {
    public static void main(String[] args){
        int[] map = {9,0,6,7,2,5,1,8,4,3};
        int[] n = {424943903,240200463,49635992,4299,54905866,6870,88829546,614045430,766};
        System.out.println(Arrays.toString(sortJumbled1(map,n)));
    }

    public static int[] sortJumbled1(int[] mapping,int[] nums){
        ArrayList<int[]> list = new ArrayList<>();
        for(int num : nums){
            int newNum = mapp(mapping,num);
            list.add(new int[]{newNum,num});
        }
        list.sort(Comparator.comparingInt(h->h[0]));
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = list.get(i)[1];
        }
        return res;

    }

    public static int mapp(int[] mapping,int num){
        char[] chars = String.valueOf(num).toCharArray();
        for(int i = 0; i < chars.length; i++){
            chars[i]=(char) (mapping[chars[i]-'0']+'0');
        }
        return Integer.parseInt(String.valueOf(chars));
    }


    public static int[] sortJumbled(int[] mapping,int[] nums){
        ArrayList<int[]> list = new ArrayList<>();

        for(int num : nums){
            int ge = num % 10;
            int shi = num / 10 % 10;
            int bai = num / 100 % 10;
            int qian = num / 1000 % 10;
            int wan = num / 10000 % 10;
            int h1 = num / 100000 % 10;
            int h2 = num / 1000000 % 10;
            int h3 = num / 10000000 % 10;
            int h4 = num / 100000000 % 10;

            ge = mapping[ge];
            shi = mapping[shi];
            bai = mapping[bai];
            qian = mapping[qian];
            wan = mapping[wan];
            h1 = mapping[h1];
            h2 = mapping[h2];
            h3 = mapping[h3];
            h4 = mapping[h4];

            int newNum;
            if (h4 == mapping[0]){
                if (h3 == mapping[0]){
                    if (h2 == mapping[0]){
                        if (h1 == mapping[0]){
                            if (wan == mapping[0]){
                                if (qian == mapping[0]){
                                    if (bai == mapping[0]){
                                        if (shi == mapping[0]) {
                                            newNum = ge;
                                            save(list,newNum,num);
                                        } else{
                                            newNum = shi * 10 + ge;
                                            save(list,newNum,num);
                                        }
                                    } else{
                                        newNum = bai * 100 + shi * 10 + ge;
                                        save(list,newNum,num);
                                    }
                                } else{
                                    newNum = qian * 1000 + bai * 100 + shi * 10 + ge;
                                    save(list,newNum,num);
                                }
                            } else{
                                newNum = wan * 10000 + qian * 1000 + bai * 100 + shi * 10 + ge;
                                save(list,newNum,num);
                            }
                        } else{
                            newNum = h1 * 100000 + wan * 10000 + qian * 1000 + bai * 100 + shi * 10 + ge;
                            save(list,newNum,num);
                        }
                    } else{
                        newNum = h2 * 1000000 + h1 * 100000 + wan * 10000 + qian * 1000 + bai * 100 + shi * 10 + ge;
                        save(list,newNum,num);
                    }
                } else{
                    newNum = h3 * 10000000 + h2 * 1000000 + h1 * 100000 + wan * 10000 + qian * 1000 + bai * 100 + shi * 10 + ge;
                    save(list,newNum,num);
                }
            } else {
                newNum = h4 * 100000000 + h3 * 10000000 + h2 * 1000000 + h1 * 100000 + wan * 10000 + qian * 1000 + bai * 100 + shi * 10 + ge;
                save(list,newNum,num);
            }
        }
        list.sort(Comparator.comparingInt(h -> h[0]));
        System.out.println("==========");
        for(int[] ints : list){
            System.out.println(Arrays.toString(ints));
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = list.get(i)[1];
        }
        return res;
    }

    public static void save(ArrayList<int[]> list,int newNum,int num){
        list.add(new int[]{newNum,num});
    }
}
