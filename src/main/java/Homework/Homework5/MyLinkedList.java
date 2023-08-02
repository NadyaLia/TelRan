package Homework.Homework5;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList implements Iterable<String> {

    private int size = 0;
    private Node first;

    public void clear() {
        size = 0;
        first = null;
    }

    public void add(String value) {
        if (isEmpty()) {
            first = new Node(value, null, null);
        } else {
            Node current = first;
            for (int i = 0; i < size - 1; i++) {

                current = current.next;
            }
            Node newNode = new Node(value, null, null);
            newNode.prev = current;

            current.next = newNode;
        }
        size++;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        // AAA BBB CCC - [AAA, BBB, CCC]
        StringBuilder builder = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            builder.append(current.data).append(", ");
            current = current.next;
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator<String> iterator() {

        return new MyListIterator();
    }

    public ListIterator<String> listIterator() {
        return new MyListIterator();
    }




    //    private void test() {
//        Node node = new Node("Test", null);
//        // Почему нам не нужны геттеры и сеттеры.
//        // Мы имеем прямой доступ к приватным полям внутреннего класса.
//        node.data = "";
//    }

    public class MyListIterator implements ListIterator<String> {
        private int cursor = 0;
        private Node current = first;
        private Node last = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String result = current.data;

            if(current.next == null) {
                last = current;
            }
            cursor++;
            current = current.next;
            return result;
        }

        @Override
        public boolean hasPrevious() {

            if(current == null) {
                return last != null;
            }

            return current != null;
        }

        @Override
        public String previous() {

            if(current == null) {
                current = last;
            }

            String result = current.data;
            current = current.prev;
            last = null;
            cursor--;
            return result;
        }

        @Override
        public int nextIndex() {
            return cursor+1;
        }

        @Override
        public int previousIndex() {

            if (cursor == 0) {
                return 0;
            }

            return cursor - 1;
        }

        @Override
        public void remove() {
            // to do
        }

        @Override
        public void set(String value) {
            if (current == null) {
                throw new RuntimeException();
            }
            current.data = value;
        }

        @Override
        public void add(String s) {
            add(s);
        }
    }

    private class Node {

        private String data;
        private Node next;
        private Node prev;
        public Node(String data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
