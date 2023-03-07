package StringAndHashMaps;/*
* This question is asked by Amazon.
* Given a string representing your stones and another string representing a list of jewels,
*  return the number of stones that you have that are also jewels.

Ex: Given the following jewels and stones...

jewels = "abc", stones = "ac", return 2
jewels = "Af", stones = "AaaddfFf", return 3
jewels = "AYOPD", stones = "ayopd", return 0
Thanks,
The Daily Byte
* */

import java.util.HashMap;

public class JewelsNStones {
    public static void main(String[] args) {
        String jewels = "abc", stones = "ab";

        System.out.println(ornaments(jewels,stones));
    }



    public static int ornaments(String jewels, String stones) {
        int count = 0;
        if (jewels.length()<=0 || stones.length()<0)
            return 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i))!=-1)
                count++;
        }
     return count;
    }
}
