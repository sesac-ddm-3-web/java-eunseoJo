package com.sesca.day04.problem01;

public class Rectangle implements Shape{

    double width;
    double height;

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return this.width * this.height;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * (this.width + this.height);
    }
}
