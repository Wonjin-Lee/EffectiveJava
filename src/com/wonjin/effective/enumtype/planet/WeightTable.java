package com.wonjin.effective.enumtype.planet;

public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("%s에서의 무게는 %f이다.%n", planet, planet.surfaceWeight(mass));
        }
    }
}
