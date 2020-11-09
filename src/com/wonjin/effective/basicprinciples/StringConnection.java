package com.wonjin.effective.basicprinciples;

/*
    성능에 신경 써야 한다면 많은 문자열을 연결할 때는 문자열 연결 연산자(+)를 피하자.
 */
public class StringConnection {
    public String statement() {
        String result = "";
        for (int i = 0; i < numItems(); i++) {
            result += lineForItem(i);
        }
        return result;
    }

    public String statement2() {
        StringBuilder stringBuilder = new StringBuilder(numItem() * LINE_WIDTH);
        for (int i = 0; i < numItem(); i++) {
            stringBuilder.append(lineForItem(i));
        }
        return stringBuilder.toString();
    }
}
