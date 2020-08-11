package com.wonjin.effective.enumtype.ensemble;

/*
    ordinal을 잘못 사용한 예

    합주단의 종류를 연주자가 1명인 솔로(solo)부터 10명인 디텍트(dectet)까지 정의한 열거 타입

    동작은 하지만 유지보수하기가 매우 힘든 코드이다.
    상수 선언 순서를 바꾸는 순간 numberOfMusicians가 오작동하고 이미 사용 중인 정수와 값이 같은 상수는 추가할 방법이 없다.

    해결책은 열거 타입 상수에 연결된 값은 ordinal 메서드로 얻지말고, 인스턴스 필드에 저장하면 된다.
 */
public enum Ensemble {
    SOLO, DUET, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}
