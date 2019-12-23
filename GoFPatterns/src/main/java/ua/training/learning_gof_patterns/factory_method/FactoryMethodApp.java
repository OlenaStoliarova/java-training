package ua.training.learning_gof_patterns.factory_method;

import java.time.LocalDate;
import java.time.LocalTime;

public class FactoryMethodApp {

    public static void main(String[] args) {
        WatchMaker maker = getWatchMakerByName("bla");
        //WatchMaker maker = new RomeWatchMaker();

        Watch watch = maker.createWatch(); //теперь код создания объекта Часы не зависит от конкретной реализации
        watch.showTime();
    }

    public static WatchMaker getWatchMakerByName(String name){
        if(name.equalsIgnoreCase("digital"))
            return new DigitalWatchMaker();
        if (name.equalsIgnoreCase("rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("Не поддерживаемая производственная линия часов " + name);
    }
}


interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    public void showTime() {
        System.out.println(LocalTime.now().toString());
    }
}

class RomeWatch implements Watch{
    public void showTime() {
        System.out.println("XIX-VV");
    }
}


interface WatchMaker{
    Watch createWatch(); //это фабричный метод
}

class DigitalWatchMaker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
