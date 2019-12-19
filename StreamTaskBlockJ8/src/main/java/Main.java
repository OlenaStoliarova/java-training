import javafx.util.Pair;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //Сделать массив int. Из него получить IntStream.
        //int[] intArray = {15, 40, 0, -7, 96, -90, 56, 115, -25, 0, -90, 100, 0, 40};
        int[] intArray = {-1,1,-1,1,-1};

        IntStream intStream = Arrays.stream(intArray);
        System.out.print("Initial array of ints: ");
        intStream.forEach(number -> System.out.print(number + " "));

        /*
        //RUN TIME EXCEPTION: stream has already been operated upon or closed
        intStream.average().getAsDouble();
        //!!!! Stream can be used only once
        */

        Supplier<IntStream> intStreamSupplier = () -> Arrays.stream(intArray);
        doAllTasks( intStreamSupplier);

        //Сделать List<Integer>. Из него получить IntStream.
        List<Integer> listInt = initializeArray(30);

        System.out.println("\n\n\nInitial ArrayList<Integer>:");
        listInt.forEach(number -> System.out.print(number + " "));

        Supplier<IntStream> streamSupplier = () -> listInt.stream().mapToInt(Integer::intValue);
        System.out.println("\nIntStream:");
        streamSupplier.get().forEach(number -> System.out.print(number + " "));

        doAllTasks(streamSupplier);

        //Помножить элементы массива на число
        //Here we change ArrayList itself
        int multiplier = 2;
        System.out.println("\nArray of ints multiplied by " + multiplier + " (second way):");
        listInt.forEach( (number) -> { number = number * 2;
                    System.out.print(number + " ");});

    }


    public static void doAllTasks( Supplier<IntStream> intStreamSupplier){
        StreamTestService streamService = new StreamTestService();

        //Найти среднее значение элементов массива (с использованием average и без).
        System.out.println("\n\nIntStream average()=" + streamService.averageValueUsingAverage(intStreamSupplier));
        System.out.println("IntStream average using mapToDouble() + sum()=" + streamService.averageValueOption1(intStreamSupplier));
        System.out.println("IntStream average using reduce()=" + streamService.averageValueOption2( intStreamSupplier ));

        //Найти минимальный элемент и вернуть значение и индекс (одновременно)
        System.out.println("\nSearching for min value and its index...");
        Pair<Integer, Integer> minElement = streamService.findAnyMinElementAndItsIndex( intStreamSupplier );
        System.out.println("index " + minElement.getKey() + ", value " + minElement.getValue());

        System.out.println("\nSearching all min value with its indexes...");
        Map<Integer,Integer> allMinElements = streamService.findAllMinElementsAndItsIndexes( intStreamSupplier);
        allMinElements.forEach( (k,v) -> System.out.print( "["+k + "]=" + v + "; " ));

        System.out.println("\n\nSearching min value and all its indexes...");
        Pair<Integer, List<Integer>> minElementWithAllIndexes = streamService.findMinElementAndAllItsIndexes( intStreamSupplier);
        System.out.println( "minValue = " + minElementWithAllIndexes.getKey() + " , all its indexes " + minElementWithAllIndexes.getValue());

        //Посчитать количество элементов равных нулю
        System.out.println("\nQuantity of zero elements = " + streamService.countZeroElements( intStreamSupplier));

        //Посчитать количество элементов больше нуля
        System.out.println("Quantity of elements higher than zero = " + streamService.countElementsAboveZero( intStreamSupplier));

        //Помножить элементы массива на число
        int multiplier = 3;
        int[] multipliedArray =  streamService.multiplyStreamElementsByNumber(intStreamSupplier, multiplier).toArray();
        System.out.println("\nArray of ints multiplied by " + multiplier + ":");
        Arrays.stream(multipliedArray).forEach(number -> System.out.print(number + " "));
    }


    public static List<Integer> initializeArray(int numberOfElements){
        List<Integer> listInt = new ArrayList<>();
        for(int i=0; i<numberOfElements; i++)
        {
            Random random = new Random();
            listInt.add(random.nextInt(100));
        }
        return listInt;
    }
}
