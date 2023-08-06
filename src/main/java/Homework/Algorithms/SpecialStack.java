package Homework.Algorithms;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SpecialStack<T extends Comparable<T>> {
    private int count;
    private ArrayList<T> items;

    public SpecialStack() {
        this.count = 0;
        this.items = new ArrayList<>();
    }

    public void push(T element) {
        this.items.add(element);
        this.count++;
    }

    public T pop() {
        if (this.count == 0) {
            throw new EmptyStackException();
        }
        T deleteItem = this.items.remove(this.count - 1);
        this.count--;
        return deleteItem;
    }

    public T peek() {
        if (this.count == 0) {
            throw new EmptyStackException();
        }
        T showItem = this.items.get(this.count - 1);
        return showItem;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size() {
        return this.count;
    }

    public void clear() {
        if (this.count == 0) {
            throw new EmptyStackException();
        }
        this.items.removeAll(items);
    }

    public T getMin() {
        if (this.count == 0) {
            throw new EmptyStackException();
        }
        return this.items.stream().min(Comparable::compareTo).orElse(null);
    }
}
