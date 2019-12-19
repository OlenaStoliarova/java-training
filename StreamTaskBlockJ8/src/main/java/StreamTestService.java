
import javafx.util.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTestService {

    public double averageValueUsingAverage(Supplier<IntStream> intStreamSupplier) {
        return intStreamSupplier.get()
                .average()
                .getAsDouble();
    }

    public double averageValueOption1(Supplier<IntStream> intStreamSupplier) {
        return intStreamSupplier.get()
                .mapToDouble(number -> (double) number / intStreamSupplier.get().count())
                .sum();
    }

    public double averageValueOption2(Supplier<IntStream> intStreamSupplier) {
        return intStreamSupplier.get()
                .mapToDouble(number -> (double) number / intStreamSupplier.get().count())
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public Pair<Integer,Integer> findAnyMinElementAndItsIndex(Supplier<IntStream> intStreamSupplier)
    {
        int[] tempArray = intStreamSupplier.get().toArray();

        return IntStream.range(0, tempArray.length)
                .boxed()
                .map( i -> new Pair<>(i, tempArray[i]))
                .min(Comparator.comparingInt(Pair::getValue))
                .orElse( null);

        /*
        IntStream.range(0, intArray.length )
                .reduce( (a,b) -> intArray[a] < intArray[b] ? a : b)
                .ifPresent( minElem -> System.out.println("Index " + minElem + ", value " + intArray[minElem]));
        */
    }

    public Map<Integer,Integer> findAllMinElementsAndItsIndexes(Supplier<IntStream> intStreamSupplier){
        int[] tempArray = intStreamSupplier.get().toArray();

        int minValue = intStreamSupplier.get().min().orElse(0);

        return IntStream.range(0, tempArray.length)
                .boxed()
                .map( i -> new Pair<>(i, tempArray[i]))
                .filter( p -> p.getValue().equals(minValue))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }

    public Pair<Integer, List<Integer>> findMinElementAndAllItsIndexes(Supplier<IntStream> intStreamSupplier){
        int[] tempArray = intStreamSupplier.get().toArray();

        int minValue = intStreamSupplier.get().min().orElse(0);

        List<Integer> indexes = IntStream.range(0, tempArray.length)
                .boxed()
                .filter(i -> tempArray[i] == minValue)
                .collect(Collectors.toList());

        return new Pair<>(minValue, indexes);
    }

    public long countZeroElements(Supplier<IntStream> intStreamSupplier) {
        return intStreamSupplier.get()
                .filter(number -> number == 0)
                .count();
    }

    public long countElementsAboveZero(Supplier<IntStream> intStreamSupplier) {
        return intStreamSupplier.get()
                .filter(number -> number > 0)
                .count();
    }

    public IntStream multiplyStreamElementsByNumber(Supplier<IntStream> intStreamSupplier, int multiplier) {
        return intStreamSupplier.get()
                .map( number -> number * multiplier );
    }
}
