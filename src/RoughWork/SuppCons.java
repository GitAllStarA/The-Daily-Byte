package RoughWork;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SuppCons {

    static int val = 0;

    public static void main(String[] args) {

        Thread t = new Thread();
        t.start();

        int sum = 0;
        int j;
        for ( j = 1; j>=100; j++) ;
        System.out.println(j);

        if (j%2==0) {
            sum = sum + j;
        }
        System.out.println("here "+sum);




        Supplier<Integer> supplier = () -> val++;

        Consumer<Integer> consumer = (v) -> System.out.println(v + val);

        consumer.accept(1);
        System.out.println(supplier.get());

        String s = "racecar";

        var x = s.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(k -> k.getValue() == 1)
                .findFirst();
        System.out.println(x);

        Optional<Map.Entry<Character, Long>> y = Arrays.stream(s.chars().toArray()).mapToObj(k1 -> (char) k1)
                .collect(Collectors.groupingBy(key1 -> key1, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(val -> val.getValue() == 1)
                .findFirst();
        System.out.println(y);

    }
}
