package ua.training.learning_gof_patterns.behavioral.state;

public class Kid {
    private int age;
    private KidState state;

    public Kid(int age) {
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age >= 19) {
            throw new IllegalArgumentException("Kid's age should be between 0 and 18");
        }

        this.age = age;

        if (age < 1) {
            state = new Infant();
            return;
        }

        if (age < 4) {
            state = new Toddler();
            return;
        }

        if (age < 13) {
            state = new Child();
            return;
        }

        state = new Teenager();
    }

    public void grow() {
        setAge(age + 1);
    }

    public void eat() {
        state.eat();
    }

    public void play() {
        state.play();
    }
}
