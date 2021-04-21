package io.marble.lambda;


import org.junit.Test;

public class LambdaTest {
    @Test
    public void test() {
        System.out.println(new LambdaTest().testFunction((Integer::sum), 4, 5));
    }

    public int testFunction(LambdaInterface face, int a, int b) {
        return face.doSomeShit(a, b);
    }

    @Test
    public void testMathOperation() {
        MathOperation<Integer> marbleMath = new MathOperation<Integer>() {
            private final int key = 100;

            @Override
            public Integer operate(int a, int b) {
                System.out.println("marble 定义的方法：");
                return a + key + b;
            }
        };
        System.out.println(marbleMath.operate(3, 7));

        MathOperation<Integer> tianMath = (a, b) -> {
            System.out.println("tian 定义的方法：");
            int key = 200;
            return a + key + b;
        };
        System.out.println(tianMath.operate(3, 7));


    }
}
