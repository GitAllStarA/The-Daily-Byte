/*
* Dominoes
Stacks & Queues
Hard
You’re given a set of integers, dominoes, that represent a set of domino tiles.
* The value of domino represents either weight and its sign, positive or negative,
* represents the direction it is falling: positive falls right and negative falls left. When two dominoes collide,
* the larger domino destroys the smaller domino. If two dominoes of the same size collide, both dominoes are destroyed.
* After all the collisions, return the state of the dominoes.

Ex: Given the following dominoes…

dominoes = [3, -3], return [].
Ex: Given the following dominoes…

dominoes = [1, 2, -3, 2, -1], return [-3, 2] (-3 destroys both dominoes to its left and the second two destroys the domino to the right of it).
See Solution
*
*
* */

package StacksNQueues;

import java.util.*;
import java.util.function.*;

public class Dominoes {


    public static void main(String[] args) {
        int[] dominoes = new int[]{1, 2, -3, 2, -1};
        System.out.println(game(dominoes));
    }


    public static int[] game(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }

        Deque<Integer> deque = new LinkedList<>();
        int count =0;
        for (int x : array)
        {
            if (x<0) {
                while (count <= array.length) {

                    if (deque.peekLast() < Math.abs(x)) {
                        deque.pollLast();
                        if (deque.isEmpty()) {
                            break;
                        }
                    } else if (deque.peekLast() > Math.abs(x)) {
                        continue;

                    }
                    count++;
                }
            }
            deque.offer(x);

        }

        System.out.println(deque);




        return new int[]{};

    }

    public static void j8() {

        BinaryOperator<Integer> x = (a, b) -> a + b;
        System.out.println(x.apply(1, 2));


        //takes nothing but return object T below
        Supplier<Integer> s = () -> (int) ((Math.random() * 100) + 1);
        int res = s.get();
        System.out.println(res);


        ArrayList<String> al = new ArrayList<>();
        al.add("hello");
        al.add("world");
        al.add("ggg");

        //takes one argument and return boolean as seen below filter method, if true add to list.
        Predicate<String> sbs = word -> word.contains("o");

        List<String> d = al.stream().filter(sbs).toList();
        System.out.println(d);

        al.add("axe");
        al.add("axolotl");
        al.add("ahar");
        al.add("xerox");

        BiPredicate<String, String> bp = (w, w2) -> w.contains("a") && w2.contains("x");

        List<String> d2 = al.stream().filter((w1) -> bp.test(w1, w1)).toList();
        System.out.println(d2);

        // takes only one input and don't output,
        Consumer<String> c = (a) -> System.out.println(a);
        c.accept("ss");

        // biconsumer can take two args
        BiConsumer<String, String> bc = (a, b) -> System.out.println(a + ", " + b);
        bc.accept("everything everywhere", "all at once");
    }
}
