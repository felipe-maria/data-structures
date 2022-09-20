package br.com.fantonio.datastructures.cs14.pilha;

import java.util.ArrayList;
import java.util.List;

public class Minotauro {

    private final boolean[][] map;

    private Pilha<Passo> passos = new Pilha<>();

    public Minotauro(boolean[][] map) {
        this.map = map;
    }

    public int fugir() {
        int i = 0;
        int j = 0;

        passos.push(new Passo(0,0));
        avancar(i, j);

        return contarPassos();
    }

    private int contarPassos() {
        int count = -1;
        while (!passos.empty()) {
            passos.pop();
            count++;
        }
        return count == -1 ? 0: count;
    }


    /*
     * A cada avanço, pego elemento atual da pilha e coloca a direção usada.
     * Então cria-se um novo elemento sem direção
     * No primeiro avanço não se poe direção
     * Nas comparações, comparamos com a posicao anterior (i,j)
     * Se nada for possível aí se retrocede, tirando um elemento da pilha e avancando para a posicao anterior.
     */
    public void avancar(int i, int j) {
        /*
         * (0,0)  (0,1)  (0,2) (0,3)
         * (1,0)  (1,1)  (1,2) (1,3)
         * (2,0)  (2,1)  (2,2) (2,3)
         * (3,0)  (3,1)  (3,2) (3,3)
         */

        // Condicao de saída, cheguei na ultima coluna e ela é true
        if (j == map[j].length - 1 && map[i][j] == true) {
            System.out.println("Acabou");
            return;
        }

        Passo passoAtual = passos.pop();
        int iAnterior;
        int jAnterior;
        if (passos.empty()) {
            iAnterior = -1;
            jAnterior = -1;
        } else {
            iAnterior = passos.peek().i;
            jAnterior = passos.peek().j;
        }
        passos.push(passoAtual);
        List<Direcao> direcoes = passoAtual.direcoes;

        // Checar os limites antes de pegar o elemento do array

        // Verifica caminho a direita
        if (j+1 < map[i].length                         // Existe coluna a direita
                && !direcoes.contains(Direcao.RIGHT)    // O caminho a direita ainda não foi feito
                && jAnterior != j+1                     // Não estou indo de onde eu vim
                && map[i][j + 1] == true                // Direita é true
        ) {
            passoAtual.addDirecao(Direcao.RIGHT);
            passos.push(new Passo(i, j + 1));
            avancar(i, j+1);
        }

        // Verifica caminho pra baixo
        else if (i+1 < map.length                       // Existe linha para baixo
                && !direcoes.contains(Direcao.DOWN)      // O caminho para baixo ainda não foi feito
                && iAnterior != i+1                     // Não estou indo de onde eu vim
                && map[i+1][j] == true                  // Baixo é true
        ) {
            passoAtual.addDirecao(Direcao.DOWN);
            passos.push(new Passo(i+1, j));
            avancar(i+1,j);
        }

        // Verifica caminho pra cima
        else if (i-1 >= 0                               // Existe linha para cima
                && !direcoes.contains(Direcao.UP)       // O caminho para cima ainda não foi feito
                && iAnterior != i-1                     // Não estou indo de onde eu vim
                && map[i-1][j] == true                  // Cima é true
        ) {
            passoAtual.addDirecao(Direcao.UP);
            passos.push(new Passo(i-1, j));
            avancar(i-1, j);
        }

        // Verifica caminho pra esquerda
        else if (j-1 >= 0                                // Existe coluna a esquerda
                && !direcoes.contains(Direcao.LEFT)      // O caminho a esquerda ainda não foi feito
                && jAnterior != j-1                     // Não estou indo de onde eu vim
                && map[i][j - 1] == true                 // Esquerda é true
        ) {
            passoAtual.addDirecao(Direcao.LEFT);
            passos.push(new Passo(i, j - 1));
            avancar(i, j-1);
        }

        // Retrocede
        else {
            passos.pop();
            if (passos.empty()) {
                // Condicao de saída
                System.out.println("Acabou");
                return;
            }
            avancar(passos.peek().i, passos.peek().j);
        }

    }

    class Passo {

        int i;
        int j;
        List<Direcao> direcoes = new ArrayList<>();

        Passo(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void addDirecao(Direcao direcao) {
            this.direcoes.add(direcao);
        }

    }

    enum Direcao {

        RIGHT,
        DOWN,
        LEFT,
        UP;
    }
}
