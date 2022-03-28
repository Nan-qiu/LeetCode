package leetcode.digitalProblem;

import java.util.*;

public class MinimumIndexSumofTwoLists {
    public static void main(String[] args){
        //System.out.println(Arrays.toString(findRestaurant(s1,s2)));
    }

    public static String[] findRestaurant(String[] list1,String[] list2){
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> help = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i],-1);
            help.put(list1[i],i);
        }

        for(int i = 0; i < list2.length; i++){
            if (map.containsKey(list2[i])){
                int count = help.get(list2[i]);
                map.put(list2[i],count + i);
            }
        }
        System.out.println(map);
        int min = 2008;
        ArrayList<String> strings = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() == -1) continue;
            if (entry.getValue() < min){
                min = entry.getValue();
                //strings = new ArrayList<>(Collections.singletonList(entry.getKey()));
                strings.clear();
                strings.add(entry.getKey());
            } else if (entry.getValue() == min) strings.add(entry.getKey());
        }
        return strings.toArray(new String[0]);
    }
}
