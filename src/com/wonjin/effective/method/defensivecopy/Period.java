package src.com.wonjin.effective.method.defensivecopy;

import java.util.Date;

// 기간을 표현하는 클래스 - 불변식을 지키지 못했다.
public class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start 시작 시각
     * @param end 종료 시각; 시작 시각보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
     * @throws NullPointerException start나 end가 null이면 발생한다.
     */
    /*
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        this.start = start;
        this.end = end;
    }
     */

    // 수정한 생성자 - 매개변수의 방어적 복사본을 만든다.
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(this.start + "가 " + this.end + "보다 늦다.");
    }

    /*
    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
     */

    // 수정한 접근자 - 필드의 방어적 복사본을 반환한다.
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    // 나머지 코드 생략
}

/*
    아래와 같이 Period 인스턴스의 내부를 공격할 수 있다.

    Date start = new Date();
    Date end = new Date();
    Period period = new Period(start, end);
    end.setYear(78); // period의 내부를 수정했다!

    외부 공격으로부터 Period 인스턴스의 내부를 보호하려면
    생성자에서 받은 가변 매개변수 각각을 방어적으로 복사(defensive copy)해야 한다.
    그런 다음 Period 인스턴스 안에서는 원본이 아닌 복사본을 사용한다.

    Period 인스턴스를 향한 두 번째 공격
    Date start = new Date();
    Date end = new Date();
    Period p = new Period(start, end);
    p.end().setYear(78); // period의 내부를 변경했다!

    두 번째 공격을 막아내려면 접근자가 가변 필드의 방아적 복사본을 반환하면 된다.
 */
