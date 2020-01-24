package ua.training.learning_gof_patterns.behavioral;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));
        user.StartComputer();
        user.StopComputer();
        user.ResetComputer();
    }
}


interface Command{
    void execute();
}

//Receiver
class Comp{
    void start(){  System.out.println("Start"); }
    void stop(){  System.out.println("Stop"); }
    void reset(){  System.out.println("Reset"); }
}

//ConcreteCommand
class StartCommand implements Command{
    Comp comp;
    public StartCommand(Comp comp) {  this.comp = comp; }

    public void execute() {
        comp.start();
    }
}

class StopCommand implements Command{
    Comp comp;
    public StopCommand(Comp comp) {  this.comp = comp; }

    public void execute() {
        comp.stop();
    }
}

class ResetCommand implements Command{
    Comp comp;
    public ResetCommand(Comp comp) {  this.comp = comp; }

    public void execute() {
        comp.reset();
    }
}

//Invoker
class User{
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void StartComputer(){
        start.execute();
    }
    void StopComputer(){
        stop.execute();
    }
    void ResetComputer(){
        reset.execute();
    }
}