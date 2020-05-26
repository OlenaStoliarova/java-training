package ua.training.learning_gof_patterns.behavioral.state;

public class Main {

    public static void main(String[] args) {
        Kid kid = new Kid(0);

        for (int i = 0; i < 19; i++) {
            System.out.println("Kid's age: " + kid.getAge());

            System.out.print("\t");
            kid.eat();

            System.out.print("\t");
            kid.play();

            kid.grow();
        }
    }
}
