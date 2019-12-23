package ua.training.learning_gof_patterns.builder;

public class BuilderFullApp {
    public static void main(String[] args) {
        CarDirector carDirector = new CarDirector();
        carDirector.setCarBuilder(new SubaruBuilder());

        Car car = carDirector.buildCar();
        System.out.println(car.toString());

        carDirector.setCarBuilder(new FordMondeoBuilder());
        car = carDirector.buildCar();
        System.out.println(car.toString());
    }
}

abstract class CarBuilderFull{
    Car car;
    void creteCar(){car = new Car();}

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar(){return car;}
}

class FordMondeoBuilder extends CarBuilderFull{
    void buildMake() { car.setMake("Ford Mondeo");}
    void buildTransmission() { car.setTransmission(Transmission.MANUAL);}
    void buildMaxSpeed() { car.setMaxSpeed(280);}
}

class SubaruBuilder extends CarBuilderFull{
    void buildMake() { car.setMake("Subaru");}
    void buildTransmission() { car.setTransmission(Transmission.AUTO);}
    void buildMaxSpeed() { car.setMaxSpeed(320);}
}

class CarDirector{
    CarBuilderFull carBuilder;

    void setCarBuilder(CarBuilderFull b){ carBuilder = b;}

    Car buildCar(){
        carBuilder.creteCar();
        carBuilder.buildMake();
        carBuilder.buildTransmission();
        carBuilder.buildMaxSpeed();
        return carBuilder.getCar();
    }

}