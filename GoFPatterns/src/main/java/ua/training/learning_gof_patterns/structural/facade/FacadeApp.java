package ua.training.learning_gof_patterns.structural.facade;

public class FacadeApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();

        /*
        //работа с классами без использования фасада
        Power power = new Power();
        power.on();

        DVDRom dvd = new DVDRom();
        dvd.load();

        HDD hdd = new HDD();
        hdd.copyFromDVD(dvd);
        */
    }
}

//facade class
class Computer{
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power{
    void on(){
        System.out.println("Включение питания");
    }
    void off(){
        System.out.println("Выключение питания");
    }
}

class DVDRom{
    private boolean data = false; //есть ли диск
    public boolean hasData(){ return  data;}

    public void load(){
        data = true;
    }

    public void unload(){
        data = false;
    }
}

class HDD{
    public void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Происходит копирование данных с диска");
        } else{
            System.out.println("Вставте диск с данными");
        }
    }
}
