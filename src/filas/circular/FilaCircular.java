package filas.circular;


import java.util.Arrays;

public class FilaCircular<T> {
    private T[] elementos;
    private int tamanho;
    private int inicio;
    private int fim;

    public FilaCircular(int capacidade){
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
        inicio = 0;
        fim = 0;
    }

    public int tamanho(){
        return tamanho;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public boolean estaCheia(){
        return tamanho == elementos.length;
    }

    public boolean enfileirar(T e){
        if(!estaCheia()){

            elementos[fim] = e;
            fim++;
            if(fim == elementos.length){
                fim = 0;
            }
            tamanho++;
            return true;
        }
        return false;
    }

    public T desenfileirar(){
        if(!estaVazia()){
            T e = elementos[inicio];

            inicio++;
            if (elementos.length == inicio){
                inicio = 0;
            }
            tamanho--;
            return e;
        }
        return null;
    }

    public T espiar(){
        if(!estaVazia()){
            return elementos[inicio];
        }
        return null;
    }

    public void imprimirTodos(){
        System.out.println(Arrays.toString(elementos));
    }

    public void imprimir(){
        for (int i = 0; i < tamanho; i++){
            System.out.println(elementos[i]);
        }
    }
}

