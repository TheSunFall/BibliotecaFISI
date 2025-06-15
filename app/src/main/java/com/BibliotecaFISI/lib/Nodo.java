package com.BibliotecaFISI.lib;

public class Nodo<T> {
    public Nodo<T> prev;
    public Nodo<T> sgte;
    public T val;
    Nodo(T val) {
        this.val = val;
        prev = null;
        sgte = null;
    }
}
