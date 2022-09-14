package br.com.fantonio.datastructures.cs14.lista;

public class ListaDuplamenteLigada<E> implements Lista<E> {

    private CelulaDupla primeira;
    private CelulaDupla ultima;

    private int tamanho = 0;


    @Override
    public void adiciona(E element) {
        if (tamanho == 0) {
            adicionaNoComeco(element);
        } else {
            CelulaDupla nova = new CelulaDupla(element);
            ultima.setProxima(nova);
            nova.setAnterior(ultima);
            ultima = nova;
            tamanho++;
        }
    }

    public void adicionaNoComeco(E element) {
        if (tamanho == 0) {
            CelulaDupla nova = new CelulaDupla(element);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            CelulaDupla nova = new CelulaDupla(this.primeira, element);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        tamanho++;
    }

    @Override
    public void adiciona(int posicao, E element) throws IllegalArgumentException {
        // valida posicao
        if (posicaoInvalida(posicao)) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        // verifica se é a primeira posicao
        if (posicao == 0) {
            this.adicionaNoComeco(element);
        } else if (posicao == tamanho) { // verifica se é a ultima posicao
            this.adiciona(element);
        } else { // adiciona no meio
            CelulaDupla anterior = this.pegaCelula(posicao - 1);
            CelulaDupla proxima = anterior.getProxima();
            CelulaDupla nova = new CelulaDupla(element);

            nova.setAnterior(anterior);
            nova.setProxima(proxima);

            proxima.setAnterior(nova);
            anterior.setProxima(nova);

            tamanho++;
        }
    }

    @Override
    public Object pega(int posicao) throws IllegalArgumentException {
        return this.pegaCelula(posicao).getElemento();
    }

    @Override
    public void remove(int posicao) {
        // verifica se posicao é valida
        if (posicaoInvalida(posicao)) throw new IllegalArgumentException("Posicao inválida");

        // verifica se é o primeiro
        if (posicao == 0) {
            removeDoComeco();
        } else if (posicao == this.tamanho - 1) {
            this.removeDoFim();
        } else {
            // verifica as demais
            CelulaDupla anterior = pegaCelula(posicao - 1);
            CelulaDupla atual = anterior.getProxima();
            CelulaDupla proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            tamanho--;
        }
    }

    @Override
    public void remove(E item) {
        // verifica se lista vazia
        if (tamanho == 0) {
            return;
        }

        // verifica se só tem 1 elemento
        if (tamanho == 1) {

            primeira = null;
            ultima = null;
            tamanho = 0;
            return;
        }

        // verifica se é o primeiro
        if (item.equals(primeira.getElemento())) {
            CelulaDupla celulaProxima = primeira.getProxima();
            primeira = celulaProxima;
            tamanho--;
        }

        // verifica as demais
        CelulaDupla celulaAtual = primeira;
        CelulaDupla celulaAnterior = null;
        while (celulaAtual != null) {
            Object element = celulaAtual.getElemento();
            if (item.equals(element)) {
                CelulaDupla celulaProxima = celulaAtual.getProxima();
                if (celulaAnterior != null) { // caso seja a primeira célula
                    celulaAnterior.setProxima(celulaProxima);
                }

                // verifica se também o ultimo
                if (celulaProxima == null) {
                    ultima = celulaAnterior;
                }
                tamanho--;
            }
            celulaAnterior = celulaAtual;
            celulaAtual = celulaAtual.getProxima();
        }
    }

    @Override
    public boolean contem(E item) {
        CelulaDupla atual = primeira;

        while (atual != null) {
            Object element = atual.getElemento();
            if (element.equals(item)) {
                return true;
            }
            atual = atual.getProxima();
        }

        return false;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[10];
        CelulaDupla proxima = primeira;
        int indice = -1;
        int tamanho = 0;
        while (proxima != null) {
            if (indice == array.length - 1) {
                array = dobrarTamanhoArray(array);
            }
            array[++indice] = proxima.getElemento();
            proxima = proxima.getProxima();
            tamanho++;
        }
        return array;
    }

    @Override
    public void limpar() {
        tamanho = 0;
        primeira = null;
        ultima = null;
    }

    @Override
    public int indexOf(E o) {
        if (o == null) return -1;
        if (tamanho == 0) return -1;

        CelulaDupla proxima = primeira;
        int indexAuxiliar = 0;
        int index = -1;
        while (proxima != null) {
            if (o.equals(proxima.getElemento())) {
                index = indexAuxiliar;
                break;
            }
            proxima = proxima.getProxima();
            indexAuxiliar++;
        }
        return index;
    }

    @Override
    public int lastIndexOf(E o) {
        if (o == null) return -1;
        if (tamanho == 0) return -1;

        CelulaDupla proxima = primeira;
        int indexAuxiliar = 0;
        int lastIndex = -1;
        while (proxima != null) {
            if (o.equals(proxima.getElemento())) {
                lastIndex = indexAuxiliar;
            }
            proxima = proxima.getProxima();
            indexAuxiliar++;
        }
        return lastIndex;
    }

    public void removeDoComeco() {
        if (posicaoInvalida(0)) {
            throw new IllegalArgumentException("Posicao não existe");
        }

        this.primeira = primeira.getProxima();
        tamanho--;

        if (tamanho == 1) {
            ultima = null;
        }

    }

    public void removeDoFim() {
        // lista vazia
        if (tamanho == 0) {
            throw new IllegalArgumentException("Posição não existe");
        }

        // lista com um elemento
        if (tamanho == 1) {
            removeDoComeco();
        } else {
            CelulaDupla penultima = ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.tamanho--;
        }
    }

    private boolean posicaoInvalida(int posicao) {
        return posicao < 0 || posicao >= this.tamanho;
    }

    private CelulaDupla pegaCelula(int posicao) {
        if(this.posicaoInvalida(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        CelulaDupla atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    private Object[] dobrarTamanhoArray(Object[] elements) {
        Object[] newArray = new Object[elements.length * 2];
        copiarArray(elements, newArray);

        return newArray;
    }

    private void copiarArray(Object[] origem, Object[] destino) {
        for (int i = 0; i < origem.length && origem[i] != null; i++) {
            destino[i] = origem[i];
        }
    }

}

