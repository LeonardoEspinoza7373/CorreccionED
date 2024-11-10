package com.proyecto.utilidades;

import java.util.LinkedList;

public class Pila<T> {
    private LinkedList<T> stack = new LinkedList<>();

    public void push(T item) {
        stack.addFirst(item);
    }

    public T pop() {
        return stack.isEmpty() ? null : stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

