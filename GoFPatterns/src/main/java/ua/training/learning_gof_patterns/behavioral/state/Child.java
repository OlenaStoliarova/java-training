package ua.training.learning_gof_patterns.behavioral.state;

class Child implements KidState {

    @Override
    public void eat() {
        System.out.println("Eating ice-cream and chocolate");
    }

    @Override
    public void play() {
        System.out.println("Playing with lego and puzzles");
    }
}
