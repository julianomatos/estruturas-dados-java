package listas.circular;

public class ListaCircular <T> {
    private No<T> fim;

    public ListaCircular(){
        this.fim = null;
    }

    public void inserirNoFim (T dado){
        No<T> novo = new No<>(dado);

        //Verifica se a lista está vazia
        if (fim == null){
            fim = novo;
            fim.proximo = fim;
        }else {
            novo.proximo = fim.proximo;
            fim.proximo = novo;
            fim = novo;
        }
    }

    public T removerNoInicio(){
        if (fim == null) {
            System.out.println("Lista vazia.");
            return null;
        }

        No<T> inicio = fim.proximo;
        T valorRemovido = inicio.dado;

        //Verifica se só existe um elemento na lista
        if (fim == inicio){
            fim = null;
        }else{
            fim.proximo = inicio.proximo;
        }
        return valorRemovido;
    }

    public void imprimir(){
        if (fim == null){
            System.out.println("Lista vazia");
            return;
        }
        No<T> atual = fim.proximo;
        do{
            System.out.println(atual.dado + " ");
            atual = atual.proximo;
        }while (atual != fim.proximo);
        System.out.println();
    }

}
