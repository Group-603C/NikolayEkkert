package com.company;

public class Main {

    public static void main(String[] args) {

        Point instance = new Point(10, 2, 54);
        System.out.println(instance.getX());
        System.out.println(instance.getY());
        System.out.println(instance.getZ());

        Point instnaceForComparison = new Point(12, 144, 90);
        System.out.println(instance.distanceTo(instnaceForComparison));

        PolarPoint instancePolar = instance.toPolar();
        System.out.println(instancePolar.getPhi());
        System.out.println(instancePolar.getRho());
        System.out.println(instancePolar.toCartesian() instanceof Point);

        CylindricalPoint instanceCylindrical = instance.toCylindrical();
        System.out.println(instanceCylindrical.getZ());
        System.out.println(instanceCylindrical.getPhi());
        System.out.println(instanceCylindrical.getRho());
        System.out.println(instanceCylindrical.toCartesian() instanceof Point);
    }
}
