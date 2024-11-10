package com.proyecto.utilidades;

import java.util.LinkedList;

public class PilaCaracteres {
    private LinkedList<Character> stack = new LinkedList<>();

    public void push(char item) {
        stack.addFirst(item);
    }

    public char pop() {
        return stack.isEmpty() ? '\0' : stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
