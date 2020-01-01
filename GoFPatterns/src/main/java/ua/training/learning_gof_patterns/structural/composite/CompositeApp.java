package ua.training.learning_gof_patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Square s1 = new Square();
        Square s2 = new Square();
        Triangle t1 = new Triangle();

        Square s3 = new Square();
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(s1);
        composite1.addComponent(s2);
        composite1.addComponent(t1);

        composite2.addComponent(s3);
        composite2.addComponent(c1);
        composite2.addComponent(c2);
        composite2.addComponent(c3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(new Triangle());

        composite.draw();
    }
}

interface Shape{
    void draw();
}

class Square implements Shape{
    public void draw() { System.out.println("Привет, я квадрат"); }
}

class Triangle implements Shape{
    public void draw() { System.out.println("Привет, я треугольник"); }
}

class Circle implements Shape{
    public void draw() { System.out.println("Привет, я круг"); }
}


class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component){
        components.add(component);
    }

    public void removeComponent(Shape component){
        components.remove(component);
    }

    public void draw() {
        for (Shape component: components){
            component.draw();
        }
    }
}