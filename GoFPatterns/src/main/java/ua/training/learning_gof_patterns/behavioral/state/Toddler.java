package ua.training.learning_gof_patterns.behavioral.state;

public class Toddler implements KidState {

    @Override
    public void eat() {
        System.out.println("Eating plain food");
    }

    @Override
    public void play() {
        System.out.println("Playing with teddy bear");
    }
}
