package Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set<String> {
    public static void main(String[] args) {
        MySet mySet = new MySet();
        System.out.println(mySet.add("abc"));
        System.out.println(mySet.add("vvc"));
        System.out.println(mySet.add("abc"));
        System.out.println(mySet.size());
    }
    @Override
    public int size() {
        int arraySizr=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=null){
                arraySizr++;
            }
        }
        return arraySizr;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {

        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    String[] array = new String[10];
    int count = 0;
    @Override
    public boolean add(String s) {
        array[count] = s;
        count++;
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(s)){
                return false;
            }else {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(String.valueOf(o))){
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
