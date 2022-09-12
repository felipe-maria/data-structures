package br.com.fantonio.datastructures.cs14;

public class ListaDuplamenteLigada<E> implements Lista<E> {

    private Celula primeira;
    private Celula ultima;

    private int tamanho = 0;


    @Override
    public void adiciona(E element) {
        if (tamanho == 0) {
            adicionaNoComeco(element);
        } else {
            Celula novaUltima = new Celula(element);
            ultima.setProxima(novaUltima);
            ultima = novaUltima;
            tamanho++;
        }
    }

    public void adicionaNoComeco(E element) {
        Celula novaPrimeira = new Celula(primeira, element);
        this.primeira = novaPrimeira;

        if (tamanho == 0) {
            this.ultima = primeira;
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
        } else { // demais posicoes
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula nova = new Celula(anterior.getProxima(), element);
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

        // verifica se lista vazia
        if (tamanho == 0) return;

        // verifica se só tem 1 elemento
        if (tamanho == 1) {
            primeira = null;
            ultima = null;
            tamanho--;
            return;
        }

        // verifica se é o primeiro
        if (posicao == 0) {
            Celula proximaCelula = primeira.getProxima();
            primeira = proximaCelula;
        }
        // verifica as demais
        Celula celulaAtual = primeira;
        Celula celulaAnterior = null;
        int indiceAuxiliar = 0;
        while (celulaAtual != null) {
            if (indiceAuxiliar == posicao) {
                Celula celulaProxima = celulaAtual.getProxima();
                if (celulaAnterior != null) { // caso seja a primeira célula
                    celulaAnterior.setProxima(celulaProxima);
                }

                // verifica se é o ultimo
                if (celulaProxima == null) {
                    ultima = celulaAnterior;
                }
                break;
            }

            celulaAnterior = celulaAtual;
            celulaAtual = celulaAtual.getProxima();
            indiceAuxiliar++;
        }

        tamanho--;
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
            Celula celulaProxima = primeira.getProxima();
            primeira = celulaProxima;
            tamanho--;
        }

        // verifica as demais
        Celula celulaAtual = primeira;
        Celula celulaAnterior = null;
        while (celulaAtual != null) {
            Object element = celulaAtual.getElemento();
            if (item.equals(element)) {
                Celula celulaProxima = celulaAtual.getProxima();
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
        if (item == null) return false;

        Celula proxima = primeira;
        boolean contem = false;
        while (proxima != null) {
            Object element = proxima.getElemento();
            if (element != null && element.equals(item)) {
                contem = true;
                break;
            }
            proxima = proxima.getProxima();
        }

        return contem;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[10];
        Celula proxima = primeira;
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

        Celula proxima = primeira;
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

        Celula proxima = primeira;
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
        if (tamanho == 0) return;

        // lista com um elemento
        if (tamanho == 1) {
            primeira = null;
            ultima = null;
            tamanho--;

            return;
        }

        Celula celulaAtual = primeira;
        Celula celulaAnterior = null;
        while (celulaAtual != null) {
            Celula celulaProxima = celulaAtual.getProxima();
            if (celulaProxima == null) {
                celulaAnterior.setProxima(null);
                ultima = celulaAnterior;
                tamanho--;

                return;
            }
            celulaAnterior = celulaAtual;
            celulaAtual = celulaAtual.getProxima();
        }

    }

    private boolean posicaoInvalida(int posicao) {
        return posicao < 0 || posicao >= this.tamanho;
    }

    private Celula pegaCelula(int posicao) {
        if(this.posicaoInvalida(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula atual = primeira;
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

