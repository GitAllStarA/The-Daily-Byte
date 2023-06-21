package Recursion;


//spaces at the * makes the differnce in the triangle
public class UpwardsTriangle {

    public static void main(String[] args) {
        int n = 5;
        //LTrianlge(n);
        /*System.out.println("----------");
        RTriangle(5);
        System.out.println();
        System.out.println("----------");
        Triangle(5);*/
       // TriVerticalSpaces(0, n);
        System.out.println();
        System.out.println("-------KKT--------");
        KKTriangle(5, 0);
        System.out.println("-------KKT2--------");
        KKTriangle2(5, 0);
    }


    static void KKTriangle(int n, int c) {
        if (n == 0) {
            return;
        }
        if (c < n) {
            System.out.print(" * ");
            KKTriangle(n, c + 1);
        } else {
            System.out.println();
            KKTriangle(n - 1, 0);
        }
    }

    static void KKTriangle2(int n, int c) {
        if (n == 0) {
            return;
        }
        if (c < n) {
            KKTriangle2(n, c + 1);
            System.out.print(" * ");
        } else {

            KKTriangle2(n - 1, 0);
            System.out.println();
        }
    }


    static void TriVerticalSpaces(int m, int n) {
        if (n == 0) {
            return;
        }
        TriVerticalSpaces(m, n - 1);
        System.out.print(spaces(n) + TriHorizontal(m, n));
        System.out.println();
    }

    static String spaces(int n) {
        if (n == 5) {
            return "";
        }
        return " " + spaces(n + 1);
    }

    static String TriHorizontal(int m, int n) {
        if (m == n) {
            return "";
        }
        return "* " + TriHorizontal(m + 1, n);
    }


    static void LTrianlge(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void RTriangle(int n) {
        int m = n;

        for (int i = 0; i < n; i++) {
            String star = "";
            System.out.println(" ");
            for (int j = 0; j < m; j++) {
                System.out.print("-");
            }
            for (int j = 0; j <= i; j++) {
                star = "*";
                System.out.print(star);
            }
            m = m - 1;
        }
    }

    static void Triangle(int n) {
        int m = n;

        for (int i = 0; i < n; i++) {
            String star = "";
            System.out.println(" ");
            for (int j = 0; j < m; j++) {
                System.out.print("-");
            }
            for (int j = 0; j <= i; j++) {
                //here the space makes the difference
                star = "* ";
                System.out.print(star);
            }
            m = m - 1;
        }
    }


}
