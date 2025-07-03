package ordenacao;

import java.util.Random;

public class Ordenacao {

    public static void bubbleSort(int[] vetor){
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++){
            for(int j = 0; j < n -i - 1; j++){
                if (vetor[j] > vetor[j+1]){
                    int aux = vetor[j];
                    vetor[j] = vetor[j +1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }

    public static void bubbleSortDesc(int[] vetor){
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++){
            for(int j = 0; j < n -i - 1; j++){
                if (vetor[j] < vetor[j+1]){
                    int aux = vetor[j];
                    vetor[j] = vetor[j +1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }

    public static void selectionSort(int[] vetor){
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++){
            int index = i;

            for (int j = i+ 1; j < n; j++){
                    if (vetor[j] < vetor[index]) {
                        index = j;
                    }
            }
            int aux = vetor[index];
            vetor[index] = vetor[i];
            vetor[i] = aux;
        }
    }

    public static void selectionSortDesc(int[] vetor){
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++){
            int index = i;

            for (int j = i+ 1; j < n; j++){
                if (vetor[j] > vetor[index]) {
                    index = j;
                }
            }
            int aux = vetor[index];
            vetor[index] = vetor[i];
            vetor[i] = aux;
        }
    }

    public static void insertionSort(int[] vetor){
        int n = vetor.length;
        for(int i = 1; i < n; i++){
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 &&  vetor[j] > chave){
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j+1] = chave;
        }
    }

    public static void insertionSortDesc(int[] vetor){
        int n = vetor.length;
        for(int i = 1; i < n; i++){
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 &&  vetor[j] < chave){
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j+1] = chave;
        }
    }

    public static void imprimeVetor(int [] vetor){
        for(int vet : vetor){
            System.out.print(vet + " ");
        }
        System.out.println();
    }

    //Recebe como parametros o vetor a ser ordenado, inicio e fim
    public static void mergeSort(int [] vetor, int inicio, int fim){
        if (inicio < fim ){ //Caso base -> quando forem iguais sai da recurso
            int meio = (inicio + fim)/2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio , fim);
        }
    }

    public static void merge(int [] vetor, int inicio, int meio, int fim) {
        // Passo 1: Determinar os tamanhos dos dois subarrays que serão mesclados
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        // Passo 2: Criar arrays temporários para armazenar os subarrays
        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        // Passo 3: Copiar os dados para os arrays temporários
        for (int i = 0; i < n1; i++)
            esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = vetor[meio + 1 + j];

        // Passo 4: Mesclar os arrays temporários de volta no array original
        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }

        // Passo 5: Copiar os elementos restantes de esquerda[], se houver
        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        // Passo 6: Copiar os elementos restantes de direita[], se houver
        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // Particiona o vetor e retorna o índice do pivô
            int indicePivo = particionar(vetor, inicio, fim);
            // Ordena a sublista à esquerda do pivô
            quickSort(vetor, inicio, indicePivo - 1);
            //Ordena a sublista à direita do pivô
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // Escolhe o último elemento como pivô
        int i = (inicio - 1); // Índice do menor elemento

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) { // Se o elemento atual é menor ou igual ao pivô
                i++;
                // Troca vetor[i] e vetor[j]
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        // Troca vetor[i+1] com o pivô (vetor[fim])
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1; // Retorna o índice do pivô
    }

    public static void main(String[] args) {
        int[] vetor = new int [1_000_000];
        Random radom = new Random();
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = radom.nextInt(100);
        }

        //imprimeVetor(vetor);
        double tempoInicio = System.nanoTime();
        mergeSort(vetor, 0, vetor.length - 1);
        //bubbleSort(vetor);
        //quickSort(vetor, 0, vetor.length -1);
        double tempoFim = System.nanoTime();
        double tempoGasto = tempoFim - tempoInicio;
        double miliSegundos = tempoGasto / 1_000_000;
        double segundos = tempoGasto / 1_000_000_000;

        System.out.println(segundos);
        //imprimeVetor(vetor);
    }

}
