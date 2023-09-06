package DesignPatterns.Creational.Singleton;

public class ClientClass {

    public static void main(String[] args) {
        //singleton eager
        SingletonEager.getInstance();

        //singleton lazy
        SingletonLazy.getInstance();

        //singleton synchronized
        SingletonSynchronized.getInstance();

        //singleton double lock
        SingletonDoubleLock.getInstance();
    }



}
