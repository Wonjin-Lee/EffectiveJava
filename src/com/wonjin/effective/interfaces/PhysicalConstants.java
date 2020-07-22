package com.wonjin.effective.interfaces;

/*
    인터페이스는 타입을 정의하는 용도로만 사용해야 한다. 상수 공개용 수단으로 인터페이스를 사용하지 말자.
    상수 공개는 인스턴스화할 수 없는 유틸리티 클래스에 담아서 공개하자.
 */
public class PhysicalConstants {

    // 인스턴스화 방지
    private PhysicalConstants() { }

    // 아보가드로 수 (1/몰)
    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;

    // 볼츠만 상수 (J/K)
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;

    // 전자 질량 (kg)
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}