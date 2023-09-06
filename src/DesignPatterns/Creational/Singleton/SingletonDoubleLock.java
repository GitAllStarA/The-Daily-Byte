package DesignPatterns.Creational.Singleton;

public class SingletonDoubleLock {

    private static SingletonDoubleLock singletonDoubleLock;

    private SingletonDoubleLock(){

    }

    // synchronized is very costly it will lock method for every thread,
    // below implementation of double lock is better if 1st thread enters at sychozied
    // and creation of object happens
    // remaining theads can use the object without looking the method.
    public static SingletonDoubleLock getInstance(){
        if (singletonDoubleLock == null){
            synchronized (SingletonDoubleLock.class) {
                if (singletonDoubleLock == null) {
                    singletonDoubleLock = new SingletonDoubleLock();
                }
            }
        }
        return singletonDoubleLock;
    }

}
