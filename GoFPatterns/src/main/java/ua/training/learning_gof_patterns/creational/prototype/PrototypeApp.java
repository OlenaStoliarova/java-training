package ua.training.learning_gof_patterns.creational.prototype;

//в Java этот шаблон реализован с помощью интерфейса Cloneable и метода clone()

public class PrototypeApp {
    public static void main(String[] args) {
        Human original = new Human("Vasya", 18);
        System.out.println(original);

        Human copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Human h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setPrototype(new Human("Lena", 33 ));
        Human h2 = factory.makeCopy();
        System.out.println(h2);
    }
}


interface Copiable{
    Object copy();
}

class Human implements Copiable{
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object copy() {
        Human copy = new Human(name, age);
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class HumanFactory{
    Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }

    public void setPrototype(Human human){
        this.human = human;
    }

    Human makeCopy(){
        return (Human) human.copy();
    }
}