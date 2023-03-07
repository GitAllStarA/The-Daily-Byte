package StringAndHashMaps;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/*
* StringAndHashMaps.Restaurants
Hash Maps - Medium
*
You and a friend are trying to choose a restaurant to go to. You both give your preferences of restaurants in separate lists.
*  You need to find a restaurant to go to that’s listed in both of your preferences that has the least index sum.
*  If there are ties, output all restaurants you could go to together.

Ex: Given the following lists...

list1 = ["A", "B", "C", "D"], list2 = ["D", "B", "C"], return [“B”] (“B” is the least index sum 1 + 1 whereas “D” is 3 + 0).
Ex: Given the following lists...

list1 = [“C”], list2 = [“D”], return [].

*
* */
public class Restaurants {

    public static void main(String[] args) {
        String[] list1 = {"F", "A", "B", "C", "D"}, list2 = { "A","F","D", "B", "C"};
        String[] list3 = {"S"}, list4 = {"D"};
        System.out.println(Arrays.toString(leastIndex(list3,list4)));
    }

    public static String[] leastIndex(String[] list1, String[] list2) {

        HashMap<String,Integer> menu1 = new HashMap<>();
        HashMap<String,Integer> menu2 = new HashMap<>();
        HashMap<String,Integer> hashMap3 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            menu1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            menu2.put(list2[i],i);
        }

        for (Map.Entry<String, Integer> entryMenu2 : menu2.entrySet()){
            if (menu1.containsKey(entryMenu2.getKey())){
                int menu1Value = menu1.get(entryMenu2.getKey());
                int menu2Value = menu2.get(entryMenu2.getKey());
                hashMap3.put(entryMenu2.getKey(),menu1Value+menu2Value);
            }
        }

        int minIndex = Integer.MAX_VALUE;
        String minElement = "";
        for (Map.Entry<String,Integer> entry : hashMap3.entrySet()){
            if (entry.getValue() <= minIndex ){
                minIndex = entry.getValue();
                minElement = entry.getKey();
               // System.out.println(MIN);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,Integer> entry: hashMap3.entrySet()){
            if (entry.getValue() == minIndex){
                list.add(entry.getKey());
            }
        }
      //  System.out.println(list);
        int i =0;
        String[] results = new String[list.size()];
        for (String s : list){
            results[i++] = s;
        }
        return results;
    }

}
