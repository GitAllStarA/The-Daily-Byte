package Recursion;

public class PatternsDownwordsTriangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("downward left angle triangle: ");
        verticalPatternRecursionDLAT(n);



    }

    static void pattern(int n) {
        int m = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("* ");
            }
            System.out.println();
            m = m - 1;
        }
    }


    static void verticalPatternRecursionDLAT(int n) {
        if (n == 0) {
            return;
        }
        int m = n;
        System.out.println();
        System.out.print(horizontalPatternRecursionDLAT(m));
        verticalPatternRecursionDLAT(n - 1) ;
    }

    static String horizontalPatternRecursionDLAT(int m){
        if (m == 0)
        {
            return "";
        }
        String s = "* "+ horizontalPatternRecursionDLAT(m-1);
        return s;
    }



}
