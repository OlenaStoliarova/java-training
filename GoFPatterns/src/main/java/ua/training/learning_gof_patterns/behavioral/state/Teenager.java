package ua.training.learning_gof_patterns.behavioral.state;

public class Teenager implements KidState {
    @Override
    public void eat() {
        System.out.println("Eating junk food");
    }

    @Override
    public void play() {
        System.out.println("Playing on parent's nerves");
    }
}
