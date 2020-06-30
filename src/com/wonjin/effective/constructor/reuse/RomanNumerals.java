package com.wonjin.effective.constructor.reuse;

import java.util.regex.Pattern;

/*
    주어진 문자열이 로마 숫자인지를 확인하는 정규표현식 패턴은
    앞으로 변경될 일이 없고 Pattern 인스턴스는 생성 시에 Cost가 크다.

    이러한 경우 Pattern 인스턴스를 static final 필드로 만들어서 성능을 올릴 수 있다.
 */
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "^(=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"
    );

    public static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
