package br.com.fantonio.datastructures.exercises;

import br.com.fantonio.datastructures.cs14.pilha.Pilha;

public class Criptografia {

    Pilha<Character> pilhaChar = new Pilha<>();
    StringBuilder sb = new StringBuilder();

    public String criptografar(String frase) throws IllegalArgumentException {
        validarEntrada(frase);

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                desempilharTudo();
            } else {
                pilhaChar.insere(frase.charAt(i));
            }
        }
        desempilharTudo();

        return sb.toString().trim();
    }

    public String descriptografar(String frase) throws IllegalArgumentException {
        return criptografar(frase);
    }

    /**
     * Verifica se a frase nula é ou frase vazia
     *
     * @throws IllegalArgumentException
     */
    private void validarEntrada(String frase) throws IllegalArgumentException {
        if (frase == null) {
            throw new IllegalArgumentException("Frase nula");
        }

        if (frase.equals("")) {
            throw new IllegalArgumentException("Frase vazia");
        }
    }

    private void desempilharTudo() {
        while(!pilhaChar.vazia()) {
            sb.append(pilhaChar.remove());
        }
        sb.append(' ');
    }
}
