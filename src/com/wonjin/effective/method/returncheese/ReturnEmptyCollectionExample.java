package src.com.wonjin.effective.method.returncheese;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReturnEmptyCollectionExample {
    class Cheese {

    }

    private List<Cheese> cheesesInStock;

    /*
        컬렉션이 비었으면 null을 반환한다. - 좋지 않은 코드 -
     */
    public List<Cheese> getCheeses() {
        return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
    }

    /*
        빈 컬렉션을 반환하는 올바른 예
     */
    public List<Cheese> getCheesesList() {
        return new ArrayList<>(cheesesInStock);
    }

    /*
        길이가 0일 수도 있는 배열을 반환하는 올바른 방법
     */
    public Cheese[] getCheesesArray() {
        return cheesesInStock.toArray(new Cheese[0]);
    }
}
