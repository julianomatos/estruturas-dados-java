package filas.simples;

import java.util.Arrays;

public class Fila<T> {
    private T[] elementos;
    private int tamanho;

    public Fila(int capacidade){
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
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
           elementos[tamanho] = e;
           tamanho++;
           return true;
        }
        return false;
    }

    public T desenfileirar(){
        if(!estaVazia()){
            T e = elementos[0];
            for( int i = 1; i < tamanho; i++ ){
                elementos[i - 1] = elementos[i];
            }
            tamanho--;
            return e;
        }
        return null;
    }

    public T espiar(){
        if(!estaVazia()){
            return elementos[0];
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
