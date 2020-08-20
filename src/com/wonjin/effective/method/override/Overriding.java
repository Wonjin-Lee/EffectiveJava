package src.com.wonjin.effective.method.override;

import java.util.List;

// 재정의된(Override) 메서드 호출 메커니즘
class Wine {
    String name() {
        return "포도주";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "발포성 포도주";
    }
}

class Champagne extends Wine {
    @Override
    String name() {
        return "샴페인";
    }
}

public class Overriding {
    public static void main(String[] args) {

        List<Wine> wineList = List.of(new Wine(), new SparklingWine(), new Champagne());

        // "포도주", "발포성 포도주", "샴페인"을 차례로 출력한다.
        // for 문에서의 컴파일타임 타입이 모두 Wine인 것에 무관하게 항상 '가장 하위에서 정의한' 재정의 메서드가 실행된다.
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}