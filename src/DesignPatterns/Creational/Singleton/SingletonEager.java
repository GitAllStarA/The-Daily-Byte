package DesignPatterns.Creational.Singleton;

public class SingletonEager {

    private static SingletonEager singletonInstance = new SingletonEager();
    private SingletonEager(){}
    public static SingletonEager getInstance() {
        return singletonInstance;
    }
}
