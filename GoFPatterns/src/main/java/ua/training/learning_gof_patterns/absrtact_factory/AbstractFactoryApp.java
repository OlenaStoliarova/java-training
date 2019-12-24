package ua.training.learning_gof_patterns.absrtact_factory;


public class AbstractFactoryApp {
    public static void main(String[] args) {
        //DeviceFactory factory = getFactoryByCountryCode("RU");
        DeviceFactory factory = getFactoryByCountryCode("EN");
        Mouse mouse = factory.getMouse();
        Keyboard keyboard = factory.getKeyboard();
        Touchpad touchpad = factory.getTouchpad();

        mouse.click();
        keyboard.print();
        touchpad.track(10,35);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code " + lang);
        }
    }
}


interface Mouse{
    void click();
    void dblclick();
    void scroll (int direction);
}

interface Keyboard{
    void print();
    void println();
}

interface Touchpad{
    void track(int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}


class RuMouse implements Mouse{
    public void click() { System.out.println("Щелчок мышью");}
    public void dblclick() { System.out.println("Двойной щелчок мышью"); }
    public void scroll(int direction) {
        if(direction > 0)
            System.out.println("Скроллим вверх");
        else if (direction < 0)
            System.out.println("Скроллим вниз");
        else
            System.out.println("Не скроллим");
    }
}

class RuKeyboard implements Keyboard{
    public void print() { System.out.println("Печатаем строку"); }
    public void println() { System.out.println("Печатаем строку с переводом строки"); }
}

class RuTouchpad implements Touchpad{
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt( Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}


class EnMouse implements Mouse{
    public void click() { System.out.println("Mouse click");}
    public void dblclick() { System.out.println("Mouse double click"); }
    public void scroll(int direction) {
        if(direction > 0)
            System.out.println("Scroll up");
        else if (direction < 0)
            System.out.println("Scroll down");
        else
            System.out.println("No scroll");
    }
}

class EnKeyboard implements Keyboard{
    public void print() { System.out.println("Print"); }
    public void println() { System.out.println("Print line"); }
}

class EnTouchpad implements Touchpad{
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt( Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Move " + s + " pixels");
    }
}


class EnDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new EnMouse();
    }

    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}

class RuDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new RuMouse();
    }

    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}