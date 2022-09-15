package br.com.fantonio.datastructures.cs14.pilha;

public class Minotauro {

    private final boolean[][] map;

    private Pilha<Passo> passos = new Pilha<>();

    public Minotauro(boolean[][] map){
        this.map = map;
    }

    public int melhorCaminho() {
        int i = 0;
        int j = 0;

        avancar(i,j,false, Direcao.FORWARD);

        return contarPassos();
    }

    private int contarPassos() {
        int count = 0;
        while (!passos.vazia()) {
            passos.remove();
            count++;
        }
        return count;
    }

    public void avancar(int i, int j, boolean retro, Direcao direcao) {
        // Por enquanto o tamanho é dois
        if (j == map[j].length - 1) {
            if (map[i][j] == true) {
                System.out.println("Acabou");
                return;
            } else {
                // retroceder();
            }
        }

        if (retro == false) {

            if (map[i][j + 1] == true) { // se proxima coluna na mesma linha true, avanca
                // segue
                passos.insere(new Passo(i, j + 1, Direcao.FORWARD));
                avancar(i, j + 1, false, Direcao.FORWARD);
            } else if (map[i + 1][j] == true) { // se proxima linha na mesma coluna true, avanca
                // segue
                avancar(i + 1, j, false, Direcao.DOWNWARD);
                passos.insere(new Passo(i + 1, j, Direcao.DOWNWARD));
            } else if (map[i][j-1] == true) {
                avancar(i + 1, j, false, Direcao.BACKWARD);
                passos.insere(new Passo(i, j-1, Direcao.BACKWARD));
            } else {
                Passo passoAnterior = passos.remove();
                avancar(passoAnterior.i, passoAnterior.j, true, direcao);
            }
        } else {
            if (map[i][j + 1] == true && !direcao.equals(Direcao.FORWARD)) {
                passos.insere(new Passo(i, j + 1, Direcao.FORWARD));
                avancar(i, j + 1, false, Direcao.FORWARD);
            } else if (map[i + 1][j] == true && !direcao.equals(Direcao.DOWNWARD)) {
                avancar(i + 1, j, false, Direcao.DOWNWARD);
                passos.insere(new Passo(i + 1, j, Direcao.DOWNWARD));
            } else if (map[i][j-1] == true) {
                avancar(i + 1, j, true, Direcao.BACKWARD);
                passos.insere(new Passo(i, j-1, Direcao.BACKWARD));
            } else {
                Passo passoAnterior = passos.remove();
                avancar(passoAnterior.i, passoAnterior.j, true, direcao);
            }
        }

    }

//    private void retroceder(int i, int j) {
//
//        Passo passoAnterior = passos.remove();
////        if ()
//    }

    class Passo {

        int i;
        int j;
        Direcao direcao;

        Passo(int i, int j, Direcao direcao) {
            this.i = i;
            this.j = j;
            this.direcao = direcao;
        }

    }

    enum Direcao {

        FORWARD,
        DOWNWARD,
        BACKWARD,
        UPWARD;
    }
}
