package br.com.fantonio.datastructures.complexity;

import java.util.Scanner;

/**
 * Notação assintótica
 *
 * Exercícios e teorias tirados do vídeo do professor Eduardo Mendes de Oliveira:
 * https://www.youtube.com/watch?v=gELxaucTIyk&list=PLikRnDdXnDvo1WUrumRQRaWYEvz7C3gjX&ab_channel=EduardoMendesdeOliveira
 *
 * É uma notação que nos permite descartar os termos constantes e menos significativos
 * Foco no que realmente é relevante.
 *
 * Algumas ideias:
 *
 * Uma função do tamanho da sua entrada
 * Quão rápido uma função cresce dado o tamanho da entrada
 *
 * Instruções simples:
 * são aquelas que podem ser executadas em linguagem de máquina
 * diremos que medem 1 unidade de tempo ou simplesmente 1
 *
 * Exemplos:
 * 1. atribuições de valor de forma geral
 * 2. incremento de valores
 * 3. operações aritméticas mais complexas
 * 4. acesso ao valor de um elemento em um vetor
 * 5. expressões lógicas de forma geral
 * 6. operações de leitura ou escrita *
 *
 * Instruções complexas:
 * combinação de instruções simples
 * construídas através de instruções de controle de fluxo
 * diremos que será a soma de suas instruções simples
 *
 */
public class Complexity {


    // Contando instruções
    /**
     * Atribuição e escrita
     * Complexidade: 3
     */
    public void exemplo1() {
        int x = 0;              // 1
        x = x + 1;              // 1
        System.out.println(x);  // 1
    }

    /**
     * Seleção e comparação
     * Complexidade: 4
     */
    public void exemplo2() {
        int numero = new Scanner(System.in).nextInt(); // 1

        if (numero % 2 == 0) {                         // 1 + 1(ou then ou else)
            numero = numero + 1;
        } else {
            numero = numero -1;
        }
        System.out.println(numero);                     // 1

    }

    /**
     * While
     * Complexidade: 3
     */
    public void exemplo3() {
        int max = 0;                    // 1
        int i = 0;                      // 1

        while (i < max) {               // 1
            i++;
        }
    }

    /**
     * While, max com valor 10
     * Complexidade: 23
     *
     * 1+1+11+10 = 2 + 21 = 23
     */
    public void exemplo4() {
        int max = 10;                    // 1
        int i = 0;                       // 1

        while (i < max) {               // 1 + (max - i) => 1 + (10-0) => 1 + 10 => 11
            i++;                        // max => 10
        }
    }

    /**
     * While, max com valor 10
     * Complexidade: 23
     *
     * 1+1+11+20 = 2 + 31 = 33
     */
    public void exemplo5() {
        int max = 10;                    // 1
        int i = 0;                       // 1

        while (i < max) {               // 1 + (max - i) => 1 + (10-0) => 1 + 10 => 11
            System.out.println(i++);    // max * 2 = 10 * 2 = 20
        }
    }

    /**
     * For
     * Complexidade: 3
     */
    public void exemplo6() {
        int max = 0;                                // 1

        for (int i = 0; i < max; i++) {             // 1 (int i = 0) + 1 (i< max)
            System.out.println(i);
        }
    }

    /**
     * For, max 10, laço vazio
     * Complexidade: 23
     */
    public void exemplo7() {
        int max = 10;                                // 1

        for (int i = 0; i < max; i++) {              // 1  + (1 + (max - i)) + (max -i) => 1 + 1 + 10-0 + 10-0 => 22

        }
    }

    /**
     * For, max 10, com laço não vazio
     * Complexidade: 23 + 10 = 33
     */
    public void exemplo8() {
        int max = 10;                                // 1

        for (int i = 0; i < max; i++) {              // 1  + (1 + (max - i)) + (max -i) => 1 + 1 + 10-0 + 10-0 => 22
            System.out.println(i);                   // 1 * max = 1 * 10 = 10
        }
    }

    /**
     * For, max 100
     * Complexidade: 404
     *
     * 1+1+202+100+100
     */
    public void exemplo9() {
        int newMax = 100;                            // 1
        int a = 0;                                   // 1

        for (int i = 0; i < newMax; i++) {           // 1  + (1 + (max - i)) + (max -i)
                                                     // => 1 + (1 + 100-0) + (100-0) => 1 + 101 + 100 => 202
            a = a + 1;                               // 1 * max => 1 * 100 => 100
            System.out.println(i);                   // 1 * max => 1 * 100 => 100
        }
    }

    /**
     * For, n variavel
     * Complexidade: 3n + 2
     *
     * 1 + 1 + n + n
     * n
     * 2 + 3n
     */
    public void exemplo10(int n) {
        for (int i = 0; i < n; i++) {           // 1  + (1 + (n - i)) + (n - i)
                                                // 1 + (1 + (n - 0) + (n - 0)
                                                // 1 + 1 + n + n
                                                // 2 + 2n
            System.out.println(i);              // 1 * n
                                                // n
        }
    }

    /**
     * For, n variavel e i = 1
     * Complexidade: 4n
     *
     * 1
     * 2 + (n-1) + (n-1)
     * n-1
     * n-1
     * 1
     *
     * 2 + 2 + (n-1) + (n-1) + (n-1) + (n-1)
     * 4 + 4(n-1)
     * 4 + 4n - 4
     * 4n
     */
    public void exemplo11(int n) {
        int a = 0;                              // 1

        for (int i = 0; i < n; i++) {           // 1 + 1 + (n - i) + (n - i)
                                                // 1 + 1 + (n - 1) + (n - 1)
                                                // 2 + (n-1) + (n-1)
            a = a + 1;                          // n - 1
            System.out.println(i);              // n - 1
        }

        System.out.println(a);                  // 1
    }

    /**
     * For dentro de for
     * Complexidade: 3n² + 3n + 2
     *
     * 2 + n * (2n + 2 + n ) + n
     * 2 + n * (3n + 2) + n
     * 2 + 3n² + 2n + n
     * 3n² + 3n + 2
     */
    public void exemplo12(int n) {

        for (int i = 0; i < n; i++) {               // 1 + 1 + (n - i) + (n - i)
                                                    // 1 + 1 + (n - 0) + (n - 0)
                                                    // 1 + 1 + n * (laço interno) + n
                                                    // 2 + n * (laço interno) + n

            for (int j = 0; j < n; j++) {           // 1 + 1 + (n - j) + (n - j)
                                                    // 1 + 1 + (n - 0) + (n - 0)
                                                    // 1 + 1 + n + n
                                                    // 2 + 2n

                System.out.println(i);              // n * 1
                                                    // n

            }
        }
    }

    /**
     * If dentro de for
     * Complexidade: 23 ou sem saber o n: 4n + 3 (pior caso)
     */
    public void exemplo13() {
        int[] numbers = {1,2,3,4,5,6,7,8};                      // 1

        for (int i = 0; i < numbers.length; i++) {              // 1 + 1 + (n-i) + 1
                                                                // 2 + (8-0) + 1
                                                                // 2 + 8 + 1
                                                                // 11
            if (numbers[i] % 2 == 0) {                          // 8
                System.out.println(i);                          // 4
            }
        }
    }

}

