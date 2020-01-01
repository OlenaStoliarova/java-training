package ua.training.collectionsLearning.linkedListTutorial;


import java.util.Iterator;

public class LinkedContainer<E> implements Linked<E>, Iterable<E>, DescendingIterator<E> {
    public static void main(String[] args) {
        LinkedContainer<String> linkedStrings = new LinkedContainer<>();
        linkedStrings.addFirst("abc");
        linkedStrings.addLast("def");
        linkedStrings.addFirst("abc2");
        linkedStrings.addLast("def2");

        System.out.println(linkedStrings.size());
        for(int i=0; i < linkedStrings.size(); i++) {
            System.out.println(linkedStrings.getElementByIndex(i));
        }

        System.out.println("for each loop:");
        for(String s: linkedStrings){
            System.out.println(s);
        }

        System.out.println("Descending iterator:");
        Iterator<String> descendingIterator = linkedStrings.descendingIterator();
        while (descendingIterator.hasNext())
            System.out.println(descendingIterator.next());
    }

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public LinkedContainer() {
        firstNode = new Node<>(null, null, null);
        lastNode = new Node<>(null, firstNode, null);
        firstNode.setNextElement(lastNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> previousLast = lastNode;
        previousLast.setCurrentElement(e);
        lastNode = new Node<>(null, previousLast, null);
        previousLast.setNextElement(lastNode);
        size ++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> previousFirst = firstNode;
        previousFirst.setCurrentElement(e);
        firstNode = new Node<>(null, null, previousFirst);
        previousFirst.setPreviousElement(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int index) {
        Node<E> target = firstNode;
        for(int i=0; i <= index; i++) {
            target = target.getNextElement();
        }
        return target.getCurrentElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return getElementByIndex(index++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(index--);
            }
        };
    }


    private class Node<E>{
        private E currentElement;
        private Node<E> previousElement;
        private Node<E> nextElement;

        public Node(E currentElement, Node<E> previousElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.previousElement = previousElement;
            this.nextElement = nextElement;
        }

        public E getCurrentElement() {  return currentElement;    }
        public Node<E> getPreviousElement() { return previousElement;  }
        public Node<E> getNextElement() {   return nextElement;    }

        public void setCurrentElement(E currentElement) {  this.currentElement = currentElement;    }
        public void setPreviousElement(Node<E> previousElement) {  this.previousElement = previousElement;    }
        public void setNextElement(Node<E> nextElement) {  this.nextElement = nextElement;   }
    }
}
