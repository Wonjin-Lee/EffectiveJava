package com.wonjin.effective.enumtype.calculator;

/*
    아래 코드는 새로운 상수를 추가하게 되면 해당 case 문도 추가해야 한다.
    동작은 하지만 그리 좋은 코드는 아님.
 */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    // 상수가 뜻하는 연산을 수행한다.
    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("알 수 없는 연산: " + this);
    }
}
