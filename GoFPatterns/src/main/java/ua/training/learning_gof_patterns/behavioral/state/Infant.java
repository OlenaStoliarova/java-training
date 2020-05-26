package ua.training.learning_gof_patterns.behavioral.state;

public class Infant implements KidState {

    @Override
    public void eat() {
        System.out.println("Drinking milk");
    }

    @Override
    public void play() {
        System.out.println("Putting legs in the mouth");
    }
}
