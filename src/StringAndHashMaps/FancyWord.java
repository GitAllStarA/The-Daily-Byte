package StringAndHashMaps;

import java.util.HashMap;

public class FancyWord {
    public static void main(String[] args) {
        String s = "leeetcode";
        String s2 = "aaabaaaa";
        System.out.println(fancyWordAlg(s));
        System.out.println(fancyWordAlg(s2));
    }

    static String fancyWordAlg(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        String ss= "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i))+1);
                if (count < 2){
                    ss = ss + String.valueOf(hashMap.get(i));
                }
            }
            hashMap.put(s.charAt(i),0);
        }
        return ss;
    }
}
