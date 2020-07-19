package com.wonjin.effective.accessmodifier.mutator;

/*
    패키지 바깥에서 접근할 수 있는 클래스는 필드에 대한 접근자를 제공
 */
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
