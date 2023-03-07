package StringAndHashMaps;

public class VaccumCleanerRoute {
    public static void main(String[] args) {
        System.out.println(returnVaccum("URURDDLL"));
    }


    public static boolean returnVaccum(String s) {
        if (s.length() <= 1) {
            return false;
        }
        char[] routeToCharArray = s.toCharArray();
        int rightUp = 1, leftDown = -1;
        char R = 'R', L = 'L', U = 'U', D = 'D';
        int totalRouteDistnace = routeToCharArray.length;
        int temp = s.length();
        for (int i = 0; i < routeToCharArray.length; i++) {
            if (routeToCharArray[i] == L || routeToCharArray[i] == D ) {
                totalRouteDistnace = totalRouteDistnace + leftDown;
            }
            if (routeToCharArray[i] == R || routeToCharArray[i] == U) {
                totalRouteDistnace = totalRouteDistnace + rightUp;
            }
        }
       return totalRouteDistnace == temp;
    }
}
