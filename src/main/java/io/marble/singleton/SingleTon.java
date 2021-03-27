package io.marble.singleton;

public class SingleTon {
    private SingleTon() {
        System.out.println("SingleTon is create");
    }

    private static final SingleTon instance = new SingleTon();

    public static SingleTon getInstance() {
        return instance;
    }
    public static void createString(){
        System.out.println("createString");
    }

    public static void main(String[] args) {
        SingleTon.createString();
    }
    public static void test() {
        SingleTon.createString();
    }
}
