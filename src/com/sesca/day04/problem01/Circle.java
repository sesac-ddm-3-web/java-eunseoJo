package com.sesca.day04.problem01;

public class Circle implements Shape{

    double radius;
    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea(){
        return this.radius * this.radius * Shape.PI;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * Shape.PI * radius;
    }
}
