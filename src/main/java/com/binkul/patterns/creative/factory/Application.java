package com.binkul.patterns.creative.factory;

public class Application {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.createShape(ShapeFactory.CIRCLE);
        System.out.println(circle.getName() + ", field: " + circle.getArea());

        factory = new ShapeFactory();
        Shape square = factory.createShape(ShapeFactory.SQUARE);
        System.out.println(square.getName() + ", field: " + square.getArea());

        factory = new ShapeFactory();
        Shape rectangle = factory.createShape(ShapeFactory.RECTANGLE);
        System.out.println(rectangle.getName() + ", field: " + rectangle.getArea());
    }
}
