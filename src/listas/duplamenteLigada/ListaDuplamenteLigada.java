package listas.duplamenteLigada;

public class ListaDuplamenteLigada<T> {
    private No<T> inicio;
    private No<T> fim;
    private No<T> atual;

    public ListaDuplamenteLigada(){
        this.inicio = null;
        this.fim = null;
    }

    public void inserirNoFim(T dado){
        No<T> novoNo = new No<>(dado);

        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
        }else{
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void inserirNoInicio(T dado){
        No<T> novoNo = new No<>(dado);

        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
        }else{
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    public boolean contem(T dado){
        No<T> atual = inicio;
        while (atual != null){
            if(atual.dado.equals(dado)) return  true;
            atual = atual.proximo;
        }
        return false;
    }

    public void remomerPorValor(T dado){
        if(inicio == null)
            System.out.println("Lista vazia.");

        No<T> atual = inicio;

        while (atual != null){
            if (atual.dado.equals(dado)){
                //Cenário 1 - Elemento é o primeiro nó
                if  (atual == inicio){
                    inicio = inicio.proximo;
                    if (inicio != null) inicio.anterior = null;
                }
                //Cenário 2 - Elemento é o último nó
                else if (atual == fim) {
                    fim = fim.anterior;
                    if(fim != null) fim.proximo = null;
                }
                //Cenário 3 - Elemento no meio da lista
                else{
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                return;
            }
            atual = atual.proximo;
        }
    }


    public void imprimir(){
        No<T> atual = inicio;

        if (inicio == null)
            System.out.println("Lista Vazia");

        while (atual != null){
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
        System.out.println();
    }
}
