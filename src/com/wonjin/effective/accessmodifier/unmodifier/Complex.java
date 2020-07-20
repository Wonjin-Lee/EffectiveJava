package com.wonjin.effective.accessmodifier.unmodifier;

/*
    불변 객체는 생성된 시점의 상태를 파괴될 때까지 그대로 간직한다.
    불변 객체는 스레드 안전하여 따로 동기화할 필요 없다.

    한번 만든 인스턴스를 최대한 재활용하는게 좋다.
 */
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    /*
        사칙연산 메서드들은 인스턴스 자신을 수정하지 않고 새로운 Complex 인스턴스를 만들어 반환한다.
        메서드의 이름도 해당 메서드가 객체의 값을 변경하지 않는다는 사실을 강조하기 위해 동사(add 같은) 대신 전치사(plus 같은)를 사용했다.
     */

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        // float와 double은 특수한 부동소수 값 등을 다뤄야 하기 때문에, compare 메서드를 사용하여 비교한다.
        return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}

/*
    생성자 대신 정적 팩터리를 사용한 불변 클래스
 */
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}