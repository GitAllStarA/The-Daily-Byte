package StringAndHashMaps;

import java.util.Arrays;

/*
* Defanging IPs
Strings
Easy
This question is asked by Amazon. Given a valid IP address, defang it.
Note: To defang an IP address, replace every ”.”, with ”[.]”.

Ex: Given the following address…

address = "127.0.0.1", return "127[.]0[.]0[.]1"
* */
public class DefangIp {

    public static void main(String[] args) {
        String address = "127.0.0.1";
        System.out.println(ipDefanger(address));

    }

    public static String ipDefanger(String address){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char x = address.charAt(i);
            if (x=='.'){
                sb.append("[.]");

            }else {
                sb.append(x);
            }
        }

        return sb.toString();

    }
}
