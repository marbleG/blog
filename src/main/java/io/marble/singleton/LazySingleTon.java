package io.marble.singleton;

public class LazySingleTon {

    private LazySingleTon() {
        System.out.println("LazySingleTon is create");
    }

    private static LazySingleTon instance = null;

    public static synchronized LazySingleTon getInstance() {
        if (instance == null) {
            instance = new LazySingleTon();
        }
        return instance;
    }

    public static void createString(){
        System.out.println("createString");
    }

    public static void main(String[] args) {
        LazySingleTon.createString();
        LazySingleTon.createString();
    }
}
