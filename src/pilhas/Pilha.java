package pilhas;

import java.util.Arrays;

public class Pilha <T> {

    private Object[] elementos;
    private int tamanho;

    public Pilha(int capacidade){
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazio(){
        return tamanho == 0;
    }

    public boolean estaCheia(){
        return tamanho == elementos.length;
    }

    public boolean empilhar(T e){
        if(!estaCheia()){
           elementos[tamanho] = e;
           tamanho++;
           return true;
        }
        return false;
    }

    public Object desempilhar(){
        if(!estaVazio()){
            tamanho--;
            Object removido = elementos[tamanho];
            elementos[tamanho] = null;
            return removido;
        }
        return null;
    }

    public Object espiar(){
        if(!estaVazio()){
            return  elementos[tamanho -1];
        }
        return null;
    }

    public void imprimir(){
        System.out.println(Arrays.toString(elementos));
    }
}
