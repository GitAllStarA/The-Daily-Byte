package DesignPatterns.Creational.Singleton;

public class SingletonSynchronized {
    private static SingletonSynchronized singletonSynchronized;

    private SingletonSynchronized(){}

    // synchronized : thread safe
    synchronized public static SingletonSynchronized getInstance(){
        if (singletonSynchronized == null){
            singletonSynchronized = new SingletonSynchronized();
        }
        return singletonSynchronized;
    }

}
