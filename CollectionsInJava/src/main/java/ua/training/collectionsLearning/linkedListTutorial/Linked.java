package ua.training.collectionsLearning.linkedListTutorial;

public interface Linked<E> {
    void addFirst(E e);
    void addLast(E e);
    int size();
    E getElementByIndex(int index);
}
