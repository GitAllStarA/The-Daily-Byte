package StringAndHashMaps;

import java.util.*;

/*
* Uncommon Words
Hash Maps
Hard
*
This question is asked by Amazon. Given two strings representing sentences,
*  return the words that are not common to both strings (i.e. the words that only appear in one of the sentences).
*  You may assume that each sentence is a sequence of words (without punctuation) correctly separated using space characters.

Ex: given the following strings...

sentence1 = "the quick", sentence2 = "brown fox", return ["the", "quick", "brown", "fox"]
sentence1 = "the tortoise beat the haire", sentence2 = "the tortoise lost to the haire", return ["beat", "to", "lost"]
sentence1 = "copper coffee pot", sentence2 = "hot coffee pot", return ["copper", "hot"]

*
* */
public class UncommonWords {

    public static void main(String[] args) {
       String sentence1 = "the tortoise beat the haire", sentence2 = "the tortoise lost to the haire";
       String s1 = "this apple is sweet", s2 = "this apple is sour";
       //return ["the", "quick", "brown", "fox"]
       // System.out.println(Arrays.toString(notCommonWords(s1,s2)));
        System.out.println(notCommon(s1,s2));
    }

    public static String[] notCommonWords(String s1, String s2){
        if (s1.length()==0)
            return s2.split(" ");
        if (s2.length()==0)
            return s1.split(" ");
        HashMap<String,Integer> hashMap = new HashMap<>();
        String[] sentence1_split = s1.split(" ");
        String[] sentence2_split = s2.split(" ");
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < sentence1_split.length; i++) {
            if(!hashSet.contains(sentence1_split[i])) {
                hashSet.add(sentence1_split[i]);
            }else {
                hashSet.remove(sentence1_split[i]);
            }
        }
        for (int i = 0; i < sentence2_split.length; i++) {
            if (hashSet.contains(sentence2_split[i]))
                hashSet.remove(sentence2_split[i]);
            else
                hashSet.add(sentence2_split[i]);
        }
        String[] s = new String[hashSet.size()];
        int i =0;
        for (String x : hashSet){
            s[i++]= x;
        }
        return s;
    }


    public static String[] notCommon(String s1, String s2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] s1S = s1.split(" ");
        String[] s2S = s2.split(" ");
        for (int i = 0; i < s1S.length; i++) {
            if (!hashMap.containsKey(s1S[i])){
                hashMap.put(s1S[i], hashMap.getOrDefault(s1S[i],1));
            }
            else {
                hashMap.put(s1S[i], hashMap.getOrDefault(s1S[i],0)+1);
            }
        }
        for (int i = 0; i < s2S.length; i++) {
            if (!hashMap.containsKey(s2S[i])){
                hashMap.put(s2S[i], hashMap.getOrDefault(s2S[i],1));
            }
            else {
                hashMap.put(s2S[i], hashMap.getOrDefault(s2S[i],0)+1);
            }
        }

        List<String> list = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
            if (entry.getValue() <= 1){
                list.add(entry.getKey());
            }
        }
        System.out.println(list);
        String[] s   = new String[list.size()];
        list.toArray(s);
        return s;
    }
}
