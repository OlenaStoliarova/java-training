package ua.training.learning_gof_patterns.structural.delegate;

public class DelegateApp {
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();

        /*
        A a = new A();
        a.f();
         */
    }
}

class A{
    void f(){
        System.out.println("f()");
    }
}

//класс В пользуется плодами уже готовой реализации класса А
//делегирует ему часть работы
class B{
    A a = new A();
    void f(){
        a.f();
    }
}


interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    public void draw() {
        System.out.println("Рисуем треугольник");
    }
}

class Square implements Graphics{
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}

class Circle implements Graphics{
    public void draw() {
        System.out.println("Рисуем круг");
    }
}

class Painter{
    Graphics graphics;

    void setGraphics(Graphics g){
        graphics = g;
    }

    void draw(){
        graphics.draw();
    }
}
