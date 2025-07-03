package listas.simplesLigada;

public class ListaLigada <T> {
    private No<T> inicio;

    public ListaLigada(){
        inicio = null;
    }

    public void inserirNoFim (T valor){
        No<T> novoNo = new No<>(valor);

        if (inicio == null){
           inicio = novoNo;
        }else{
            No<T> noAtual = inicio;
            while(noAtual.proximo != null){
                noAtual = noAtual.proximo;
            }
            noAtual.proximo = novoNo;
        }
    }

    public void inserirNoInicio (T valor){
        No<T> novoNo = new No<>(valor);

        if (inicio == null){
            inicio = novoNo;
        }else{
            novoNo.proximo = inicio;
            inicio = novoNo;
        }
    }

    public void removerDoInicio(){
        if (inicio == null){
            System.out.println("Lista vazia.");
            return;
        }
        inicio = inicio.proximo;
    }

    public void removerDoFim(){
        if (inicio == null){
            System.out.println("Lista vazia.");
            return;
        }else{
            No<T> atual = inicio;
            No<T> anterior = null;
            while (atual.proximo != null){
                anterior = atual;
                atual = atual.proximo;
            }
            anterior.proximo = null;
        }


    }

    public void removerPorValor(T valor){
        if (inicio == null){
            System.out.println("Lista vazia.");
            return;
        }

        //Se o elemento for o primeiro da lista
        if(inicio.valor == valor){
            inicio = inicio.proximo;
            return;
        }

        No<T> atual = inicio;
        No<T> anterior = null;

        while (atual != null && atual.valor != valor){
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual == null){
            System.out.println("Elemento não encontrado.");
            return;
        }
        anterior.proximo = atual.proximo;
    }

    public T removerDaPosicao(int indice){
        if (inicio == null){
            System.out.println("Lista vazia.");
            return null;
        }

        //Se o elemento for o primeiro da lista
        if(indice == 0){
            inicio = inicio.proximo;
            return null;
        }

        No<T> atual = inicio;
        No<T> anterior = null;
        int contador = 0;

        while (atual != null && contador < indice){
            anterior = atual;
            atual = atual.proximo;
            contador++;
        }

        if (atual == null || indice < 0){
            System.out.println("Posição inválida.");
            return null;
        }
        anterior.proximo = atual.proximo;
        return atual.valor;
    }

    public void exibir(){
        if (inicio == null){
            System.out.println("Lista Vazia.");
        }else{
            No<T> atual = inicio;
            while (atual != null){
                System.out.println(atual.valor);
                atual = atual.proximo; //incremento da lista
            }
            System.out.println();
        }
    }

}
