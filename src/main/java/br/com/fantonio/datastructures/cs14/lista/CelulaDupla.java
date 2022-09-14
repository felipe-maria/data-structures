package br.com.fantonio.datastructures.cs14.lista;

public class CelulaDupla {

    private CelulaDupla anterior;

    private CelulaDupla proxima;

    private Object elemento;

    public CelulaDupla(CelulaDupla proxima, Object elemento) {
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public CelulaDupla(Object elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla getProxima() {
        return proxima;
    }

    public void setProxima(CelulaDupla proxima) {
        this.proxima = proxima;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaDupla anterior) {
        this.anterior = anterior;
    }
}
