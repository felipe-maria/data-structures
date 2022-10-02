package br.com.fantonio.datastructures.cs14.lista;

public class CelulaDupla<E> {

    private CelulaDupla<E> anterior;

    private CelulaDupla<E> proxima;

    private E elemento;

    public CelulaDupla(CelulaDupla<E> proxima, E elemento) {
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public CelulaDupla(E elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla getProxima() {
        return proxima;
    }

    public void setProxima(CelulaDupla proxima) {
        this.proxima = proxima;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla<E> getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaDupla<E> anterior) {
        this.anterior = anterior;
    }
}
