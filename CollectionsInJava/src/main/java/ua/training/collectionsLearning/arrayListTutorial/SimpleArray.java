package ua.training.collectionsLearning.arrayListTutorial;

import ua.training.collectionsLearning.arrayListTutorial.ArrayIterator;
import java.util.Iterator;

public class SimpleArray<E> implements Simple<E> {
    public static void main(String[] args) {
        Simple<String> strings = new SimpleArray<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");

        // we can use foreach because of Iterable interface
        for(String s: strings){
            System.out.println(s);
        }

        System.out.println(strings.get(1));
        System.out.println(strings.size());

        strings.update(1, "update");
        System.out.println(strings.get(1));

        strings.delete(1);
        System.out.println(strings.get(1));

        System.out.println("delete 2");
        strings.delete(1);
        System.out.println(strings.get(1));
    }

    private E[] values;

    public SimpleArray() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(
                    temp, index+1,  //src
                    values, index,          //destination
                    temp.length - index - 1); //number of elements to copy
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        try {
            return values[index];
        } catch (ArrayIndexOutOfBoundsException ex)
        {
            //ex.printStackTrace();
            System.out.println( ex.toString());
        }
        return null;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}
