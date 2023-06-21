package StringAndHashMaps;

import java.util.*;
import java.util.stream.Stream;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] s = new String[]{"ate", "eat", "aet", "tom", "mot", "app", "pap"};
        System.out.println(groupStrs(s));
        System.out.println(gropANang(s));
    }


    static List<List<String>> gropANang(String[] s){
        HashMap<String,ArrayList<String>> hashMap = new HashMap<>();
        List<List<String>> lax = new ArrayList<>();
        for (String word : s){
            char[] x = word.toCharArray();
            Arrays.sort(x);
            String sorted = new String(x);
            if (!hashMap.containsKey(sorted)){
                hashMap.put(sorted,new ArrayList<>());
            }
            hashMap.get(sorted).add(word);
        }
        lax.addAll(hashMap.values());
        return lax;
    }


    static List<List<String>> groupStrs(String[] s){
        ArrayList<String> newS = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            char[] x = s[i].toCharArray();
            Arrays.sort(x);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < x.length; j++) {
                sb.append(x[j]);
            }
            newS.add(sb.toString());
        }

        HashMap<Integer,String> stringHashMap = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            stringHashMap.put(i,s[i]);
        }


        HashMap<String,ArrayList<String>> hashMap = new HashMap<>();

        for (int i = 0; i < s.length; i++) {
            ArrayList<String> al;
            if (!hashMap.containsKey(newS.get(i))){
                al = new ArrayList<>();
                    al.add(stringHashMap.get(i));
                    hashMap.put(newS.get(i), al);

            } else {
                al = hashMap.get(newS.get(i));
                al.add(stringHashMap.get(i));
                hashMap.put(newS.get(i), al);
            }

        }
        System.out.println(hashMap);
        List<List<String>> lax = new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> entry : hashMap.entrySet()){
            lax.add(entry.getValue());
        }

        return lax;
    }
}
