package ua.training.learning_gof_patterns.creational.singletone;


public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        final int size = 1000;

        Thread[] t = new Thread[size];
        for(int i=0; i<1000; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for(int i=0; i<1000; i++)
            t[i].join();
        System.out.println(SingletonThreadsSafeLazyInit.counter);

        /*
        System.out.println(Singleton.counter); //can be more that 1 (2 or 3, but usually not more that 5,
                                                // only first couple of threads can get non-initialized instance
*/
        /*
        // one-thread Singleton usage
        Singleton[] arr = new Singleton[size];
        for(int i=0; i<1000; i++)
            arr[i] = Singleton.getInstance();
        System.out.println(Singleton.counter);
        */
    }
}

class R implements Runnable{
    @Override
    public void run() {
        //Singleton.getInstance();
        //SingletonThreadsSafe.getInstance();
        SingletonThreadsSafeLazyInit.getInstance();
    }
}

//такой Singleton сам по себе не будет работать в много поточности
class Singleton{
    private static Singleton instance;
    public static int counter = 0;

    private Singleton(){
        counter ++;
    }

    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
}


class SingletonThreadsSafe {
    public static int counter = 0;
    //при таком подходе многопоточность работает корректно, но нет "ленивой инициализации"
    // (синглтон будет создан, даже если его инстанс ни разу не запросили)
    private static SingletonThreadsSafe instance = new SingletonThreadsSafe();

    private SingletonThreadsSafe(){
        counter ++;
    }

    public static SingletonThreadsSafe getInstance(){
        return instance;
    }
}

class SingletonThreadsSafeLazyInit {
    public static int counter = 0;
    private static volatile SingletonThreadsSafeLazyInit instance;

    private SingletonThreadsSafeLazyInit(){
        counter ++;
    }

    public static SingletonThreadsSafeLazyInit getInstance(){
        if(instance == null){
            synchronized (SingletonThreadsSafeLazyInit.class){
                if(instance == null)
                    instance = new SingletonThreadsSafeLazyInit();
            }
        }

        return instance;
    }
}