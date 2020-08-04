package com.wonjin.effective.hierarchical;
/*
    아래와 같이 태그 달린 클래스는 많은 단점을 가지고 있다. 사용하지 말 것.
 */

/*
public class Figure {
    enum Shape { RECTANGLE, CIRCLE };

    // 태그 필드 - 현재 모양을 나타낸다.
    final Shape shape;

    // 다음 필드들은 모양이 사각형(RACTANGLE)일 때만 쓰인다.
    double length;
    double width;

    // 다음 필드는 모양이 원(CIRCLE)일 때만 쓰인다.
    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
*/

/*
    1. 계층구조의 루트가 될 추상 클래스를 정의한다.
    2. 태그 값에 따라 동작이 달라지는 메서드들을 루트 클래스의 추상 메서드로 선언한다. (위에서의 area)
    3. 태그 값에 상관없이 동작이 일정한 메서드들을 루트 클래스에 일반 메서드로 추가한다.
    4. 모든 하위 클래스에서 공통으로 사용하는 데이터 필드들도 전부 루트 클래스로 올린다.
 */
abstract class Figure {
    abstract double area();
}

class Circle extends Figure {
    final double radius;

    Circle(double radius) { this.radius = radius; }

    @Override
    double area() { return Math.PI * (radius * radius); }
}

class Ractangle extends Figure {
    final double length;
    final double width;

    Ractangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() { return length * length; }
}