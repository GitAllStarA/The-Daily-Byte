package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUrls {

    public static void main(String[] args) {
        String backendURL = "https://dev-sn.lexisnexis.com/secure/pe/start_page.cgi?src=server-redirect&URI=/";
               String regex = "^http(|s):\\/\\/(localhost|[^\\/]*\\.(laaaas(|naaaas)|saaaenet)\\.com|[^\\/]*\\.regn\\.net)(|:\\d+)([\\/?]+|$)";
                //"^http(|s):\/\/(localhost|[^\/]*\.(lexis(|nexis)|statenet)\.com|[^\/]*\.regn\.net)(|:d+)([\/?]+|$)";
        String compareBUrl = "https://dev-sn.lexisnexis.com/secure/pe/start_page.cgi?src=server-redirect&URI=/";
        String compareRegex = "^http(|s):\\/\\/(localhost|[^\\/]*\\.(laaaas(|naaaas)|saaaenet)\\.com|[^\\/]*\\.regn\\.net)(|:\\d+)([\\/?]+|$)";
        checkUrl(backendURL,regex,compareBUrl,compareRegex);
    }

    public static void checkUrl(String backendURL, String regex, String compareBUrl,String compareRegex){

        System.out.println(regex);
        System.out.println(compareRegex);

        if (regex.equals(compareRegex)){
            System.out.println(true);

        }

        Pattern pattern = Pattern.compile(compareRegex, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(backendURL);
        System.out.println(m);
        if (m.matches()){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }


    }
}
