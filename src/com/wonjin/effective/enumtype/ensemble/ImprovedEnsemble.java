package com.wonjin.effective.enumtype.ensemble;

/*
    Ensemble 열거 타입이 가지고 있는 문제를 인스턴스 필드로 해결

    해당 열거 타입 상수의 생성자는 합주단을 구성하는 사람의 수를 인자로 받아 numberOfMusicians 필드에 저장한다.
    이렇게 되면 상수들의 위치가 변경이 되어도 아무런 문제가 없고 사용 중인 정수와 값이 같은 상수가 추가되어도 문제가 없다.
 */
public enum ImprovedEnsemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;
    ImprovedEnsemble(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}
