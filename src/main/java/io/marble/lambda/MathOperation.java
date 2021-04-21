package io.marble.lambda;

import java.io.Serializable;

public interface MathOperation<T extends Object & Serializable> {
    T operate(int a, int b);
}
