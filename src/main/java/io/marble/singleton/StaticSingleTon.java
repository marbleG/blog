package io.marble.singleton;

public class StaticSingleTon {

    private StaticSingleTon() {
        System.out.println("StaticSingleTon is create");
    }


    private static class SingleTonHolder {
        private static StaticSingleTon instance = new StaticSingleTon();
    }

    public static StaticSingleTon getInstance() {
        return SingleTonHolder.instance;
    }

    public static void createString() {
        System.out.println("createString");
    }
}
