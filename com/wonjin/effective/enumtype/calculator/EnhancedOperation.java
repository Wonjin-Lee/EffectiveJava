package com.wonjin.effective.enumtype.calculator;

/*
    apply 메서드가 상수 선언 바로 옆에 붙어 있으니 새로운 상수를 추가할 때 apply도
    재정의해야 한다는 사실을 깜빡하기는 어려울 것이다.
    또한 apply 메서드가 추상 메서드이므로 재정의하지 않았다면 컴파일 오류로 알려준다.
 */
public enum EnhancedOperation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    public abstract double apply(double x, double y);

    EnhancedOperation(String symbol) {
        this.symbol = symbol;
    }

    // symbol을 추가하고 toString()을 아래와 같이 정의하여 계산식 출력을 편하게 만든다.
    @Override
    public String toString() {
        return symbol;
    }
}
