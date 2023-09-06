package RoughWork;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

@FunctionalInterface //not mandatory to use this annotation
interface A {
    void showMeMessage(String s);

    public default int x() {
        return 0;
    }
}

class B implements A {
    @Override
    public void showMeMessage(String s) {
        System.out.println("hi its from java old way");
    }
}

public class Java {
    public static void main(String[] args) {
        //in java old way
        A objB = new B();
        objB.showMeMessage("asd");

        //in java 7
        A obj = new A() {
            @Override
            public void showMeMessage(String s) {
                System.out.println("hi its java 7 way");
            }
        };
        obj.showMeMessage("adfs");

        //in java 8 with // functional interface
        A obj8 = (e) -> System.out.println("hello its java 8 way");
        obj8.showMeMessage("abd");
        System.out.println(obj8.toString());


        new Thread(() -> {
            System.out.println("thread created");
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("old way java7 thread created");
            }
        }).start();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.sort((a, b) -> b - a);
        System.out.println(list);

        //built in functional interfaces 1 consumer 2 predicate 3 supplier 4 function

        //Consumer - void accept(T t) - it takes one argument and return nothing
        //BiConsumer - void accept(T t, Vehicles.V v) - it takes one argument and retuen nothting
        //Predicate - boolean test(T t) - it takes one argument and return boolean value
        //Bi-Predicate - boolean test(T t, Vehicles.V,v) - takes two arguments and retuen boolean
        //Function - R(any type can return)  apply(T t) - it takes one argument and return one value
        //BiFunction - R(any type can return) apply(T t, Vehicles.V v) - it takes two arguments and retuns one value
        //Supplier - T get() - it takes nothing but returns a value
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");

        //Consumer - void accept(T t) - it takes one argument and return nothing
        Consumer<String> consumer = (t) -> System.out.println(t);
        consumer.accept("this is java");

        //BiConsumer - void accept(T t, Vehicles.V v) - it takes two argument and retuen nothting
        BiConsumer<String, String> biConsumer = (t, r) -> System.out.println(t + " is " + r);
        biConsumer.accept("Vikranth", "Software Developer and Software Engineer");

        BiConsumer<String, Integer> biConsumer2 = (t2, r2) -> System.out.println(t2 + " is " + r2 + " years old");
        biConsumer2.accept("Vikranth", 27);

        BiConsumer<Integer, Integer> biConsumer3 = (t2, r2) -> System.out.println(t2 * r2);
        biConsumer3.accept(199607, 31);


        //Predicate - boolean test(T t) - it takes one argument and return boolean value
        Predicate<Integer> predicate = (e) -> e > 10;
        boolean result = predicate.test(11);
        System.out.println(result);

        Predicate<String> predicate2 = e -> e.equals("value");
        System.out.println(predicate2.equals("Value"));

        //Bi-Predicate - boolean test(T t, Vehicles.V,v) - takes two arguments and return boolean
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;
        System.out.println(biPredicate.test(10, 9));

        BiPredicate<String, Integer> biPredicate2 = (a, b) -> a.length() == (b);
        System.out.println(biPredicate2.test("abc", 3));


        //Function - R(any type can return)  apply(T t) - it takes one argument and return one value
        Function<String, Integer> function = (s) -> s.length();
        System.out.println(function.apply("somepackage.Java Function Functional Interface"));

        //BiFunction - R(any type can return) apply(T t, Vehicles.V v) - it takes two arguments and retuns one value
        BiFunction<String, Integer,Integer> biFunction = (x, y) -> x.length() + y;
        System.out.println(biFunction.apply("abc", 15));

        BiFunction<String , String , String> biFunction2 = (a,b) -> a+b;
        System.out.println(biFunction2.apply("Vik","ranth"));

        //Supplier - T get() - it takes nothing but returns a value
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());


        //Chaining
        Function<Integer,Integer> function3 = (x) -> x*x;
        Function<Integer,Integer> function4 = (y) -> y+y;

        Integer res = function3.andThen(function4).apply(4);
        System.out.println(res);

        //Streams
        List<Integer> list1 = Arrays.asList(1,4,32,4,5);
        //list1.forEach(e-> System.out.println(e*e));

        Stream<Integer> data = list1.stream();

         Stream<Integer> mappedData=   data.map(n->n*n);
         mappedData.forEach(m-> System.out.println(m));

        System.out.println("______________________________________");


        Predicate<Integer> p = n -> n%2==0;

        Function<Integer,Integer> m = integer -> integer*integer;

        Consumer<Integer> c = (integer) -> System.out.println(integer);




        List<Integer> list2 = Arrays.asList(2,2,3,3,5);




        Long a1 =  System.currentTimeMillis();
        int x = list2.stream().filter(p).map(m).reduce(0,(a,b)->a+b);
        System.out.println(x);
        Long a2 =  System.currentTimeMillis();
        System.out.println(a2 - a1);

        Long s = System.currentTimeMillis();
        int y = list2.parallelStream().filter(p).map(m).reduce(0,(a,b)->a+b);
        System.out.println(y);
        Long e =  System.currentTimeMillis();
        System.out.println(e-s);

        A obj5 = (ex) -> System.out.println(ex);
        obj5.showMeMessage("sadas");
    }
}
