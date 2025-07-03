package arvores;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinariaBusca {
    private class No {
        int valor;
        No esquerdo, direito;

        No(int valor) {
            this.valor = valor;
        }
    }

    private No raiz;
    private int folhas = 0;

    // Inserção
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) return new No(valor);

        if (valor < atual.valor) {
            atual.esquerdo = inserirRec(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = inserirRec(atual.direito, valor);
        }
        return atual; // valor duplicado não é inserido
    }

    // Remoção
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No atual, int valor) {
        if (atual == null) return null;

        if (valor < atual.valor) {
            atual.esquerdo = removerRec(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = removerRec(atual.direito, valor);
        } else {
            // Nó com um ou nenhum filho
            if (atual.esquerdo == null) return atual.direito;
            if (atual.direito == null) return atual.esquerdo;

            // Nó com dois filhos: obter o sucessor
            No sucessor = encontrarMinimo(atual.direito);
            atual.valor = sucessor.valor;
            atual.direito = removerRec(atual.direito, sucessor.valor);
        }
        return atual;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerdo != null) {
            no = no.esquerdo;
        }
        return no;
    }

    // Busca
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No atual, int valor) {
        if (atual == null) return false;
        if (valor == atual.valor) return true;
        return valor < atual.valor
                ? buscarRec(atual.esquerdo, valor)
                : buscarRec(atual.direito, valor);
    }

    // Impressões
    public void imprimirEmOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdem(no.direito);
        }
    }

    public void imprimirPreOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }

    public void imprimirPosOrdem() {
        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerdo);
            posOrdem(no.direito);
            System.out.print(no.valor + " ");
        }
    }

    /**
     * Imprime os nós da árvore por largura (nível a nível).
     * Utiliza uma fila para gerenciar os nós a serem visitados.
     */
    public void imprimirPorLargura() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.offer(raiz); // Adiciona a raiz à fila

        while (!fila.isEmpty()) {
            No atual = fila.poll(); // Remove o primeiro nó da fila
            System.out.print(atual.valor + " ");

            // Adiciona os filhos do nó atual à fila, se existirem
            if (atual.esquerdo != null) {
                fila.offer(atual.esquerdo);
            }
            if (atual.direito != null) {
                fila.offer(atual.direito);
            }
        }
        System.out.println(); // Nova linha após a impressão
    }

    // Altura da árvore
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No no) {
        if (no == null) return -1; // altura de árvore vazia é -1
        return 1 + Math.max(alturaRec(no.esquerdo), alturaRec(no.direito));
    }

    // Contar total de nós
    public int contarNos() {
        return contarNosRec(raiz);
    }

    private int contarNosRec(No no) {
        if (no == null) return 0;
        return 1 + contarNosRec(no.esquerdo) + contarNosRec(no.direito);
    }

    // Contar folhas
    public int contarFolhas() {
        return contarFolhasRec(raiz);
    }

    private int contarFolhasRec(No no) {
        if (no == null) return 0;
        if (no.esquerdo == null && no.direito == null) return 1;
        return contarFolhasRec(no.esquerdo) + contarFolhasRec(no.direito);
    }

    // Profundidade de um nó
    public int profundidadeNo(int valor) {
        return profundidadeRec(raiz, valor, 0);
    }

    private int profundidadeRec(No atual, int valor, int profundidade) {
        if (atual == null) return -1;
        if (atual.valor == valor) return profundidade;

        if (valor < atual.valor) {
            return profundidadeRec(atual.esquerdo, valor, profundidade + 1);
        } else {
            return profundidadeRec(atual.direito, valor, profundidade + 1);
        }
    }

}

