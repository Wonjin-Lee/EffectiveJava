package src.com.wonjin.effective.method.overloading;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifier {
    public static String classify(Set<?> set) {
        return "집합";
    }

    public static String classify(List<?> list) {
        return "리스트";
    }

    public static String classify(Collection<?> collection) {
        return "그 외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        /*
            "집합", "리스트", "그 외"를 차례로 출력할 것 같지만, 실제 수행 결과는 "그 외"만 세 번 연달아 출력한다.
            그 이유는 다중정의(Overloading)된 세 classify 중 어느 메서드를 호출할지가 컴파일타임에 정해지기 때문이다.
            컴파일타임에는 for 문 안의 collection은 항상 Collection<?> 타입이다. 런타임에는 타입이 매번 달라지지만
            호출할 메서드를 선택하는 데는 영향을 주지 못한다.

            재정의한 메서드는 동적으로 선택되고, 다중정의한 메서드는 정적으로 선택된다.
         */
        for (Collection<?> collection : collections) {
            System.out.println(classify(collection));
        }
    }
}




