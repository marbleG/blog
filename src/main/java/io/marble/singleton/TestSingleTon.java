package io.marble.singleton;

public class TestSingleTon {
    public static void main(String[] args) {
        SingleTon.createString();
        LazySingleTon.createString();
        StaticSingleTon.createString();
    }
}
