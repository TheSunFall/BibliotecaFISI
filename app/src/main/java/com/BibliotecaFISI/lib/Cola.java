package com.BibliotecaFISI.lib;


public class Cola<T> {
    private ListaEnlazada<T> lista;
    public Cola() {
        lista = new ListaEnlazada<T>();
    }
    public void Encolar(Nodo<T> nodo) {
        lista.Anexar(nodo);
    }
    public Nodo<T> Decolar() {
        Nodo<T> tmp = lista.CAB;
        lista.Eliminar(tmp);
        return tmp;
    }
}
