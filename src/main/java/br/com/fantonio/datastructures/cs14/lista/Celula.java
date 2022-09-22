package br.com.fantonio.datastructures.cs14.lista;

public class Celula<E> {

    private Celula<E> proxima;

    private E elemento;

    public Celula(Celula proxima, E elemento) {
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public Celula(E elemento) {
        this.elemento = elemento;
    }

    public Celula<E> getProxima() {
        return proxima;
    }

    public void setProxima(Celula<E> proxima) {
        this.proxima = proxima;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }
}
