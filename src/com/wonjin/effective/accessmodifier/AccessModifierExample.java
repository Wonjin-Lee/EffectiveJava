package com.wonjin.effective.accessmodifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AccessModifierExample {
    /*
        보안 허점이 숨어 있다.
        상수로 사용하기 위해 public static final 필드로 선언했는데,
        길이가 0이 아닌 배열은 변경 가능하기 때문에 클라이언트에서 배열의 내용을 수정할 수 있게 된다.
     */
    public static final String[] VALUES = {"apple", "banana", "melon"};

    /*
        위 문제에 대한 해결책은 두 가지가 있다.
        첫 번째 방법은 public 배열을 private으로 만들고 public 불변 리스트를 추가하는 것이다.
        두 번째 방법은 배열을 private으로 만들고 그 복사본을 반환하는 public 메서드를 추가하는 방법이다(방어적 복사).
     */

    private static final String[] PRIVATE_VALUES = {"apple", "banana", "melon"};
    public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    private static final String[] PRIVATE_VALUES = {"apple", "banana", "melon"};
    public static final String[] values() {
        return PRIVATE_VALUES.clone();
    }

    // 결론 : public static final 필드가 참조하는 객체가 불변인지 확인하라.
}
